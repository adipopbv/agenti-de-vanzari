package domain.exceptions;

public class NotFoundException extends Exception {
    public NotFoundException() {
        super("entity not found");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
