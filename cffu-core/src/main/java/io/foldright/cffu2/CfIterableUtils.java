package io.foldright.cffu2;

import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import edu.umd.cs.findbugs.annotations.Nullable;
import org.jetbrains.annotations.Contract;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import static io.foldright.cffu2.CompletableFutureUtils.*;
import static io.foldright.cffu2.internal.CommonUtils.toArray;

/**
 * This utility class provides {@link Iterable}-based variants (including {@link Collection}, {@link List}, etc.) of
 * same-named varargs methods from {@link CompletableFutureUtils}. These methods handle multiple actions
 * and CompletableFutures with the same type, i.e. homogeneous.
 * <p>
 * While {@link CfTupleUtils} uses strongly typed tuples for handling different types of actions and
 * CompletableFutures, i.e. heterogeneous, this class and {@link CompletableFutureUtils} work with homogeneous types,
 * offering a flexible approach for handling collections of actions and CompletableFutures of the same type.
 *
 * @author Eric Lin (linqinghua4 at gmail dot com)
 * @author Jerry Lee (oldratlee at gmail dot com)
 * @see CompletableFutureUtils
 * @see CfParallelUtils
 * @see CfTupleUtils
 */
public final class CfIterableUtils {

    ////////////////////////////////////////////////////////////////////////////////
    // region# CF Factory Methods
    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////
    // region## Multi-Actions(M*) Methods(create by actions)
    //
    //    - Iterable<Supplier<T>> -> CompletableFuture<List<T>>
    //    - Iterable<Runnable>    -> CompletableFuture<Void>
    ////////////////////////////////////////////////////////////
    /**
     * Iterable variant of {@link CompletableFutureUtils#mSupplyFailFastAsync(Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static <T> CompletableFuture<List<T>> mSupplyFailFastAsync(Iterable<? extends Supplier<? extends T>> suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mSupplyFailFastAsync(Executor, Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static <T> CompletableFuture<List<T>> mSupplyFailFastAsync(Iterable<? extends Supplier<? extends T>> suppliers, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mSupplyAllSuccessAsync(Object, Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static <T> CompletableFuture<List<T>> mSupplyAllSuccessAsync(@Nullable T valueIfFailed, Iterable<? extends Supplier<? extends T>> suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mSupplyAllSuccessAsync(Executor, Object, Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static <T> CompletableFuture<List<T>> mSupplyAllSuccessAsync(@Nullable T valueIfFailed, Iterable<? extends Supplier<? extends T>> suppliers, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mSupplyMostSuccessAsync(Object, long, TimeUnit, Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static <T> CompletableFuture<List<T>> mSupplyMostSuccessAsync(@Nullable T valueIfNotSuccess, long timeout, TimeUnit unit, Iterable<? extends Supplier<? extends T>> suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mSupplyMostSuccessAsync(Executor, Object, long, TimeUnit, Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static <T> CompletableFuture<List<T>> mSupplyMostSuccessAsync(@Nullable T valueIfNotSuccess, long timeout, TimeUnit unit, Iterable<? extends Supplier<? extends T>> suppliers, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mSupplyAsync(Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static <T> CompletableFuture<List<T>> mSupplyAsync(Iterable<? extends Supplier<? extends T>> suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mSupplyAsync(Executor, Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static <T> CompletableFuture<List<T>> mSupplyAsync(Iterable<? extends Supplier<? extends T>> suppliers, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mSupplyAnySuccessAsync(Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static <T> CompletableFuture<T> mSupplyAnySuccessAsync(Iterable<? extends Supplier<? extends T>> suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mSupplyAnySuccessAsync(Executor, Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static <T> CompletableFuture<T> mSupplyAnySuccessAsync(Iterable<? extends Supplier<? extends T>> suppliers, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mSupplyAnyAsync(Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static <T> CompletableFuture<T> mSupplyAnyAsync(Iterable<? extends Supplier<? extends T>> suppliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mSupplyAnyAsync(Executor, Supplier[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static <T> CompletableFuture<T> mSupplyAnyAsync(Iterable<? extends Supplier<? extends T>> suppliers, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    private static <T> Supplier<? extends T>[] toSupplierArray(Iterable<? extends Supplier<? extends T>> suppliers) {
        return toArray(suppliers, EMPTY_SUPPLIERS);
    }

    @SuppressWarnings("rawtypes")
    private static final Supplier[] EMPTY_SUPPLIERS = {};

    /**
     * Iterable variant of {@link CompletableFutureUtils#mRunFailFastAsync(Runnable...)}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static CompletableFuture<Void> mRunFailFastAsync(Iterable<? extends Runnable> actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mRunFailFastAsync(Executor, Runnable...)}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static CompletableFuture<Void> mRunFailFastAsync(Iterable<? extends Runnable> actions, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mRunAsync(Runnable...)}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static CompletableFuture<Void> mRunAsync(Iterable<? extends Runnable> actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mRunAsync(Executor, Runnable...)}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static CompletableFuture<Void> mRunAsync(Iterable<? extends Runnable> actions, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mRunAnySuccessAsync(Runnable...)}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static CompletableFuture<Void> mRunAnySuccessAsync(Iterable<? extends Runnable> actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mRunAnySuccessAsync(Executor, Runnable...)}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static CompletableFuture<Void> mRunAnySuccessAsync(Iterable<? extends Runnable> actions, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mRunAnyAsync(Runnable...)}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static CompletableFuture<Void> mRunAnyAsync(Iterable<? extends Runnable> actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mRunAnyAsync(Executor, Runnable...)}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `mRunAsyncAndForget`")
    public static CompletableFuture<Void> mRunAnyAsync(Iterable<? extends Runnable> actions, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mRunAsync(Runnable...)}.
     *
     * @since 2.1.0
     */
    public static void mRunAsyncAndForget(Iterable<? extends Runnable> actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @since 2.1.0
     * Iterable variant of {@link CompletableFutureUtils#mRunAsync(Executor, Runnable...)}.
     */
    public static void mRunAsyncAndForget(Iterable<? extends Runnable> actions, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static Runnable[] toRunnableArray(Iterable<? extends Runnable> actions) {
        return toArray(actions, EMPTY_RUNNABLES);
    }

    private static final Runnable[] EMPTY_RUNNABLES = {};

    // endregion
    ////////////////////////////////////////////////////////////
    // region## allOf* Methods (including mostSuccessResultsOf)
    //
    //    Iterable<CompletionStage<T>> -> CompletableFuture<List<T>>
    ////////////////////////////////////////////////////////////
    /**
     * Iterable variant of {@link CompletableFutureUtils#allResultsFailFastOf(CompletionStage[])}.
     */
    @Contract(pure = true)
    public static <T> CompletableFuture<List<T>> allResultsFailFastOf(Iterable<? extends CompletionStage<? extends T>> cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#allSuccessResultsOf(Object, CompletionStage[])}.
     */
    @Contract(pure = true)
    public static <T> CompletableFuture<List<T>> allSuccessResultsOf(@Nullable T valueIfFailed, Iterable<? extends CompletionStage<? extends T>> cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mostSuccessResultsOf(Object, long, TimeUnit, CompletionStage[])}.
     */
    @Contract(pure = true)
    public static <T> CompletableFuture<List<T>> mostSuccessResultsOf(@Nullable T valueIfNotSuccess, long timeout, TimeUnit unit, Iterable<? extends CompletionStage<? extends T>> cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#mostSuccessResultsOf(Executor, Object, long, TimeUnit, CompletionStage[])}.
     */
    @Contract(pure = true)
    public static <T> CompletableFuture<List<T>> mostSuccessResultsOf(@Nullable T valueIfNotSuccess, long timeout, TimeUnit unit, Iterable<? extends CompletionStage<? extends T>> cfs, Executor executorWhenTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#allResultsOf}.
     */
    @Contract(pure = true)
    public static <T> CompletableFuture<List<T>> allResultsOf(Iterable<? extends CompletionStage<? extends T>> cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#allFailFastOf(CompletionStage[])}.
     */
    @Contract(pure = true)
    public static CompletableFuture<Void> allFailFastOf(Iterable<? extends CompletionStage<?>> cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#allOf(CompletionStage[])}.
     */
    @Contract(pure = true)
    public static CompletableFuture<Void> allOf(Iterable<? extends CompletionStage<?>> cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    private static <T> CompletionStage<? extends T>[] toStageArray(Iterable<? extends CompletionStage<? extends T>> cfs) {
        return toArray(cfs, EMPTY_STAGES);
    }

    @SuppressWarnings("rawtypes")
    private static final CompletionStage[] EMPTY_STAGES = {};

    // endregion
    ////////////////////////////////////////////////////////////
    // region## anyOf* Methods
    //
    //    Iterable<CompletionStage<T>> -> CompletableFuture<T>
    ////////////////////////////////////////////////////////////
    /**
     * Iterable variant of {@link CompletableFutureUtils#anySuccessOf(CompletionStage[])}.
     */
    @Contract(pure = true)
    public static <T> CompletableFuture<T> anySuccessOf(Iterable<? extends CompletionStage<? extends T>> cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#anyOf(CompletionStage[])}.
     */
    @Contract(pure = true)
    public static <T> CompletableFuture<T> anyOf(Iterable<? extends CompletionStage<? extends T>> cfs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    // endregion
    ////////////////////////////////////////////////////////////////////////////////
    // region# CF Instance Methods, Then-Multi-Actions(thenM*) Methods
    //
    //    - thenMApply* (Iterable<Function>: T -> U)       -> CompletableFuture<List<U>>
    //    - thenMAccept*(Iterable<Consumer>: T -> Void)    -> CompletableFuture<Void>
    //    - thenMRun*   (Iterable<Runnable>: Void -> Void) -> CompletableFuture<Void>
    ////////////////////////////////////////////////////////////
    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMApplyFailFastAsync(CompletableFuture, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> thenMApplyFailFastAsync(CompletableFuture<? extends T> cfThis, Iterable<? extends Function<? super T, ? extends U>> fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMApplyFailFastAsync(CompletableFuture, Executor, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> thenMApplyFailFastAsync(CompletableFuture<? extends T> cfThis, Iterable<? extends Function<? super T, ? extends U>> fns, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMApplyAllSuccessAsync(CompletableFuture, Object, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> thenMApplyAllSuccessAsync(CompletableFuture<? extends T> cfThis, @Nullable U valueIfFailed, Iterable<? extends Function<? super T, ? extends U>> fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMApplyAllSuccessAsync(CompletableFuture, Executor, Object, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> thenMApplyAllSuccessAsync(CompletableFuture<? extends T> cfThis, @Nullable U valueIfFailed, Iterable<? extends Function<? super T, ? extends U>> fns, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMApplyMostSuccessAsync(CompletableFuture, Object, long, TimeUnit, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> thenMApplyMostSuccessAsync(CompletableFuture<? extends T> cfThis, @Nullable U valueIfNotSuccess, long timeout, TimeUnit unit, Iterable<? extends Function<? super T, ? extends U>> fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMApplyMostSuccessAsync(CompletableFuture, Executor, Object, long, TimeUnit, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> thenMApplyMostSuccessAsync(CompletableFuture<? extends T> cfThis, @Nullable U valueIfNotSuccess, long timeout, TimeUnit unit, Iterable<? extends Function<? super T, ? extends U>> fns, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMApplyAsync(CompletableFuture, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> thenMApplyAsync(CompletableFuture<? extends T> cfThis, Iterable<? extends Function<? super T, ? extends U>> fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMApplyAsync(CompletableFuture, Executor, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<List<U>> thenMApplyAsync(CompletableFuture<? extends T> cfThis, Iterable<? extends Function<? super T, ? extends U>> fns, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMApplyAnySuccessAsync(CompletableFuture, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<U> thenMApplyAnySuccessAsync(CompletableFuture<? extends T> cfThis, Iterable<? extends Function<? super T, ? extends U>> fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMApplyAnySuccessAsync(CompletableFuture, Executor, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<U> thenMApplyAnySuccessAsync(CompletableFuture<? extends T> cfThis, Iterable<? extends Function<? super T, ? extends U>> fns, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMApplyAnyAsync(CompletableFuture, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<U> thenMApplyAnyAsync(CompletableFuture<? extends T> cfThis, Iterable<? extends Function<? super T, ? extends U>> fns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMApplyAnyAsync(CompletableFuture, Executor, Function[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T, U> CompletableFuture<U> thenMApplyAnyAsync(CompletableFuture<? extends T> cfThis, Iterable<? extends Function<? super T, ? extends U>> fns, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    private static <T, U> Function<? super T, ? extends U>[] toFunctionArray(Iterable<? extends Function<? super T, ? extends U>> fns) {
        return toArray(fns, EMPTY_FUNCTIONS);
    }

    @SuppressWarnings("rawtypes")
    private static final Function[] EMPTY_FUNCTIONS = {};

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMAcceptFailFastAsync(CompletableFuture, Consumer[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> thenMAcceptFailFastAsync(CompletableFuture<? extends T> cfThis, Iterable<? extends Consumer<? super T>> actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMAcceptFailFastAsync(CompletableFuture, Executor, Consumer[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> thenMAcceptFailFastAsync(CompletableFuture<? extends T> cfThis, Iterable<? extends Consumer<? super T>> actions, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMAcceptAsync(CompletableFuture, Consumer[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> thenMAcceptAsync(CompletableFuture<? extends T> cfThis, Iterable<? extends Consumer<? super T>> actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMAcceptAsync(CompletableFuture, Executor, Consumer[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> thenMAcceptAsync(CompletableFuture<? extends T> cfThis, Iterable<? extends Consumer<? super T>> actions, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMAcceptAnySuccessAsync(CompletableFuture, Consumer[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> thenMAcceptAnySuccessAsync(CompletableFuture<? extends T> cfThis, Iterable<? extends Consumer<? super T>> actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMAcceptAnySuccessAsync(CompletableFuture, Executor, Consumer[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> thenMAcceptAnySuccessAsync(CompletableFuture<? extends T> cfThis, Iterable<? extends Consumer<? super T>> actions, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMAcceptAnyAsync(CompletableFuture, Consumer[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> thenMAcceptAnyAsync(CompletableFuture<? extends T> cfThis, Iterable<? extends Consumer<? super T>> actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMAcceptAnyAsync(CompletableFuture, Executor, Consumer[])}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMAcceptAsyncAndForget`")
    public static <T> CompletableFuture<Void> thenMAcceptAnyAsync(CompletableFuture<? extends T> cfThis, Iterable<? extends Consumer<? super T>> actions, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMAcceptAsyncAndForget(CompletionStage, Consumer[])}.
     *
     * @since 2.1.0
     */
    @Contract("_, _ -> param1")
    public static <T, F extends CompletionStage<? extends T>> F thenMAcceptAsyncAndForget(F cfThis, Iterable<? extends Consumer<? super T>> actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMAcceptAsyncAndForget(CompletionStage, Executor, Consumer[])}.
     *
     * @since 2.1.0
     */
    @Contract("_, _, _ -> param1")
    public static <T, F extends CompletionStage<? extends T>> F thenMAcceptAsyncAndForget(F cfThis, Iterable<? extends Consumer<? super T>> actions, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    private static <T> Consumer<? super T>[] toConsumerArray(Iterable<? extends Consumer<? super T>> actions) {
        return toArray(actions, EMPTY_CONSUMERS);
    }

    @SuppressWarnings("rawtypes")
    private static final Consumer[] EMPTY_CONSUMERS = {};

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMRunFailFastAsync(CompletableFuture, Runnable...)}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMRunAsyncAndForget`")
    public static CompletableFuture<Void> thenMRunFailFastAsync(CompletableFuture<?> cfThis, Iterable<? extends Runnable> actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMRunFailFastAsync(CompletableFuture, Executor, Runnable...)}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMRunAsyncAndForget`")
    public static CompletableFuture<Void> thenMRunFailFastAsync(CompletableFuture<?> cfThis, Iterable<? extends Runnable> actions, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMRunAsync(CompletableFuture, Runnable...)}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMRunAsyncAndForget`")
    public static CompletableFuture<Void> thenMRunAsync(CompletableFuture<?> cfThis, Iterable<? extends Runnable> actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMRunAsync(CompletableFuture, Executor, Runnable...)}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMRunAsyncAndForget`")
    public static CompletableFuture<Void> thenMRunAsync(CompletableFuture<?> cfThis, Iterable<? extends Runnable> actions, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMRunAnySuccessAsync(CompletableFuture, Runnable...)}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMRunAsyncAndForget`")
    public static CompletableFuture<Void> thenMRunAnySuccessAsync(CompletableFuture<?> cfThis, Iterable<? extends Runnable> actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMRunAnySuccessAsync(CompletableFuture, Executor, Runnable...)}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMRunAsyncAndForget`")
    public static CompletableFuture<Void> thenMRunAnySuccessAsync(CompletableFuture<?> cfThis, Iterable<? extends Runnable> actions, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMRunAnyAsync(CompletableFuture, Runnable...)}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMRunAsyncAndForget`")
    public static CompletableFuture<Void> thenMRunAnyAsync(CompletableFuture<?> cfThis, Iterable<? extends Runnable> actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMRunAnyAsync(CompletableFuture, Executor, Runnable...)}.
     */
    @CheckReturnValue(explanation = "should use the returned CompletableFuture; otherwise, use method `thenMRunAsyncAndForget`")
    public static CompletableFuture<Void> thenMRunAnyAsync(CompletableFuture<?> cfThis, Iterable<? extends Runnable> actions, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMRunAsyncAndForget(CompletionStage, Runnable...)}.
     *
     * @since 2.1.0
     */
    public static <F extends CompletionStage<?>> F thenMRunAsyncAndForget(F cfThis, Iterable<? extends Runnable> actions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Iterable variant of {@link CompletableFutureUtils#thenMRunAsyncAndForget(CompletionStage, Executor, Runnable...)}.
     *
     * @since 2.1.0
     */
    public static <F extends CompletionStage<?>> F thenMRunAsyncAndForget(F cfThis, Iterable<? extends Runnable> actions, Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private CfIterableUtils() {
    }
}
