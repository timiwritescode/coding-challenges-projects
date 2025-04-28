package protocol.exceptions;

import exceptions.HttpServerBaseException;

public class ProtocolViolatedException extends HttpServerBaseException {

    public ProtocolViolatedException(String message) {
        super(message, 400);

    }

}
