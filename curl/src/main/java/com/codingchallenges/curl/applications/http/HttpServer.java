package com.codingchallenges.curl.applications.http;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpServer {
    private final String host;
    private int port = 80;

    public HttpServer(String host) {
        this.host = host;
    }

    public HttpServer(String host, int port) {
        this.host = host;
        this.port = port;
    }


    public HttpServerResponse sendMessage(String message) {
        StringBuilder headerBuilder = new StringBuilder();
        StringBuilder responseBodyBuilder = new StringBuilder();
        try(
            Socket socket = new Socket(host, port);
                ) {


            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            out.write(message.getBytes());
            out.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.ISO_8859_1));
            String line;
            boolean isCurrentlyReadingHeader = true;
            while((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    isCurrentlyReadingHeader = false;
                    headerBuilder.append("\n");
                    continue;
                }
                if (isCurrentlyReadingHeader) {
                    headerBuilder.append(line).append("\n");
                } else {
                    responseBodyBuilder.append(line).append("\n");
                }
                ;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new HttpServerResponse(headerBuilder.toString(), responseBodyBuilder.toString());
    }
}
