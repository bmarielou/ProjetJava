package exception;

public class DataCorruptedException extends Exception {

    public DataCorruptedException(String message) {
        super(message);
    }

    // Version avec la cause originale (très utile pour déboguer)
    public DataCorruptedException(String message, Throwable cause) {
        super(message, cause);
    }
}