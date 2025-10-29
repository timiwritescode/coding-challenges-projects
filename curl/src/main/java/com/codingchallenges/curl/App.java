package com.codingchallenges.curl;


import com.codingchallenges.curl.applications.http.HttpMessage;
import com.codingchallenges.curl.applications.http.HttpServer;
import com.codingchallenges.curl.applications.http.HttpServerResponse;
import com.codingchallenges.curl.exceptions.BaseException;
import picocli.CommandLine;

import java.net.URISyntaxException;
import java.util.List;

@CommandLine.Command(
        name="cc_curl",
        mixinStandardHelpOptions = true,
        description = "Curl tool"
)
public class App implements Runnable{
    @CommandLine.Parameters(index = "0", description = "File to cut", arity = "1")
    private String inputUrl;

    @CommandLine.Option(names = "-i", description = "verbose to print it out request and response")
    private boolean verboseOption;

    @CommandLine.Option(names = "-H", description = "add headers")
    private List<String> headers;

    @CommandLine.Option(names = "-d", description = "The request body")
    private String requestBody;

    @CommandLine.Option(names = "-X", description = "Set method", defaultValue = "GET")
    private String method;

    public static void main(String[] args) throws BaseException {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);

    }

    @Override
    public void run() {
        try {

            Url url = UrlParser.parse(inputUrl);

            // if body use post by default except explicitly stated
            if (!requestBody.isEmpty() && method.isEmpty()) {
                method = "POST";
            }

            HttpMessage message = HttpMessage.builder()
                    .setHost(url.getHost())
                    .setPath(url.getPath())
                    .setMethod(method)
                    .setHeader("Accept", "*/*")
                    .setHeader("Host", url.getHost())
                    .setHeader("Connection", "close")
                    .build();

            if (!headers.isEmpty()) {
                for (String header: headers) {
                    String[] keyValuePair = header.split(":");
                    if (keyValuePair.length != 2) {
                        throw new RuntimeException("Invalid header format");
                    }
                    message.setHeaders(keyValuePair[0], keyValuePair[1]);
                }
            }

            if (!requestBody.isEmpty()) {
                message.setBody(requestBody);
            }

            HttpServer server = new HttpServer(url.getHost(), 80);
            HttpServerResponse response = server.sendMessage(message.toString());

            StringBuilder consoleResponseBuilder = new StringBuilder();
            if (verboseOption) {
                String[] messageLines = message.toString().split("\n");
                for (String line : messageLines) {
                    consoleResponseBuilder.append("> ").append(line).append("\n");
                }
                consoleResponseBuilder.append("> ").append("\n");
                String[] headerLines = response.responseHeaders().split("\n");
                for (String line : headerLines) {
                    consoleResponseBuilder.append("< ").append(line).append("\n");
                }
                consoleResponseBuilder.append("< ").append("\n").append("\n");

            }

            consoleResponseBuilder.append(response.responseBody());


            System.out.println(consoleResponseBuilder.toString());
        } catch (URISyntaxException | BaseException e) {
            throw new RuntimeException(e);
        }
    }


}
