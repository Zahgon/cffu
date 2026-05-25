package io.foldright.cffu2;

import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import edu.umd.cs.findbugs.annotations.Nullable;
import io.foldright.cffu2.internal.CommonUtils;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import static io.foldright.cffu2.CompletableFutureUtils.*;
import static io.foldright.cffu2.LLCF.ASYNC_POOL;
import static io.foldright.cffu2.LLCF.f_cast;
import static io.foldright.cffu2.eh.SwallowedExceptionHandleUtils.handleAllSwallowedExceptions;
import static io.foldright.cffu2.eh.SwallowedExceptionHandleUtils.handleSwallowedExceptions;
import static java.util.Objects.requireNonNull;

/**
 * Utility class for async parallel data processing using CompletableFuture.
 * <p>
 * Supports different concurrency strategies:
 * all-fail-fast, all-success, most-success, all-complete, any-success and any-complete.
 * <p>
 * The parallel processing methods are divided into two categories:
 * <ul>
 * <li>Factory methods that create CompletableFutures from input collections</li>
 * <li>Instance methods that chain parallel operations on existing CompletableFutures(CompletionStages)</li>
 * </ul>
 * <p>
 * <strong>NOTE:</strong> For all methods, the input Iterable is allowed to contain {@code null} elements which are
 * passed directly to the sequential actions, matching CompletableFuture's behavior of allowing {@code null} values.
 * To skip processing {@code null} values, filter them out from the input collection beforehand.
 *
 * @author Jerry Lee (oldratlee at gmail dot com)
 * @see CompletableFutureUtils
 * @see java.util.stream.Stream#parallel()
 * @see java.util.Collection#parallelStream()
 * @see CfIterableUtils
 * @see CfTupleUtils
 */
public final class CfParallelUtils {

