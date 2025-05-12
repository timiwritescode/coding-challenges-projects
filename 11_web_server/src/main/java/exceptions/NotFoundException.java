package exceptions;

public class NotFoundException extends HttpServerBaseException{
    public NotFoundException(String message) {
        super(message, 404);
    }
}
