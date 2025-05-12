import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
    private final int port;

    public MultiServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        new MultiServer(5000).go();
    }
    void go() {
        try(
                ServerSocket serverSocket = new ServerSocket(port, 50, InetAddress.getByName("0.0.0.0"));

                ) {
            while (true) {
                Socket clientSocket = serverSocket.accept();

                ServerThread newThread = new ServerThread(clientSocket);

                newThread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
