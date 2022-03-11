package util;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class utils {
    public static Time dateStringToTime(String dateString){
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
            return new Time(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String readStringFromMap(Map m, String key){
        if(m.getOrDefault(key, "") == null || m.getOrDefault(key, "").toString().isEmpty()){
            return "";
        }
        return m.getOrDefault(key, "").toString();
    }
}
