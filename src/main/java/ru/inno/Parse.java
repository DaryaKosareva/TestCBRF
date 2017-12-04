package ru.inno;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parse {
    private static Logger logger = Logger.getLogger(Parse.class);
    public static long stringParseInMilliseconds(String dateString, String pattern) {
        long milliseconds;
        Date date = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
        milliseconds = date.getTime();
        return milliseconds;
    }
}
