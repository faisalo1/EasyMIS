/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymis.utils;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author RashidKP
 */
public class DateUtils implements IDateUtils{

    @Override
    public Date getToday() {
        return new java.sql.Date(Calendar.getInstance().getTime().getTime());
    }
    
}
