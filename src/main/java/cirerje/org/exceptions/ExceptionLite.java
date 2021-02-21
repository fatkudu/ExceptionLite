package cirerje.org.exceptions;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ExceptionLite {

    private static final Logger log = LogManager.getLogger(ExceptionLite.class);
    private final Throwable throwable;
    public ExceptionLite(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{").append(throwable.toString()).append("}");
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        if (stackTrace != null) {
            builder.append("->").append(stackTrace[0]);
        }
        return builder.toString();
    }

    public static void main( String[] args ) {
        log.info("Library for providing a string representation of an Exception");
        Throwable throwMe = new Throwable("Hello there");
        log.info("For example {}", new ExceptionLite(throwMe), throwMe);
    }
}
