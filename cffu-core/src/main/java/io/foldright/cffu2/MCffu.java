package io.foldright.cffu2;

import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import edu.umd.cs.findbugs.annotations.Nullable;
import org.jetbrains.annotations.Contract;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import static io.foldright.cffu2.CffuFactoryBuilder.cffuScreened;

/**
 * Cffu with result type {@link Iterable}, i.e. multiply data/collection,
 * {@code MCffu<E, List<E>>} is same as {@code Cffu<List<E>>} except with more methods.
 *
 * @param <T> The result collection type returned by this future's {@code join}
 * @param <E> the data element type of result collection
 * @author Jerry Lee (oldratlee at gmail dot com)
 * @see Cffu
 */
public final class MCffu<E, T extends Iterable<? extends E>> extends BaseCffu<T, MCffu<E, T>> implements Future<T>, CompletionStage<T> {

    ////////////////////////////////////////////////////////////////////////////////
    // region# Internal constructor/methods
    ////////////////////////////////////////////////////////////////////////////////
    /**
     * INTERNAL constructor.
     */
    MCffu(CffuFactory cffuFactory, boolean isMinimalStage, CompletableFuture<T> cf) {
        super(cffuFactory, isMinimalStage, cf);
    }

    @Override
    MCffu<E, T> create(CffuFactory fac, boolean isMinimalStage, CompletableFuture<T> cf) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    ////////////////////////////////////////////////////////////////////////////////
    // region# Conversion Methods
    ////////////////////////////////////////////////////////////////////////////////
    /**
     * Converts to {@link Cffu}, reuse the underlying CompletableFuture instance and rewraps it to {@link Cffu}.
     *
     * @see Cffu#asMCffu(Cffu)
     * @see CffuFactory#toCffu(CompletionStage)
     */
    @Contract(pure = true)
    public Cffu<T> asCffu() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    ////////////////////////////////////////////////////////////////////////////////
    // region# More Ops
    ////////////////////////////////////////////////////////////////////////////////
    /**
     * Returns a {@link ParOps} instance to access the methods for parallel data processing.
     *
     * @see CffuFactory#parOps()
     * @see CfParallelUtils
     */
    public ParOps parOps() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The methods for parallel data processing.
     *
     * @see CffuFactory#parOps()
     * @see CfParallelUtils
     */
    public final class ParOps {

