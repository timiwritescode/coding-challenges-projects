package com.codingchallenges.curl.exceptions;

public class ProtocolNotSupportedException extends BaseException{
    public ProtocolNotSupportedException(String protocol) {
        super("Protocol \"" + protocol + "\" not supported");

    }
}
