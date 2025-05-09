import java.util.Date;

public final class Util {

    private Util() {}


    public static String getDateTIme() {
        Date date = new Date();
        return date.toString();
    }
}
