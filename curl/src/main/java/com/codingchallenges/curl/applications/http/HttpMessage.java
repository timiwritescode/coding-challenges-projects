package com.codingchallenges.curl.applications.http;

import java.util.HashMap;
import java.util.Map;

public class HttpMessage {
    private String httpVersion;
    private String host;
    private String method;
    private  String path;
    private Map<String, String> headers;

    private HttpMessage(String httpVersion,
                String host,
                String method,
                String path,
                Map<String, String> headers) {
        this.httpVersion = httpVersion;
        this.host = host;
        this.method = method;
        this.path = path;
        this.headers = headers;
    }

    public static class Builder {
        private String httpVersion = "1.1";
        private String host;
        private String method = "GET";
        private String path = "/";
        private String body = "";
        private final Map<String, String>  headers = new HashMap<>();

        public Builder setMethod(String method) {
            this.method = method;
            return this;
        }

        public Builder setVersion(String version) {
            this.httpVersion = version;
            return this;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder setHeader(String key, String value) {
            headers.put(key, value);
            return this;
        }

        public Builder setHost(String host) {
            this.host = host;
            return this;
        }

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        public HttpMessage build() {
            return new HttpMessage(httpVersion, host, method, path, headers);
        }

    }

    public static Builder builder() {
        return new Builder();
    }
    private String stringifyHeaders() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : headers.keySet()) {
            stringBuilder
                    .append(key).append(": ")
                    .append(headers.get(key))
                    .append("\r\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        if (host.isEmpty()) {
            throw new RuntimeException("Host cannot be empty");
        }
        return method + " " + path + " " + "HTTP/" + httpVersion + "\r\n" +
                        stringifyHeaders() +
                        "\r\n";
    }
}
