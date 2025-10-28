package com.codingchallenges.curl;


import com.codingchallenges.curl.applications.http.HttpMessage;
import com.codingchallenges.curl.applications.http.HttpServer;
import com.codingchallenges.curl.exceptions.BaseException;

import java.net.URISyntaxException;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {
    private static final Logger logger = Logger.getLogger("curl");
    public static void main(String[] args) throws BaseException {
        try {
            Url url = UrlParser.parse("http://eu.httpbin.org:80/get");

            HttpMessage message = HttpMessage.builder()
                    .setHost(url.getHost())
                    .setPath(url.getPath())
                    .setHeader("Host", url.getHost())
                    .setHeader("Connection", "close")
                    .build();


            HttpServer server = new HttpServer(url.getHost(), 80);
            System.out.println(server.sendMessage(message.toString()));

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
}
