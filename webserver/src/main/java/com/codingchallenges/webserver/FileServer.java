package com.codingchallenges.webserver;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;

public class FileServer {

    void serveFile(File file, Socket client, PrintWriter out) {
       try(
               BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(client.getOutputStream());
               FileInputStream fis = new FileInputStream(file);
               BufferedInputStream bis = new BufferedInputStream(fis);

       ) {
           String contentType = Files.probeContentType(file.toPath());
           contentType = "application/octet-stream";
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
           throw new RuntimeException(e);
       }
    }
}
