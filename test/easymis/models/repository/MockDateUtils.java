/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymis.models.repository;

import easymis.utils.IDateUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RashidKP
 */
public class MockDateUtils implements IDateUtils {

    private Properties properties;

    public MockDateUtils() {
        try {
            if(properties == null){
            InputStream propertiesFileStream = new FileInputStream("C:\\Users\\RashidKP\\Documents\\NetBeansProjects\\EasyMIS\\test\\easymis\\models\\repository\\MockDateUtils.properties");
            properties = new Properties();
            properties.load(propertiesFileStream);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EventRepositoryTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EventRepositoryTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Date getToday() {
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            java.util.Date date = sdf.parse(properties.getProperty("currentDate"));
            
            java.sql.Date sqlDate = new Date(date.getTime());
            return sqlDate;
        } catch (ParseException ex) {
            Logger.getLogger(MockDateUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
