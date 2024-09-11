/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtentionLibrary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author Admin
 */
public class XDate {
    static SimpleDateFormat formater = new SimpleDateFormat();
    
    public static Date toDate(String date, String pattern)
    {
        try {
            formater.applyPattern(pattern);
            return formater.parse(date);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    
    public static String toString(Date date, String pattern)
    {
        formater.applyPattern(pattern);
        return formater.format(date);
    }
    
    public static Date addDays(Date date, long days)
    {
        date.setTime(date.getTime() + days*24*60*60*1000);
        return date;
    }
}
