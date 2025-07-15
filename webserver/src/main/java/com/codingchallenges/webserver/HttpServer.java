package com.codingchallenges.webserver;

import com.codingchallenges.webserver.exceptions.HttpServerBaseException;
import com.codingchallenges.webserver.templates.HomePage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;

public class HttpServer {
    public static void main(String[] args) {
        new HttpServer().go();
    }

    public void go() {
        // a socket that accepts connection one at a time
        int port = 5000;
        try(
                ServerSocket serverSocket = new ServerSocket(port);
                Socket clientSocket = serverSocket.accept();
                InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader reader = new BufferedReader(in);
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(clientSocket.getOutputStream());
                ) {
            StringBuilder reqBuilder = new StringBuilder();

            String responseBody = "Nice to meet you";
            String responseHeader = "HTTP/1.1 200 OK\r\n" +
                                    "Content-Type: text/html\r\n"+
                                    "Content-Length: " + responseBody.length() + "\r\n" +
                                    "Connection: keep-alive\r\n" +
                                    "\r\n";
            while(true) {
                String reqLine;
                try{
                    while((reqLine = reader.readLine()) != null && !reqLine.isEmpty()) {
                        reqBuilder.append(reqLine).append("\n");
                    }
                    if (reqLine == null) {
                        break;
                    }

                    String fullReq = reqBuilder.toString();
                    System.out.println("Received request: \n" + fullReq);


                    out.print(responseHeader);
                    out.print(responseBody);
                    out.flush();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
