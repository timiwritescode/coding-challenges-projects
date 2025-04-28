package protocol.exceptions;

import exceptions.BaseException;

public class ProtocolViolatedException extends BaseException {
    int statusCode;
    public ProtocolViolatedException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }


}
