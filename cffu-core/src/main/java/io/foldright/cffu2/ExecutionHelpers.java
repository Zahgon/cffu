package io.foldright.cffu2;

// =============================================================================
//# delay execution helper classes
//
//  the below code is copied from CompletableFuture with small adaptions
// =============================================================================
import edu.umd.cs.findbugs.annotations.Nullable;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import static java.util.Objects.requireNonNull;

/**
 * Singleton delay scheduler, used only for starting and cancelling tasks
 * <p>
 * code is copied from {@link CompletableFuture.Delayer} with small adaptions.
 */
@SuppressWarnings("JavadocReference")
final class Delayer {

    /**
     * @return a Future that can be used to cancel the delayed task
     * @see FutureCanceller
     * @see DelayedExecutor#execute(Runnable)
     */
    static ScheduledFuture<?> delay(Runnable command, long delay, TimeUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return a Future can be used to cancel the delayed task (timeout CF)
     * @see FutureCanceller
     */
    static ScheduledFuture<?> delayToTimeoutCf(CompletableFuture<?> cf, long delay, TimeUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return a Future can be used to cancel the delayed task (complete CF)
     * @see FutureCanceller
     */
    static <T> ScheduledFuture<?> delayToCompleteCf(CompletableFuture<? super T> cf, @Nullable T value, long delay, TimeUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks whether execution is at the thread of CompletableFuture/Cffu delayer.
     * <p>
     * The constant {@code "CompletableFutureDelayScheduler"} is defined
     * at {@link CompletableFuture.Delayer.DaemonThreadFactory}.
     */
    @SuppressWarnings("JavadocReference")
    static boolean atCfDelayerThread() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final String THREAD_NAME_OF_CFFU_DELAY_SCHEDULER = "CffuBuiltinDelayScheduler";

    private static final Set<String> DELAY_SCHEDULER_THREAD_NAMES = new HashSet<>(Arrays.asList(// Java 9 ~ 24
    "CompletableFutureDelayScheduler", // Java 25
    "ForkJoinPool.commonPool-delayScheduler", THREAD_NAME_OF_CFFU_DELAY_SCHEDULER));

    /**
     * Holds {@link #delayer} scheduler as field of static inner class for lazy loading (init only when needed).
     * <p>
     * The lazy loading is need because {@link #atCfDelayerThread()} method of
     * class {@link Delayer} is used on {@code Java 9+}.
     */
    private static final class DelayerHolder {

        static final ScheduledThreadPoolExecutor delayer;

        static {
            delayer = new ScheduledThreadPoolExecutor(1, new DaemonThreadFactory());
            delayer.setRemoveOnCancelPolicy(true);
        }
    }

    private static final class DaemonThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private Delayer() {
    }
}

/**
 * An executor wrapper with delayed execution.
 * <p>
 * code is copied from {@link CompletableFuture.DelayedExecutor} with small adaptions.
 */
@SuppressWarnings("JavadocReference")
final class DelayedExecutor implements Executor {

    private final long delay;

    private final TimeUnit unit;

    private final Executor executor;

    DelayedExecutor(long delay, TimeUnit unit, Executor executor) {
        this.delay = delay;
        this.unit = unit;
        this.executor = executor;
    }

    @Override
    public void execute(Runnable r) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

// =============================================================================
// Little classified lambdas to better support monitoring
// =============================================================================
/**
 * Action to submit the task (Runnable) to executor.
 * <p>
 * code is copied from {@link CompletableFuture.TaskSubmitter} with small adaptions.
 */
@SuppressWarnings("JavadocReference")
final class TaskSubmitter implements Runnable {

    private final Executor executor;

    private final Runnable action;

    TaskSubmitter(Executor executor, Runnable action) {
        this.executor = executor;
        this.action = action;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

/**
 * Action to cf.completeExceptionally with TimeoutException.
 * <p>
 * code is copied from {@link CompletableFuture.Timeout} with small adaptions.
 */
@SuppressWarnings("JavadocReference")
final class CfTimeout implements Runnable {

    private final CompletableFuture<?> cf;

    CfTimeout(CompletableFuture<?> cf) {
        this.cf = cf;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

/**
 * Action to complete cf.
 * <p>
 * code is copied from {@link CompletableFuture.DelayedCompleter} with small adaptions.
 */
@SuppressWarnings("JavadocReference")
final class CfCompleter<T> implements Runnable {

    private final CompletableFuture<? super T> cf;

    @Nullable
    private final T value;

    CfCompleter(CompletableFuture<? super T> cf, @Nullable T value) {
        this.cf = cf;
        this.value = value;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

/**
 * Action to cancel the unneeded scheduled task by Future (for example, timeouts).
 * <p>
 * code is copied from {@link CompletableFuture.Canceller} with small adaptions.
 *
 * @see Delayer#delay(Runnable, long, TimeUnit)
 * @see Delayer#delayToTimeoutCf(CompletableFuture, long, TimeUnit)
 * @see Delayer#delayToCompleteCf(CompletableFuture, Object, long, TimeUnit)
 */
@SuppressWarnings("JavadocReference")
final class FutureCanceller implements BiConsumer<Object, Throwable> {

    private final Future<?> f;

    FutureCanceller(Future<?> f) {
        this.f = f;
    }

    /**
     * Note: Before Java 21(Java 20-), {@link CompletableFuture#orTimeout(long, TimeUnit)}
     * leaks if the future completes exceptionally; For more information, see
     * <a href="https://bugs.openjdk.org/browse/JDK-8303742">issue JDK-8303742</a>,
     * <a href="https://github.com/openjdk/jdk/pull/13059">PR review openjdk/jdk/13059</a>
     * and <a href="https://github.com/openjdk/jdk/commit/ded6a8131970ac2f7ae59716769e6f6bae3b809a">JDK bugfix commit</a>.
     */
    @Override
    public void accept(Object ignore, @Nullable Throwable ex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

/**
 * code is copied from {@link CompletableFuture.AsyncSupply} with small adaptions.
 */
@SuppressWarnings("JavadocReference")
@SuppressFBWarnings("SE_BAD_FIELD")
final class CfCompleterBySupplier<T> extends ForkJoinTask<Void> implements Runnable, CompletableFuture.AsynchronousCompletionTask {

    private static final long serialVersionUID = 4465654102372072986L;

    @Nullable
    private CompletableFuture<? super T> dep;

    @Nullable
    private Supplier<? extends T> fn;

    CfCompleterBySupplier(CompletableFuture<? super T> dep, Supplier<? extends T> fn) {
        this.dep = dep;
        this.fn = fn;
    }

    @Override
    public Void getRawResult() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setRawResult(Void v) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean exec() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

/**
 * code is copied from {@link CompletableFuture.AsyncSupply} with small adaptions.
 */
@SuppressWarnings("JavadocReference")
@SuppressFBWarnings("SE_BAD_FIELD")
final class CfExCompleterBySupplier extends ForkJoinTask<Void> implements Runnable, CompletableFuture.AsynchronousCompletionTask {

    private static final long serialVersionUID = -8839478315679555049L;

    @Nullable
    private CompletableFuture<?> dep;

    @Nullable
    private Supplier<? extends Throwable> fn;

    CfExCompleterBySupplier(CompletableFuture<?> dep, Supplier<? extends Throwable> fn) {
        this.dep = dep;
        this.fn = fn;
    }

    @Override
    public Void getRawResult() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setRawResult(Void v) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean exec() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
