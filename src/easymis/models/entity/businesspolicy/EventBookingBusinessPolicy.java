package easymis.models.entity.businesspolicy;

import easymis.models.entity.EventDetails;
import easymis.models.entity.enumeration.EventType;
import easymis.models.repository.EventRepository;
import easymis.utils.DateHelper;
import easymis.utils.ValidationError;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author RashidKP
 */
public class EventBookingBusinessPolicy {

    List<ValidationError> validationErrors = new ArrayList<>();

    public List<ValidationError> validateBooking(EventDetails eventDetails) {

        validateIfEventDateIsInPast(eventDetails.getEventDate());
        validateDateAvailability(eventDetails);

        return validationErrors;
    }

    private void validateIfEventDateIsInPast(Date eventDate) {
        Date today = DateHelper.getToday();
        if (!eventDate.after(today)) {
            validationErrors.add(new ValidationError("501", "Event Date should be after today"));
        }
    }

    private void validateDateAvailability(EventDetails eventDetails) {
        List<EventDetails> existingEvents = EventRepository.getUniqueInstance().fetchByEventDate(eventDetails.getEventDate());
        List<EventType> eventTypesOnCurrentBooking = populateEventListExceptMehandi(Collections.singletonList(eventDetails));
        if (existingEvents != null && !existingEvents.isEmpty()) {
            List<EventType> existingEventTypes = populateEventListExceptMehandi(existingEvents);
            List<EventType> common = new ArrayList<>(existingEventTypes);
            common.retainAll(eventTypesOnCurrentBooking);
            if (!common.isEmpty()) {
                common.forEach(e -> validationErrors.add(new ValidationError("502", "Following event already exists on the date: " + e)));
            }
        }

        if (eventDetails.isMehandiSelected()) {
            validateMehandiBooking(eventDetails.getEventDate());
        }

        if (eventDetails.isReceptionSelected()) {
            validateReceptionBooking(eventDetails.getEventDate());
        }

    }

    private List<EventType> populateEventListExceptMehandi(List<EventDetails> events) {
        List<EventType> eventTypes = new ArrayList<>();
        for (EventDetails event : events) {
            if (event.isWeddingSelected()) {
                eventTypes.add(EventType.WEDDING);
            }
            if (event.isIshaSelected()) {
                eventTypes.add(EventType.ISHA_HALL_AC);
            }
            if (event.isNicaSelected()) {
                eventTypes.add(EventType.NICA_LONGUE_AC);
            }
            if (event.isReceptionSelected()) {
                eventTypes.add(EventType.RECEPTION);
            }
        }
        return eventTypes;
    }

    private void validateReceptionBooking(Date eventDate) {
        EventDetails existingMehandiEvent = EventRepository.getUniqueInstance().
                fetchExistingMehandiEventOnDate(eventDate);
        if (existingMehandiEvent != null) {
            validationErrors.add(new ValidationError("502", "Mehandi Already exists on the date"));
        }
    }

    private void validateMehandiBooking(Date eventDate) {
        EventDetails existingReceptionEvent = EventRepository.getUniqueInstance().
                fetchExistingReceptionEventOnPreviousDate(eventDate);
        if (existingReceptionEvent != null) {
            validationErrors.add(new ValidationError("502", "Reception already exists on Mehandi date"));
        }
    }
}
