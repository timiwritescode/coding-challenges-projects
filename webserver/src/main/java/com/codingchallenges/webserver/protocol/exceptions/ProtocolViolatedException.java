package com.codingchallenges.webserver.protocol.exceptions;

import com.codingchallenges.webserver.exceptions.HttpServerBaseException;

public class ProtocolViolatedException extends HttpServerBaseException {

    public ProtocolViolatedException(String message) {
        super(message, 400);

    }

}
