package com.codingchallenges.curl.applications.http;

public record HttpServerResponse(String responseHeaders, String responseBody) {

    public String getFullMessage() {
        return responseHeaders + "\n" + responseBody;
    }
}