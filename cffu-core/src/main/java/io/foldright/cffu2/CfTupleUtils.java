package io.foldright.cffu2;

import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import io.foldright.cffu2.internal.CommonUtils;
import io.foldright.cffu2.tuple.Tuple2;
import io.foldright.cffu2.tuple.Tuple3;
import io.foldright.cffu2.tuple.Tuple4;
import io.foldright.cffu2.tuple.Tuple5;
import org.jetbrains.annotations.Contract;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.function.Function;
import java.util.function.Supplier;
import static io.foldright.cffu2.CompletableFutureUtils.*;
import static io.foldright.cffu2.LLCF.ASYNC_POOL;
import static io.foldright.cffu2.eh.SwallowedExceptionHandleUtils.handleAllSwallowedExceptions;
import static io.foldright.cffu2.eh.SwallowedExceptionHandleUtils.handleSwallowedExceptions;
import static io.foldright.cffu2.internal.CommonUtils.*;
import static java.util.Objects.requireNonNull;

/**
 * This Utility class provides tuple-based variants of methods from {@link CompletableFutureUtils}
 * for processing and composing multiple asynchronous actions and CompletableFutures in a type-safe manner.
 * <p>
 * While {@link CompletableFutureUtils} uses array-based methods with varargs, this class uses strongly typed tuples
 * containing 2 to 5 elements. The tuple approach provides better type safety when working with a fixed number of
 * heterogeneous actions or CompletableFutures, as type mismatches are caught at compile time rather than runtime.
 *
 * @author Jerry Lee (oldratlee at gmail dot com)
 * @author HuHao (995483610 at qq dot com)
 * @see CompletableFutureUtils
 * @see CfIterableUtils
 * @see CfParallelUtils
 */
public final class CfTupleUtils {

