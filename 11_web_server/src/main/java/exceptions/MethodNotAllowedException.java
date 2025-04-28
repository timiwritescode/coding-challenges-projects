package exceptions;

public class MethodNotAllowedException extends HttpServerBaseException {
    public MethodNotAllowedException() {
        super("Method not allowed", 405);

    }
}
