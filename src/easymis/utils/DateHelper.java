package easymis.utils;

import java.sql.Date;

/**
 *
 * @author RashidKP
 */
public class DateHelper {
    private static IDateUtils dateUtils = new DateUtils();
    
    private DateHelper(){
        
    }
    
    public static void load(IDateUtils adateUtils){
       dateUtils = adateUtils;
    }
    
    public static Date getToday(){
        return dateUtils.getToday();
    }
    public static Date getNextDay(Date currentDate){
        return new java.sql.Date(currentDate.getTime() + 24*60*60*1000);
    }
    }