        ////////////////////////////////////////////////////////////////////////////////
        // - thenParApply* (CF<Iterable>, Function: E -> U)    -> MCffu<U, List<U>>
        // - thenParAccept*(CF<Iterable>, Consumer: E -> Void) -> Cffu<Void>
        ////////////////////////////////////////////////////////////////////////////////
        /**
         * Shortcut to method {@link CffuFactory#allResultsFailFastOf allResultsFailFastOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's function computation
         * into a Cffu using {@link CffuFactory#supplyAsync(Supplier)} with the executor {@link #defaultExecutor()}.
         * <p>
         * See the {@link CffuFactory#allResultsFailFastOf allResultsFailFastOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned MCffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public <U> MCffu<U, List<U>> thenParApplyFailFastAsync(Function<? super E, ? extends U> fn) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#allResultsFailFastOf allResultsFailFastOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's function computation
         * into a Cffu using {@link CffuFactory#supplyAsync(Supplier, Executor)}.
         * <p>
         * See the {@link CffuFactory#allResultsFailFastOf allResultsFailFastOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned MCffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public <U> MCffu<U, List<U>> thenParApplyFailFastAsync(Function<? super E, ? extends U> fn, Executor executor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#allSuccessResultsOf allSuccessResultsOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's function computation
         * into a Cffu using {@link CffuFactory#supplyAsync(Supplier)} with the executor {@link #defaultExecutor()}.
         * <p>
         * See the {@link CffuFactory#allSuccessResultsOf allSuccessResultsOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned MCffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public <U> MCffu<U, List<U>> thenParApplyAllSuccessAsync(@Nullable U valueIfFailed, Function<? super E, ? extends U> fn) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#allSuccessResultsOf allSuccessResultsOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's function computation
         * into a Cffu using {@link CffuFactory#supplyAsync(Supplier, Executor)}.
         * <p>
         * See the {@link CffuFactory#allSuccessResultsOf allSuccessResultsOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned MCffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public <U> MCffu<U, List<U>> thenParApplyAllSuccessAsync(@Nullable U valueIfFailed, Function<? super E, ? extends U> fn, Executor executor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#mostSuccessResultsOf mostSuccessResultsOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's function computation
         * into a Cffu using {@link CffuFactory#supplyAsync(Supplier)} with the executor {@link #defaultExecutor()}.
         * <p>
         * See the {@link CffuFactory#mostSuccessResultsOf mostSuccessResultsOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned MCffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public <U> MCffu<U, List<U>> thenParApplyMostSuccessAsync(@Nullable U valueIfNotSuccess, long timeout, TimeUnit unit, Function<? super E, ? extends U> fn) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#mostSuccessResultsOf mostSuccessResultsOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's function computation
         * into a Cffu using {@link CffuFactory#supplyAsync(Supplier, Executor)}.
         * <p>
         * See the {@link CffuFactory#mostSuccessResultsOf mostSuccessResultsOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned MCffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public <U> MCffu<U, List<U>> thenParApplyMostSuccessAsync(@Nullable U valueIfNotSuccess, long timeout, TimeUnit unit, Function<? super E, ? extends U> fn, Executor executor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#allResultsOf allResultsOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's function computation
         * into a Cffu using {@link CffuFactory#supplyAsync(Supplier)} with the executor {@link #defaultExecutor()}.
         * <p>
         * See the {@link CffuFactory#allResultsOf allResultsOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned MCffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public <U> MCffu<U, List<U>> thenParApplyAsync(Function<? super E, ? extends U> fn) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#allResultsOf allResultsOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's function computation
         * into a Cffu using {@link CffuFactory#supplyAsync(Supplier, Executor)}.
         * <p>
         * See the {@link CffuFactory#allResultsOf allResultsOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned MCffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public <U> MCffu<U, List<U>> thenParApplyAsync(Function<? super E, ? extends U> fn, Executor executor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#anySuccessOf anySuccessOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's function computation
         * into a Cffu using {@link CffuFactory#supplyAsync(Supplier)} with the executor {@link #defaultExecutor()}.
         * <p>
         * See the {@link CffuFactory#anySuccessOf anySuccessOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned Cffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public <U> Cffu<U> thenParApplyAnySuccessAsync(Function<? super E, ? extends U> fn) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#anySuccessOf anySuccessOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's function computation
         * into a Cffu using {@link CffuFactory#supplyAsync(Supplier, Executor)}.
         * <p>
         * See the {@link CffuFactory#anySuccessOf anySuccessOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned Cffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public <U> Cffu<U> thenParApplyAnySuccessAsync(Function<? super E, ? extends U> fn, Executor executor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#anyOf anyOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's function computation
         * into a Cffu using {@link CffuFactory#supplyAsync(Supplier)} with the executor {@link #defaultExecutor()}.
         * <p>
         * See the {@link CffuFactory#anyOf anyOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned Cffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public <U> Cffu<U> thenParApplyAnyAsync(Function<? super E, ? extends U> fn) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#anyOf anyOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's function computation
         * into a Cffu using {@link CffuFactory#supplyAsync(Supplier, Executor)}.
         * <p>
         * See the {@link CffuFactory#anyOf anyOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned Cffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public <U> Cffu<U> thenParApplyAnyAsync(Function<? super E, ? extends U> fn, Executor executor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#allResultsFailFastOf allResultsFailFastOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's consumer computation
         * into a Cffu using {@link CffuFactory#runAsync(Runnable)} with the executor {@link #defaultExecutor()}.
         * <p>
         * See the {@link CffuFactory#allResultsFailFastOf allResultsFailFastOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned Cffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public Cffu<Void> thenParAcceptFailFastAsync(Consumer<? super E> action) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#allResultsFailFastOf allResultsFailFastOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's consumer computation
         * into a Cffu using {@link CffuFactory#runAsync(Runnable, Executor)}.
         * <p>
         * See the {@link CffuFactory#allResultsFailFastOf allResultsFailFastOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned Cffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public Cffu<Void> thenParAcceptFailFastAsync(Consumer<? super E> action, Executor executor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#allResultsOf allResultsOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's consumer computation
         * into a Cffu using {@link CffuFactory#runAsync(Runnable)} with the executor {@link #defaultExecutor()}.
         * <p>
         * See the {@link CffuFactory#allResultsOf allResultsOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned Cffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public Cffu<Void> thenParAcceptAsync(Consumer<? super E> action) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#allResultsOf allResultsOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's consumer computation
         * into a Cffu using {@link CffuFactory#runAsync(Runnable, Executor)}.
         * <p>
         * See the {@link CffuFactory#allResultsOf allResultsOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned Cffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public Cffu<Void> thenParAcceptAsync(Consumer<? super E> action, Executor executor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#anySuccessOf anySuccessOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's consumer computation
         * into a Cffu using {@link CffuFactory#runAsync(Runnable)} with the executor {@link #defaultExecutor()}.
         * <p>
         * See the {@link CffuFactory#anySuccessOf anySuccessOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned Cffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public Cffu<Void> thenParAcceptAnySuccessAsync(Consumer<? super E> action) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#anySuccessOf anySuccessOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's consumer computation
         * into a Cffu using {@link CffuFactory#runAsync(Runnable, Executor)}.
         * <p>
         * See the {@link CffuFactory#anySuccessOf anySuccessOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned Cffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public Cffu<Void> thenParAcceptAnySuccessAsync(Consumer<? super E> action, Executor executor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#anyOf anyOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's consumer computation
         * into a Cffu using {@link CffuFactory#runAsync(Runnable)} with the executor {@link #defaultExecutor()}.
         * <p>
         * See the {@link CffuFactory#anyOf anyOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned Cffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public Cffu<Void> thenParAcceptAnyAsync(Consumer<? super E> action) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to method {@link CffuFactory#anyOf anyOf},
         * processes elements from the result of this MCffu in parallel by wrapping each element's consumer computation
         * into a Cffu using {@link CffuFactory#runAsync(Runnable, Executor)}.
         * <p>
         * See the {@link CffuFactory#anyOf anyOf} documentation for the rules of result computation.
         */
        @CheckReturnValue(explanation = "should use the returned Cffu; otherwise, use method `thenParAcceptAsyncAndForget`")
        public Cffu<Void> thenParAcceptAnyAsync(Consumer<? super E> action, Executor executor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Processes elements from the result of parameter cfThis in parallel and forget (return {@code void}).
         * This method explicitly indicates that the caller will not care about any exceptions
         * from actions and will not wait for the computations to complete ("fire-and-forget").
         *
         * @return this MCffu
         * @since 2.1.0
         */
        public MCffu<E, T> thenParAcceptAsyncAndForget(Consumer<? super E> action) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Processes elements from the result of parameter cfThis in parallel and forget (return {@code void}).
         * This method explicitly indicates that the caller will not care about any exceptions
         * from actions and will not wait for the computations to complete ("fire-and-forget").
         *
         * @return this MCffu
         * @since 2.1.0
         */
        public MCffu<E, T> thenParAcceptAsyncAndForget(Consumer<? super E> action, Executor executor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private ParOps() {
        }
    }
}
