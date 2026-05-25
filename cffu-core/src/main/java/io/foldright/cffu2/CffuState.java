package io.foldright.cffu2;

import org.jetbrains.annotations.Contract;
import java.util.concurrent.Future;
import static java.util.Objects.requireNonNull;

/**
 * This class is the same as {@link Future.State}, existed for java version compatibility.
 *
 * @author Jerry Lee (oldratlee at gmail dot com)
 * @see Future.State
 * @see CompletableFutureUtils#state(Future)
 * @see Cffu#cffuState()
 */
public enum CffuState {

    /**
     * The task has not completed.
     */
    RUNNING {

        @Override
        public Future.State toFutureState() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ,
    /**
     * The task completed with a result.
     *
     * @see Cffu#resultNow()
     * @see Future#resultNow()
     * @see CompletableFutureUtils#resultNow(Future)
     */
    SUCCESS {

        @Override
        public Future.State toFutureState() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ,
    /**
     * The task completed with an exception.
     *
     * @see Cffu#exceptionNow()
     * @see Future#exceptionNow()
     * @see CompletableFutureUtils#exceptionNow(Future)
     */
    FAILED {

        @Override
        public Future.State toFutureState() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ,
    /**
     * The task was cancelled.
     *
     * @see Cffu#cancel(boolean)
     * @see Future#cancel(boolean)
     */
    CANCELLED {

        @Override
        public Future.State toFutureState() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ;

    /**
     * Convert {@link CffuState} to {@link Future.State}.
     *
     * @see #toCffuState(Future.State)
     */
    @Contract(pure = true)
    public abstract Future.State toFutureState();

    /**
     * Convert {@link Future.State} to {@link CffuState}.
     *
     * @see #toFutureState()
     */
    @Contract(pure = true)
    public static CffuState toCffuState(Future.State state) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
