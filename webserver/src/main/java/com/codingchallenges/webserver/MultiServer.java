package com.codingchallenges.webserver;

import picocli.CommandLine;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


@CommandLine.Command(
        name="http.server",
        mixinStandardHelpOptions = true,
        description = "A simple http file server"
)
public class MultiServer implements Runnable {
    @CommandLine.Option(
            names = {"-P", "--PORT"},
            description = "Port server listens on",
            required = false
    )
    private int port;

//    public MultiServer(int port) {
//        this.port = port;
//    }
//
    public static void main(String[] args) {
        int exitCode = new CommandLine(new MultiServer()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        if (!System.getProperty("user.dir").startsWith("/home")) {
            System.out.println("Cannot start server outside of /home");
            System.exit(1);
        }
        port = port > 1000 ? port : 8080;
        try(
                ServerSocket serverSocket = new ServerSocket(port, 50, InetAddress.getByName("0.0.0.0"));

                ) {
            System.out.println("Server started and accessible via http://localhost:" + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();

                ServerThread newThread = new ServerThread(clientSocket);

                newThread.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }


}
