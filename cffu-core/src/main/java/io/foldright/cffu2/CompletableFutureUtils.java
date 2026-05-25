package io.foldright.cffu2;

import com.google.common.util.concurrent.Futures;
import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import edu.umd.cs.findbugs.annotations.Nullable;
import io.foldright.cffu2.internal.CommonUtils;
import io.foldright.cffu2.tuple.Tuple2;
import org.jetbrains.annotations.Blocking;
import org.jetbrains.annotations.Contract;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.function.*;
import static io.foldright.cffu2.LLCF.*;
import static io.foldright.cffu2.eh.SwallowedExceptionHandleUtils.handleAllSwallowedExceptions;
import static io.foldright.cffu2.eh.SwallowedExceptionHandleUtils.handleSwallowedExceptions;
import static io.foldright.cffu2.internal.CommonUtils.*;
import static java.lang.Thread.currentThread;
import static java.util.Objects.requireNonNull;
import static java.util.concurrent.CompletableFuture.completedFuture;

/**
 * Utility class providing enhanced and backport methods for {@link CompletableFuture}.
 *
 * @author Jerry Lee (oldratlee at gmail dot com)
 * @author HuHao (995483610 at qq dot com)
 * @author Eric Lin (linqinghua4 at gmail dot com)
 * @see CompletableFuture
 * @see CfIterableUtils
 * @see CfParallelUtils
 * @see CfTupleUtils
 */
public final class CompletableFutureUtils {

