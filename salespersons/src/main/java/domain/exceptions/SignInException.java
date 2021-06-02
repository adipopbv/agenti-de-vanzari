package domain.exceptions;

public class SignInException extends Exception {
    public SignInException() {
        super("error signing in");
    }

    public SignInException(String message) {
        super(message);
    }
}
