package io.foldright.cffu2;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.jetbrains.annotations.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static io.foldright.cffu2.internal.CffuLogger.Level.ERROR;
import static io.foldright.cffu2.internal.CffuLogger.Level.WARN;
import static io.foldright.cffu2.internal.CffuLogger.log;
import static io.foldright.cffu2.internal.CffuLogger.logUncaughtException;
import static java.lang.Thread.currentThread;

/**
 * @author Jerry Lee (oldratlee at gmail dot com)
 * @see CompletableFutureUtils#concurrencyLimitExecutor(int)
 * @see CffuFactory#concurrencyLimitExecutor(int)
 * @see com.google.common.util.concurrent.SequentialExecutor
 * @since 2.1.0
 */
@SuppressWarnings("JavadocReference")
@SuppressFBWarnings({ "UL_UNRELEASED_LOCK", "AT_STALE_THREAD_WRITE_OF_PRIMITIVE", "AT_NONATOMIC_OPERATIONS_ON_SHARED_VARIABLE" })
final class ConcurrencyLimitExecutor implements Executor {

    private final int maxConcurrency;

    private final Executor executor;

    private final Lock lock = new ReentrantLock();

    @GuardedBy("lock")
    private final Deque<Runnable> queue = new ArrayDeque<>();

    @GuardedBy("lock")
    private int workerCount = 0;

    @GuardedBy("lock")
    private int syncRunnerCount = 0;

    // for debugging and monitoring
    @GuardedBy("lock")
    private long syncRunTimes = 0;

    @GuardedBy("lock")
    private long exceedLimitTimes = 0;

    ConcurrencyLimitExecutor(int maxConcurrency, Executor executor) {
        this.maxConcurrency = maxConcurrency;
        this.executor = executor;
    }

    @Override
    public void execute(Runnable command) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("ConstantValue")
    private void asyncWork() {
        boolean interruptedDuringTask = false;
        while (true) {
            Runnable task;
            lock.lock();
            try {
                task = queue.poll();
                if (task == null) {
                    workerCount--;
                    // ensure that if the thread was interrupted at all while processing, it is returned to
                    // the base Executor interrupted so that it may handle the interruption if it likes.
                    if (interruptedDuringTask)
                        currentThread().interrupt();
                    return;
                }
            } finally {
                lock.unlock();
            }
            // remove the interrupt bit before each task
            interruptedDuringTask |= Thread.interrupted();
            // safely execute the task in `try-catch` block
            try {
                task.run();
            } catch (Throwable e) {
                // check for InterruptedEx from `task.run`, as other JVM languages may throw InterruptedEx
                if (e instanceof InterruptedException)
                    interruptedDuringTask = true;
                logUncaughtException(ERROR, super.toString() + "#asyncWork", e);
            }
        }
    }

    @GuardedBy("lock")
    private void incrementWorkerCount() {
        workerCount++;
        //  check the concurrency limit issue
        if (workerCount <= maxConcurrency)
            return;
        if (isPowerOfTwo(++exceedLimitTimes))
            log(ERROR, exceedLimitTimes + " concurrency limit violation(s)" + " (current: " + workerCount + " > max: " + maxConcurrency + ") detected in " + this + ". This should never happen - please report this issue to the cffu library!");
    }

    @GuardedBy("lock")
    private void warnLogSyncRunning() {
        if (isPowerOfTwo(++syncRunTimes))
            log(WARN, syncRunTimes + " synchronous execution(s) detected" + " in base executor of " + this + " - base executor runs task on caller thread, likely prevent" + "reaching max concurrency! (current: " + workerCount + ", max: " + maxConcurrency + ")");
    }

    /**
     * Checks if a number is a power of two. Used for throttling repetitive log volume by emitting logs
     * only when the count reaches a power of two (1, 2, 4, 8, 16, 32, 64, ...). This exponential sampling strategy
     * reduces log volume while ensuring that early occurrences are always captured for debugging and monitoring.
     *
     * @see <a href="https://books.google.com/books/about/Hacker_s_Delight.html?id=VicPJYM0I5QC">Algorithm reference:
     * "Hacker's Delight" (2nd edition) by Henry S. Warren Jr., Chapter 3. Power-of-2 Boundaries</a>
     */
    @VisibleForTesting
    static boolean isPowerOfTwo(long n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("removal")
    protected void finalize() throws Throwable {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
