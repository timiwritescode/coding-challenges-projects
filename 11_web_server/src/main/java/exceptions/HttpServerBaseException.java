package exceptions;

public abstract class HttpServerBaseException extends Exception{
    private final int statusCode;
    protected HttpServerBaseException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
