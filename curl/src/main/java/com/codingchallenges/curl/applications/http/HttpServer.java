package com.codingchallenges.curl.applications.http;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

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

    public String sendMessage(String message) {
        StringBuilder appResponse = new StringBuilder();
        try(
            Socket socket = new Socket(host, port);
                ) {


            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            out.write(message.getBytes());
            out.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.ISO_8859_1));
            String line;
            while((line = reader.readLine()) != null) {
                appResponse.append(line).append("\n");
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return appResponse.toString();
    }
}
