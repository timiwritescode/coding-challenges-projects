package com.codingchallenges.webserver;

import com.codingchallenges.webserver.exceptions.HttpServerBaseException;
import com.codingchallenges.webserver.templates.*;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Set;


public class ServerThread extends Thread {
    Socket client;

    ServerThread(Socket client) {
        this.client = client;
    }


    public void run() {

        try(
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                InputStreamReader in = new InputStreamReader(client.getInputStream());
                BufferedReader reader =  new BufferedReader(in);

                ) {
                String currentLine;
                StringBuilder stringBuilder =  new StringBuilder();

                while((currentLine = reader.readLine()) != null) {
                    stringBuilder.append(currentLine).append("\n");
                    if (currentLine.isEmpty()) break;
                }
                String requestMessage =  stringBuilder.toString();

                Response response;
            RequestParser reqParser = new RequestParser();
                try{
                    reqParser.parseRequestMessage(requestMessage);

                    String rootDir = System.getProperty("user.dir");

                    String currentDir = rootDir + reqParser.getRoute();


                    // check if current directory is a file
                    Path path = Path.of(currentDir);
                    if (Files.exists(path) & !Files.isDirectory(path)) {
                        File file = new File(path.toString());
                        serveFile(file, client, out);
                        client.close();

                    } else {
                        Set<String> dirListing = FileServiceUtil.listDir(currentDir);

                        response = new Response(out, StatusCodes.OK);
                        response.setHeader("Content-Type", "text/html");
                        response
                                .body(new HomePage().constructPage(currentDir, dirListing, rootDir )
                                        .renderTemplate())
                                .send();
                    }

                    HttpRequestsLogger.info(reqParser.getMethod(), reqParser.getRoute(), 200, reqParser.getUserAgent());
                } catch (HttpServerBaseException e) {
                    response = new Response(out, StatusCodes.BAD_REQUEST);
                    response.body(new BadRequestTemplate().constructMessage().renderTemplate()).send();
                    HttpRequestsLogger.info(reqParser.getMethod(), reqParser.getRoute(), StatusCodes.BAD_REQUEST.getStatusCode(), reqParser.getUserAgent());
                } catch (NoSuchFileException e) {
                    response = new Response(out, StatusCodes.NOT_FOUND);
                    response.body(new NotFound().constructMessage().renderTemplate()).send();
                    HttpRequestsLogger.info(reqParser.getMethod(), reqParser.getRoute(), StatusCodes.NOT_FOUND.getStatusCode(), reqParser.getUserAgent());
                } catch (Exception e) {
                    response = new Response(out, StatusCodes.SERVER_ERROR);
                    response.body(new ServerError().constructMessage().renderTemplate()).send();
                    HttpRequestsLogger.info(reqParser.getMethod(), reqParser.getRoute(), StatusCodes.SERVER_ERROR.getStatusCode(), reqParser.getUserAgent());
                    throw e;
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void serveFile(File file, Socket client, PrintWriter out) throws IOException {
        try(
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(client.getOutputStream());
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);

        ) {

            String contentType = "application/octet-stream";
            String header = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: " + contentType + "\r\n" +
                    "Content-Length: " + file.length() + "\r\n\r";
            out.println(header);
            byte[] buffer = new byte[8192];

            int count;
            while((count = bis.read(buffer)) > 0) {

                bufferedOutputStream.write(buffer, 0, count);
                bufferedOutputStream.flush();
            }

        } catch (IOException e) {
            throw e;
        }
    }
}
