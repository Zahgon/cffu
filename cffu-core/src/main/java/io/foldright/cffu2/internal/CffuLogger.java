package io.foldright.cffu2.internal;

import edu.umd.cs.findbugs.annotations.Nullable;
import io.foldright.cffu2.config.CffuConfiguration.ExceptionLoggingFormat;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.VisibleForTesting;
import org.slf4j.spi.LocationAwareLogger;

/**
 * <strong>Internal</strong> exception logging utility for the cffu library.
 *
 * @author HuHao (995483610 at qq dot com)
 * @author Jerry Lee (oldratlee at gmail dot com)
 * @see io.foldright.cffu2.config.CffuConfiguration#setExceptionLoggingFormat
 * @see <a href="https://peps.python.org/pep-0020/">Errors should never pass silently. Unless explicitly silenced.</a>
 */
@ApiStatus.Internal
public final class CffuLogger {

    private static final String FQCN = CffuLogger.class.getName();

    private static final String CFFU_PACKAGE_NAME = FQCN.replaceFirst("(\\.[^.]*){2}$", "");

    @VisibleForTesting
    static volatile ExceptionLoggingFormat exceptionLoggingFormat = initExceptionLoggingFormat();

    private static final LoggerAdapter logger = getLogger();

    public static void logException(Level level, String msg, Throwable ex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void logUncaughtException(Level level, String where, Throwable ex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void log(Level level, String msg) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("StatementWithEmptyBody")
    private static void log0(Level level, String msg, @Nullable Throwable ex) {
        final ExceptionLoggingFormat format = exceptionLoggingFormat;
        if (format == ExceptionLoggingFormat.NONE) {
            // pass silently when explicitly silenced.
        } else if (format == ExceptionLoggingFormat.SHORT) {
            if (ex != null)
                msg = msg + ", exception: " + ex;
            logger.log(level, msg + ", " + ex, null);
        } else {
            logger.log(level, msg, ex);
        }
    }

    public static void setExceptionLoggingFormat(ExceptionLoggingFormat format) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static ExceptionLoggingFormat initExceptionLoggingFormat() {
        final String fullFormat = "full";
        final String shortFormat = "short";
        final String noneFormat = "none";
        final String format = System.getProperty("cffu.exception.log.format", fullFormat);
        if (noneFormat.equalsIgnoreCase(format)) {
            return ExceptionLoggingFormat.NONE;
        } else if (shortFormat.equalsIgnoreCase(format)) {
            return ExceptionLoggingFormat.SHORT;
        } else {
            return ExceptionLoggingFormat.FULL;
        }
    }

    public enum Level {

        ERROR, WARN
    }

    /**
     * Returns a logger adapter that uses {@code SLF4J} if available, otherwise uses {@link java.util.logging}.
     */
    private static LoggerAdapter getLogger() {
        try {
            return new Slf4jLoggerAdapter();
        } catch (NoClassDefFoundError e) {
            return new JulLoggerAdapter();
        }
    }

    private interface LoggerAdapter {

        void log(Level level, String msg, @Nullable Throwable ex);
    }

    private static final class Slf4jLoggerAdapter implements LoggerAdapter {

        private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CFFU_PACKAGE_NAME);

        @Override
        public void log(Level level, String msg, @Nullable Throwable ex) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class JulLoggerAdapter implements LoggerAdapter {

        private final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CFFU_PACKAGE_NAME);

        @Override
        public void log(Level level, String msg, @Nullable Throwable ex) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private CffuLogger() {
    }
}
