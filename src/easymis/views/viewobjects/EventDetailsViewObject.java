package easymis.views.viewobjects;

import easymis.models.entity.enumeration.BookingStatus;
import easymis.models.entity.enumeration.BookingType;
import easymis.models.entity.enumeration.EventCategory;
import java.sql.Date;

/**
 *
 * @author RashidKP
 */
public class EventDetailsViewObject {
    
    private Date eventDate;
    
    private String fullName;
    
    private BookingStatus bookingStatus;
    
    private String eventType;
    
    private BookingType bookingType;
    
    private Date bookingDate;
    
    private EventCategory eventCategory;

    public EventDetailsViewObject(Date eventDate, String fullName, BookingStatus bookingStatus, String eventType, BookingType bookingType, Date bookingDate, EventCategory eventCategory) {
        this.eventDate = eventDate;
        this.fullName = fullName;
        this.bookingStatus = bookingStatus;
        this.eventType = eventType;
        this.bookingType = bookingType;
        this.bookingDate = bookingDate;
        this.eventCategory = eventCategory;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public String getFullName() {
        return fullName;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public String getEventType() {
        return eventType;
    }

    public BookingType getBookingType() {
        return bookingType;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }
    
    
}
