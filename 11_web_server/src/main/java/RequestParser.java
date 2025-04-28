import protocol.HttpProtocol;
import protocol.exceptions.ProtocolViolatedException;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the parser for all http requests
 * An http request is
 *
 * This parser parses request one line at a time as the
 * request is being streamed from the chain stream or connection stream
 * whichever is used to read the request*/
public class RequestParser {

    String startLine = "";
    Map<String, String> headers = new HashMap<>();

    void parse(String line) throws ProtocolViolatedException {

        // check if line is more than one if it is, don't parse it
        if (startLine.isEmpty()) {
            // then this is the first line of the request
            if (!HttpProtocol.isStartLineFollowProtocol(line)) {
                throw new ProtocolViolatedException("Start line should follow...", 400);
            }
            startLine = line;
        }

        if (!HttpProtocol.isHeaderFollowProtocol(line)) {
            throw new ProtocolViolatedException("Header line should follow....", 400);
        }

        String headerKey = line.split(":")[0];
        String headerValue = line.split(":")[1];

        headers.put(headerKey, headerValue);
    }


    String getStartLine() {
        return startLine;
    };

    Map<String, String> getHeaders() {
        return null;
    }

    int getHeaderCount() {
        return headers.keySet().size();
    }

    String getMethod() {
        return startLine.split(" ")[0];
    }

    String getRoute() {

        return startLine.split(" ")[1];
    }

    String getHttpVersion() {
        return startLine.split(" ")[2];
    }



}
