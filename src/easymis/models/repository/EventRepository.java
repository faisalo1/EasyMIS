/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymis.models.repository;

import easymis.models.entity.EventDetails;
import easymis.models.entity.TransactionStatus;
import easymis.models.entity.businesspolicy.EventBookingBusinessPolicy;
import easymis.models.entity.utils.QueryConstants;
import easymis.utils.ValidationError;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author RashidKP
 *
 */
public class EventRepository extends AbstractRepository {

    private static EventRepository uniqueInstance = new EventRepository();

    private EventRepository() {
    }

    public static EventRepository getUniqueInstance() {
        return uniqueInstance;
    }

    public TransactionStatus create(EventDetails eventDetails) {
        EventBookingBusinessPolicy policy = new EventBookingBusinessPolicy();
        List<ValidationError> validationErrors = policy.validateBooking(eventDetails);
        if (validationErrors.isEmpty()) {
            return persist(eventDetails);
        } else {
            TransactionStatus status = new TransactionStatus();
            status.setSuccess(false);
            status.setValidationErrors(validationErrors);
            return status;
        }
    }

    public List<EventDetails> fetchAllEvents() {
        return retrieve(QueryConstants.FETCH_ALL_EVENTS, null, EventDetails.class);
    }
    
    public List<EventDetails> fetchAllUpcomingEventsOnDate(Date eventDate){
        return retrieve(QueryConstants.FETCH_ALL_EVENTS, null, EventDetails.class);
    }
}
