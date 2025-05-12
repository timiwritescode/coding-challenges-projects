import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * This class constructs the appropriate response to an HTTP request
 * It constructs the response message which includes three sections of
 * Startline, headers and body of an HTTP response while adhering to the HTTP protocol.
 * It provides methods for setting headers and also setting the status code of a request
 */
public class Response {
    Map<String, String> requestHeaders = new HashMap<>();
    private int status;
    private String statusMessage;
    private final PrintWriter clientPrintWriter;
    private String responseBody = "";

    public Response(PrintWriter clientPrintWriter,
                    StatusCodes statusCode) {
        // set the default headers
        this.clientPrintWriter = clientPrintWriter;
        status = statusCode.getStatusCode();
        this.statusMessage = statusCode.getDescription();
        setDefaultHeaders(requestHeaders);
    }

    void setHeader(String key, String value) {

    }
    Response status(StatusCodes statusCode) {
        status = statusCode.getStatusCode();
        statusMessage = statusCode.getDescription();
        return this;
    }

    Response body(String body) {
        responseBody = body;
        return this;
    }

    void send() {
        // sends the message
        // check if status has beem set
        // should be even initialized
        String responseMessage = constructResponseMessage() + responseBody;

        clientPrintWriter.println(responseMessage);

    }


    private String constructResponseMessage() {

        String startLine = constructStartLine();
        String headers =  constructHeaders();
        // add response body later
        // head line
        return startLine + headers;
    }
    private String constructStartLine() {
        return Constants.HTTP_V11 + " " +
                status + " " +
                statusMessage +
                "\n";

    }

    private String constructHeaders() {
        StringBuilder headersMessage = new StringBuilder();

        requestHeaders.forEach((k, v) -> {
            String header = k + ": " + v + "\n";
            headersMessage.append(header);
        });

        headersMessage.append("\n"); // a trailing new line to separate header and body section
        return headersMessage.toString();
    }

    static void setDefaultHeaders(Map<String, String> headerMap) {

        headerMap.put("Server", "SimpleHTTP/ JAVA");
        headerMap.put("Date", Util.getDateTIme());
        headerMap.put("Content-Type", "text/html");
        headerMap.put("Cache-Control", "no-store");
    }
}
