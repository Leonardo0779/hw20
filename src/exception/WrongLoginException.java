package exception;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException() {
        super("Wrong login");
    }
}
