package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateHandler {

    public static String getCurrentDateTime() {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
        Date date = new Date();
        return formatter.format(date);
    }

}
