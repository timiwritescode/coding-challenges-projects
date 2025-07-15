package com.codingchallenges.cuttool.exceptions;

public class ColumnNotFoundException extends IndexOutOfBoundsException {
    private String message  = "One or more column inputed does not exist";

    public ColumnNotFoundException() {}

    ColumnNotFoundException(String customMessage) {
        message = customMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }
}