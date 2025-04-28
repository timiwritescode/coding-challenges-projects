package protocol;


/**
 * This class provides checker methods for different sections of http request
 * An HTTP request message is divided into three sections of:
 * Start line, headers and the request body (if any)
 * This server only supports GET requests for retrieval so the
 * only checkers for the start line and headers are provided*/
public class HttpProtocol {
    // Protocol defines the message format of a standard acceptable http request of
    // this server
    //
    //
    public static boolean isStartLineFollowProtocol(String startLine) {
        if (startLine == null) {
            return false;
        }
        String[] startLineParts = startLine.split(" ");
        if (startLineParts.length != 3) {
            return false;
        };

        String method = startLineParts[0];
        String requestTarget = startLineParts[1];
        String httpVersion = startLineParts[2];

        if (!method.matches("^[A-Z]+$")) return false;

        if (!requestTarget.startsWith("/")) return false;

        return httpVersion.equals("HTTP/1.1");
    }

    public static boolean isHeaderFollowProtocol(String headerEntry) {

        if (headerEntry.isEmpty()) return false;


        int colonIndex = headerEntry.indexOf(":");

        if (colonIndex <= 0 ) return false;

        String fieldName = headerEntry.substring(0, colonIndex).trim();
        String fieldValue = headerEntry.substring(colonIndex + 1).trim();

        if (!fieldName.matches("^[!#$%&'*+.^_`|~0-9A-Za-z-]+$")) {
            System.out.println("Does not match");
            return false;
        };

        return !fieldValue.isEmpty();
    }

}
