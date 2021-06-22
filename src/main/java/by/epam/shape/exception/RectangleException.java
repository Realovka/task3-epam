package by.epam.shape.exception;

public class RectangleException extends Exception{

    public RectangleException() {
    }

    public RectangleException(String message) {
        super(message);
    }

    public RectangleException(String message, Throwable cause) {
        super(message, cause);
    }

    public RectangleException(Throwable cause) {
        super(cause);
    }
}
