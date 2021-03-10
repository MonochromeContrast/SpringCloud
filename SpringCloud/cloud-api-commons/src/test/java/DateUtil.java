import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * @author chen
 * @date 2021/3/1 14:35
 */
public class DateUtil {

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * date  to  localdate
     * @param date
     * @return
     */
    public static LocalDate dateToLocalDate(Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }

    /**
     * date to localdatetime
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date){
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return localDateTime;
    }

    /**
     * localdate to date
     * @param localDate
     * @return
     */
    public static Date localDateToDate(LocalDate localDate){
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }

    /**
     * localdatetime to date
     * @param localDateTime
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime){
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }

    /**
     * localdatetime to string
     * @param localDateTime
     * @param dateTimePattern
     * @return
     */
    public static String localDateTimeToString(LocalDateTime localDateTime,String dateTimePattern){
        try {
            DateTimeFormatter format;
            if(dateTimePattern != null && dateTimePattern.trim().length() > 0){
                format = DateTimeFormatter.ofPattern(dateTimePattern);
            } else {
                format = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
            }
            String str = localDateTime.format(format);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * localdate to string
     * @param localDate
     * @param datePattern
     * @return
     */
    public static String localDateToString(LocalDate localDate,String datePattern){
        try {
            DateTimeFormatter format;
            if(datePattern != null && datePattern.trim().length() > 0){
                format = DateTimeFormatter.ofPattern(datePattern);
            } else {
                format = DateTimeFormatter.ofPattern(DATE_PATTERN);
            }
            String str = localDate.format(format);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static LocalDate localDateStrToLocalDate(String localDateStr,String datePattern){
        if(localDateStr == null || localDateStr.trim().length() <= 0)
            return null;
        DateTimeFormatter format;
        if(datePattern != null && datePattern.trim().length() > 0){
            format = DateTimeFormatter.ofPattern(datePattern);
        } else {
            format = DateTimeFormatter.ofPattern(DATE_PATTERN);
        }
        LocalDate localDate = LocalDate.parse(localDateStr, format);
        return localDate;
    }
    public static LocalDateTime localDateTimeStrToLocalDateTime(String localDateTimeStr,String datePattern){
        if(localDateTimeStr == null || localDateTimeStr.trim().length() <= 0)
            return null;

        DateTimeFormatter format;
        if(datePattern != null && datePattern.trim().length() > 0){
            format = DateTimeFormatter.ofPattern(datePattern);
        } else {
            format = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
        }
        LocalDateTime localDateTime = LocalDateTime.parse(localDateTimeStr, format);
        return localDateTime;
    }

    @Test
    public static void main(String[] args) {
        System.out.println("原生date：" + new Date());
        LocalDate localDateNow = LocalDate.now();
        System.out.println("LocalDate：" + localDateNow.toString());
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        System.out.println("LocalDateTime："+ localDateTimeNow);
        System.out.println("======================");
        LocalDateTime localDateTimeOf = LocalDateTime.of(2019, 10, 22, 9, 37, 11);
        System.out.println("指定日期和时间的LocalDateTime：" + localDateTimeOf);
        LocalDate localDateOf = LocalDate.of(2019, 10, 22);
        System.out.println("指定日期的LocalDate："+localDateOf);
        //比较日期相等
        if(localDateNow.equals(localDateOf)){
            System.out.println("日期相等");
        }
        //比较日期和时间相等
        if(localDateTimeNow.equals(localDateTimeOf)){
            System.out.println("日期和时间相等");
        }
        System.out.println("========================");
        System.out.println("dateToLocalDate：" + dateToLocalDate(new Date()));
        System.out.println("dateToLocalDateTime：" + dateToLocalDateTime(new Date()));
        System.out.println("=======================");
        System.out.println("localDateToDate：" + localDateToDate(localDateNow));
        System.out.println("localDateTimeToDate：" + localDateTimeToDate(localDateTimeNow));
        System.out.println("============================");
        System.out.println(localDateTimeToString(localDateTimeNow,"yyyy/MM/dd HH:mm:ss"));
        System.out.println(localDateToString(localDateNow,""));
        System.out.println("===================================");
        System.out.println(localDateStrToLocalDate("2012/11/11","yyyy/MM/dd"));
        System.out.println(localDateTimeStrToLocalDateTime("2012/11/11 12:12:12","yyyy/MM/dd HH:mm:ss"));
    }
}
