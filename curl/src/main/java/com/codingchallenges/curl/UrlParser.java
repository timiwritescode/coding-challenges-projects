package com.codingchallenges.curl;

import com.codingchallenges.curl.exceptions.BaseException;
import com.codingchallenges.curl.exceptions.MalformedURLException;
import com.codingchallenges.curl.exceptions.PortDoesNotExistForProtocol;
import com.codingchallenges.curl.exceptions.ProtocolNotSupportedException;

import java.util.List;

public class UrlParser {
    private static List<String> protocols = List.of("http", "https");
    private static String urlRegex = "^[a-zA-Z0-9_-]+://[a-zA-Z0-9_-]+:[0-9]+/[a-zA-Z0-9_-]+$";

    public static Url parse(String url) throws BaseException {
        // parse url
        String protocol = parseProtocol(url);
        int port = parsePort(url, protocol);
        // build a new Url from it

        return Url.builder()
                .port(port)
                .protocol(protocol)
                .build();
    }

    private static String parseProtocol(String url) throws BaseException {
        if(url.contains(":")) {
            String[] urlSections = url.split(":");
            if (!urlSections[1].startsWith("//")) {
                throw new MalformedURLException();
            }
            if (!protocols.contains(urlSections[0])) {
                throw new ProtocolNotSupportedException(urlSections[0]);
            }
            return urlSections[0];
        }

        return "https";
    }

    private static Integer parsePort(String url, String protocol) throws BaseException{
        int port = 0;
        if (url.contains(":")) {
            String[] urlSections = url.split(":");
            if (urlSections.length > 2) {
                String[] portSection = urlSections[2].split("/");
                if (!portSection[0].matches("^[0-9]+$")) {
                    // check if the port number is for
                    throw new MalformedURLException();
                }
                port = Integer.parseInt(portSection[0]);
            }
        } else {
            if (protocol.equals("https")) {
                port = 443;
            } else if(protocol.equals("http")) {
                port = 80;
            } else {
                throw new PortDoesNotExistForProtocol(protocol);
            }
        }

        return port;
    }
}
