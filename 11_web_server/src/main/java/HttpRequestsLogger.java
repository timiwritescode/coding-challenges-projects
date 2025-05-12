/**
 * This class provides the logger utilities to log HTTP requests and
 * Http responses for the HTTP Server
 */
public class HttpRequestsLogger {

    public static void info(String method, String route, int statusCode, String userAgent) {
        String time = Util.getDateTIme();

        System.out.println(time + " " + userAgent + " " +  method + " " + route + " " + statusCode);

    }

}
