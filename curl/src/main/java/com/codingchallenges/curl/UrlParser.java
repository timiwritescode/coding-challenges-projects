package com.codingchallenges.curl;

import com.codingchallenges.curl.exceptions.BaseException;
import com.codingchallenges.curl.exceptions.MalformedURLException;
import com.codingchallenges.curl.exceptions.PortDoesNotExistForProtocol;
import com.codingchallenges.curl.exceptions.ProtocolNotSupportedException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public class UrlParser {
    private static List<String> protocols = List.of("http", "https");
    private static Map<String, Integer> DEFAULT_PORTS = Map.of(
            "http", 80,
            "https", 443
    ) ;

    public static Url parse(String url) throws URISyntaxException, BaseException {
        String host = parseHost(url);
        String protocol = parseProtocol(url);
        int port = parsePort(url, protocol);
        String path = parsePath(url);
        return Url.builder()
                .host(host)
                .port(port)
                .protocol(protocol)
                .path(path)
                .build();
    }

    private static String parseProtocol(String url) throws BaseException {

        if(url.contains(":")) {
            String[] urlSections = url.split(":");
            if (!urlSections[0].matches("^[a-zA-Z]+$")) {
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
            } else {
                if (urlSections.length > 1 ) {
                    if (urlSections[1].matches("^[0-9]$+")) {
                        port = Integer.parseInt(urlSections[1]);
                    } else {
                        port = 443;
                    }
                } else {
                    port = 443;
                }
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

    private static String parseHost(String url) throws BaseException {
        String host = "";

        if (url.matches("^[a-zA-Z]+://.+$")) {

            String[] urlPartitionByColon = url.split((":"));

            url = url.substring(urlPartitionByColon[0].length() + 3);
        }

//      String hostRegex = "^(?:(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}|localhost|(?:\\d{1,3}\\.){3}\\d{1,3}):.+$\n";
        String hostRegex = "^[^:/?#]+(?::\\d+)?(?:/.*)?$";;

        Pattern hostPattern = Pattern.compile(hostRegex);

        // form host:port
        if (hostPattern.matcher(url).matches()) {

            host = url.split(":")[0];
        };


        return host;
    }

    private static String parsePath(String url) {
        StringBuilder path = new StringBuilder("/");
        // check that spring start with protocol e.g http://

        // if it does, remove it
        if (url.matches("^[a-zA-Z]+://.+$")) {

            String[] urlPartitionsByColon = url.split(":");
            int indexFromZeroToTruncate = urlPartitionsByColon[0].length() + 3; // + 1 to account for the trailing '//' and zero indexing

            // truncate
            url = url.substring(indexFromZeroToTruncate);

        }
        // check that string has query parameter
        // if it does, remove it
        if (url.contains("?")) {
            String[] urlPartitionsByQuestionMark = url.split("\\?");

            url = urlPartitionsByQuestionMark[0];
        }

        // remove the host
        String[] urlPartitionByBackwardSlash = url.split("/");
        for (int i = 0; i < urlPartitionByBackwardSlash.length; i++) {
            if (i == 0) {
                continue;
            }
            path.append(urlPartitionByBackwardSlash[i]);
            if (i != urlPartitionByBackwardSlash.length - 1) {
                path.append("/");
            }
        }

        return path.toString();
    }


    private static boolean isValidHostFormat(String host) {
        return !host.matches("^/{2,3}[a-zA-Z]+$") &&
                !host.matches("[^[a-zA-Z0-9][a-zA-Z0-9_-]*$]");
    }

}
