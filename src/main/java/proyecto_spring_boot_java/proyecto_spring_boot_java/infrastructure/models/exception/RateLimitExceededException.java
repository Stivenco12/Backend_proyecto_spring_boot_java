package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.models.exception;

public class RateLimitExceededException extends RuntimeException {
    public RateLimitExceededException() {
        super("Too many requests - rate limit exceeded");
    }

    public RateLimitExceededException(String message) {
        super(message);
    }

    public RateLimitExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}