    ////////////////////////////////////////////////////////////////////////////////
    // region# CF Factory Methods (create by multiply data and one action)
    //
    //    - parApply* (Iterable, Function: T -> U)    -> CompletableFuture<List<U>>
    //    - parAccept*(Iterable, Consumer: T -> Void) -> CompletableFuture<Void>
    ////////////////////////////////////////////////////////////////////////////////
    /**
     * Shortcut to method {@link CompletableFutureUtils#allResultsFailFastOf allResultsFailFastOf},
     * processes multiple input elements in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier)}.
     * <p>
     * See the {@link CompletableFutureUtils#allResultsFailFastOf allResultsFailFastOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> parApplyFailFastAsync(Iterable<? extends T> elements, Function<? super T, ? extends U> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#allResultsFailFastOf allResultsFailFastOf},
     * processes multiple input elements in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#allResultsFailFastOf allResultsFailFastOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> parApplyFailFastAsync(Iterable<? extends T> elements, Function<? super T, ? extends U> fn, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T, U> CompletableFuture<List<U>> parApplyFailFastAsync0(Iterable<? extends T> elements, Function<? super T, ? extends U> fn, Executor executor, String where) {
        CompletableFuture<U>[] cfs = wrapEleFunction0(elements, fn, executor);
        CompletableFuture<List<U>> ret = allResultsOf0(true, cfs);
        handleSwallowedExceptions(where, ret, cfs);
        return ret;
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#allSuccessResultsOf allSuccessResultsOf},
     * processes multiple input elements in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier)}.
     * <p>
     * See the {@link CompletableFutureUtils#allSuccessResultsOf allSuccessResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> parApplyAllSuccessAsync(Iterable<? extends T> elements, @Nullable U valueIfFailed, Function<? super T, ? extends U> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#allSuccessResultsOf allSuccessResultsOf},
     * processes multiple input elements in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#allSuccessResultsOf allSuccessResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> parApplyAllSuccessAsync(Iterable<? extends T> elements, @Nullable U valueIfFailed, Function<? super T, ? extends U> fn, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T, U> CompletableFuture<List<U>> parApplyAllSuccessAsync0(Iterable<? extends T> elements, @Nullable U valueIfFailed, Function<? super T, ? extends U> fn, Executor executor, String where) {
        CompletableFuture<U>[] cfs = wrapEleFunction0(elements, fn, executor);
        handleAllSwallowedExceptions(where, cfs);
        return allSuccessResultsOf0(valueIfFailed, cfs);
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#mostSuccessResultsOf mostSuccessResultsOf},
     * processes multiple input elements in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier)}.
     * <p>
     * See the {@link CompletableFutureUtils#mostSuccessResultsOf mostSuccessResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> parApplyMostSuccessAsync(Iterable<? extends T> elements, @Nullable U valueIfNotSuccess, long timeout, TimeUnit unit, Function<? super T, ? extends U> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#mostSuccessResultsOf mostSuccessResultsOf},
     * processes multiple input elements in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#mostSuccessResultsOf mostSuccessResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> parApplyMostSuccessAsync(Iterable<? extends T> elements, @Nullable U valueIfNotSuccess, long timeout, TimeUnit unit, Function<? super T, ? extends U> fn, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T, U> CompletableFuture<List<U>> parApplyMostSuccessAsync0(Iterable<? extends T> elements, @Nullable U valueIfNotSuccess, long timeout, TimeUnit unit, Function<? super T, ? extends U> fn, Executor executor, String where) {
        CompletableFuture<U>[] cfs = wrapEleFunction0(elements, fn, executor);
        handleAllSwallowedExceptions(where, cfs);
        return mostSuccessResultsOf0(executor, valueIfNotSuccess, timeout, unit, cfs);
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#allResultsOf allResultsOf},
     * processes multiple input elements in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier)}.
     * <p>
     * See the {@link CompletableFutureUtils#allResultsOf allResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> parApplyAsync(Iterable<? extends T> elements, Function<? super T, ? extends U> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#allResultsOf allResultsOf},
     * processes multiple input elements in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#allResultsOf allResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> parApplyAsync(Iterable<? extends T> elements, Function<? super T, ? extends U> fn, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T, U> CompletableFuture<List<U>> parApplyAsync0(Iterable<? extends T> elements, Function<? super T, ? extends U> fn, Executor executor, String where) {
        CompletableFuture<U>[] cfs = wrapEleFunction0(elements, fn, executor);
        CompletableFuture<List<U>> ret = allResultsOf0(false, cfs);
        handleSwallowedExceptions(where, ret, cfs);
        return ret;
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#anySuccessOf anySuccessOf},
     * processes multiple input elements in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier)}.
     * <p>
     * See the {@link CompletableFutureUtils#anySuccessOf anySuccessOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<U> parApplyAnySuccessAsync(Iterable<? extends T> elements, Function<? super T, ? extends U> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#anySuccessOf anySuccessOf},
     * processes multiple input elements in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#anySuccessOf anySuccessOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<U> parApplyAnySuccessAsync(Iterable<? extends T> elements, Function<? super T, ? extends U> fn, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T, U> CompletableFuture<U> parApplyAnySuccessAsync0(Iterable<? extends T> elements, Function<? super T, ? extends U> fn, Executor executor, String where) {
        CompletableFuture<U>[] cfs = wrapEleFunction0(elements, fn, executor);
        CompletableFuture<U> ret = anySuccessOf0(cfs);
        handleSwallowedExceptions(where, ret, cfs);
        return ret;
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#anyOf anyOf},
     * processes multiple input elements in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier)}.
     * <p>
     * See the {@link CompletableFutureUtils#anyOf anyOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<U> parApplyAnyAsync(Iterable<? extends T> elements, Function<? super T, ? extends U> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#anyOf anyOf},
     * processes multiple input elements in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#anyOf anyOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<U> parApplyAnyAsync(Iterable<? extends T> elements, Function<? super T, ? extends U> fn, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T, U> CompletableFuture<U> parApplyAnyAsync0(Iterable<? extends T> elements, Function<? super T, ? extends U> fn, Executor executor, String where) {
        CompletableFuture<U>[] cfs = wrapEleFunction0(elements, fn, executor);
        CompletableFuture<U> ret = f_cast(CompletableFuture.anyOf(cfs));
        handleSwallowedExceptions(where, ret, cfs);
        return ret;
    }

    private static <T, U> CompletableFuture<U>[] wrapEleFunction0(Iterable<? extends T> elements, Function<? super T, ? extends U> fn, Executor executor) {
        return CommonUtils.toArray(elements, CommonUtils::newCfArray, e -> CompletableFuture.supplyAsync(() -> fn.apply(e), executor));
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#allResultsFailFastOf allResultsFailFastOf},
     * processes multiple input elements in parallel by wrapping each element's action computation
     * into a CompletableFuture using {@link CompletableFuture#runAsync(Runnable)}.
     * <p>
     * See the {@link CompletableFutureUtils#allResultsFailFastOf allResultsFailFastOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> parAcceptFailFastAsync(Iterable<? extends T> elements, Consumer<? super T> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#allResultsFailFastOf allResultsFailFastOf},
     * processes multiple input elements in parallel by wrapping each element's action computation
     * into a CompletableFuture using {@link CompletableFuture#runAsync(Runnable, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#allResultsFailFastOf allResultsFailFastOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> parAcceptFailFastAsync(Iterable<? extends T> elements, Consumer<? super T> action, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T> CompletableFuture<Void> parAcceptFailFastAsync0(Iterable<? extends T> elements, Consumer<? super T> action, Executor executor, String where) {
        CompletableFuture<Void>[] inputs = wrapEleConsumer0(elements, action, executor);
        CompletableFuture<Void> ret = allFailFastOf0(inputs);
        handleSwallowedExceptions(where, ret, inputs);
        return ret;
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#allOf allOf},
     * processes multiple input elements in parallel by wrapping each element's action computation
     * into a CompletableFuture using {@link CompletableFuture#runAsync(Runnable)}.
     * <p>
     * See the {@link CompletableFutureUtils#allOf allOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> parAcceptAsync(Iterable<? extends T> elements, Consumer<? super T> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#allOf allOf},
     * processes multiple input elements in parallel by wrapping each element's action computation
     * into a CompletableFuture using {@link CompletableFuture#runAsync(Runnable, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#allOf allOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> parAcceptAsync(Iterable<? extends T> elements, Consumer<? super T> action, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T> CompletableFuture<Void> parAcceptAsync0(Iterable<? extends T> elements, Consumer<? super T> action, Executor executor, String where) {
        CompletableFuture<Void>[] inputs = wrapEleConsumer0(elements, action, executor);
        CompletableFuture<Void> ret = CompletableFuture.allOf(inputs);
        handleSwallowedExceptions(where, ret, inputs);
        return ret;
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#anySuccessOf anySuccessOf},
     * processes multiple input elements in parallel by wrapping each element's action computation
     * into a CompletableFuture using {@link CompletableFuture#runAsync(Runnable)}.
     * <p>
     * See the {@link CompletableFutureUtils#anySuccessOf anySuccessOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> parAcceptAnySuccessAsync(Iterable<? extends T> elements, Consumer<? super T> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#anySuccessOf anySuccessOf},
     * processes multiple input elements in parallel by wrapping each element's action computation
     * into a CompletableFuture using {@link CompletableFuture#runAsync(Runnable, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#anySuccessOf anySuccessOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> parAcceptAnySuccessAsync(Iterable<? extends T> elements, Consumer<? super T> action, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T> CompletableFuture<Void> parAcceptAnySuccessAsync0(Iterable<? extends T> elements, Consumer<? super T> action, Executor executor, String where) {
        CompletableFuture<Void>[] inputs = wrapEleConsumer0(elements, action, executor);
        CompletableFuture<Void> ret = anySuccessOf0(inputs);
        handleSwallowedExceptions(where, ret, inputs);
        return ret;
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#anyOf anyOf},
     * processes multiple input elements in parallel by wrapping each element's action computation
     * into a CompletableFuture using {@link CompletableFuture#runAsync(Runnable)}.
     * <p>
     * See the {@link CompletableFutureUtils#anyOf anyOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> parAcceptAnyAsync(Iterable<? extends T> elements, Consumer<? super T> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#anyOf anyOf},
     * processes multiple input elements in parallel by wrapping each element's action computation
     * into a CompletableFuture using {@link CompletableFuture#runAsync(Runnable, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#anyOf anyOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `parAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> parAcceptAnyAsync(Iterable<? extends T> elements, Consumer<? super T> action, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T> CompletableFuture<Void> parAcceptAnyAsync0(Iterable<? extends T> elements, Consumer<? super T> action, Executor executor, String where) {
        CompletableFuture<Void>[] inputs = wrapEleConsumer0(elements, action, executor);
        CompletableFuture<Void> ret = f_cast(CompletableFuture.anyOf(inputs));
        handleSwallowedExceptions(where, ret, inputs);
        return ret;
    }

    /**
     * Processes multiple input elements in parallel and forget (return {@code void}).
     * This method explicitly indicates that the caller will not care about any exceptions
     * from actions and will not wait for the computations to complete ("fire-and-forget").
     *
     * @since 2.1.0
     */
    public static <T> void parAcceptAsyncAndForget(Iterable<? extends T> elements, Consumer<? super T> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Processes multiple input elements in parallel and forget (return {@code void}).
     * This method explicitly indicates that the caller will not care about any exceptions
     * from actions and will not wait for the computations to complete ("fire-and-forget").
     *
     * @since 2.1.0
     */
    public static <T> void parAcceptAsyncAndForget(Iterable<? extends T> elements, Consumer<? super T> action, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T> void parAcceptAsyncAndForget0(Iterable<? extends T> elements, Consumer<? super T> action, Executor executor, String where) {
        CompletableFuture<Void>[] inputs = wrapEleConsumer0(elements, action, executor);
        handleAllSwallowedExceptions(where, inputs);
    }

    private static <T> CompletableFuture<Void>[] wrapEleConsumer0(Iterable<? extends T> elements, Consumer<? super T> action, Executor executor) {
        return CommonUtils.toArray(elements, CommonUtils::newCfArray, e -> CompletableFuture.runAsync(() -> action.accept(e), executor));
    }

    // endregion
    ////////////////////////////////////////////////////////////////////////////////
    // region# CF Instance Methods for CF<Iterable<T>>
    //
    //    - thenParApply* (CF<Iterable>, Function: T -> U)    -> CompletableFuture<List<U>>
    //    - thenParAccept*(CF<Iterable>, Consumer: T -> Void) -> CompletableFuture<Void>
    ////////////////////////////////////////////////////////////////////////////////
    /**
     * Shortcut to method {@link CompletableFutureUtils#allResultsFailFastOf allResultsFailFastOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier, Executor)} with the default executor of parameter cfThis.
     * <p>
     * See the {@link CompletableFutureUtils#allResultsFailFastOf allResultsFailFastOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> thenParApplyFailFastAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, Function<? super T, ? extends U> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#allResultsFailFastOf allResultsFailFastOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#allResultsFailFastOf allResultsFailFastOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> thenParApplyFailFastAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, Function<? super T, ? extends U> fn, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#allSuccessResultsOf allSuccessResultsOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier, Executor)} with the default executor of parameter cfThis.
     * <p>
     * See the {@link CompletableFutureUtils#allSuccessResultsOf allSuccessResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> thenParApplyAllSuccessAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, @Nullable U valueIfFailed, Function<? super T, ? extends U> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#allSuccessResultsOf allSuccessResultsOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#allSuccessResultsOf allSuccessResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> thenParApplyAllSuccessAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, @Nullable U valueIfFailed, Function<? super T, ? extends U> fn, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#mostSuccessResultsOf mostSuccessResultsOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier, Executor)} with the default executor of parameter cfThis.
     * <p>
     * See the {@link CompletableFutureUtils#mostSuccessResultsOf mostSuccessResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> thenParApplyMostSuccessAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, @Nullable U valueIfNotSuccess, long timeout, TimeUnit unit, Function<? super T, ? extends U> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#mostSuccessResultsOf mostSuccessResultsOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#mostSuccessResultsOf mostSuccessResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> thenParApplyMostSuccessAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, @Nullable U valueIfNotSuccess, long timeout, TimeUnit unit, Function<? super T, ? extends U> fn, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#allResultsOf allResultsOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier, Executor)} with the default executor of parameter cfThis.
     * <p>
     * See the {@link CompletableFutureUtils#allResultsOf allResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> thenParApplyAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, Function<? super T, ? extends U> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#allResultsOf allResultsOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#allResultsOf allResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> thenParApplyAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, Function<? super T, ? extends U> fn, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#anySuccessOf anySuccessOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier, Executor)} with the default executor of parameter cfThis.
     * <p>
     * See the {@link CompletableFutureUtils#anySuccessOf anySuccessOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<U> thenParApplyAnySuccessAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, Function<? super T, ? extends U> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#anySuccessOf anySuccessOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#anySuccessOf anySuccessOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<U> thenParApplyAnySuccessAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, Function<? super T, ? extends U> fn, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#anyOf anyOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier, Executor)} with the default executor of parameter cfThis.
     * <p>
     * See the {@link CompletableFutureUtils#anyOf anyOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<U> thenParApplyAnyAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, Function<? super T, ? extends U> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#anyOf anyOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's function computation
     * into a CompletableFuture using {@link CompletableFuture#supplyAsync(Supplier, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#anyOf anyOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<U> thenParApplyAnyAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, Function<? super T, ? extends U> fn, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#allResultsFailFastOf allResultsFailFastOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's action computation
     * into a CompletableFuture using {@link CompletableFuture#runAsync(Runnable, Executor)} with the default executor of parameter cfThis.
     * <p>
     * See the {@link CompletableFutureUtils#allResultsFailFastOf allResultsFailFastOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> thenParAcceptFailFastAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, Consumer<? super T> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#allResultsFailFastOf allResultsFailFastOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's action computation
     * into a CompletableFuture using {@link CompletableFuture#runAsync(Runnable, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#allResultsFailFastOf allResultsFailFastOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> thenParAcceptFailFastAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, Consumer<? super T> action, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#allOf allOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's action computation
     * into a CompletableFuture using {@link CompletableFuture#runAsync(Runnable, Executor)} with the default executor of parameter cfThis.
     * <p>
     * See the {@link CompletableFutureUtils#allOf allOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> thenParAcceptAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, Consumer<? super T> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#allOf allOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's action computation
     * into a CompletableFuture using {@link CompletableFuture#runAsync(Runnable, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#allOf allOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> thenParAcceptAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, Consumer<? super T> action, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#anySuccessOf anySuccessOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's action computation
     * into a CompletableFuture using {@link CompletableFuture#runAsync(Runnable, Executor)} with the default executor of parameter cfThis.
     * <p>
     * See the {@link CompletableFutureUtils#anySuccessOf anySuccessOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> thenParAcceptAnySuccessAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, Consumer<? super T> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#anySuccessOf anySuccessOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's action computation
     * into a CompletableFuture using {@link CompletableFuture#runAsync(Runnable, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#anySuccessOf anySuccessOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> thenParAcceptAnySuccessAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, Consumer<? super T> action, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#anyOf anyOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's action computation
     * into a CompletableFuture using {@link CompletableFuture#runAsync(Runnable, Executor)} with the default executor of parameter cfThis.
     * <p>
     * See the {@link CompletableFutureUtils#anyOf anyOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> thenParAcceptAnyAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, Consumer<? super T> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link CompletableFutureUtils#anyOf anyOf},
     * processes elements from the result of parameter cfThis in parallel by wrapping each element's action computation
     * into a CompletableFuture using {@link CompletableFuture#runAsync(Runnable, Executor)}.
     * <p>
     * See the {@link CompletableFutureUtils#anyOf anyOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenParAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> thenParAcceptAnyAsync(CompletableFuture<? extends Iterable<? extends T>> cfThis, Consumer<? super T> action, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Processes elements from the result of parameter cfThis in parallel and forget (return {@code void}).
     * This method explicitly indicates that the caller will not care about any exceptions
     * from actions and will not wait for the computations to complete ("fire-and-forget").
     *
     * @return the given CompletableFuture
     * @since 2.1.0
     */
    public static <T, F extends CompletionStage<? extends Iterable<? extends T>>> F thenParAcceptAsyncAndForget(F cfThis, Consumer<? super T> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Processes elements from the result of parameter cfThis in parallel and forget (return {@code void}).
     * This method explicitly indicates that the caller will not care about any exceptions
     * from actions and will not wait for the computations to complete ("fire-and-forget").
     *
     * @return the given CompletableFuture
     * @since 2.1.0
     */
    public static <T, F extends CompletionStage<? extends Iterable<? extends T>>> F thenParAcceptAsyncAndForget(F cfThis, Consumer<? super T> action, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private CfParallelUtils() {
    }
}
