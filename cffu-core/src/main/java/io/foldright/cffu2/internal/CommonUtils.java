package io.foldright.cffu2.internal;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.StreamSupport;
import static java.util.Objects.requireNonNull;

/**
 * <strong>Internal</strong> common utility methods.
 */
@ApiStatus.Internal
public final class CommonUtils {

    // region# Array Utility Methods
    @SafeVarargs
    public static <T> T[] requireArrayAndEleNonNull(String varName, T... array) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * example code of "map int[] to string[]":
     *
     * <pre>{@code  Integer[] source = new Integer[3];
     * mapArray(source, String[]::new, i -> "integer: " + i);}</pre>
     */
    public static <T, R> R[] mapArray(T[] source, IntFunction<R[]> destConstructor, Function<? super T, ? extends R> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Fills the input array where each element is calculated by calling the specified init function.
     */
    public static <T> T[] fillArray(T[] array, IntFunction<T> init) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if the object is in the given array.
     */
    public static boolean containsInArray(final Object[] array, final Object objectToFind) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public static <T> CompletableFuture<T>[] newCfArray(int length) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public static <T> CompletionStage<T>[] newStageArray(int length) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    // region# List Utility Methods
    /**
     * Returns a new {@link ArrayList} which is not unmodifiable({@link java.util.List#of}) or fixed-size
     * ({@link Arrays#asList}) list. Safer for application code which may reuse the return list as a normal collection.
     */
    @Contract("_ -> new")
    @SafeVarargs
    public static <T> ArrayList<T> arrayList(T... elements) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new {@link ArrayList} with the specified size,
     * where each element is calculated by calling the specified init function.
     */
    @Contract("_, _ -> new")
    public static <T> ArrayList<T> arrayList(int size, IntFunction<? extends T> init) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    // region# Conversation Methods (Iterable -> Array)
    /**
     * Converts an Iterable to an array.
     */
    @Contract(value = "null, _ -> null; !null, _ -> !null")
    @Nullable
    public static <T> T[] toArray(@Nullable Iterable<? extends T> iterable, T[] typeToken) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts an Iterable to an array.
     */
    @Contract(value = "null, _, _ -> null; !null, _, _ -> !null")
    @Nullable
    public static <T, U> U[] toArray(@Nullable Iterable<? extends T> iterable, IntFunction<U[]> generator, Function<? super T, ? extends U> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    // region# AtomicReferenceArray Utility Methods
    /**
     * Fills the given {@link AtomicReferenceArray} with the same elements as the given value.
     *
     * @see Arrays#fill(Object[], Object)
     */
    public static <E> void fillAtomicReferenceArray(AtomicReferenceArray<? super E> array, E value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new {@link ArrayList} with the same elements as the given {@link AtomicReferenceArray}.
     */
    @Contract("_ -> new")
    public static <E> ArrayList<E> toArrayList(AtomicReferenceArray<? extends E> array) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // endregion
    // region# Other Mics Methods
    @Nullable
    public static <T> T castOrNull(Class<T> clazz, @Nullable Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private CommonUtils() {
    }
}
