package protocol;

public class HttpProtocol {
    // Protocol defines the message format of a standard acceptable http request of
    // this server
    //
    //
    public static boolean isStartLineFollowProtocol(String startLine) {
        return false;
    }

    public static boolean isHeaderFollowProtocol(String headerEntry) {

        return false;
    }

}
