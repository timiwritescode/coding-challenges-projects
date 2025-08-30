package com.codingchallenges.curl;

/**
 * This class defines the URL
 */

public record Url (
        String protocol,
        int port
) {
    public static class Builder {
        private String protocol;
        private int port;

        public Builder protocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Url build() {
            return new Url(protocol, port);
        }

        }
    public static Builder builder() {
        return new Builder();
    }

    public String getProtocol() {
        return protocol;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return protocol + port;
    }
}

