package io.foldright.cffu2.eh;

import edu.umd.cs.findbugs.annotations.Nullable;
import io.foldright.cffu2.Cffu;
import io.foldright.cffu2.internal.CommonUtils;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import static io.foldright.cffu2.CompletableFutureUtils.unwrapCfException;
import static io.foldright.cffu2.LLCF.*;
import static io.foldright.cffu2.internal.CffuLogger.Level.ERROR;
import static io.foldright.cffu2.internal.CffuLogger.Level.WARN;
import static io.foldright.cffu2.internal.CffuLogger.logException;
import static io.foldright.cffu2.internal.CffuLogger.logUncaughtException;
import static io.foldright.cffu2.internal.CommonUtils.requireArrayAndEleNonNull;
import static java.util.Objects.requireNonNull;

/**
 * Utilities to handle swallowed exceptions from <strong>MULTIPLE</strong> {@link CompletionStage}s
 * (including {@link CompletableFuture}s and {@link Cffu}s).
 * <p>
 * These utilities are designed for noncritical tasks like reporting and logging exceptions. For business logic
 * exception handling, use the standard exception handling methods for SINGLE {@code CompletionStage}s instead: {@link
 * CompletionStage#exceptionally exceptionally}, {@link Cffu#catching catching}, or {@link CompletionStage#handle handle}.
 *
 * @author Jerry Lee (oldratlee at gmail dot com)
 * @see <a href="https://peps.python.org/pep-0020/">Errors should never pass silently. Unless explicitly silenced.</a>
 */
public final class SwallowedExceptionHandleUtils {

    /**
     * Handles all exceptions from multiple input {@code CompletionStage}s as swallowed exceptions,
     * using {@link #cffuSwallowedExceptionHandler()} and calling back it with {@code null} attachment.
     *
     * @param where the location where the exception occurs
     */
    public static void handleAllSwallowedExceptions(String where, CompletionStage<?>... inputs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Handles all exceptions from multiple input {@code CompletionStage}s as swallowed exceptions,
     * calling back the exceptionHandler with {@code null} attachment.
     *
     * @param where            the location where the exception occurs
     * @param exceptionHandler the exception handler
     */
    public static void handleAllSwallowedExceptions(String where, ExceptionHandler exceptionHandler, CompletionStage<?>... inputs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Handles all exceptions from multiple input {@code CompletionStage}s as swallowed exceptions.
     *
     * @param where            the location where the exception occurs
     * @param attachments      the attachment objects
     * @param exceptionHandler the exception handler
     */
    public static void handleAllSwallowedExceptions(String where, @Nullable Object[] attachments, ExceptionHandler exceptionHandler, CompletionStage<?>... inputs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Handles swallowed exceptions from multiple input {@code CompletionStage}s that are discarded (not propagated)
     * by the output {@code CompletionStage}, using {@link #cffuSwallowedExceptionHandler()}
     * and calling it back with {@code null} attachment.
     *
     * @param where the location where the exception occurs
     */
    public static void handleSwallowedExceptions(String where, CompletionStage<?> output, CompletionStage<?>... inputs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Handles swallowed exceptions from multiple input {@code CompletionStage}s that are discarded (not propagated)
     * by the output {@code CompletionStage}, calling back the {@code exceptionHandler} with {@code null} attachment.
     *
     * @param where            the location where the exception occurs
     * @param exceptionHandler the exception handler
     */
    public static void handleSwallowedExceptions(String where, ExceptionHandler exceptionHandler, CompletionStage<?> output, CompletionStage<?>... inputs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Handles swallowed exceptions from multiple input {@code CompletionStage}s
     * that are discarded (not propagated) by the output {@code CompletionStage}.
     *
     * @param where            the location where the exception occurs
     * @param attachments      the attachment objects
     * @param exceptionHandler the exception handler
     */
    public static void handleSwallowedExceptions(String where, @Nullable Object[] attachments, ExceptionHandler exceptionHandler, CompletionStage<?> output, CompletionStage<?>... inputs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns an exception handler that logs swallowed exceptions from CompletionStages
     * at warning level using the cffu logger.
     */
    public static ExceptionHandler cffuSwallowedExceptionHandler() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final ExceptionHandler CFFU_SWALLOWED_EX_HANDLER = exInfo -> {
        String msg = "Swallowed exception of cf" + (exInfo.index + 1) + " at " + exInfo.where;
        logException(WARN, msg, exInfo.exception);
    };

    /**
     * Creates new CompletionStages that only observe exception results from the input CompletionStages,
     * ensuring the original stages and their results can be garbage collected ASAP by avoiding references.
     */
    private static CompletionStage<Void>[] unreferenced(CompletionStage<?>[] stages) {
        return CommonUtils.mapArray(stages, CommonUtils::newStageArray, s -> {
            CompletableFuture<Void> ret = new CompletableFuture<>();
            peek0(s, (v, ex) -> completeCf0(ret, null, ex), "unreferenced");
            return ret;
        });
    }

    @Nullable
    private static Object safeGet(@Nullable Object[] attachments, int index) {
        if (attachments == null)
            return null;
        else if (index < attachments.length)
            return attachments[index];
        else
            return null;
    }

    private static void safeHandle(ExceptionInfo info, ExceptionHandler handler) {
        try {
            handler.handle(info);
        } catch (Throwable ex) {
            safeAddSuppressedEx(info.exception, ex);
            logUncaughtException(ERROR, "exceptionHandler(" + handler.getClass() + ")", ex);
        }
    }

    private SwallowedExceptionHandleUtils() {
    }
}