    ////////////////////////////////////////////////////////////////////////////////
    // region# CF Parallel Factory Methods
    ////////////////////////////////////////////////////////////
    // region## Multi-Actions-Tuple(MTuple*) Methods(create by actions)
    ////////////////////////////////////////////////////////////
    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyFailFastAsync(Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2> CompletableFuture<Tuple2<T1, T2>> mSupplyTupleFailFastAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyFailFastAsync(Executor, Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2> CompletableFuture<Tuple2<T1, T2>> mSupplyTupleFailFastAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyFailFastAsync(Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3> CompletableFuture<Tuple3<T1, T2, T3>> mSupplyTupleFailFastAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyFailFastAsync(Executor, Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3> CompletableFuture<Tuple3<T1, T2, T3>> mSupplyTupleFailFastAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyFailFastAsync(Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3, T4> CompletableFuture<Tuple4<T1, T2, T3, T4>> mSupplyTupleFailFastAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Supplier<? extends T4> supplier4) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyFailFastAsync(Executor, Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3, T4> CompletableFuture<Tuple4<T1, T2, T3, T4>> mSupplyTupleFailFastAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Supplier<? extends T4> supplier4, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyFailFastAsync(Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3, T4, T5> CompletableFuture<Tuple5<T1, T2, T3, T4, T5>> mSupplyTupleFailFastAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Supplier<? extends T4> supplier4, Supplier<? extends T5> supplier5) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyFailFastAsync(Executor, Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3, T4, T5> CompletableFuture<Tuple5<T1, T2, T3, T4, T5>> mSupplyTupleFailFastAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Supplier<? extends T4> supplier4, Supplier<? extends T5> supplier5, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T> CompletableFuture<T> f_allTupleWithEhOf0(boolean failFast, CompletionStage<?>[] stages, String where) {
        CompletableFuture<T> ret = f_allTupleOf0(failFast, stages);
        handleSwallowedExceptions(where, ret, stages);
        return ret;
    }

    /**
     * Returns {@code CompletableFuture<T>} with generic type {@code T} but constrained to type TupleX.
     */
    private static <T> CompletableFuture<T> f_allTupleOf0(boolean failFast, CompletionStage<?>[] stages) {
        final AtomicReferenceArray<Object> results = new AtomicReferenceArray<>(stages.length);
        final CompletableFuture<Void>[] resultsSetterCfs = createAllResultsSetterCfs(stages, results);
        final CompletableFuture<Void> resultsSetter;
        if (failFast)
            resultsSetter = allFailFastOf0(resultsSetterCfs);
        else
            resultsSetter = CompletableFuture.allOf(resultsSetterCfs);
        return resultsSetter.thenApply(unused -> f_tupleOf0(toArrayList(results)));
    }

    /**
     * Returns generic type {@code T} but constrained to type TupleX.
     */
    @SuppressWarnings("unchecked")
    private static <T> T f_tupleOf0(List<?> xs) {
        final int len = xs.size();
        final Object ret;
        if (len == 2)
            ret = Tuple2.of(xs.get(0), xs.get(1));
        else if (len == 3)
            ret = Tuple3.of(xs.get(0), xs.get(1), xs.get(2));
        else if (len == 4)
            ret = Tuple4.of(xs.get(0), xs.get(1), xs.get(2), xs.get(3));
        else
            ret = Tuple5.of(xs.get(0), xs.get(1), xs.get(2), xs.get(3), xs.get(4));
        return (T) ret;
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyAllSuccessAsync(Object, Supplier[])} with {@code null} valueIfFailed.
     * <p>
     * If any of the provided suppliers fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2> CompletableFuture<Tuple2<T1, T2>> mSupplyAllSuccessTupleAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyAllSuccessAsync(Executor, Object, Supplier[])} with {@code null} valueIfFailed.
     * <p>
     * If any of the provided suppliers fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2> CompletableFuture<Tuple2<T1, T2>> mSupplyAllSuccessTupleAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyAllSuccessAsync(Object, Supplier[])} with {@code null} valueIfFailed.
     * <p>
     * If any of the provided suppliers fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3> CompletableFuture<Tuple3<T1, T2, T3>> mSupplyAllSuccessTupleAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyAllSuccessAsync(Executor, Object, Supplier[])} with {@code null} valueIfFailed.
     * <p>
     * If any of the provided suppliers fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3> CompletableFuture<Tuple3<T1, T2, T3>> mSupplyAllSuccessTupleAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyAllSuccessAsync(Object, Supplier[])} with {@code null} valueIfFailed.
     * <p>
     * If any of the provided suppliers fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3, T4> CompletableFuture<Tuple4<T1, T2, T3, T4>> mSupplyAllSuccessTupleAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Supplier<? extends T4> supplier4) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyAllSuccessAsync(Executor, Object, Supplier[])} with {@code null} valueIfFailed.
     * <p>
     * If any of the provided suppliers fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3, T4> CompletableFuture<Tuple4<T1, T2, T3, T4>> mSupplyAllSuccessTupleAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Supplier<? extends T4> supplier4, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyAllSuccessAsync(Object, Supplier[])} with {@code null} valueIfFailed.
     * <p>
     * If any of the provided suppliers fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3, T4, T5> CompletableFuture<Tuple5<T1, T2, T3, T4, T5>> mSupplyAllSuccessTupleAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Supplier<? extends T4> supplier4, Supplier<? extends T5> supplier5) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyAllSuccessAsync(Executor, Object, Supplier[])} with {@code null} valueIfFailed.
     * <p>
     * If any of the provided suppliers fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3, T4, T5> CompletableFuture<Tuple5<T1, T2, T3, T4, T5>> mSupplyAllSuccessTupleAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Supplier<? extends T4> supplier4, Supplier<? extends T5> supplier5, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T> CompletableFuture<T> f_allSuccessTupleWithEhOf0(CompletionStage<?>[] stages, String where) {
        handleAllSwallowedExceptions(where, stages);
        return f_allSuccessTupleOf0(stages);
    }

    private static <T> CompletableFuture<T> f_allSuccessTupleOf0(CompletionStage<?>[] stages) {
        return f_allTupleOf0(false, mapArray(stages, CommonUtils::newStageArray, s -> LLCF.covariantExceptionally0(s, ex -> null)));
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyMostSuccessAsync(Object, long, TimeUnit, Supplier[])} with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided suppliers is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2> CompletableFuture<Tuple2<T1, T2>> mSupplyMostSuccessTupleAsync(long timeout, TimeUnit unit, Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyMostSuccessAsync(Executor, Object, long, TimeUnit, Supplier[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided suppliers is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2> CompletableFuture<Tuple2<T1, T2>> mSupplyMostSuccessTupleAsync(long timeout, TimeUnit unit, Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyMostSuccessAsync(Object, long, TimeUnit, Supplier[])} with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided suppliers is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3> CompletableFuture<Tuple3<T1, T2, T3>> mSupplyMostSuccessTupleAsync(long timeout, TimeUnit unit, Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyMostSuccessAsync(Executor, Object, long, TimeUnit, Supplier[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided suppliers is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3> CompletableFuture<Tuple3<T1, T2, T3>> mSupplyMostSuccessTupleAsync(long timeout, TimeUnit unit, Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyMostSuccessAsync(Object, long, TimeUnit, Supplier[])} with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided suppliers is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3, T4> CompletableFuture<Tuple4<T1, T2, T3, T4>> mSupplyMostSuccessTupleAsync(long timeout, TimeUnit unit, Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Supplier<? extends T4> supplier4) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyMostSuccessAsync(Executor, Object, long, TimeUnit, Supplier[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided suppliers is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3, T4> CompletableFuture<Tuple4<T1, T2, T3, T4>> mSupplyMostSuccessTupleAsync(long timeout, TimeUnit unit, Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Supplier<? extends T4> supplier4, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyMostSuccessAsync(Object, long, TimeUnit, Supplier[])} with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided suppliers is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3, T4, T5> CompletableFuture<Tuple5<T1, T2, T3, T4, T5>> mSupplyMostSuccessTupleAsync(long timeout, TimeUnit unit, Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Supplier<? extends T4> supplier4, Supplier<? extends T5> supplier5) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyMostSuccessAsync(Executor, Object, long, TimeUnit, Supplier[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided suppliers is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3, T4, T5> CompletableFuture<Tuple5<T1, T2, T3, T4, T5>> mSupplyMostSuccessTupleAsync(long timeout, TimeUnit unit, Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Supplier<? extends T4> supplier4, Supplier<? extends T5> supplier5, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T> CompletableFuture<T> f_mostSuccessTupleWithEhOf0(Executor executorWhenTimeout, long timeout, TimeUnit unit, CompletionStage<?>[] stages, String where) {
        handleAllSwallowedExceptions(where, stages);
        return f_mostSuccessTupleOf0(executorWhenTimeout, timeout, unit, stages);
    }

    private static <T> CompletableFuture<T> f_mostSuccessTupleOf0(Executor executorWhenTimeout, long timeout, TimeUnit unit, CompletionStage<?>[] stages) {
        // 1. MUST be non-minimal-stage CF instances to read results(`getSuccessNow`), otherwise UnsupportedOpException.
        // 2. SHOULD copy input cfs (by calling `exceptionally` method) to avoid memory leaks,
        //    otherwise all input cfs would be retained until output cf completes.
        CompletableFuture<?>[] cfArray = mapArray(stages, CompletableFuture[]::new, s -> LLCF.toNonMinCf0(s).exceptionally(v -> null));
        return cffuCompleteOnTimeout(CompletableFuture.allOf(cfArray), null, timeout, unit, executorWhenTimeout).handle((unused, ex) -> f_tupleOf0(mGetSuccessNow0(null, cfArray)));
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyAsync(Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2> CompletableFuture<Tuple2<T1, T2>> mSupplyTupleAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyFailFastAsync(Executor, Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2> CompletableFuture<Tuple2<T1, T2>> mSupplyTupleAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyAsync(Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3> CompletableFuture<Tuple3<T1, T2, T3>> mSupplyTupleAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyFailFastAsync(Executor, Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3> CompletableFuture<Tuple3<T1, T2, T3>> mSupplyTupleAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyAsync(Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3, T4> CompletableFuture<Tuple4<T1, T2, T3, T4>> mSupplyTupleAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Supplier<? extends T4> supplier4) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyFailFastAsync(Executor, Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3, T4> CompletableFuture<Tuple4<T1, T2, T3, T4>> mSupplyTupleAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Supplier<? extends T4> supplier4, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyAsync(Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3, T4, T5> CompletableFuture<Tuple5<T1, T2, T3, T4, T5>> mSupplyTupleAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Supplier<? extends T4> supplier4, Supplier<? extends T5> supplier5) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mSupplyFailFastAsync(Executor, Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#mRunAsyncAndForget`")
    public static <T1, T2, T3, T4, T5> CompletableFuture<Tuple5<T1, T2, T3, T4, T5>> mSupplyTupleAsync(Supplier<? extends T1> supplier1, Supplier<? extends T2> supplier2, Supplier<? extends T3> supplier3, Supplier<? extends T4> supplier4, Supplier<? extends T5> supplier5, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    ////////////////////////////////////////////////////////////
    // region## allTupleOf*/mostSuccessTupleOf Methods
    ////////////////////////////////////////////////////////////
    /**
     * Tuple variant of {@link CompletableFutureUtils#allResultsFailFastOf(CompletionStage[])}.
     */
    @Contract(pure = true)
    public static <T1, T2> CompletableFuture<Tuple2<T1, T2>> allTupleFailFastOf(CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#allResultsFailFastOf(CompletionStage[])}.
     */
    @Contract(pure = true)
    public static <T1, T2, T3> CompletableFuture<Tuple3<T1, T2, T3>> allTupleFailFastOf(CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2, CompletionStage<? extends T3> cf3) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#allResultsFailFastOf(CompletionStage[])}.
     */
    @Contract(pure = true)
    public static <T1, T2, T3, T4> CompletableFuture<Tuple4<T1, T2, T3, T4>> allTupleFailFastOf(CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2, CompletionStage<? extends T3> cf3, CompletionStage<? extends T4> cf4) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#allResultsFailFastOf(CompletionStage[])}.
     */
    @Contract(pure = true)
    public static <T1, T2, T3, T4, T5> CompletableFuture<Tuple5<T1, T2, T3, T4, T5>> allTupleFailFastOf(CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2, CompletionStage<? extends T3> cf3, CompletionStage<? extends T4> cf4, CompletionStage<? extends T5> cf5) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#allSuccessResultsOf(Object, CompletionStage[])} with {@code null} valueIfFailed.
     * <p>
     * If any of the provided stages fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the stage having a successful value of {@code null}).
     */
    @Contract(pure = true)
    public static <T1, T2> CompletableFuture<Tuple2<T1, T2>> allSuccessTupleOf(CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#allSuccessResultsOf(Object, CompletionStage[])} with {@code null} valueIfFailed.
     * <p>
     * If any of the provided stages fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the stage having a successful value of {@code null}).
     */
    @Contract(pure = true)
    public static <T1, T2, T3> CompletableFuture<Tuple3<T1, T2, T3>> allSuccessTupleOf(CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2, CompletionStage<? extends T3> cf3) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#allSuccessResultsOf(Object, CompletionStage[])} with {@code null} valueIfFailed.
     * <p>
     * If any of the provided stages fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the stage having a successful value of {@code null}).
     */
    @Contract(pure = true)
    public static <T1, T2, T3, T4> CompletableFuture<Tuple4<T1, T2, T3, T4>> allSuccessTupleOf(CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2, CompletionStage<? extends T3> cf3, CompletionStage<? extends T4> cf4) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#allSuccessResultsOf(Object, CompletionStage[])} with {@code null} valueIfFailed.
     * <p>
     * If any of the provided stages fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the stage having a successful value of {@code null}).
     */
    @Contract(pure = true)
    public static <T1, T2, T3, T4, T5> CompletableFuture<Tuple5<T1, T2, T3, T4, T5>> allSuccessTupleOf(CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2, CompletionStage<? extends T3> cf3, CompletionStage<? extends T4> cf4, CompletionStage<? extends T5> cf5) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mostSuccessResultsOf(Object, long, TimeUnit, CompletionStage[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided stages is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @Contract(pure = true)
    public static <T1, T2> CompletableFuture<Tuple2<T1, T2>> mostSuccessTupleOf(long timeout, TimeUnit unit, CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mostSuccessResultsOf(Executor, Object, long, TimeUnit, CompletionStage[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided stages is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @Contract(pure = true)
    public static <T1, T2> CompletableFuture<Tuple2<T1, T2>> mostSuccessTupleOf(Executor executorWhenTimeout, long timeout, TimeUnit unit, CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mostSuccessResultsOf(Object, long, TimeUnit, CompletionStage[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided stages is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @Contract(pure = true)
    public static <T1, T2, T3> CompletableFuture<Tuple3<T1, T2, T3>> mostSuccessTupleOf(long timeout, TimeUnit unit, CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2, CompletionStage<? extends T3> cf3) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mostSuccessResultsOf(Executor, Object, long, TimeUnit, CompletionStage[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided stages is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @Contract(pure = true)
    public static <T1, T2, T3> CompletableFuture<Tuple3<T1, T2, T3>> mostSuccessTupleOf(Executor executorWhenTimeout, long timeout, TimeUnit unit, CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2, CompletionStage<? extends T3> cf3) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mostSuccessResultsOf(Object, long, TimeUnit, CompletionStage[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided stages is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @Contract(pure = true)
    public static <T1, T2, T3, T4> CompletableFuture<Tuple4<T1, T2, T3, T4>> mostSuccessTupleOf(long timeout, TimeUnit unit, CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2, CompletionStage<? extends T3> cf3, CompletionStage<? extends T4> cf4) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mostSuccessResultsOf(Executor, Object, long, TimeUnit, CompletionStage[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided stages is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @Contract(pure = true)
    public static <T1, T2, T3, T4> CompletableFuture<Tuple4<T1, T2, T3, T4>> mostSuccessTupleOf(Executor executorWhenTimeout, long timeout, TimeUnit unit, CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2, CompletionStage<? extends T3> cf3, CompletionStage<? extends T4> cf4) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mostSuccessResultsOf(Object, long, TimeUnit, CompletionStage[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided stages is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @Contract(pure = true)
    public static <T1, T2, T3, T4, T5> CompletableFuture<Tuple5<T1, T2, T3, T4, T5>> mostSuccessTupleOf(long timeout, TimeUnit unit, CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2, CompletionStage<? extends T3> cf3, CompletionStage<? extends T4> cf4, CompletionStage<? extends T5> cf5) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#mostSuccessResultsOf(Executor, Object, long, TimeUnit, CompletionStage[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided stages is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @Contract(pure = true)
    public static <T1, T2, T3, T4, T5> CompletableFuture<Tuple5<T1, T2, T3, T4, T5>> mostSuccessTupleOf(Executor executorWhenTimeout, long timeout, TimeUnit unit, CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2, CompletionStage<? extends T3> cf3, CompletionStage<? extends T4> cf4, CompletionStage<? extends T5> cf5) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#allResultsOf(CompletionStage[])}.
     */
    @Contract(pure = true)
    public static <T1, T2> CompletableFuture<Tuple2<T1, T2>> allTupleOf(CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#allResultsOf(CompletionStage[])}.
     */
    @Contract(pure = true)
    public static <T1, T2, T3> CompletableFuture<Tuple3<T1, T2, T3>> allTupleOf(CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2, CompletionStage<? extends T3> cf3) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#allResultsOf(CompletionStage[])}.
     */
    @Contract(pure = true)
    public static <T1, T2, T3, T4> CompletableFuture<Tuple4<T1, T2, T3, T4>> allTupleOf(CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2, CompletionStage<? extends T3> cf3, CompletionStage<? extends T4> cf4) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#allResultsOf(CompletionStage[])}.
     */
    @Contract(pure = true)
    public static <T1, T2, T3, T4, T5> CompletableFuture<Tuple5<T1, T2, T3, T4, T5>> allTupleOf(CompletionStage<? extends T1> cf1, CompletionStage<? extends T2> cf2, CompletionStage<? extends T3> cf3, CompletionStage<? extends T4> cf4, CompletionStage<? extends T5> cf5) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    // endregion
    ////////////////////////////////////////////////////////////////////////////////
    // region# CF Instance Methods, Then-Multi-Actions-Tuple(thenMTuple*) Methods
    ////////////////////////////////////////////////////////////////////////////////
    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyFailFastAsync(CompletableFuture, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2> CompletableFuture<Tuple2<U1, U2>> thenMApplyTupleFailFastAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyFailFastAsync(CompletableFuture, Executor, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2> CompletableFuture<Tuple2<U1, U2>> thenMApplyTupleFailFastAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyFailFastAsync(CompletableFuture, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3> CompletableFuture<Tuple3<U1, U2, U3>> thenMApplyTupleFailFastAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyFailFastAsync(CompletableFuture, Executor, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3> CompletableFuture<Tuple3<U1, U2, U3>> thenMApplyTupleFailFastAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyFailFastAsync(CompletableFuture, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3, U4> CompletableFuture<Tuple4<U1, U2, U3, U4>> thenMApplyTupleFailFastAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Function<? super T, ? extends U4> fn4) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyFailFastAsync(CompletableFuture, Executor, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3, U4> CompletableFuture<Tuple4<U1, U2, U3, U4>> thenMApplyTupleFailFastAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Function<? super T, ? extends U4> fn4, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyFailFastAsync(CompletableFuture, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3, U4, U5> CompletableFuture<Tuple5<U1, U2, U3, U4, U5>> thenMApplyTupleFailFastAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Function<? super T, ? extends U4> fn4, Function<? super T, ? extends U5> fn5) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyFailFastAsync(CompletableFuture, Executor, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3, U4, U5> CompletableFuture<Tuple5<U1, U2, U3, U4, U5>> thenMApplyTupleFailFastAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Function<? super T, ? extends U4> fn4, Function<? super T, ? extends U5> fn5, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyAllSuccessAsync(CompletableFuture, Object, Function[])}
     * with {@code null} valueIfFailed.
     * <p>
     * If any of the provided functions fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the function having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2> CompletableFuture<Tuple2<U1, U2>> thenMApplyAllSuccessTupleAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyAllSuccessAsync(CompletableFuture, Executor, Object, Function[])}
     * with {@code null} valueIfFailed.
     * <p>
     * If any of the provided functions fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the function having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2> CompletableFuture<Tuple2<U1, U2>> thenMApplyAllSuccessTupleAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyAllSuccessAsync(CompletableFuture, Object, Function[])}
     * with {@code null} valueIfFailed.
     * <p>
     * If any of the provided functions fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the function having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3> CompletableFuture<Tuple3<U1, U2, U3>> thenMApplyAllSuccessTupleAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyAllSuccessAsync(CompletableFuture, Executor, Object, Function[])}
     * with {@code null} valueIfFailed.
     * <p>
     * If any of the provided functions fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the function having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3> CompletableFuture<Tuple3<U1, U2, U3>> thenMApplyAllSuccessTupleAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyAllSuccessAsync(CompletableFuture, Object, Function[])}
     * with {@code null} valueIfFailed.
     * <p>
     * If any of the provided functions fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the function having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3, U4> CompletableFuture<Tuple4<U1, U2, U3, U4>> thenMApplyAllSuccessTupleAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Function<? super T, ? extends U4> fn4) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyAllSuccessAsync(CompletableFuture, Executor, Object, Function[])}
     * with {@code null} valueIfFailed.
     * <p>
     * If any of the provided functions fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the function having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3, U4> CompletableFuture<Tuple4<U1, U2, U3, U4>> thenMApplyAllSuccessTupleAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Function<? super T, ? extends U4> fn4, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyAllSuccessAsync(CompletableFuture, Object, Function[])}
     * with {@code null} valueIfFailed.
     * <p>
     * If any of the provided functions fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the function having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3, U4, U5> CompletableFuture<Tuple5<U1, U2, U3, U4, U5>> thenMApplyAllSuccessTupleAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Function<? super T, ? extends U4> fn4, Function<? super T, ? extends U5> fn5) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyAllSuccessAsync(CompletableFuture, Executor, Object, Function[])}
     * with {@code null} valueIfFailed.
     * <p>
     * If any of the provided functions fails, its corresponding position will contain {@code null}
     * (which is indistinguishable from the function having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3, U4, U5> CompletableFuture<Tuple5<U1, U2, U3, U4, U5>> thenMApplyAllSuccessTupleAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Function<? super T, ? extends U4> fn4, Function<? super T, ? extends U5> fn5, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyMostSuccessAsync(CompletableFuture, Object, long, TimeUnit, Function[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided suppliers is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2> CompletableFuture<Tuple2<U1, U2>> thenMApplyMostSuccessTupleAsync(CompletableFuture<? extends T> cfThis, long timeout, TimeUnit unit, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyMostSuccessAsync(CompletableFuture, Executor, Object, long, TimeUnit, Function[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided suppliers is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2> CompletableFuture<Tuple2<U1, U2>> thenMApplyMostSuccessTupleAsync(CompletableFuture<? extends T> cfThis, long timeout, TimeUnit unit, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyMostSuccessAsync(CompletableFuture, Object, long, TimeUnit, Function[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided suppliers is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3> CompletableFuture<Tuple3<U1, U2, U3>> thenMApplyMostSuccessTupleAsync(CompletableFuture<? extends T> cfThis, long timeout, TimeUnit unit, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyMostSuccessAsync(CompletableFuture, Executor, Object, long, TimeUnit, Function[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided suppliers is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3> CompletableFuture<Tuple3<U1, U2, U3>> thenMApplyMostSuccessTupleAsync(CompletableFuture<? extends T> cfThis, long timeout, TimeUnit unit, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyMostSuccessAsync(CompletableFuture, Object, long, TimeUnit, Function[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided suppliers is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3, U4> CompletableFuture<Tuple4<U1, U2, U3, U4>> thenMApplyMostSuccessTupleAsync(CompletableFuture<? extends T> cfThis, long timeout, TimeUnit unit, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Function<? super T, ? extends U4> fn4) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyMostSuccessAsync(CompletableFuture, Executor, Object, long, TimeUnit, Function[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided suppliers is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3, U4> CompletableFuture<Tuple4<U1, U2, U3, U4>> thenMApplyMostSuccessTupleAsync(CompletableFuture<? extends T> cfThis, long timeout, TimeUnit unit, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Function<? super T, ? extends U4> fn4, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyMostSuccessAsync(CompletableFuture, Object, long, TimeUnit, Function[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided suppliers is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3, U4, U5> CompletableFuture<Tuple5<U1, U2, U3, U4, U5>> thenMApplyMostSuccessTupleAsync(CompletableFuture<? extends T> cfThis, long timeout, TimeUnit unit, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Function<? super T, ? extends U4> fn4, Function<? super T, ? extends U5> fn5) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyMostSuccessAsync(CompletableFuture, Executor, Object, long, TimeUnit, Function[])}
     * with {@code null} valueIfNotSuccess.
     * <p>
     * If any of the provided suppliers is not completed normally, its corresponding position will contain {@code null}
     * (which is indistinguishable from the supplier having a successful value of {@code null}).
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3, U4, U5> CompletableFuture<Tuple5<U1, U2, U3, U4, U5>> thenMApplyMostSuccessTupleAsync(CompletableFuture<? extends T> cfThis, long timeout, TimeUnit unit, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Function<? super T, ? extends U4> fn4, Function<? super T, ? extends U5> fn5, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyAsync(CompletableFuture, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2> CompletableFuture<Tuple2<U1, U2>> thenMApplyTupleAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyAsync(CompletableFuture, Executor, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2> CompletableFuture<Tuple2<U1, U2>> thenMApplyTupleAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyAsync(CompletableFuture, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3> CompletableFuture<Tuple3<U1, U2, U3>> thenMApplyTupleAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyAsync(CompletableFuture, Executor, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3> CompletableFuture<Tuple3<U1, U2, U3>> thenMApplyTupleAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyAsync(CompletableFuture, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3, U4> CompletableFuture<Tuple4<U1, U2, U3, U4>> thenMApplyTupleAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Function<? super T, ? extends U4> fn4) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyAsync(CompletableFuture, Executor, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3, U4> CompletableFuture<Tuple4<U1, U2, U3, U4>> thenMApplyTupleAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Function<? super T, ? extends U4> fn4, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyAsync(CompletableFuture, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3, U4, U5> CompletableFuture<Tuple5<U1, U2, U3, U4, U5>> thenMApplyTupleAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Function<? super T, ? extends U4> fn4, Function<? super T, ? extends U5> fn5) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tuple variant of {@link CompletableFutureUtils#thenMApplyAsync(CompletableFuture, Executor, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `CFU#thenMAcceptAsyncAndForget`")
    public static <T, U1, U2, U3, U4, U5> CompletableFuture<Tuple5<U1, U2, U3, U4, U5>> thenMApplyTupleAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U1> fn1, Function<? super T, ? extends U2> fn2, Function<? super T, ? extends U3> fn3, Function<? super T, ? extends U4> fn4, Function<? super T, ? extends U5> fn5, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private CfTupleUtils() {
    }
}
