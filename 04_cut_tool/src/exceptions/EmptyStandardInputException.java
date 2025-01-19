package exceptions;

public class EmptyStandardInputException extends Exception {
    private String message = "Standard Input is empty";
    public EmptyStandardInputException() {}
    public EmptyStandardInputException(String customMessage) {
        message = customMessage;
    }

    public String getMessage() {
        return message;
    }


}