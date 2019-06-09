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
import easymis.utils.DateHelper;
import easymis.utils.ValidationError;
import java.sql.Date;
import java.util.Collections;
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
    
    public List<EventDetails> fetchEventsOnDate(Date eventDate){
        QueryParams param = new QueryParams();
        param.setParamName("eventDate");
        param.setParamDateValue(eventDate);
        return retrieve(QueryConstants.FETCH_EVENTS_FOR_DATE, Collections.singletonList(param), EventDetails.class);
    }

    public EventDetails fetchExistingMehandiEventOnDate(Date eventDate) {
        java.sql.Date nextDate = DateHelper.getNextDay(eventDate);
        QueryParams param = new QueryParams();
        param.setParamName("eventDate");
        param.setParamDateValue(nextDate);
        List<EventDetails> mehandiEvents = retrieve(QueryConstants.FETCH_MEHANDI_EVENT_FOR_DATE, Collections.singletonList(param), EventDetails.class);
        return mehandiEvents != null && !mehandiEvents.isEmpty() ? mehandiEvents.get(0): null;
    }
    
     public EventDetails fetchExistingReceptionEventOnPreviousDate(Date eventDate) {
        java.sql.Date nextDate = DateHelper.getPreviousDay(eventDate);
        QueryParams param = new QueryParams();
        param.setParamName("eventDate");
        param.setParamDateValue(nextDate);
        List<EventDetails> mehandiEvents = retrieve(QueryConstants.FETCH_RECEPTION_EVENT_FOR_DATE, Collections.singletonList(param), EventDetails.class);
        return mehandiEvents != null && !mehandiEvents.isEmpty() ? mehandiEvents.get(0): null;
    }

    public EventDetails fetchByBookingId(String bookingId) {
        QueryParams param = new QueryParams();
        param.setParamName("bookingId");
        param.setParamValue(bookingId);
        List<EventDetails> events =retrieve(QueryConstants.FETCH_EVENT_FOR_BOOKING_ID, Collections.singletonList(param), EventDetails.class);
        return events != null && !events.isEmpty() ? events.get(0) : null;
    }

    public TransactionStatus update(EventDetails eventDetail, boolean isNewBooking) {
        if(isNewBooking){
            EventBookingBusinessPolicy policy = new EventBookingBusinessPolicy();
        List<ValidationError> validationErrors = policy.validateBooking(eventDetail);
        if (validationErrors.isEmpty()) {
            return merge(eventDetail);
        } else {
            TransactionStatus status = new TransactionStatus();
            status.setSuccess(false);
            status.setValidationErrors(validationErrors);
            return status;
        }
        }else{
            return merge(eventDetail);
        }
    }
}
