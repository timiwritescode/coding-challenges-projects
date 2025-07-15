package com.codingchallenges.webserver;

public enum StatusCodes {
    OK(200, "ok"),
    NOT_FOUND(404, "not found"),
    BAD_REQUEST(400, "bad request"),
    SERVER_ERROR(500, "server error");

    private final int code;
    private final String description;

    StatusCodes(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getStatusCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}