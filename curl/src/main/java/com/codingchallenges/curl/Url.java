package com.codingchallenges.curl;

/**
 * This class defines the URL
 */

public record Url (
        String host,
        String protocol,
        int port,
        String path
) {
    public static class Builder {
        private String protocol;
        private int port;
        private String host;
        private String path = "";


        public Builder protocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder path(String paths) {
            this.path = paths;
            return this;
        }

        public Url build() {
            return new Url(host, protocol, port, path);
        }

        }
    public static Builder builder() {
        return new Builder();
    }

    public String getPath() {
        return path;
    }
    public String getProtocol() {
        return protocol;
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    @Override
    public String toString() {
        if (!protocol.isEmpty()) {
            return protocol + "://" + host + ":" + port + path;
        }
        return protocol + port + path;
    }
}