    /*
     * Implementation Note about the name convention of internal methods:
     *
     * - methods with `f_` prefix means not type-safe, e.g.
     *    - return type CompletableFuture that may be a minimal-stage
     *    - forcefully cast to CompletableFuture<T> from any CompletableFuture<?>
     *    - return generic type T but constrained runtime type TupleX
     * - methods with `0` suffix mean no parameter validation, e.g.
     *    - no null check
     *
     * because these methods are not safe, caller logic SHOULD pay attention to keep implementation correct.
     */
    ////////////////////////////////////////////////////////////////////////////////
    // region# CF Factory Methods (including static methods of CF)
    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////
    // region## Multi-Actions(M*) Methods(create by actions)
    //
    //    - Supplier<T>[] -> CompletableFuture<List<T>>
    //    - Runnable[]    -> CompletableFuture<Void>
    ////////////////////////////////////////////////////////////
    /**
     * Shortcut to method {@link #allResultsFailFastOf allResultsFailFastOf}, wraps input suppliers to
     * CompletableFuture by {@link CompletableFuture#supplyAsync(Supplier)}.
     * <p>
     * See the {@link #allResultsFailFastOf allResultsFailFastOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<List<T>> mSupplyFailFastAsync(Supplier<? extends T>... suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allResultsFailFastOf allResultsFailFastOf}, wraps input suppliers to
     * CompletableFuture by {@link CompletableFuture#supplyAsync(Supplier, Executor)}.
     * <p>
     * See the {@link #allResultsFailFastOf allResultsFailFastOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<List<T>> mSupplyFailFastAsync(Executor executor, Supplier<? extends T>... suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allSuccessResultsOf allSuccessResultsOf}, wraps input suppliers to
     * CompletableFuture by {@link CompletableFuture#supplyAsync(Supplier)}.
     * <p>
     * See the {@link #allSuccessResultsOf allSuccessResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<List<T>> mSupplyAllSuccessAsync(@Nullable T valueIfFailed, Supplier<? extends T>... suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allSuccessResultsOf allSuccessResultsOf}, wraps input suppliers to
     * CompletableFuture by {@link CompletableFuture#supplyAsync(Supplier, Executor)}.
     * <p>
     * See the {@link #allSuccessResultsOf allSuccessResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<List<T>> mSupplyAllSuccessAsync(Executor executor, @Nullable T valueIfFailed, Supplier<? extends T>... suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #mostSuccessResultsOf(Object, long, TimeUnit, CompletionStage[]) mostSuccessResultsOf},
     * wraps input suppliers to CompletableFuture by {@link CompletableFuture#supplyAsync(Supplier)}.
     * <p>
     * See the {@link #mostSuccessResultsOf(Object, long, TimeUnit, CompletionStage[]) mostSuccessResultsOf}
     * documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<List<T>> mSupplyMostSuccessAsync(@Nullable T valueIfNotSuccess, long timeout, TimeUnit unit, Supplier<? extends T>... suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #mostSuccessResultsOf(Executor, Object, long, TimeUnit, CompletionStage[]) mostSuccessResultsOf},
     * wraps input suppliers to CompletableFuture by {@link CompletableFuture#supplyAsync(Supplier, Executor)}.
     * <p>
     * See the {@link #mostSuccessResultsOf(Executor, Object, long, TimeUnit, CompletionStage[]) mostSuccessResultsOf}
     * documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<List<T>> mSupplyMostSuccessAsync(Executor executor, @Nullable T valueIfNotSuccess, long timeout, TimeUnit unit, Supplier<? extends T>... suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allResultsOf allResultsOf}, wraps input suppliers to
     * CompletableFuture by {@link CompletableFuture#supplyAsync(Supplier)}.
     * <p>
     * See the {@link #allResultsOf allResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<List<T>> mSupplyAsync(Supplier<? extends T>... suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allResultsOf allResultsOf}, wraps input suppliers to
     * CompletableFuture by {@link CompletableFuture#supplyAsync(Supplier, Executor)}.
     * <p>
     * See the {@link #allResultsOf allResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<List<T>> mSupplyAsync(Executor executor, Supplier<? extends T>... suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anySuccessOf anySuccessOf}, wraps input suppliers to
     * CompletableFuture by {@link CompletableFuture#supplyAsync(Supplier)}.
     * <p>
     * See the {@link #anySuccessOf anySuccessOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<T> mSupplyAnySuccessAsync(Supplier<? extends T>... suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anySuccessOf anySuccessOf}, wraps input suppliers to
     * CompletableFuture by {@link CompletableFuture#supplyAsync(Supplier, Executor)}.
     * <p>
     * See the {@link #anySuccessOf anySuccessOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<T> mSupplyAnySuccessAsync(Executor executor, Supplier<? extends T>... suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anyOf anyOf}, wraps input suppliers to
     * CompletableFuture by {@link CompletableFuture#supplyAsync(Supplier)}.
     * <p>
     * See the {@link #anyOf anyOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<T> mSupplyAnyAsync(Supplier<? extends T>... suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anyOf anyOf}, wraps input suppliers to
     * CompletableFuture by {@link CompletableFuture#supplyAsync(Supplier, Executor)}.
     * <p>
     * See the {@link #anyOf anyOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<T> mSupplyAnyAsync(Executor executor, Supplier<? extends T>... suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> CompletableFuture<? extends T>[] wrapSuppliers0(Executor executor, Supplier<? extends T>[] suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allFailFastOf allFailFastOf}, wraps input actions to
     * CompletableFuture by {@link CompletableFuture#runAsync(Runnable)}.
     * <p>
     * See the {@link #allFailFastOf allFailFastOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static CompletableFuture<Void> mRunFailFastAsync(Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allFailFastOf allFailFastOf}, wraps input actions to
     * CompletableFuture by {@link CompletableFuture#runAsync(Runnable, Executor)}.
     * <p>
     * See the {@link #allFailFastOf allFailFastOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static CompletableFuture<Void> mRunFailFastAsync(Executor executor, Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allOf allOf}, wraps input actions to
     * CompletableFuture by {@link CompletableFuture#runAsync(Runnable)}.
     * <p>
     * See the {@link #allOf allOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static CompletableFuture<Void> mRunAsync(Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allOf allOf}, wraps input actions to
     * CompletableFuture by {@link CompletableFuture#runAsync(Runnable, Executor)}.
     * <p>
     * See the {@link #allOf allOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static CompletableFuture<Void> mRunAsync(Executor executor, Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anySuccessOf anySuccessOf}, wraps input actions to
     * CompletableFuture by {@link CompletableFuture#runAsync(Runnable)}.
     * <p>
     * See the {@link #anySuccessOf anySuccessOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static CompletableFuture<Void> mRunAnySuccessAsync(Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anySuccessOf anySuccessOf}, wraps input actions to
     * CompletableFuture by {@link CompletableFuture#runAsync(Runnable, Executor)}.
     * <p>
     * See the {@link #anySuccessOf anySuccessOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static CompletableFuture<Void> mRunAnySuccessAsync(Executor executor, Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anyOf anyOf}, wraps input actions to
     * CompletableFuture by {@link CompletableFuture#runAsync(Runnable)}.
     * <p>
     * See the {@link #anyOf anyOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static CompletableFuture<Void> mRunAnyAsync(Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anyOf anyOf}, wraps input actions to
     * CompletableFuture by {@link CompletableFuture#runAsync(Runnable, Executor)}.
     * <p>
     * See the {@link #anyOf anyOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static CompletableFuture<Void> mRunAnyAsync(Executor executor, Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Runs all input actions async and forget (return {@code void}).
     * This method explicitly indicates that the caller will not care about any exceptions
     * from actions and will not wait for the computations to complete ("fire-and-forget").
     *
     * @since 2.1.0
     */
    public static void mRunAsyncAndForget(Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Runs all input actions async and forget (return {@code void}).
     * This method explicitly indicates that the caller will not care about any exceptions
     * from actions and will not wait for the computations to complete ("fire-and-forget").
     *
     * @since 2.1.0
     */
    public static void mRunAsyncAndForget(Executor executor, Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static CompletableFuture<Void>[] wrapRunnables0(Executor executor, Runnable[] actions) {
        return mapArray(actions, CommonUtils::newCfArray, a -> CompletableFuture.runAsync(a, executor));
    }

    // endregion
    ////////////////////////////////////////////////////////////
    // region## allOf* Methods (including mostSuccessResultsOf)
    //
    //    CompletionStage<T>[] -> CompletableFuture<List<T>>
    ////////////////////////////////////////////////////////////
    /**
     * Returns a new CompletableFuture that is completed normally with a list containing
     * the successful results of all given stages when all the given stages complete normally;
     * If any of the given stages complete exceptionally, then the returned CompletableFuture also does so,
     * WITHOUT waiting other incomplete given stages, with a CompletionException holding this exception as its cause.
     * If no stages are provided, returns a CompletableFuture completed with the value empty list.
     * <p>
     * The list of results is in the <strong>same order</strong> as the input list.
     * <p>
     * This method is the same as {@link #allResultsOf allResultsOf} method except for the fail-fast behavior.
     *
     * @throws NullPointerException if the cfs param or any of its elements are {@code null}
     * @see Futures#allAsList the equivalent Guava method allAsList()
     */
    @Contract(pure = true)
    @SafeVarargs
    public static <T> CompletableFuture<List<T>> allResultsFailFastOf(CompletionStage<? extends T>... cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that is completed normally with a list containing the successful results of
     * all given stages when all the given stages complete; The list of results is in the <strong>same order</strong>
     * as the input list, and if any of given stages complete exceptionally, their corresponding position will contain
     * {@code valueIfFailed} (which is indistinguishable from the stage having a successful value of {@code valueIfFailed}).
     * If no stages are provided, returns a CompletableFuture completed with the value empty list.
     * <p>
     * The list of results is in the <strong>same order</strong> as the input list.
     * <p>
     * This method differs from {@link #allResultsFailFastOf allResultsFailFastOf} method in that it's tolerant
     * of failed stages for any of the items, representing them as {@code valueIfFailed} in the result list.
     *
     * @param valueIfFailed the value used as the result if the input stage completed exceptionally
     * @throws NullPointerException if the cfs param or any of its elements is {@code null}
     * @see #getSuccessNow(CompletableFuture, Object)
     * @see Futures#successfulAsList the equivalent Guava method successfulAsList()
     */
    @Contract(pure = true)
    @SafeVarargs
    public static <T> CompletableFuture<List<T>> allSuccessResultsOf(@Nullable T valueIfFailed, CompletionStage<? extends T>... cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> CompletableFuture<List<T>> allSuccessResultsOf0(@Nullable T valueIfFailed, CompletionStage<? extends T>[] cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that is completed normally with a list containing the successful results of
     * the given stages before the given timeout, i.e. as many results as possible in the given time;
     * The list of results is in the <strong>same order</strong> as the input list, and if any of given stages
     * complete exceptionally or are incomplete, their corresponding positions will contain {@code valueIfNotSuccess}
     * (which is indistinguishable from the stage having a successful value of {@code valueIfNotSuccess}).
     * If no stages are provided, returns a CompletableFuture completed with the value empty list.
     * <p>
     * The list of results is in the <strong>same order</strong> as the input list.
     * <p>
     * This method differs from {@link #allResultsFailFastOf allResultsFailFastOf} method in that it's tolerant of
     * failed or incomplete stages for any of the items, representing them as {@code valueIfNotSuccess} in the result list.
     *
     * @param valueIfNotSuccess the value used as the result if the input stage not completed normally
     * @param timeout           how long to wait in units of {@code unit}
     * @param unit              a {@code TimeUnit} determining how to interpret the {@code timeout} parameter
     * @throws NullPointerException if the cfs param or any of its elements are {@code null}
     * @see #getSuccessNow(CompletableFuture, Object)
     */
    @Contract(pure = true)
    @SafeVarargs
    public static <T> CompletableFuture<List<T>> mostSuccessResultsOf(@Nullable T valueIfNotSuccess, long timeout, TimeUnit unit, CompletionStage<? extends T>... cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that is completed normally with a list containing the successful results of
     * the given stages before the given timeout, i.e. as many results as possible in the given time;
     * The list of results is in the <strong>same order</strong> as the input list, and if any of given stages
     * complete exceptionally or are incomplete, their corresponding positions will contain {@code valueIfNotSuccess}
     * (which is indistinguishable from the stage having a successful value of {@code valueIfNotSuccess}).
     * If no stages are provided, returns a CompletableFuture completed with the value empty list.
     * <p>
     * The list of results is in the <strong>same order</strong> as the input list.
     * <p>
     * This method differs from {@link #allResultsFailFastOf allResultsFailFastOf} method in that it's tolerant of failed
     * or incomplete stages for any of the items, representing them as {@code valueIfNotSuccess} in the result list.
     *
     * @param executorWhenTimeout the executor to use for asynchronous execution when timeout
     * @param valueIfNotSuccess   the value used as the result if the input stage not completed normally
     * @param timeout             how long to wait in units of {@code unit}
     * @param unit                a {@code TimeUnit} determining how to interpret the {@code timeout} parameter
     * @throws NullPointerException if the cfs param or any of its elements are {@code null}
     * @see #getSuccessNow(CompletableFuture, Object)
     */
    @Contract(pure = true)
    @SafeVarargs
    public static <T> CompletableFuture<List<T>> mostSuccessResultsOf(Executor executorWhenTimeout, @Nullable T valueIfNotSuccess, long timeout, TimeUnit unit, CompletionStage<? extends T>... cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> CompletableFuture<List<T>> mostSuccessResultsOf0(Executor executorWhenTimeout, @Nullable T valueIfNotSuccess, long timeout, TimeUnit unit, CompletionStage<? extends T>[] cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Multi-Gets(MGet) the results in the <strong>same order</strong> of the given cfs arguments,
     * use the result value if the given stage is completed normally, else use the given valueIfNotSuccess
     *
     * @param cfs MUST be non-minimal CF instances to read results(`getSuccessNow`), otherwise UnsupportedOperationException
     */
    static <T> ArrayList<T> mGetSuccessNow0(@Nullable T valueIfNotSuccess, CompletableFuture<? extends T>[] cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that is completed normally with a list containing
     * the successful results of all given stages when all the given stages complete;
     * If any of the given stages complete exceptionally, then the returned CompletableFuture
     * also does so, with a CompletionException holding this exception as its cause.
     * If no stages are provided, returns a CompletableFuture completed with the value empty list.
     * <p>
     * The list of results is in the <strong>same order</strong> as the input list.
     * <p>
     * Comparing the waiting-all-<strong>complete</strong> behavior of this method, the fail-fast behavior
     * of {@link #allResultsFailFastOf allResultsFailFastOf} method is more responsive to user
     * and generally more desired in the application.
     * <p>
     * This method is the same as {@link #allOf allOf} method,
     * except that the returned CompletableFuture contains the results of the given stages.
     *
     * @throws NullPointerException if the cfs param or any of its elements are {@code null}
     */
    @Contract(pure = true)
    @SafeVarargs
    public static <T> CompletableFuture<List<T>> allResultsOf(CompletionStage<? extends T>... cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> CompletableFuture<List<T>> allResultsOf0(boolean failFast, CompletionStage<? extends T>[] cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a cf array whose elements collect the results for <strong>AllResultsOf*</strong> methods.
     * <p>
     * Implementation Note: Uses AtomicReferenceArray and CAS operations to prevent memory leaks in `AllResultOf*`
     * methods. Without this protection, if any inputs complete exceptionally while others are still running,
     * the results array would unnecessarily retain memory for cf results that will never be used.
     */
    static <T> CompletableFuture<Void>[] createAllResultsSetterCfs(CompletionStage<? extends T>[] stages, AtomicReferenceArray<T> results) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A sentinel object used to mark slots in {@link AtomicReferenceArray} where values no longer need to be written.
     *
     * @see #createAllResultsSetterCfs
     */
    private static final Object SENTINEL_UNNEEDED = new Object();

    @SuppressWarnings("unchecked")
    private static <T> void fillSentinelTo(AtomicReferenceArray<T> results) {
        fillAtomicReferenceArray(results, (T) SENTINEL_UNNEEDED);
    }

    /**
     * Returns a new CompletableFuture that is completed normally when all the given stages complete normally;
     * If any of the given stages complete exceptionally, then the returned CompletableFuture also does so,
     * WITHOUT waiting other incomplete given stages, with a CompletionException holding this exception as its cause.
     * If no stages are provided, returns a CompletableFuture completed with the value {@code null}.
     * <p>
     * The successful results, if any, of the given stages are not reflected in the returned CompletableFuture
     * ({@code CompletableFuture<Void>}), but may be obtained by inspecting them individually; Or using the below methods
     * reflected results in the returned CompletableFuture which are more convenient, safer and best-practice of concurrency:
     * <ul>
     * <li>{@link #allResultsFailFastOf  allResultsFailFastOf}, {@link CfIterableUtils#allFailFastOf allFailFastOf},
     *     {@link CfParallelUtils#parApplyFailFastAsync parApplyFailFastAsync}
     * <li>{@link #allSuccessResultsOf allSuccessResultsOf}, {@link CfIterableUtils#allSuccessResultsOf allSuccessResultsOf},
     *     {@link CfParallelUtils#parApplyAllSuccessAsync parApplyAllSuccessAsync}
     * <li>{@link #mostSuccessResultsOf mostSuccessResultsOf}, {@link CfIterableUtils#mostSuccessResultsOf mostSuccessResultsOf}
     *     {@link CfParallelUtils#parApplyMostSuccessAsync parApplyMostSuccessAsync}
     * <li>{@link #allResultsOf allResultsOf}, {@link CfIterableUtils#allResultsOf allResultsOf}
     *     {@link CfParallelUtils#parApplyAsync parApplyAsync}
     * </ul>
     * <p>
     * This method is the same as {@link #allOf allOf} method except for the fail-fast behavior.
     *
     * @throws NullPointerException if the cfs param or any of its elements are {@code null}
     * @see Futures#whenAllSucceed the equivalent Guava method whenAllSucceed()
     */
    @Contract(pure = true)
    public static CompletableFuture<Void> allFailFastOf(CompletionStage<?>... cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static CompletableFuture<Void> allFailFastOf0(CompletionStage<?>[] cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T> void fill0(CompletionStage<? extends T>[] inputs, CompletableFuture<? extends T>[] successOrBeIncomplete, CompletableFuture<Void>[] failedOrBeIncomplete) {
        for (int i = 0; i < inputs.length; i++) {
            final CompletableFuture<T> f = f_toCf0(inputs[i]);
            successOrBeIncomplete[i] = exceptionallyCompose(f, ex -> new CompletableFuture<>());
            failedOrBeIncomplete[i] = f.thenCompose(v -> new CompletableFuture<>());
        }
    }

    /**
     * Returns a new CompletableFuture that is completed when all the given stages complete;
     * If any of the given stages complete exceptionally, then the returned CompletableFuture
     * also does so, with a CompletionException holding this exception as its cause.
     * If no stages are provided, returns a CompletableFuture completed with the value {@code null}.
     * <p>
     * The successful results, if any, of the given stages are not reflected in the returned CompletableFuture
     * ({@code CompletableFuture<Void>}), but may be obtained by inspecting them individually; Or using the below methods
     * reflected results in the returned CompletableFuture which are more convenient, safer and best-practice of concurrency:
     * <ul>
     * <li>{@link #allResultsOf allResultsOf}, {@link CfIterableUtils#allResultsOf allResultsOf}
     *     {@link CfParallelUtils#parApplyAsync parApplyAsync}
     * <li>{@link #allResultsFailFastOf  allResultsFailFastOf}, {@link CfIterableUtils#allFailFastOf allFailFastOf},
     *     {@link CfParallelUtils#parApplyFailFastAsync parApplyFailFastAsync}
     * <li>{@link #allSuccessResultsOf allSuccessResultsOf}, {@link CfIterableUtils#allSuccessResultsOf allSuccessResultsOf},
     *     {@link CfParallelUtils#parApplyAllSuccessAsync parApplyAllSuccessAsync}
     * <li>{@link #mostSuccessResultsOf mostSuccessResultsOf}, {@link CfIterableUtils#mostSuccessResultsOf mostSuccessResultsOf}
     *     {@link CfParallelUtils#parApplyMostSuccessAsync parApplyMostSuccessAsync}
     * </ul>
     * <p>
     * Among the applications of this method is to await completion of a set of independent stages
     * before continuing a program, as in: {@code CompletableFuture.allOf(c1, c2, c3).join();}.
     * <p>
     * This method is the same as {@link CompletableFuture#allOf CompletableFuture#allOf} method,
     * except that the parameter type is more generic {@link CompletionStage} instead of {@link CompletableFuture}.
     *
     * @throws NullPointerException if the cfs param or any of its elements are {@code null}
     * @see Futures#whenAllComplete the equivalent Guava method whenAllComplete()
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; forget to call its `join()` method?")
    @Contract(pure = true)
    public static CompletableFuture<Void> allOf(CompletionStage<?>... cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SafeVarargs
    static <S extends CompletionStage<?>> S[] requireCfsAndEleNonNull(S... cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    ////////////////////////////////////////////////////////////
    // region## anyOf* Methods
    //
    //    CompletionStage<T>[] -> CompletableFuture<T>
    ////////////////////////////////////////////////////////////
    /**
     * Returns a new CompletableFuture that completed normally when any of the given stages complete normally,
     * with the same result; Otherwise, when all the given stages complete exceptionally, the returned CompletableFuture
     * also does so, with a CompletionException holding an exception from any of the given stages as its cause.
     * If no stages are provided, returns a new CompletableFuture that is already completed exceptionally
     * with a {@link NoCfsProvidedException}.
     * <p>
     * This method differs from {@link #anyOf anyOf} method in that this method is any-<strong>success</strong>
     * instead of the any-<strong>complete</strong> behavior of method {@link #anyOf anyOf}.
     *
     * @throws NullPointerException if the cfs param or any of its elements are {@code null}
     */
    @Contract(pure = true)
    @SafeVarargs
    public static <T> CompletableFuture<T> anySuccessOf(CompletionStage<? extends T>... cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> CompletableFuture<T> anySuccessOf0(CompletionStage<? extends T>[] cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that is completed when any of the given stages complete, with the same result.
     * Otherwise, if it completed exceptionally, the returned CompletableFuture also does so, with a CompletionException
     * holding this exception as its cause. If no stages are provided, returns an incomplete CompletableFuture.
     * <p>
     * Comparing the any-<strong>complete</strong> behavior(the complete one may be failed) of this method,
     * the any-<strong>success</strong> behavior of method {@link #anySuccessOf anySuccessOf}
     * is generally more desired in the application.
     * <p>
     * This method is the same as {@link CompletableFuture#anyOf CompletableFuture#anyOf} method,
     * except that the parameter type is more generic {@link CompletionStage} instead of {@link CompletableFuture}
     * and the return type is more specific {@code T} instead of {@code Object}.
     *
     * @throws NullPointerException if the cfs param or any of its elements are {@code null}
     */
    @Contract(pure = true)
    @SafeVarargs
    public static <T> CompletableFuture<T> anyOf(CompletionStage<? extends T>... cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    ////////////////////////////////////////////////////////////
    // region## Immediate Value Argument Factory Methods(backport methods)
    ////////////////////////////////////////////////////////////
    /**
     * Returns a new CompletableFuture that is already completed exceptionally with the given exception.
     *
     * @param ex  the exception
     * @param <T> the type of the value
     * @return the exceptionally completed CompletableFuture
     */
    @Contract(pure = true)
    public static <T> CompletableFuture<T> failedFuture(Throwable ex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletionStage that is already completed with the given value
     * and supports only those methods in interface {@link CompletionStage}.
     * <p>
     * <strong>CAUTION:</strong> if run on old Java 8 (which does not support *minimal* CompletionStage),
     * this method just returns a *normal* CompletableFuture instance which is NOT a *minimal* CompletionStage.
     *
     * @param value the value
     * @param <T>   the type of the value
     * @return the completed CompletionStage
     */
    @Contract(pure = true)
    public static <T> CompletionStage<T> completedStage(@Nullable T value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletionStage that is already completed exceptionally with
     * the given exception and supports only those methods in interface {@link CompletionStage}.
     * <p>
     * <strong>CAUTION:</strong> if run on old Java 8 (which does not support *minimal* CompletionStage),
     * this method just returns a *normal* CompletableFuture instance which is NOT a *minimal* CompletionStage.
     *
     * @param ex  the exception
     * @param <T> the type of the value
     * @return the exceptionally completed CompletionStage
     */
    @Contract(pure = true)
    public static <T> CompletionStage<T> failedStage(Throwable ex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that encapsulates the execution of synchronous logic. By wrapping synchronous
     * code in a CompletableFuture, exceptions can be handled consistently within the CompletableFuture pipeline,
     * eliminating the need to manage separate exceptional paths both inside and outside the flow.
     *
     * @throws NullPointerException if argument {@code callable} is {@code null}
     * @see CompletableFuture#runAsync(Runnable)
     * @see CompletableFuture#supplyAsync(Supplier)
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, run directly instead of wrapping")
    public static <T> CompletableFuture<T> fromSyncCall(Callable<? extends T> callable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    ////////////////////////////////////////////////////////////
    // region## Incomplete CompletableFuture Constructor
    ////////////////////////////////////////////////////////////
    /**
     * Returns a new incomplete CompletableFuture of the type to be returned by a CompletionStage method.
     * <p>
     * In general, you won't use this method in application code, prefer other factory methods.
     * <p>
     * <strong>CAUTION:</strong> if running on Java 8 (where CompletableFuture does not yet have the newIncompleteFuture method),
     * this method returns a plain CompletableFuture instance rather than an instance of the same class as parameter cfThis.
     *
     * @param <U> the type of the value
     * @see CompletableFuture#newIncompleteFuture()
     * @see CompletableFuture#CompletableFuture()
     */
    @Contract(pure = true)
    public static <U> CompletableFuture<U> newIncompleteFuture(CompletableFuture<?> cfThis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    ////////////////////////////////////////////////////////////
    // region## Executors
    //    - Delayed Execution (backport methods)
    //    - Concurrency Limit Execution / Sequential Execution
    ////////////////////////////////////////////////////////////
    /**
     * Returns a new Executor that submits a task to the default executor after the given delay (or no delay
     * if non-positive). Each delay commences upon invocation of the returned executor's {@code execute} method.
     *
     * @param delay how long to delay, in units of {@code unit}
     * @param unit  a {@code TimeUnit} determining how to interpret the {@code delay} parameter
     * @return the new delayed executor
     */
    @Contract(pure = true)
    public static Executor delayedExecutor(long delay, TimeUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new Executor that submits a task to the given base executor after the given delay (or no delay
     * if non-positive). Each delay commences upon invocation of the returned executor's {@code execute} method.
     *
     * @param delay    how long to delay, in units of {@code unit}
     * @param unit     a {@code TimeUnit} determining how to interpret the {@code delay} parameter
     * @param executor the base executor
     * @return the new delayed executor
     */
    @Contract(pure = true)
    public static Executor delayedExecutor(long delay, TimeUnit unit, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new Executor that submits a task to the default executor and limits the number of concurrent tasks.
     *
     * @param maxConcurrency the maximum number of tasks that can run concurrently
     * @return the new concurrency limit executor
     * @since 2.1.0
     */
    @Contract(pure = true)
    public static Executor concurrencyLimitExecutor(int maxConcurrency) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new Executor that submits a task to the given base executor and limits the number of concurrent tasks.
     *
     * @param maxConcurrency the maximum number of tasks that can run concurrently
     * @param executor       the base executor
     * @return the new concurrency limit executor
     * @since 2.1.0
     */
    @Contract(pure = true)
    public static Executor concurrencyLimitExecutor(int maxConcurrency, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns an {@link Executor} that submits a task to the default executor
     * and runs each task executed sequentially, such that no two tasks are running concurrently.
     * <p>
     * <strong>NOTE:</strong> Calling this method {@code CompletableFutureUtils.sequentialExecutor()}
     * is the same as {@code CompletableFutureUtils.concurrencyLimitExecutor(1)}.
     *
     * @return the new sequential executor
     * @see com.google.common.util.concurrent.MoreExecutors#newSequentialExecutor(Executor)
     * @since 2.1.0
     */
    @Contract(pure = true)
    public static Executor sequentialExecutor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns an {@link Executor} that submits a task to the given base executor
     * and runs each task executed sequentially, such that no two tasks are running concurrently.
     * <p>
     * <strong>NOTE:</strong> Calling this method {@code CompletableFutureUtils.sequentialExecutor(executor)}
     * is the same as {@code CompletableFutureUtils.concurrencyLimitExecutor(1, executor)}.
     *
     * @return the new sequential executor
     * @see com.google.common.util.concurrent.MoreExecutors#newSequentialExecutor(Executor)
     * @since 2.1.0
     */
    @Contract(pure = true)
    public static Executor sequentialExecutor(Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    // endregion
    ////////////////////////////////////////////////////////////////////////////////
    // region# CF Instance Methods (including new enhanced + backport methods)
    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////
    // region## Then-Multi-Actions(thenM*) Methods
    //
    //    - thenMApply* (Function[]: T -> U)       -> CompletableFuture<List<U>>
    //    - thenMAccept*(Consumer[]: T -> Void)    -> CompletableFuture<Void>
    //    - thenMRun*   (Runnable[]: Void -> Void) -> CompletableFuture<Void>
    ////////////////////////////////////////////////////////////
    /**
     * Shortcut to method {@link #allResultsFailFastOf allResultsFailFastOf}, wraps input functions to CompletableFuture by
     * {@link CompletableFuture#supplyAsync(Supplier, Executor)} using the default executor of parameter cfThis;
     * The given CompletableFuture's result is used as the argument of functions.
     * <p>
     * See the {@link #allResultsFailFastOf allResultsFailFastOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T, U> CompletableFuture<List<U>> thenMApplyFailFastAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U>... fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allResultsFailFastOf allResultsFailFastOf}, wraps input functions to CompletableFuture by
     * {@link CompletableFuture#supplyAsync(Supplier, Executor)}; The given CompletableFuture's result is used as the argument of functions.
     * <p>
     * See the {@link #allResultsFailFastOf allResultsFailFastOf} documentation for the rules of result computation.
     * <p>
     * <strong>NOTE:</strong> if the {@code executor} argument is passed as a lambda, the {@code Runnable} lambda parameter type
     * needs to be explicitly declared to avoid compilation errors; For more information, see <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/LambdaCompilationErrorSolutionOfMultipleActionsMethodsDemo.java">
     * the demo code</a><br><img src="https://github.com/user-attachments/assets/0367d8a2-c3bd-414b-9f9a-4eaf64a16f96" alt="demo code" />
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T, U> CompletableFuture<List<U>> thenMApplyFailFastAsync(CompletableFuture<? extends T> cfThis, Executor executor, Function<? super T, ? extends U>... fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T, U> CompletableFuture<List<U>> _thenMApplyFailFastAsync(CompletableFuture<? extends T> cfThis, Executor executor, Function<? super T, ? extends U>[] fns, boolean defensiveCopy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allSuccessResultsOf allSuccessResultsOf}, wraps input functions to CompletableFuture by
     * {@link CompletableFuture#supplyAsync(Supplier, Executor)} using the default executor of parameter cfThis;
     * The given CompletableFuture's result is used as the argument of functions.
     * <p>
     * See the {@link #allSuccessResultsOf allSuccessResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T, U> CompletableFuture<List<U>> thenMApplyAllSuccessAsync(CompletableFuture<? extends T> cfThis, @Nullable U valueIfFailed, Function<? super T, ? extends U>... fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allSuccessResultsOf allSuccessResultsOf}, wraps input functions to CompletableFuture by
     * {@link CompletableFuture#supplyAsync(Supplier, Executor)}; The given CompletableFuture's result is used as the argument of functions.
     * <p>
     * See the {@link #allSuccessResultsOf allSuccessResultsOf} documentation for the rules of result computation.
     * <p>
     * <strong>NOTE:</strong> if the {@code executor} argument is passed as a lambda, the {@code Runnable} lambda parameter type
     * needs to be explicitly declared to avoid compilation errors; For more information, see <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/LambdaCompilationErrorSolutionOfMultipleActionsMethodsDemo.java">
     * the demo code</a><br><img src="https://github.com/user-attachments/assets/0367d8a2-c3bd-414b-9f9a-4eaf64a16f96" alt="demo code" />
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T, U> CompletableFuture<List<U>> thenMApplyAllSuccessAsync(CompletableFuture<? extends T> cfThis, Executor executor, @Nullable U valueIfFailed, Function<? super T, ? extends U>... fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T, U> CompletableFuture<List<U>> _thenMApplyAllSuccessAsync(CompletableFuture<? extends T> cfThis, Executor executor, @Nullable U valueIfFailed, Function<? super T, ? extends U>[] fns, boolean defensiveCopy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #mostSuccessResultsOf(Object, long, TimeUnit, CompletionStage[])
     * mostSuccessResultsOf}, wraps input functions to CompletableFuture by
     * {@link CompletableFuture#supplyAsync(Supplier, Executor)} using the default executor of parameter cfThis;
     * The given CompletableFuture's result is used as the argument of functions.
     * <p>
     * See the {@link #mostSuccessResultsOf(Object, long, TimeUnit, CompletionStage[])
     * mostSuccessResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T, U> CompletableFuture<List<U>> thenMApplyMostSuccessAsync(CompletableFuture<? extends T> cfThis, @Nullable U valueIfNotSuccess, long timeout, TimeUnit unit, Function<? super T, ? extends U>... fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #mostSuccessResultsOf(Executor, Object, long, TimeUnit, CompletionStage[])
     * mostSuccessResultsOf}, wraps input functions to CompletableFuture by
     * {@link CompletableFuture#supplyAsync(Supplier, Executor)}; The given CompletableFuture's result is used as the argument of functions.
     * <p>
     * See the {@link #mostSuccessResultsOf(Executor, Object, long, TimeUnit, CompletionStage[])
     * mostSuccessResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T, U> CompletableFuture<List<U>> thenMApplyMostSuccessAsync(CompletableFuture<? extends T> cfThis, Executor executor, @Nullable U valueIfNotSuccess, long timeout, TimeUnit unit, Function<? super T, ? extends U>... fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T, U> CompletableFuture<List<U>> _thenMApplyMostSuccessAsync(CompletableFuture<? extends T> cfThis, Executor executor, @Nullable U valueIfNotSuccess, long timeout, TimeUnit unit, Function<? super T, ? extends U>[] fns, boolean defensiveCopy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allResultsOf allResultsOf}, wraps input functions to CompletableFuture by
     * {@link CompletableFuture#supplyAsync(Supplier, Executor)} using the default executor of parameter cfThis;
     * The given CompletableFuture's result is used as the argument of functions.
     * <p>
     * See the {@link #allResultsOf allResultsOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T, U> CompletableFuture<List<U>> thenMApplyAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U>... fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allResultsOf allResultsOf}, wraps input functions to CompletableFuture by
     * {@link CompletableFuture#supplyAsync(Supplier, Executor)}; The given CompletableFuture's result is used as the argument of functions.
     * <p>
     * See the {@link #allResultsOf allResultsOf} documentation for the rules of result computation.
     * <p>
     * <strong>NOTE:</strong> if the {@code executor} argument is passed as a lambda, the {@code Runnable} lambda parameter type
     * needs to be explicitly declared to avoid compilation errors; For more information, see <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/LambdaCompilationErrorSolutionOfMultipleActionsMethodsDemo.java">
     * the demo code</a><br><img src="https://github.com/user-attachments/assets/0367d8a2-c3bd-414b-9f9a-4eaf64a16f96" alt="demo code" />
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T, U> CompletableFuture<List<U>> thenMApplyAsync(CompletableFuture<? extends T> cfThis, Executor executor, Function<? super T, ? extends U>... fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T, U> CompletableFuture<List<U>> _thenMApplyAsync(CompletableFuture<? extends T> cfThis, Executor executor, Function<? super T, ? extends U>[] fns, boolean defensiveCopy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anySuccessOf anySuccessOf}, wraps input functions to CompletableFuture by
     * {@link CompletableFuture#supplyAsync(Supplier, Executor)} using the default executor of parameter cfThis;
     * The given CompletableFuture's result is used as the argument of functions.
     * <p>
     * See the {@link #anySuccessOf anySuccessOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T, U> CompletableFuture<U> thenMApplyAnySuccessAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U>... fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anySuccessOf anySuccessOf}, wraps input functions to CompletableFuture by
     * {@link CompletableFuture#supplyAsync(Supplier, Executor)}; The given CompletableFuture's result is used as the argument of functions.
     * <p>
     * See the {@link #anySuccessOf anySuccessOf} documentation for the rules of result computation.
     * <p>
     * <strong>NOTE:</strong> if the {@code executor} argument is passed as a lambda, the {@code Runnable} lambda parameter type
     * needs to be explicitly declared to avoid compilation errors; For more information, see <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/LambdaCompilationErrorSolutionOfMultipleActionsMethodsDemo.java">
     * the demo code</a><br><img src="https://github.com/user-attachments/assets/0367d8a2-c3bd-414b-9f9a-4eaf64a16f96" alt="demo code" />
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T, U> CompletableFuture<U> thenMApplyAnySuccessAsync(CompletableFuture<? extends T> cfThis, Executor executor, Function<? super T, ? extends U>... fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T, U> CompletableFuture<U> _thenMApplyAnySuccessAsync(CompletableFuture<? extends T> cfThis, Executor executor, Function<? super T, ? extends U>[] fns, boolean defensiveCopy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anyOf anyOf}, wraps input functions to CompletableFuture by
     * {@link CompletableFuture#supplyAsync(Supplier, Executor)} using the default executor of parameter cfThis;
     * The given CompletableFuture's result is used as the argument of functions.
     * <p>
     * See the {@link #anyOf anyOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T, U> CompletableFuture<U> thenMApplyAnyAsync(CompletableFuture<? extends T> cfThis, Function<? super T, ? extends U>... fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anyOf anyOf}, wraps input functions to CompletableFuture by
     * {@link CompletableFuture#supplyAsync(Supplier, Executor)}; The given CompletableFuture's result is used as the argument of functions.
     * <p>
     * See the {@link #anyOf anyOf} documentation for the rules of result computation.
     * <p>
     * <strong>NOTE:</strong> if the {@code executor} argument is passed as a lambda, the {@code Runnable} lambda parameter type
     * needs to be explicitly declared to avoid compilation errors; For more information, see <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/LambdaCompilationErrorSolutionOfMultipleActionsMethodsDemo.java">
     * the demo code</a><br><img src="https://github.com/user-attachments/assets/0367d8a2-c3bd-414b-9f9a-4eaf64a16f96" alt="demo code" />
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T, U> CompletableFuture<U> thenMApplyAnyAsync(CompletableFuture<? extends T> cfThis, Executor executor, Function<? super T, ? extends U>... fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T, U> CompletableFuture<U> _thenMApplyAnyAsync(CompletableFuture<? extends T> cfThis, Executor executor, Function<? super T, ? extends U>[] fns, boolean defensiveCopy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T, U> CompletableFuture<U>[] wrapFunctions0(Executor executor, @Nullable T v, Function<? super T, ? extends U>[] fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allFailFastOf allFailFastOf}, wraps input actions to CompletableFuture by
     * {@link CompletableFuture#runAsync(Runnable, Executor)} using the default executor of parameter cfThis;
     * The given CompletableFuture's result is used as the argument of actions.
     * <p>
     * See the {@link #allFailFastOf allFailFastOf} documentation for the rules of result computation.
     * <p>
     * <strong>NOTE:</strong> if the second argument is passed as a lambda literal, the lambda parameter type
     * needs to be explicitly declared to avoid the compilation errors; For more information, see <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/LambdaCompilationErrorSolutionOfMultipleActionsMethodsDemo.java">
     * the demo code</a><br><img src="https://github.com/user-attachments/assets/4952e8e1-20af-4967-a4a7-b8885b816203" alt="demo code" />
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<Void> thenMAcceptFailFastAsync(CompletableFuture<? extends T> cfThis, Consumer<? super T>... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allFailFastOf allFailFastOf}, wraps input actions to CompletableFuture by
     * {@link CompletableFuture#runAsync(Runnable, Executor)} using the default executor of parameter cfThis;
     * The given CompletableFuture's result is used as the argument of actions.
     * <p>
     * See the {@link #allFailFastOf allFailFastOf} documentation for the rules of result computation.
     * <p>
     * <strong>NOTE:</strong> if the second argument is passed as a lambda literal, the lambda parameter type
     * needs to be explicitly declared to avoid the compilation errors; For more information, see <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/LambdaCompilationErrorSolutionOfMultipleActionsMethodsDemo.java">
     * the demo code</a><br><img src="https://github.com/user-attachments/assets/4952e8e1-20af-4967-a4a7-b8885b816203" alt="demo code" />
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<Void> thenMAcceptFailFastAsync(CompletableFuture<? extends T> cfThis, Executor executor, Consumer<? super T>... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> CompletableFuture<Void> _thenMAcceptFailFastAsync(CompletableFuture<? extends T> cfThis, Executor executor, Consumer<? super T>[] actions, boolean defensiveCopy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allOf allOf}, wraps input actions to CompletableFuture by
     * {@link CompletableFuture#runAsync(Runnable, Executor)} using the default executor of parameter cfThis;
     * The given CompletableFuture's result is used as the argument of actions.
     * <p>
     * See the {@link #allOf allOf} documentation for the rules of result computation.
     * <p>
     * <strong>NOTE:</strong> if the second argument is passed as a lambda literal, the lambda parameter type
     * needs to be explicitly declared to avoid the compilation errors; For more information, see <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/LambdaCompilationErrorSolutionOfMultipleActionsMethodsDemo.java">
     * the demo code</a><br><img src="https://github.com/user-attachments/assets/4952e8e1-20af-4967-a4a7-b8885b816203" alt="demo code" />
     */
    @SafeVarargs
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> thenMAcceptAsync(CompletableFuture<? extends T> cfThis, Consumer<? super T>... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allOf allOf}, wraps input actions to CompletableFuture by
     * {@link CompletableFuture#runAsync(Runnable, Executor)}; The given CompletableFuture's result is used as the argument of actions.
     * <p>
     * See the {@link #allOf allOf} documentation for the rules of result computation.
     * <p>
     * <strong>NOTE:</strong> if the second argument is passed as a lambda literal, the lambda parameter type
     * needs to be explicitly declared to avoid the compilation errors; For more information, see <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/LambdaCompilationErrorSolutionOfMultipleActionsMethodsDemo.java">
     * the demo code</a><br><img src="https://github.com/user-attachments/assets/4952e8e1-20af-4967-a4a7-b8885b816203" alt="demo code" />
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<Void> thenMAcceptAsync(CompletableFuture<? extends T> cfThis, Executor executor, Consumer<? super T>... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> CompletableFuture<Void> _thenMAcceptAsync(CompletableFuture<? extends T> cfThis, Executor executor, Consumer<? super T>[] actions, boolean defensiveCopy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anySuccessOf anySuccessOf}, wraps input actions to CompletableFuture by
     * {@link CompletableFuture#runAsync(Runnable, Executor)} using the default executor of parameter cfThis;
     * The given CompletableFuture's result is used as the argument of actions.
     * <p>
     * See the {@link #anySuccessOf anySuccessOf} documentation for the rules of result computation.
     * <p>
     * <strong>NOTE:</strong> if the second argument is passed as a lambda literal, the lambda parameter type
     * needs to be explicitly declared to avoid the compilation errors; For more information, see <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/LambdaCompilationErrorSolutionOfMultipleActionsMethodsDemo.java">
     * the demo code</a><br><img src="https://github.com/user-attachments/assets/4952e8e1-20af-4967-a4a7-b8885b816203" alt="demo code" />
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<Void> thenMAcceptAnySuccessAsync(CompletableFuture<? extends T> cfThis, Consumer<? super T>... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anySuccessOf anySuccessOf}, wraps input actions to CompletableFuture by
     * {@link CompletableFuture#runAsync(Runnable, Executor)}; The given CompletableFuture's result is used as the argument of actions.
     * <p>
     * See the {@link #anySuccessOf anySuccessOf} documentation for the rules of result computation.
     * <p>
     * <strong>NOTE:</strong> if the second argument is passed as a lambda literal, the lambda parameter type
     * needs to be explicitly declared to avoid the compilation errors; For more information, see <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/LambdaCompilationErrorSolutionOfMultipleActionsMethodsDemo.java">
     * the demo code</a><br><img src="https://github.com/user-attachments/assets/4952e8e1-20af-4967-a4a7-b8885b816203" alt="demo code" />
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<Void> thenMAcceptAnySuccessAsync(CompletableFuture<? extends T> cfThis, Executor executor, Consumer<? super T>... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> CompletableFuture<Void> _thenMAcceptAnySuccessAsync(CompletableFuture<? extends T> cfThis, Executor executor, Consumer<? super T>[] actions, boolean defensiveCopy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anyOf anyOf}, wraps input actions to CompletableFuture by
     * {@link CompletableFuture#runAsync(Runnable, Executor)} using the default executor of parameter cfThis;
     * The given CompletableFuture's result is used as the argument of actions.
     * <p>
     * See the {@link #anyOf anyOf} documentation for the rules of result computation.
     * <p>
     * <strong>NOTE:</strong> if the second argument is passed as a lambda literal, the lambda parameter type
     * needs to be explicitly declared to avoid the compilation errors; For more information, see <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/LambdaCompilationErrorSolutionOfMultipleActionsMethodsDemo.java">
     * the demo code</a><br><img src="https://github.com/user-attachments/assets/4952e8e1-20af-4967-a4a7-b8885b816203" alt="demo code" />
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<Void> thenMAcceptAnyAsync(CompletableFuture<? extends T> cfThis, Consumer<? super T>... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anyOf anyOf}, wraps input actions to CompletableFuture by
     * {@link CompletableFuture#runAsync(Runnable, Executor)}; The given CompletableFuture's result is used as the argument of actions.
     * <p>
     * See the {@link #anyOf anyOf} documentation for the rules of result computation.
     * <p>
     * <strong>NOTE:</strong> if the second argument is passed as a lambda literal, the lambda parameter type
     * needs to be explicitly declared to avoid the compilation errors; For more information, see <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/LambdaCompilationErrorSolutionOfMultipleActionsMethodsDemo.java">
     * the demo code</a><br><img src="https://github.com/user-attachments/assets/4952e8e1-20af-4967-a4a7-b8885b816203" alt="demo code" />
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    @SafeVarargs
    public static <T> CompletableFuture<Void> thenMAcceptAnyAsync(CompletableFuture<? extends T> cfThis, Executor executor, Consumer<? super T>... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> CompletableFuture<Void> _thenMAcceptAnyAsync(CompletableFuture<? extends T> cfThis, Executor executor, Consumer<? super T>[] actions, boolean defensiveCopy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Consumes the value of cfThis async by all input actions and forget (return {@code void}).
     * This method explicitly indicates that the caller will not care about any exceptions
     * from actions and will not wait for the computations to complete ("fire-and-forget").
     * <p>
     * <strong>NOTE:</strong> if the second argument is passed as a lambda literal, the lambda parameter type
     * needs to be explicitly declared to avoid the compilation errors; For more information, see <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/LambdaCompilationErrorSolutionOfMultipleActionsMethodsDemo.java">
     * the demo code</a><br><img src="https://github.com/user-attachments/assets/4952e8e1-20af-4967-a4a7-b8885b816203" alt="demo code" />
     *
     * @return the given CompletableFuture
     * @see #peekAsync(CompletionStage, BiConsumer)
     * @since 2.1.0
     */
    @Contract("_, _ -> param1")
    @SafeVarargs
    public static <T, F extends CompletionStage<? extends T>> F thenMAcceptAsyncAndForget(F cfThis, Consumer<? super T>... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Consumes the value of cfThis async by all input actions and forget (return {@code void}).
     * This method explicitly indicates that the caller will not care about any exceptions
     * from actions and will not wait for the computations to complete ("fire-and-forget").
     * <p>
     * <strong>NOTE:</strong> if the second argument is passed as a lambda literal, the lambda parameter type
     * needs to be explicitly declared to avoid the compilation errors; For more information, see <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/LambdaCompilationErrorSolutionOfMultipleActionsMethodsDemo.java">
     * the demo code</a><br><img src="https://github.com/user-attachments/assets/4952e8e1-20af-4967-a4a7-b8885b816203" alt="demo code" />
     *
     * @return the given CompletableFuture
     * @see #peekAsync(CompletionStage, BiConsumer, Executor)
     * @since 2.1.0
     */
    @Contract("_, _, _ -> param1")
    @SafeVarargs
    public static <T, F extends CompletionStage<? extends T>> F thenMAcceptAsyncAndForget(F cfThis, Executor executor, Consumer<? super T>... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T, F extends CompletionStage<? extends T>> F _thenMAcceptAsyncAndForget(F cfThis, Executor executor, Consumer<? super T>[] actions, boolean defensiveCopy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T> CompletableFuture<Void>[] wrapConsumers0(Executor executor, T v, Consumer<? super T>[] actions) {
        return mapArray(actions, CommonUtils::newCfArray, a -> CompletableFuture.runAsync(() -> a.accept(v), executor));
    }

    /**
     * Shortcut to method {@link #allFailFastOf allFailFastOf}, wraps input actions to CompletableFuture
     * by {@link CompletableFuture#runAsync(Runnable, Executor)} using the default executor of parameter cfThis.
     * <p>
     * See the {@link #allFailFastOf allFailFastOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMRunAsyncAndForget`")
    public static CompletableFuture<Void> thenMRunFailFastAsync(CompletableFuture<?> cfThis, Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allFailFastOf allFailFastOf}, wraps input actions to CompletableFuture
     * by {@link CompletableFuture#runAsync(Runnable, Executor)}.
     * <p>
     * See the {@link #allFailFastOf allFailFastOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMRunAsyncAndForget`")
    public static CompletableFuture<Void> thenMRunFailFastAsync(CompletableFuture<?> cfThis, Executor executor, Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static CompletableFuture<Void> _thenMRunFailFastAsync(CompletableFuture<?> cfThis, Executor executor, Runnable[] actions, boolean defensiveCopy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allOf allOf}, wraps input actions to CompletableFuture
     * by {@link CompletableFuture#runAsync(Runnable, Executor)} using the default executor of parameter cfThis.
     * <p>
     * See the {@link #allOf allOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMRunAsyncAndForget`")
    public static CompletableFuture<Void> thenMRunAsync(CompletableFuture<?> cfThis, Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #allOf allOf}, wraps input actions to CompletableFuture
     * by {@link CompletableFuture#runAsync(Runnable, Executor)}.
     * <p>
     * See the {@link #allOf allOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMRunAsyncAndForget`")
    public static CompletableFuture<Void> thenMRunAsync(CompletableFuture<?> cfThis, Executor executor, Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static CompletableFuture<Void> _thenMRunAsync(CompletableFuture<?> cfThis, Executor executor, Runnable[] actions, boolean defensiveCopy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anySuccessOf anySuccessOf}, wraps input actions to CompletableFuture
     * by {@link CompletableFuture#runAsync(Runnable, Executor)} using the default executor of parameter cfThis.
     * <p>
     * See the {@link #anySuccessOf anySuccessOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMRunAsyncAndForget`")
    public static CompletableFuture<Void> thenMRunAnySuccessAsync(CompletableFuture<?> cfThis, Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anySuccessOf anySuccessOf}, wraps input actions to CompletableFuture
     * by {@link CompletableFuture#runAsync(Runnable, Executor)}.
     * <p>
     * See the {@link #anySuccessOf anySuccessOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMRunAsyncAndForget`")
    public static CompletableFuture<Void> thenMRunAnySuccessAsync(CompletableFuture<?> cfThis, Executor executor, Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static CompletableFuture<Void> _thenMRunAnySuccessAsync(CompletableFuture<?> cfThis, Executor executor, Runnable[] actions, boolean defensiveCopy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anyOf anyOf}, wraps input actions to CompletableFuture
     * by {@link CompletableFuture#runAsync(Runnable, Executor)} using the default executor of parameter cfThis.
     * <p>
     * See the {@link #anyOf anyOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMRunAsyncAndForget`")
    public static CompletableFuture<Void> thenMRunAnyAsync(CompletableFuture<?> cfThis, Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shortcut to method {@link #anyOf anyOf}, wraps input actions to CompletableFuture
     * by {@link CompletableFuture#runAsync(Runnable, Executor)}.
     * <p>
     * See the {@link #anyOf anyOf} documentation for the rules of result computation.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMRunAsyncAndForget`")
    public static CompletableFuture<Void> thenMRunAnyAsync(CompletableFuture<?> cfThis, Executor executor, Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static CompletableFuture<Void> _thenMRunAnyAsync(CompletableFuture<?> cfThis, Executor executor, Runnable[] actions, boolean defensiveCopy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Runs all input actions async and forget (return {@code void}).
     * This method explicitly indicates that the caller will not care about any exceptions
     * from actions and will not wait for the computations to complete ("fire-and-forget").
     *
     * @return the given CompletableFuture
     * @see #peekAsync(CompletionStage, BiConsumer)
     * @since 2.1.0
     */
    @Contract("_, _ -> param1")
    public static <F extends CompletionStage<?>> F thenMRunAsyncAndForget(F cfThis, Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Runs all input actions async and forget (return {@code void}).
     * This method explicitly indicates that the caller will not care about any exceptions
     * from actions and will not wait for the computations to complete ("fire-and-forget").
     *
     * @return the given CompletableFuture
     * @see #peekAsync(CompletionStage, BiConsumer, Executor)
     * @since 2.1.0
     */
    @Contract("_, _, _ -> param1")
    public static <F extends CompletionStage<?>> F thenMRunAsyncAndForget(F cfThis, Executor executor, Runnable... actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <F extends CompletionStage<?>> F _thenMRunAsyncAndForget(F cfThis, Executor executor, Runnable[] actions, boolean defensiveCopy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    ////////////////////////////////////////////////////////////
    // region## thenBoth* Methods(binary input) with fail-fast support
    //
    //    - thenCombineFailFast*   (BiFunction: (T, U) -> V)    -> CompletableFuture<U>
    //    - thenAcceptBothFailFast*(BiConsumer: (T, U) -> Void) -> CompletableFuture<Void>
    //    - runAfterBothFailFast*  (Runnable:   Void -> Void)   -> CompletableFuture<Void>
    ////////////////////////////////////////////////////////////
    /**
     * Returns a new CompletableFuture that, when both of given stages complete normally,
     * is executed with the two results as arguments to the supplied function.
     * If any of the given stages complete exceptionally, then the returned CompletableFuture
     * also does so *without* waiting other incomplete given CompletionStage,
     * with a CompletionException holding this exception as its cause.
     *
     * @param fn the function to use to compute the value of the returned CompletableFuture
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, prefer method `thenAcceptBoth`")
    public static <T, U, V> CompletableFuture<V> thenCombineFailFast(CompletableFuture<? extends T> cfThis, CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when both of given stages complete normally,
     * is executed using the default executor of parameter cfThis,
     * with the two results as arguments to the supplied function.
     * If any of the given stages complete exceptionally, then the returned CompletableFuture
     * also does so *without* waiting other incomplete given CompletionStage,
     * with a CompletionException holding this exception as its cause.
     *
     * @param fn the function to use to compute the value of the returned CompletableFuture
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, prefer method `thenAcceptBothAsync`")
    public static <T, U, V> CompletableFuture<V> thenCombineFailFastAsync(CompletableFuture<? extends T> cfThis, CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when both of given stages complete normally,
     * is executed using the supplied executor,
     * with the two results as arguments to the supplied function.
     * If any of the given stages complete exceptionally, then the returned CompletableFuture
     * also does so *without* waiting other incomplete given CompletionStage,
     * with a CompletionException holding this exception as its cause.
     *
     * @param fn the function to use to compute the value of the returned CompletableFuture
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, prefer method `thenAcceptBothAsync`")
    public static <T, U, V> CompletableFuture<V> thenCombineFailFastAsync(CompletableFuture<? extends T> cfThis, CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static void requireThisAndOtherNonNull(CompletionStage<?> cfThis, CompletionStage<?> other) {
        requireNonNull(cfThis, "cfThis is null");
        requireNonNull(other, "other is null");
    }

    /**
     * Implementation Note: Calling this method is necessary to keep the runtime type (including `minimal-stage`) of
     * return cf same as input `cfThis` argument. The runtime type of method {@link #allResultsFailFastOf(CompletionStage[])}
     * return cf is always CompletableFuture, does NOT keep the runtime type of input `cfThis` argument.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static <T1, T2> CompletableFuture<Tuple2<T1, T2>> bothFailFast0(CompletableFuture<? extends T1> cfThis, CompletionStage<? extends T2> other) {
        CompletableFuture thisSuccessOrBeIncomplete = exceptionallyCompose(cfThis, ex -> new CompletableFuture());
        CompletionStage otherSuccessOrBeIncomplete = exceptionallyCompose(other, ex -> new CompletableFuture());
        CompletableFuture cfValue = thisSuccessOrBeIncomplete.thenCombine(otherSuccessOrBeIncomplete, Tuple2::of);
        CompletableFuture thisFailedOrBeIncomplete = cfThis.thenCompose(v -> new CompletableFuture());
        CompletionStage otherFailedOrBeIncomplete = other.thenCompose(v -> new CompletableFuture());
        CompletableFuture cfEx = thisFailedOrBeIncomplete.applyToEither(otherFailedOrBeIncomplete, v -> null);
        return cfValue.applyToEither(cfEx, x -> x);
    }

    /**
     * Returns a new CompletableFuture that, when both of given stages complete normally,
     * is executed with the two results as arguments to the supplied action.
     * If any of the given stages complete exceptionally, then the returned CompletableFuture
     * also does so *without* waiting other incomplete given CompletionStage,
     * with a CompletionException holding this exception as its cause.
     *
     * @param action the action to perform before completing the returned CompletableFuture
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, prefer method `thenAcceptBoth`")
    public static <T, U> CompletableFuture<Void> thenAcceptBothFailFast(CompletableFuture<? extends T> cfThis, CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when both of given stages complete normally,
     * is executed using the default executor of parameter cfThis,
     * with the two results as arguments to the supplied action.
     * If any of the given stages complete exceptionally, then the returned CompletableFuture
     * also does so *without* waiting other incomplete given CompletionStage,
     * with a CompletionException holding this exception as its cause.
     *
     * @param action the action to perform before completing the returned CompletableFuture
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, prefer method `thenAcceptBothAsync`")
    public static <T, U> CompletableFuture<Void> thenAcceptBothFailFastAsync(CompletableFuture<? extends T> cfThis, CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when both of given stages complete normally,
     * is executed using the supplied executor,
     * with the two results as arguments to the supplied action.
     * If any of the given stages complete exceptionally, then the returned CompletableFuture
     * also does so *without* waiting other incomplete given CompletionStage,
     * with a CompletionException holding this exception as its cause.
     *
     * @param action the action to perform before completing the returned CompletableFuture
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, prefer method `thenAcceptBothAsync`")
    public static <T, U> CompletableFuture<Void> thenAcceptBothFailFastAsync(CompletableFuture<? extends T> cfThis, CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when two given stages both complete normally, executes the given action.
     * If any of the given stages complete exceptionally, then the returned CompletableFuture
     * also does so *without* waiting other incomplete given CompletionStage,
     * with a CompletionException holding this exception as its cause.
     *
     * @param action the action to perform before completing the returned CompletableFuture
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, prefer method `runAfterBoth`")
    public static CompletableFuture<Void> runAfterBothFailFast(CompletableFuture<?> cfThis, CompletionStage<?> other, Runnable action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when two given stages both complete normally,
     * executes the given action using the default executor of parameter cfThis.
     * If any of the given stages complete exceptionally, then the returned CompletableFuture
     * also does so *without* waiting other incomplete given CompletionStage,
     * with a CompletionException holding this exception as its cause.
     *
     * @param action the action to perform before completing the returned CompletableFuture
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, prefer method `runAfterBothAsync`")
    public static CompletableFuture<Void> runAfterBothFailFastAsync(CompletableFuture<?> cfThis, CompletionStage<?> other, Runnable action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when two given stages both complete normally,
     * executes the given action using the supplied executor.
     * If any of the given stages complete exceptionally, then the returned CompletableFuture
     * also does so *without* waiting other incomplete given CompletionStage,
     * with a CompletionException holding this exception as its cause.
     *
     * @param action the action to perform before completing the returned CompletableFuture
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, prefer method `runAfterBothAsync`")
    public static CompletableFuture<Void> runAfterBothFailFastAsync(CompletableFuture<?> cfThis, CompletionStage<?> other, Runnable action, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    ////////////////////////////////////////////////////////////
    // region## thenEither* Methods(binary input) with either(any)-success support
    //
    //    - applyToEitherSuccess* (Function: (T) -> U)     -> CompletableFuture<U>
    //    - acceptEitherSuccess*  (Consumer: (T) -> Void)  -> CompletableFuture<Void>
    //    - runAfterEitherSuccess*(Runnable: Void -> Void) -> CompletableFuture<Void>
    ////////////////////////////////////////////////////////////
    /**
     * Returns a new CompletableFuture that, when either of given stages success,
     * is executed with the corresponding result as argument to the supplied function.
     * Otherwise, both complete exceptionally, the returned CompletableFuture also does so,
     * with a CompletionException holding an exception from either as its cause.
     *
     * @param fn  the function to use to compute the value of the returned CompletableFuture
     * @param <U> the function's return type
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, prefer method `acceptEitherSuccess`")
    public static <T, U> CompletableFuture<U> applyToEitherSuccess(CompletableFuture<? extends T> cfThis, CompletionStage<? extends T> other, Function<? super T, ? extends U> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when either of given stages success,
     * is executed using the default executor of parameter cfThis,
     * with the corresponding result as argument to the supplied function.
     * Otherwise, both complete exceptionally, the returned CompletableFuture also does so,
     * with a CompletionException holding an exception from either as its cause.
     *
     * @param fn  the function to use to compute the value of the returned CompletableFuture
     * @param <U> the function's return type
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, prefer method `acceptEitherSuccessAsync`")
    public static <T, U> CompletableFuture<U> applyToEitherSuccessAsync(CompletableFuture<? extends T> cfThis, CompletionStage<? extends T> other, Function<? super T, ? extends U> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when either of given stages success,
     * is executed using the supplied executor, with the corresponding result as argument to the supplied function.
     * Otherwise, both complete exceptionally, the returned CompletableFuture also does so,
     * with a CompletionException holding an exception from either as its cause.
     *
     * @param fn       the function to use to compute the value of the returned CompletableFuture
     * @param executor the executor to use for asynchronous execution
     * @param <U>      the function's return type
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, prefer method `acceptEitherSuccessAsync`")
    public static <T, U> CompletableFuture<U> applyToEitherSuccessAsync(CompletableFuture<? extends T> cfThis, CompletionStage<? extends T> other, Function<? super T, ? extends U> fn, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Implementation Note: Calling this method is necessary to keep the runtime type (including `minimal-stage`) of
     * return cf same as input `cfThis` argument. The runtime type of method {@link #anySuccessOf(CompletionStage[])}
     * return cf is always CompletableFuture, does NOT keep the runtime type of input `cfThis` argument.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static <T> CompletableFuture<T> eitherSuccess0(CompletableFuture<? extends T> cfThis, CompletionStage<? extends T> other) {
        CompletableFuture thisSuccessOrBeIncomplete = exceptionallyCompose(cfThis, ex -> new CompletableFuture());
        CompletionStage otherSuccessOrBeIncomplete = exceptionallyCompose(other, ex -> new CompletableFuture());
        CompletableFuture cfValue = thisSuccessOrBeIncomplete.applyToEither(otherSuccessOrBeIncomplete, x -> x);
        CompletableFuture thisFailedOrBeIncomplete = cfThis.thenCompose(v -> new CompletableFuture());
        CompletionStage otherFailedOrBeIncomplete = other.thenCompose(v -> new CompletableFuture());
        CompletableFuture cfEx = thisFailedOrBeIncomplete.thenCombine(otherFailedOrBeIncomplete, (v1, v2) -> null);
        return cfValue.applyToEither(cfEx, x -> x);
    }

    /**
     * Returns a new CompletableFuture that, when either of given stages success,
     * is executed with the corresponding result as argument to the supplied action.
     * Otherwise, both complete exceptionally, the returned CompletableFuture also does so,
     * with a CompletionException holding an exception from either as its cause.
     *
     * @param action the action to perform before completing the returned CompletableFuture
     */
    public static <T> CompletableFuture<Void> acceptEitherSuccess(CompletableFuture<? extends T> cfThis, CompletionStage<? extends T> other, Consumer<? super T> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when either of given stages success,
     * is executed using the default executor of parameter cfThis,
     * with the corresponding result as argument to the supplied action.
     * Otherwise, both complete exceptionally, the returned CompletableFuture also does so,
     * with a CompletionException holding an exception from either as its cause.
     *
     * @param action the action to perform before completing the returned CompletableFuture
     */
    public static <T> CompletableFuture<Void> acceptEitherSuccessAsync(CompletableFuture<? extends T> cfThis, CompletionStage<? extends T> other, Consumer<? super T> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when either of given stages success,
     * is executed using the supplied executor, with the corresponding result as argument to the supplied action.
     * Otherwise, both complete exceptionally, the returned CompletableFuture also does so,
     * with a CompletionException holding an exception from either as its cause.
     *
     * @param action   the action to perform before completing the returned CompletableFuture
     * @param executor the executor to use for asynchronous execution
     */
    public static <T> CompletableFuture<Void> acceptEitherSuccessAsync(CompletableFuture<? extends T> cfThis, CompletionStage<? extends T> other, Consumer<? super T> action, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when either of given stages success, executes the given action.
     * Otherwise, both complete exceptionally, the returned CompletableFuture also does so,
     * with a CompletionException holding an exception from either as its cause.
     *
     * @param action the action to perform before completing the returned CompletableFuture
     */
    public static CompletableFuture<Void> runAfterEitherSuccess(CompletableFuture<?> cfThis, CompletionStage<?> other, Runnable action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when either of given stages success, executes the given action
     * using the default executor of parameter cfThis.
     * Otherwise, both complete exceptionally, the returned CompletableFuture also does so,
     * with a CompletionException holding an exception from either as its cause.
     *
     * @param action the action to perform before completing the returned CompletableFuture
     */
    public static CompletableFuture<Void> runAfterEitherSuccessAsync(CompletableFuture<?> cfThis, CompletionStage<?> other, Runnable action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when either of given stages success, executes the given action
     * using the supplied executor.
     * Otherwise, both complete exceptionally, the returned CompletableFuture also does so,
     * with a CompletionException holding an exception from either as its cause.
     *
     * @param action the action to perform before completing the returned CompletableFuture
     */
    public static CompletableFuture<Void> runAfterEitherSuccessAsync(CompletableFuture<?> cfThis, CompletionStage<?> other, Runnable action, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    ////////////////////////////////////////////////////////////
    // region## Error Handling Methods of CompletionStage
    ////////////////////////////////////////////////////////////
    /**
     * Returns a new CompletableFuture that, when the given stage completes exceptionally with the given exceptionType,
     * is executed with the exception from the given stage({@code argument cfThis}) as the argument to the supplied function.
     * Otherwise, the returned stage contains the same result as the given stage.
     * <p>
     * <strong>"The exception from the given stage({@code argument cfThis})"</strong> means the cause of
     * the {@link ExecutionException} thrown by {@code get()} or, if {@code get()} throws a different kind
     * of exception, that exception itself, i.e. the exception is unwrapped by {@link #unwrapCfException(Throwable)}.
     *
     * @param exceptionType the exception type that triggers use of {@code fallback}. The exception type is matched against
     *                      the exception from argument cfThis. To avoid hiding bugs and other unrecoverable errors,
     *                      callers should prefer more specific types, avoiding {@code Throwable.class} in particular.
     * @param fallback      the Function to be called if cfThis fails with the expected exception type.
     *                      The function's argument is the exception from cfThis.
     * @see #unwrapCfException(Throwable)
     * @see Futures#catching the equivalent Guava method catching()
     */
    public static <T, X extends Throwable, F extends CompletionStage<T>> F catching(F cfThis, Class<X> exceptionType, Function<? super X, ? extends T> fallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when the given stage completes exceptionally with the given exceptionType,
     * is executed with the exception from the given stage({@code argument cfThis}) as the argument to the supplied
     * function, using the default executor of parameter the given stage.
     * Otherwise, the returned stage contains the same result as the given stage.
     * <p>
     * <strong>"The exception from the given stage({@code argument cfThis})"</strong> means the cause of
     * the {@link ExecutionException} thrown by {@code get()} or, if {@code get()} throws a different kind
     * of exception, that exception itself, i.e. the exception is unwrapped by {@link #unwrapCfException(Throwable)}.
     *
     * @param exceptionType the exception type that triggers use of {@code fallback}. The exception type is matched against
     *                      the exception from argument cfThis. To avoid hiding bugs and other unrecoverable errors,
     *                      callers should prefer more specific types, avoiding {@code Throwable.class} in particular.
     * @param fallback      the Function to be called if cfThis fails with the expected exception type.
     *                      The function's argument is the exception from cfThis.
     * @see #unwrapCfException(Throwable)
     * @see Futures#catching the equivalent Guava method catching()
     */
    public static <T, X extends Throwable, F extends CompletionStage<T>> F catchingAsync(F cfThis, Class<X> exceptionType, Function<? super X, ? extends T> fallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when the given stage completes exceptionally with the given exceptionType,
     * is executed with the exception from the given stage({@code argument cfThis}) as the argument to the supplied
     * function, using the supplied Executor. Otherwise, the returned stage contains the same result as the given stage.
     * <p>
     * <strong>"The exception from the given stage({@code argument cfThis})"</strong> means the cause of
     * the {@link ExecutionException} thrown by {@code get()} or, if {@code get()} throws a different kind
     * of exception, that exception itself, i.e. the exception is unwrapped by {@link #unwrapCfException(Throwable)}.
     *
     * @param exceptionType the exception type that triggers use of {@code fallback}. The exception type is matched against
     *                      the exception from argument cfThis. To avoid hiding bugs and other unrecoverable errors,
     *                      callers should prefer more specific types, avoiding {@code Throwable.class} in particular.
     * @param fallback      the Function to be called if cfThis fails with the expected exception type.
     *                      The function's argument is the exception from cfThis.
     * @param executor      the executor to use for asynchronous execution
     * @see #unwrapCfException(Throwable)
     * @see Futures#catching the equivalent Guava method catching()
     */
    public static <T, X extends Throwable, F extends CompletionStage<T>> F catchingAsync(F cfThis, Class<X> exceptionType, Function<? super X, ? extends T> fallback, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when the given stage completes exceptionally, is executed with the given
     * stage's exception as the argument to the supplied function, using the default executor of parameter cfThis.
     * Otherwise, if the given stage completes normally, then the returned stage also completes normally with the same value.
     * <p>
     * Just as catching {@code Throwable} is not best practice in general, this method handles the {@code Throwable};
     * <strong>Strongly recommend</strong> using {@link #catchingAsync(CompletionStage, Class, Function)}
     * instead in your business application.
     *
     * @param fn the function to use to compute the value of the returned CompletableFuture
     *           if given CompletionStage completed exceptionally
     * @see #catchingAsync(CompletionStage, Class, Function)
     */
    public static <T, F extends CompletionStage<T>> F exceptionallyAsync(F cfThis, Function<Throwable, ? extends T> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when the given stage completes exceptionally, is executed with the given
     * stage's exception as the argument to the supplied function, using the supplied Executor. Otherwise,
     * if the given stage completes normally, then the returned stage also completes normally with the same value.
     * <p>
     * Just as catching {@code Throwable} is not best practice in general, this method handles the {@code Throwable};
     * <strong>Strongly recommend</strong> using {@link #catchingAsync(CompletionStage, Class, Function, Executor)}
     * instead in your business application.
     *
     * @param fn       the function to use to compute the value of the returned CompletableFuture
     *                 if given CompletionStage completed exceptionally
     * @param executor the executor to use for asynchronous execution
     * @see #catchingAsync(CompletionStage, Class, Function, Executor)
     */
    public static <T, F extends CompletionStage<T>> F exceptionallyAsync(F cfThis, Function<Throwable, ? extends T> fn, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    ////////////////////////////////////////////////////////////
    // region## Timeout Control Methods of CompletableFuture
    ////////////////////////////////////////////////////////////
    /**
     * Returns a new CompletableFuture that is completed exceptionally with a {@link TimeoutException}
     * when the given CompletableFuture is not completed before the given timeout; otherwise the returned
     * CompletableFuture completed with the same successful result or exception of the given CompletableFuture.
     * <p>
     * Uses the default executor of parameter cfThis as {@code executorWhenTimeout}.
     * <p>
     * <strong>CAUTION:</strong> This method returns a new CompletableFuture instead of {@code cfThis} to avoid
     * the subsequent usage of the <strong>SINGLE-thread</strong> ScheduledThreadPoolExecutor's thread; This behavior is
     * DIFFERENT from the original CF method {@link CompletableFuture#orTimeout CompletableFuture#orTimeout} and its backport
     * method {@link #orTimeout orTimeout}. For more information, see the Javadoc of {@link #orTimeout orTimeout} and the demo <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/CfDelayDysfunctionDemo.java"
     * >DelayDysfunctionDemo</a>.
     *
     * @param timeout how long to wait before completing exceptionally with a TimeoutException, in units of {@code unit}
     * @param unit    a {@code TimeUnit} determining how to interpret the {@code timeout} parameter
     * @see #cffuOrTimeout(CompletableFuture, long, TimeUnit, Executor)
     */
    public static <F extends CompletableFuture<?>> F cffuOrTimeout(F cfThis, long timeout, TimeUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that is completed exceptionally with a {@link TimeoutException}
     * when the given CompletableFuture is not completed before the given timeout; otherwise the returned
     * CompletableFuture completed with the same successful result or exception of the given CompletableFuture.
     * <p>
     * <strong>CAUTION:</strong> This method returns a new CompletableFuture instead of {@code cfThis} to avoid
     * the subsequent usage of the <strong>SINGLE-thread</strong> ScheduledThreadPoolExecutor's thread; This behavior is
     * DIFFERENT from the original CF method {@link CompletableFuture#orTimeout CompletableFuture#orTimeout} and its backport
     * method {@link #orTimeout orTimeout}. For more information, see the Javadoc of {@link #orTimeout orTimeout} and the demo <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/CfDelayDysfunctionDemo.java"
     * >DelayDysfunctionDemo</a>.
     *
     * @param timeout             how long to wait before completing exceptionally with a TimeoutException,
     *                            in units of {@code unit}
     * @param unit                a {@code TimeUnit} determining how to interpret the {@code timeout} parameter
     * @param executorWhenTimeout the executor to use for asynchronous execution when the wait timed out
     */
    public static <F extends CompletableFuture<?>> F cffuOrTimeout(F cfThis, long timeout, TimeUnit unit, Executor executorWhenTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Exceptionally completes given CompletableFuture with a {@link TimeoutException}
     * if not otherwise completed before the given timeout.
     * <p>
     * <strong>CAUTION:</strong> {@link CompletableFuture#orTimeout CompletableFuture#orTimeout}
     * and this backport method is <strong>UNSAFE</strong>!
     * <p>
     * When the wait timed out, the subsequent non-async actions of the dependent CompletableFutures are performed
     * in CompletableFuture's internal <strong>SINGLE-thread</strong> ScheduledThreadPoolExecutor (including delay functionality).
     * This means that the long-running subsequent non-async actions will block this executor thread, preventing it from
     * handling other timeouts and delays, effectively breaking CompletableFuture's timeout and delay functionality.
     * <p>
     * <strong>Strongly recommend</strong> using the safe method {@link #cffuOrTimeout(CompletableFuture, long, TimeUnit, Executor)
     * cffuOrTimeout} instead of {@link CompletableFuture#orTimeout CompletableFuture#orTimeout} and this backport method.
     * Using {@link CompletableFuture#orTimeout CompletableFuture#orTimeout} and this backport method is appropriate only when:
     * <ul>
     * <li>the returned CompletableFuture is only read explicitly(e.g. by get/join/resultNow methods),
     * <li>and/or all subsequent actions of dependent CompletableFutures are guaranteed to execute asynchronously,
     *    i.e. the dependent CompletableFutures are created using async methods.
     * </ul> In these cases, using these unsafe methods avoids an unnecessary thread switching when timeout occurs; However, these
     * conditions are difficult to guarantee in practice, especially when the returned CompletableFuture is used by others' codes.
     * <p>
     * Note: Before Java 21(Java 20-), {@link CompletableFuture#orTimeout CompletableFuture#orTimeout} method leaks if the
     * future completes exceptionally; For more information, see <a href="https://bugs.openjdk.org/browse/JDK-8303742">issue JDK-8303742</a>,
     * <a href="https://github.com/openjdk/jdk/pull/13059">PR review openjdk/jdk/13059</a>
     * and <a href="https://github.com/openjdk/jdk/commit/ded6a8131970ac2f7ae59716769e6f6bae3b809a">JDK bugfix commit</a>.
     * The cffu backport logic (for Java 20-) has merged this JDK bugfix.
     *
     * @param timeout how long to wait before completing exceptionally with a TimeoutException, in units of {@code unit}
     * @param unit    a {@code TimeUnit} determining how to interpret the {@code timeout} parameter
     * @return the given CompletableFuture
     * @see #cffuOrTimeout(CompletableFuture, long, TimeUnit, Executor)
     */
    @Contract("_, _, _ -> param1")
    public static <F extends CompletableFuture<?>> F orTimeout(F cfThis, long timeout, TimeUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that is completed normally with the given value
     * when the given CompletableFuture is not completed before the given timeout; otherwise the returned
     * CompletableFuture completed with the same successful result or exception of the given CompletableFuture.
     * <p>
     * Uses the default executor of parameter cfThis as {@code executorWhenTimeout}.
     * <p>
     * <strong>CAUTION:</strong> This method returns a new CompletableFuture instead of {@code cfThis} to avoid
     * the subsequent usage of the <strong>SINGLE-thread</strong> ScheduledThreadPoolExecutor's thread; This behavior is
     * DIFFERENT from the original CF method {@link CompletableFuture#completeOnTimeout CompletableFuture#completeOnTimeout}
     * and its backport method {@link #completeOnTimeout completeOnTimeout}.
     * For more information, see the Javadoc of {@link #completeOnTimeout completeOnTimeout} and the demo <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/CfDelayDysfunctionDemo.java"
     * >DelayDysfunctionDemo</a>.
     *
     * @param value   the value to use upon timeout
     * @param timeout how long to wait before completing normally with the given value, in units of {@code unit}
     * @param unit    a {@code TimeUnit} determining how to interpret the {@code timeout} parameter
     * @see #cffuCompleteOnTimeout(CompletableFuture, Object, long, TimeUnit, Executor)
     */
    public static <T, F extends CompletableFuture<? super T>> F cffuCompleteOnTimeout(F cfThis, @Nullable T value, long timeout, TimeUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that is completed normally with the given value
     * when the given CompletableFuture is not completed before the given timeout; otherwise the returned
     * CompletableFuture completed with the same successful result or exception of the given CompletableFuture.
     * <p>
     * <strong>CAUTION:</strong> This method returns a new CompletableFuture instead of {@code cfThis} to avoid
     * the subsequent usage of the <strong>SINGLE-thread</strong> ScheduledThreadPoolExecutor's thread; This behavior is
     * DIFFERENT from the original CF method {@link CompletableFuture#completeOnTimeout CompletableFuture#completeOnTimeout}
     * and its backport method {@link #completeOnTimeout completeOnTimeout}.
     * For more information, see the Javadoc of {@link #completeOnTimeout completeOnTimeout} and the demo <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/demo/CfDelayDysfunctionDemo.java"
     * >DelayDysfunctionDemo</a>.
     *
     * @param value               the value to use upon timeout
     * @param timeout             how long to wait before completing normally with the given value, in units of {@code unit}
     * @param unit                a {@code TimeUnit} determining how to interpret the {@code timeout} parameter
     * @param executorWhenTimeout the executor to use for asynchronous execution when the wait timed out
     */
    public static <T, F extends CompletableFuture<? super T>> F cffuCompleteOnTimeout(F cfThis, @Nullable T value, long timeout, TimeUnit unit, Executor executorWhenTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Completes given CompletableFuture with the given value if not otherwise completed before the given timeout.
     * <p>
     * <strong>CAUTION:</strong> {@link CompletableFuture#completeOnTimeout CompletableFuture#completeOnTimeout}
     * and this backport method is <strong>UNSAFE</strong>!
     * <p>
     * When the wait timed out, the subsequent non-async actions of the dependent CompletableFutures are performed
     * in CompletableFuture's internal <strong>SINGLE-thread</strong> ScheduledThreadPoolExecutor (including delay functionality).
     * This means that the long-running subsequent non-async actions will block this executor thread, preventing it from
     * handling other timeouts and delays, effectively breaking CompletableFuture's timeout and delay functionality.
     * <p>
     * <strong>Strongly recommend</strong> using the safe method {@link #cffuCompleteOnTimeout(CompletableFuture, Object, long, TimeUnit, Executor)
     * cffuCompleteOnTimeout} instead of {@link CompletableFuture#completeOnTimeout CompletableFuture#completeOnTimeout} and this backport method.
     * Using {@link CompletableFuture#completeOnTimeout CompletableFuture#completeOnTimeout} and this backport method is appropriate only when:
     * <ul>
     * <li>the returned CompletableFuture is only read explicitly(e.g. by get/join/resultNow methods),
     * <li>and/or all subsequent actions of dependent CompletableFutures are guaranteed to execute asynchronously,
     *    i.e. the dependent CompletableFutures are created using async methods.
     * </ul> In these cases, using these unsafe methods avoids an unnecessary thread switching when timeout occurs; However, these
     * conditions are difficult to guarantee in practice, especially when the returned CompletableFuture is used by others' codes.
     *
     * @param value   the value to use upon timeout
     * @param timeout how long to wait before completing normally with the given value, in units of {@code unit}
     * @param unit    a {@code TimeUnit} determining how to interpret the {@code timeout} parameter
     * @return the given CompletableFuture
     * @see #cffuCompleteOnTimeout(CompletableFuture, Object, long, TimeUnit, Executor)
     */
    @Contract("_, _, _, _ -> param1")
    public static <T, F extends CompletableFuture<? super T>> F completeOnTimeout(F cfThis, @Nullable T value, long timeout, TimeUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    ////////////////////////////////////////////////////////////
    // region## Advanced Methods of CompletionStage(compose* and handle-like methods)
    //
    // NOTE about advanced meaning:
    //   - `compose` methods, input function argument returns CompletionStage
    //   - handle the successful and failed result together(handle*/whenComplete*/peek*)
    ////////////////////////////////////////////////////////////
    /**
     * Returns a new CompletionStage that, when the given stage completes exceptionally with the given exceptionType, is composed
     * using the results of the supplied function applied to the exception from the given stage({@code argument cfThis}).
     * <p>
     * <strong>"The exception from the given stage({@code argument cfThis})"</strong> means the cause of
     * the {@link ExecutionException} thrown by {@code get()} or, if {@code get()} throws a different kind
     * of exception, that exception itself, i.e. the exception is unwrapped by {@link #unwrapCfException(Throwable)}.
     *
     * @param exceptionType the exception type that triggers use of {@code fallback}. The exception type is matched against
     *                      the exception from argument cfThis. To avoid hiding bugs and other unrecoverable errors,
     *                      callers should prefer more specific types, avoiding {@code Throwable.class} in particular.
     * @param fallback      the Function to be called if cfThis fails with the expected exception type.
     *                      The function's argument is the exception from cfThis.
     * @see #unwrapCfException(Throwable)
     * @see Futures#catchingAsync the equivalent Guava method catchingAsync()
     */
    public static <T, X extends Throwable, F extends CompletionStage<T>> F catchingCompose(F cfThis, Class<X> exceptionType, Function<? super X, ? extends CompletionStage<T>> fallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletionStage that, when the given stage completes exceptionally with the given exceptionType, is composed
     * using the results of the supplied function applied to the exception from the given stage({@code argument cfThis}),
     * using the default executor of parameter the given stage.
     * <p>
     * <strong>"The exception from the given stage({@code argument cfThis})"</strong> means the cause of
     * the {@link ExecutionException} thrown by {@code get()} or, if {@code get()} throws a different kind
     * of exception, that exception itself, i.e. the exception is unwrapped by {@link #unwrapCfException(Throwable)}.
     *
     * @param exceptionType the exception type that triggers use of {@code fallback}. The exception type is matched against
     *                      the exception from argument cfThis. To avoid hiding bugs and other unrecoverable errors,
     *                      callers should prefer more specific types, avoiding {@code Throwable.class} in particular.
     * @param fallback      the Function to be called if cfThis fails with the expected exception type.
     *                      The function's argument is the exception from cfThis.
     * @see #unwrapCfException(Throwable)
     * @see Futures#catchingAsync the equivalent Guava method catchingAsync()
     */
    public static <T, X extends Throwable, F extends CompletionStage<T>> F catchingComposeAsync(F cfThis, Class<X> exceptionType, Function<? super X, ? extends CompletionStage<T>> fallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletionStage that, when the given stage completes exceptionally with the given exceptionType, is composed
     * using the results of the supplied function applied to the exception from the given stage({@code argument cfThis}),
     * using the supplied Executor.
     * <p>
     * <strong>"The exception from the given stage({@code argument cfThis})"</strong> means the cause of
     * the {@link ExecutionException} thrown by {@code get()} or, if {@code get()} throws a different kind
     * of exception, that exception itself, i.e. the exception is unwrapped by {@link #unwrapCfException(Throwable)}.
     *
     * @param exceptionType the exception type that triggers use of {@code fallback}. The exception type is matched against
     *                      the exception from argument cfThis. To avoid hiding bugs and other unrecoverable errors,
     *                      callers should prefer more specific types, avoiding {@code Throwable.class} in particular.
     * @param fallback      the Function to be called if cfThis fails with the expected exception type.
     *                      The function's argument is the exception from cfThis.
     * @param executor      the executor to use for asynchronous execution
     * @see #unwrapCfException(Throwable)
     * @see Futures#catchingAsync the equivalent Guava method catchingAsync()
     */
    public static <T, X extends Throwable, F extends CompletionStage<T>> F catchingComposeAsync(F cfThis, Class<X> exceptionType, Function<? super X, ? extends CompletionStage<T>> fallback, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when given CompletableFuture completes exceptionally,
     * is composed using the results of the supplied function applied to the given stage's exception.
     * <p>
     * Just as catching {@code Throwable} is not best practice in general, this method handles the {@code Throwable};
     * <strong>Strongly recommend</strong> using {@link #catchingCompose(CompletionStage, Class, Function)}
     * instead in your business application.
     *
     * @param fn the function to use to compute the returned CompletableFuture
     *           if given CompletionStage completed exceptionally
     * @see #catchingCompose(CompletionStage, Class, Function)
     */
    public static <T, F extends CompletionStage<T>> F exceptionallyCompose(F cfThis, Function<Throwable, ? extends CompletionStage<T>> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when given CompletableFuture completes exceptionally,
     * is composed using the results of the supplied function applied to the given stage's exception,
     * using the default executor of parameter cfThis.
     * <p>
     * Just as catching {@code Throwable} is not best practice in general, this method handles the {@code Throwable};
     * <strong>Strongly recommend</strong> using {@link #catchingComposeAsync(CompletionStage, Class, Function)}
     * instead in your business application.
     *
     * @param fn the function to use to compute the returned CompletableFuture
     *           if given CompletionStage completed exceptionally
     * @see #catchingComposeAsync(CompletionStage, Class, Function)
     */
    public static <T, F extends CompletionStage<T>> F exceptionallyComposeAsync(F cfThis, Function<Throwable, ? extends CompletionStage<T>> fn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletableFuture that, when given CompletableFuture completes exceptionally, is composed using
     * the results of the supplied function applied to the given stage's exception, using the supplied Executor.
     * <p>
     * Just as catching {@code Throwable} is not best practice in general, this method handles the {@code Throwable};
     * <strong>Strongly recommend</strong> using {@link #catchingComposeAsync(CompletionStage, Class, Function, Executor)}
     * instead in your business application.
     *
     * @param fn       the function to use to compute the returned CompletableFuture
     *                 if given CompletionStage completed exceptionally
     * @param executor the executor to use for asynchronous execution
     * @see #catchingComposeAsync(CompletionStage, Class, Function, Executor)
     */
    public static <T, F extends CompletionStage<T>> F exceptionallyComposeAsync(F cfThis, Function<Throwable, ? extends CompletionStage<T>> fn, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Peeks the result by executing the given action when the given stage completes, returns the given stage.
     * <p>
     * When the given stage is complete, the given action is invoked with the result(or {@code null} if none)
     * and the exception (or {@code null} if none) of given stage as arguments.
     * <p>
     * <strong>NOTE:</strong> When using {@link CompletionStage#whenComplete(BiConsumer)},
     * if the input stage completes normally but the supplied action throws an exception, the returned stage will contain
     * a <strong>DIFFERENT</strong> result than the input stage. This subtle behavior of {@code whenComplete} can lead to
     * bugs when you only want to <strong>peek</strong> at the stage's result (e.g. for logging) without modifying it.<br>
     * In contrast, this {@code peek} method guarantees that the returned stage (which is the input stage)
     * will maintain its original result, regardless of whether the supplied action throws an exception or not.
     * <p>
     * <strong>CAUTION:</strong> Since this method returns the input stage directly, the execution order between
     * the given action and other actions added to the input stage cannot be guaranteed. The given action should
     * be treated as "fire and forget" - do not make any assumptions about timing or execution sequence.
     * <p>
     * Unlike method {@link CompletionStage#handle(BiFunction)} and like method
     * {@link CompletionStage#whenComplete(BiConsumer)}, this method is not designed to translate completion outcomes.
     *
     * @param action the action to perform
     * @return the given stage
     * @see CompletionStage#whenComplete(BiConsumer)
     * @see java.util.stream.Stream#peek(Consumer)
     */
    @Contract("_, _ -> param1")
    public static <T, F extends CompletionStage<? extends T>> F peek(F cfThis, BiConsumer<? super T, ? super Throwable> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Peeks the result by executing the given action using the default executor of parameter cfThis
     * when the given stage completes, returns the given stage.
     * <p>
     * When the given stage is complete, the given action is invoked with the result(or {@code null} if none)
     * and the exception (or {@code null} if none) of given stage as arguments.
     * <p>
     * <strong>NOTE:</strong> When using {@link CompletionStage#whenCompleteAsync(BiConsumer)},
     * if the input stage completes normally but the supplied action throws an exception, the returned stage will contain
     * a <strong>DIFFERENT</strong> result than the input stage. This subtle behavior of {@code whenComplete} can lead to
     * bugs when you only want to <strong>peek</strong> at the stage's result (e.g. for logging) without modifying it.<br>
     * In contrast, this {@code peekAsync} method guarantees that the returned stage (which is the input stage)
     * will maintain its original result, regardless of whether the supplied action throws an exception or not.
     * <p>
     * <strong>CAUTION:</strong> Since this method returns the input stage directly, the execution order between
     * the given action and other actions added to the input stage cannot be guaranteed. The given action should
     * be treated as "fire and forget" - do not make any assumptions about timing or execution sequence.
     * <p>
     * Unlike method {@link CompletionStage#handleAsync(BiFunction)} and like method {@link
     * CompletionStage#whenCompleteAsync(BiConsumer)}, this method is not designed to translate completion outcomes.
     *
     * @param action the action to perform
     * @return the given stage
     * @see CompletionStage#whenCompleteAsync(BiConsumer)
     * @see java.util.stream.Stream#peek(Consumer)
     */
    @Contract("_, _ -> param1")
    public static <T, F extends CompletionStage<? extends T>> F peekAsync(F cfThis, BiConsumer<? super T, ? super Throwable> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Peeks the result by executing the given action using the supplied executor
     * when the given stage completes, returns the given stage.
     * <p>
     * When the given stage is complete, the given action is invoked with the result(or {@code null} if none)
     * and the exception (or {@code null} if none) of given stage as arguments.
     * <p>
     * <strong>NOTE:</strong> When using {@link CompletionStage#whenCompleteAsync(BiConsumer, Executor)},
     * if the input stage completes normally but the supplied action throws an exception, the returned stage will contain
     * a <strong>DIFFERENT</strong> result than the input stage. This subtle behavior of {@code whenComplete} can lead to
     * bugs when you only want to <strong>peek</strong> at the stage's result (e.g. for logging) without modifying it.<br>
     * In contrast, this {@code peekAsync} method guarantees that the returned stage (which is the input stage)
     * will maintain its original result, regardless of whether the supplied action throws an exception or not.
     * <p>
     * <strong>CAUTION:</strong> Since this method returns the input stage directly, the execution order between
     * the given action and other actions added to the input stage cannot be guaranteed. The given action should
     * be treated as "fire and forget" - do not make any assumptions about timing or execution sequence.
     * <p>
     * Unlike method {@link CompletionStage#handleAsync(BiFunction, Executor)} and like method {@link
     * CompletionStage#whenCompleteAsync(BiConsumer, Executor)}, this method is not designed to translate completion outcomes.
     *
     * @param action the action to perform
     * @return the given stage
     * @see CompletionStage#whenCompleteAsync(BiConsumer, Executor)
     * @see java.util.stream.Stream#peek(Consumer)
     */
    @Contract("_, _, _ -> param1")
    public static <T, F extends CompletionStage<? extends T>> F peekAsync(F cfThis, BiConsumer<? super T, ? super Throwable> action, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    ////////////////////////////////////////////////////////////
    // region## Read(explicitly) Methods of CompletableFuture(including Future)
    //
    //    - get()               // BLOCKING!
    //    - get(timeout, unit)  // BLOCKING!
    //    - join()              // BLOCKING!
    //    - join(timeout, unit) // BLOCKING!
    //    - getNow(T valueIfAbsent)
    //    - getSuccessNow(T valueIfNotSuccess)
    //    - resultNow()
    //    - exceptionNow()
    //
    //    - isDone()
    //    - isCompletedExceptionally()
    //    - isCancelled()
    //    - state()
    //    - cffuState()
    //
    // NOTE about ExecutionException or CompletionException when the computation threw an exception:
    //   - get methods throw ExecutionException(checked exception)
    //     these methods exists in `Future` interface since Java 5
    //   - getNow/join throw CompletionException(unchecked exception),
    //     these methods exists in `CompletableFuture` since Java 8
    ////////////////////////////////////////////////////////////
    /**
     * Waits if necessary for at most the given time for the computation to complete
     * and then retrieves its result value when complete, or throws an (unchecked) exception if completed exceptionally.
     * <p>
     * <strong>CAUTION:</strong> if the wait timed out, this method throws an (unchecked) {@link CompletionException}
     * with the {@link TimeoutException} as its cause;
     * NOT throws a (checked) {@link TimeoutException} like {@link CompletableFuture#get(long, TimeUnit)}.
     * <p>
     * <strong>NOTE:</strong> Calling this method
     * <p>
     * {@code result = CompletableFutureUtils.join(cf, timeout, unit);}
     * <p>
     * is the same as:
     *
     * <pre>{@code result = cf.copy() // defensive copy to avoid writing this cf unexpectedly
     *     .orTimeout(timeout, unit)
     *     .join();}</pre>
     *
     * @param timeout the maximum time to wait
     * @param unit    the time unit of the timeout argument
     * @return the result value
     * @throws CancellationException if the computation was cancelled
     * @throws CompletionException   if given future completed exceptionally
     *                               or a completion computation threw an exception,
     *                               or the wait timed out (with the {@code TimeoutException} as its cause)
     * @see CompletableFuture#join()
     */
    @Blocking
    @Nullable
    public static <T> T join(CompletableFuture<? extends T> cfThis, long timeout, TimeUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the result value if the given stage is completed normally, else returns the given valueIfNotSuccess.
     * <p>
     * This method is guaranteed not to throw {@link CompletionException}, {@link ExecutionException},
     * {@link CancellationException} and {@link IllegalStateException}.
     *
     * @param valueIfNotSuccess the value to return if not completed normally
     * @return the result value, if completed normally, else the given valueIfNotSuccess
     * @throws NullPointerException if the given CompletableFuture is {@code null}
     */
    @Contract(pure = true)
    @Nullable
    public static <T> T getSuccessNow(CompletableFuture<? extends T> cfThis, @Nullable T valueIfNotSuccess) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the computed result without waiting.
     * <p>
     * This method is for cases where the caller knows that the task has already completed normally,
     * for example, when filtering a stream of Future objects for the successful tasks
     * and using a mapping operation to obtain a stream of results.
     *
     * <pre>{@code results = futures.stream()
     *     .filter(f -> f.state() == Future.State.SUCCESS)
     *     .map(Future::resultNow)
     *     .toList();}</pre>
     *
     * @return the computed result
     * @throws IllegalStateException if the task has not completed, or the task did not complete with a result
     */
    @Contract(pure = true)
    @Nullable
    public static <T> T resultNow(Future<? extends T> cfThis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the exception thrown by the task without waiting.
     * <p>
     * This method is for cases where the caller knows that the task has already completed with an exception.
     *
     * @return the exception thrown by the task
     * @throws IllegalStateException if the task has not completed, the task completed normally,
     *                               or the task was cancelled
     */
    @Contract(pure = true)
    public static Throwable exceptionNow(Future<?> cfThis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the computation state ({@link CffuState}). This method provides equivalent functionality to
     * {@link CompletableFuture#state()} with backwards compatibility for {@code Java 18-}.
     *
     * @return the computation state
     * @see Future#state()
     */
    @Contract(pure = true)
    public static CffuState state(Future<?> cfThis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    ////////////////////////////////////////////////////////////
    // region## Write Methods of CompletableFuture
    ////////////////////////////////////////////////////////////
    /**
     * Completes given CompletableFuture with the result of the given Supplier function invoked
     * from an asynchronous task using the default executor of parameter cfThis.
     *
     * @param supplier a function returning the value to be used to complete the given CompletableFuture
     * @return the given CompletableFuture
     * @see CompletableFuture#completeAsync(Supplier)
     */
    @Contract("_, _ -> param1")
    public static <T, F extends CompletableFuture<? super T>> F completeAsync(F cfThis, Supplier<? extends T> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Completes given CompletableFuture with the result of the given Supplier function invoked
     * from an asynchronous task using the given executor.
     *
     * @param supplier a function returning the value to be used to complete the given CompletableFuture
     * @param executor the executor to use for asynchronous execution
     * @return the given CompletableFuture
     * @see CompletableFuture#completeAsync(Supplier, Executor)
     */
    @Contract("_, _, _ -> param1")
    public static <T, F extends CompletableFuture<? super T>> F completeAsync(F cfThis, Supplier<? extends T> supplier, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If not already completed, completes given CompletableFuture with the exception result
     * of the given Supplier function invoked from an asynchronous task using the default executor of parameter cfThis.
     *
     * @param supplier a function returning the value to be used to complete the given CompletableFuture
     * @return the given CompletableFuture
     * @see CompletableFuture#completeExceptionally(Throwable)
     */
    @Contract("_, _ -> param1")
    public static <F extends CompletableFuture<?>> F completeExceptionallyAsync(F cfThis, Supplier<? extends Throwable> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If not already completed, completes given CompletableFuture with the exception result
     * of the given Supplier function invoked from an asynchronous task using the given executor.
     *
     * @param supplier a function returning the value to be used to complete the given CompletableFuture
     * @param executor the executor to use for asynchronous execution
     * @return the given CompletableFuture
     * @see CompletableFuture#completeExceptionally(Throwable)
     */
    @Contract("_, _, _ -> param1")
    public static <F extends CompletableFuture<?>> F completeExceptionallyAsync(F cfThis, Supplier<? extends Throwable> supplier, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    ////////////////////////////////////////////////////////////
    // region## Re-Config Methods of CompletableFuture
    ////////////////////////////////////////////////////////////
    /**
     * Returns a new CompletableFuture that is completed normally with the same value as this CompletableFuture when
     * it completes normally. If this CompletableFuture completes exceptionally, then the returned CompletableFuture
     * completes exceptionally with a CompletionException with this exception as cause. The behavior is equivalent
     * to {@code thenApply(x -> x)}. This method may be useful as a form of "defensive copying", to prevent clients
     * from completing, while still being able to arrange dependent actions.
     *
     * @see CompletableFuture#copy()
     */
    @Contract(pure = true)
    public static <T> CompletableFuture<T> copy(CompletableFuture<T> cfThis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new CompletionStage that is completed normally with the same value as given CompletableFuture
     * when it completes normally, and cannot be independently completed or otherwise used in ways
     * not defined by the methods of interface {@link CompletionStage}.
     * If the given CompletableFuture completes exceptionally, then the returned CompletionStage completes exceptionally
     * with a CompletionException with the given exception as a cause.
     * <p>
     * <strong>CAUTION:</strong> if run on old Java 8 (which does not support *minimal* CompletionStage),
     * this method just returns a *normal* CompletableFuture instance which is NOT a *minimal* CompletionStage.
     *
     * @see CompletableFuture#minimalCompletionStage()
     */
    @Contract(pure = true)
    public static <T> CompletionStage<T> minimalCompletionStage(CompletableFuture<T> cfThis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the default Executor of parameter cfThis used for async methods that do not specify an Executor.
     * <p>
     * The default executor of CompletableFuture(<strong>NOT</strong> including the customized subclasses of CompletableFuture)
     * uses the {@link ForkJoinPool#commonPool()} if it supports more than one parallel thread, or else an Executor using one
     * thread per async task. <strong>CAUTION:</strong> This executor may be not suitable for common business use(io intensive).
     *
     * @see CompletableFuture#defaultExecutor()
     */
    @Contract(pure = true)
    public static Executor defaultExecutor(CompletionStage<?> cfThis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    // endregion
    ////////////////////////////////////////////////////////////////////////////////
    // region# CF Exception Utility Methods
    ////////////////////////////////////////////////////////////////////////////////
    /**
     * Unwraps CompletableFuture exception ({@link CompletionException} or {@link ExecutionException})
     * to its cause exception. If the input exception is not a {@code CompletableFuture}/{@code ExecutionException}
     * or has no cause, contains a cyclic chain of CompletableFuture exceptions, or is null, returns the input exception.
     *
     * @param ex the exception to be unwrapped may be null
     * @see com.google.common.base.Throwables#getRootCause(Throwable) Guava method Throwables#getRootCause(),
     * the loop detection code using fast and slow pointers is adapted from it
     */
    @Contract(value = "null -> null; !null -> !null", pure = true)
    @Nullable
    public static Throwable unwrapCfException(@Nullable final Throwable ex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Wraps an exception-handling {@code Function} to ensure that if the handling throws a new exception,
     * the error context is preserved by calling {@link Throwable#addSuppressed}.
     * <p>
     * Example usage with {@link CompletableFuture#exceptionally CompletableFuture#exceptionally},
     * {@link CompletableFuture#exceptionallyCompose CompletableFuture#exceptionallyCompose},
     * {@link CompletableFutureUtils#catching CompletableFutureUtils#catching},
     * or {@link CompletableFutureUtils#catchingCompose CompletableFutureUtils#catching}:
     * <pre>{@code  cf.exceptionally(nonExSwallowedFunction(fn, false));
     * CompletableFutureUtils.catching(cf, exceptionType, nonExSwallowedFunction(fallback, false));}</pre>
     * <p>
     * The methods {@link CompletableFuture#exceptionally exceptionally*} in {@code CompletableFuture} and the
     * methods {@link CompletableFutureUtils#exceptionallyCompose CompletableFutureUtils#exceptionallyCompose*} /
     * {@link CompletableFutureUtils#catching catching*} in {@code CompletableFutureUtils} do not incorporate
     * the {@code nonExSwallowed} logic, to maintain consistent and predictable behavior with the standard {@code CompletableFuture}.
     * It is recommended to use {@link Cffu} which has enhanced exception handling with the {@code nonExSwallowed} logic.
     * <p>
     * For more details on exception swallowing in exception handling methods, see the test cases in <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/aspect_test/ExSwallowingOfExHandlingMethodsTests.kt"
     * >ExSwallowingOfExHandlingMethodsTests</a>.
     *
     * @param addSuppressedToOriginalEx if true, the new exception is added as a suppressed exception to the original exception;
     *                                  otherwise, the original exception is added as a suppressed exception to the new exception
     * @see <a href="https://peps.python.org/pep-0020/">Errors should never pass silently. Unless explicitly silenced.</a>
     */
    @Contract(value = "null, _ -> null; !null, _ -> !null", pure = true)
    @Nullable
    public static <X extends Throwable, T> Function<X, T> nonExSwallowedFunction(@Nullable Function<? super X, ? extends T> fn, boolean addSuppressedToOriginalEx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Wraps an exception-handling {@code BiFunction} to ensure that if the handling throws a new exception,
     * the error context is preserved by calling {@link Throwable#addSuppressed}.
     * <p>
     * Example usage with {@link CompletableFuture#handle CompletableFuture#handle}:
     * <pre>{@code cf.handle(nonExSwallowedBiFunction(fn, false));}</pre>
     * <p>
     * The methods {@link CompletableFuture#handle CompletableFuture#handle*} in {@code CompletableFuture}
     * do not incorporate the {@code nonExSwallowed} logic.
     * It is recommended to use {@link Cffu} which has enhanced exception handling with the {@code nonExSwallowed} logic.
     * <p>
     * For more details on exception swallowing in exception handling methods, see the test cases in <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/aspect_test/ExSwallowingOfExHandlingMethodsTests.kt"
     * >ExSwallowingOfExHandlingMethodsTests</a>.
     *
     * @param addSuppressedToOriginalEx if true, the new exception is added as a suppressed exception to the original exception;
     *                                  otherwise, the original exception is added as a suppressed exception to the new exception
     * @see <a href="https://peps.python.org/pep-0020/">Errors should never pass silently. Unless explicitly silenced.</a>
     */
    @Contract(value = "null, _ -> null; !null, _ -> !null", pure = true)
    @Nullable
    public static <T, X extends Throwable, U> BiFunction<T, X, U> nonExSwallowedBiFunction(@Nullable BiFunction<? super T, ? super X, ? extends U> fn, boolean addSuppressedToOriginalEx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Wraps an exception-handling {@code BiConsumer} to ensure that if the handling throws a new exception,
     * the error context is preserved by calling {@link Throwable#addSuppressed}.
     * <p>
     * Example usage with {@link CompletableFuture#whenComplete CompletableFuture#whenComplete}:
     * <pre>{@code cf.whenComplete(nonExSwallowedBiConsumer(action, true));}</pre>
     * <p>
     * The methods {@link CompletableFuture#whenComplete CompletableFuture#whenComplete*} in {@code CompletableFuture}
     * may not incorporate the {@code nonExSwallowed} logic.
     * It is recommended to use {@link Cffu} which has enhanced exception handling with the {@code nonExSwallowed} logic.
     * <p>
     * For more details on exception swallowing in exception handling methods, see the test cases in <a href=
     * "https://github.com/foldright/cffu/blob/2.x-dev/cffu-core/src/test/java/io/foldright/aspect_test/ExSwallowingOfExHandlingMethodsTests.kt"
     * >ExSwallowingOfExHandlingMethodsTests</a>.
     *
     * @param addSuppressedToOriginalEx if true, the new exception is added as a suppressed exception to the original exception;
     *                                  otherwise, the original exception is added as a suppressed exception to the new exception
     * @see <a href="https://peps.python.org/pep-0020/">Errors should never pass silently. Unless explicitly silenced.</a>
     */
    @Contract(value = "null, _ -> null; !null, _ -> !null", pure = true)
    @Nullable
    public static <T, X extends Throwable> BiConsumer<T, X> nonExSwallowedBiConsumer(@Nullable BiConsumer<? super T, ? super X> action, boolean addSuppressedToOriginalEx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private CompletableFutureUtils() {
    }
}
