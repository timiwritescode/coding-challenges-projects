class InvalidDelimeterException extends Exception {
    private String message = "Invalid delimeter provided";

    InvalidDelimeterException() {}

    InvalidDelimeterException(String customMessage) {
        message = customMessage;
    }
    public String getMessage() {
        return message;
    }
}