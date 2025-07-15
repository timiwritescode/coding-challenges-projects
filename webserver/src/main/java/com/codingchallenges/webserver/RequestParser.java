package com.codingchallenges.webserver;

import com.codingchallenges.webserver.exceptions.MethodNotAllowedException;
import com.codingchallenges.webserver.protocol.HttpProtocol;
import com.codingchallenges.webserver.protocol.exceptions.ProtocolViolatedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the parser for all http requests
 * An http request is
 *
 * This parser parses request one line at a time as the
 * request is being streamed from the chain stream or connection stream
 * whichever is used to read the request*/
public class RequestParser {

    private String startLine = "";
    private Map<String, String> headers = new HashMap<>();
    private int blankLineCount = 0;


    public void parseRequestMessage(String requestMessage) throws ProtocolViolatedException, MethodNotAllowedException {
        String[] reqMessageLines = requestMessage.split("\n");
        for (String line: reqMessageLines) {
            parseLine(line);
        }
    }

    void parseLine(String line) throws ProtocolViolatedException, MethodNotAllowedException {

        if (line.isBlank() || line.isEmpty()) {

            if (blankLineCount > 1) {
                throw new ProtocolViolatedException("Broken request message");
            }
            blankLineCount += 1;


        } else if (startLine.isEmpty()) {

            parseStartLine(line);

        } else {
            parseHeaderLine(line);
        }


    }

    private void parseStartLine(String startLine) throws ProtocolViolatedException, MethodNotAllowedException {
        if (!HttpProtocol.isStartLineFollowProtocol(startLine)) {
            throw new ProtocolViolatedException("Broken request message");
        }
        this.startLine = startLine;
        // check method
        String method = getMethod();
        if (!List.of(Constants.ALLOWED_METHODS).contains(method)) {
            throw new MethodNotAllowedException();
        };

    }

    private void parseHeaderLine(String line) throws ProtocolViolatedException {
        if (!HttpProtocol.isHeaderFollowProtocol(line)) {
            throw new ProtocolViolatedException("Broken Request headers");
        }

        String headerKey = line.split(":")[0];
        String headerValue = line.split(":")[1];

        headers.put(headerKey, headerValue);
    }

    String getStartLine() {
        return startLine;
    };

    Map<String, String> getHeaders() {
        return headers;
    }

    int getHeaderCount() {
        return headers.keySet().size();
    }

    String getMethod() {
        return startLine.split(" ")[0].strip();
    }

    String getRoute() {

        return startLine.split(" ")[1];
    }


    String getUserAgent() {
        return headers.get("User-Agent");
    }

    String getHttpVersion() {
        return startLine.split(" ")[2];
    }



}
