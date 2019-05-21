package easymis.models.entity.businesspolicy;

import easymis.models.entity.EventDetails;
import easymis.utils.ValidationError;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author RashidKP
 */
public class EventBookingBusinessPolicy {
    
    List<ValidationError> validationErrors = new ArrayList<ValidationError>();
    
    public List<ValidationError> validateBooking(EventDetails eventDetails){
        
        validateEventDate(eventDetails.getEventDate());
        return validationErrors;
    }

    private void validateEventDate(Date eventDate) {
        Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        if(eventDate.before(today) || eventDate.equals(today)){
            validationErrors.add(new ValidationError("501", "Event Date should be after today"));
        }
    }
}
