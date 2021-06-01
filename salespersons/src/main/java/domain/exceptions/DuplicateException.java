package domain.exceptions;

public class DuplicateException extends Exception {
    public DuplicateException() {
        super("duplicate entity");
    }

    public DuplicateException(String message) {
        super(message);
    }
}
