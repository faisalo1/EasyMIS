package easymis.models.entity.utils;


/**
 *
 * @author RashidKP
 */
public class QueryConstants {
    public static final String FETCH_ALL_EVENTS = "SELECT e FROM EventDetails e"; 
    
    public static final String FETCH_EVENTS_FOR_DATE = "SELECT e from EventDetails e "
            + "where e.eventDate = :eventDate and e.bookingStatus = "
            + "easymis.models.entity.enumeration.BookingStatus.BOOKED";
    
    public static final String FETCH_MEHANDI_EVENT_FOR_DATE = "SELECT e from EventDetails e "
            + "where e.eventDate = :eventDate and e.mehandiSelected = true "
            + "and e.bookingStatus = "
            + "easymis.models.entity.enumeration.BookingStatus.BOOKED";
    
    public static final String FETCH_RECEPTION_EVENT_FOR_DATE = "SELECT e from EventDetails e "
            + "where e.eventDate = :eventDate and e.receptionSelected = true "
            + "and e.bookingStatus = "
            + "easymis.models.entity.enumeration.BookingStatus.BOOKED";
    
    public static final String FETCH_EVENT_FOR_BOOKING_ID = "SELECT e from EventDetails e "
            + "where e.bookingId = :bookingId";
}
