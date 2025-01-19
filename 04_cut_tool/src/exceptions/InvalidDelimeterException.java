package exceptions;

public class InvalidDelimeterException extends Exception {
    private String message = "Invalid delimeter provided";

    public InvalidDelimeterException() {}

    InvalidDelimeterException(String customMessage) {
        message = customMessage;
    }
    public String getMessage() {
        return message;
    }
}