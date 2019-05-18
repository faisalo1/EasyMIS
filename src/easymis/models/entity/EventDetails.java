package easymis.models.entity;

import easymis.models.entity.enumeration.BookingType;
import easymis.models.entity.enumeration.EventCategory;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.ConversionValue;
import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.ObjectTypeConverter;

/**
 *
 * @author RashidKP
 */
@Entity
@Table(name = "EMIS_EVENT_MASTER_B")
public class EventDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EVENT_ID")
    private String eventId;
    
    @Column(name = "EVENT_DATE")
    private Date eventDate;
    
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @Column(name = "ADDRESS_LINE_1")
    private String addressLine1;
    
    @Column(name = "ADDRESS_LINE_2")
    private String addressLine2;
    
    @Column(name = "ADDRESS_LINE_3")
    private String addressLine3;
    
    @Column(name = "DISTRICT")
    private String district;
    
    @Column(name = "STATE")
    private String state;
    
    @Column(name = "PIN")
    private Integer pinCode;
    
    @Column(name = "IS_WEDDING")
    private boolean weddingSelected;
    
    @Column(name = "IS_MEHANDI")
    private boolean mehandiSelected;
    
    @Column(name = "IS_RECEPTION")
    private boolean receptionSelected;
    
    @Column(name = "IS_AC")
    private boolean acSelected;
    
    @Column(name = "IS_AC_ADD")
    private boolean acAddSelected;
    
    @Column(name = "IS_ISHA")
    private boolean ishaSelected;
    
    @Column(name = "IS_NICA")
    private boolean nicaSelected;
    
    @Column(name = "ADVANCE_PAID")
    private int advanceAmount;
    
    @ObjectTypeConverter    (
            name = "eventCategoryConverter", objectType = EventCategory.class, dataType = String.class, conversionValues = {
    @ConversionValue(objectValue = "DIAMOND", dataValue = "DIAMOND"),
    @ConversionValue(objectValue = "GOLD", dataValue = "GOLD"),
    @ConversionValue(objectValue = "SILVER", dataValue = "SILVER") }
    )
    @Convert("eventCategoryConverter")
    @Column(name = "EVENT_CATEGORY")
    private EventCategory eventCategory;
    
    @Column(name = "TOTAL_EVENT_COST")
    private int totalEventCost;
    
    @Column(name = "MOBILE_NUMBER_1")
    private int mobileNumber1;
    
    @Column(name = "MOBILE_NUMBER_2")
    private int mobileNumber2;
    
    @Column(name = "EVENT_DATE_STATUS")
    private String eventDateStatus;
    
    @ObjectTypeConverter    (
            name = "bookingTypeConverter", objectType = BookingType.class, dataType = String.class, conversionValues = {
    @ConversionValue(objectValue = "BOOKED", dataValue = "BOOKED"),
    @ConversionValue(objectValue = "BLOCKED", dataValue = "BLOCKED") }
    )
    @Convert("bookingTypeConverter")
    @Column(name = "BOOKING_TYPE")
    private BookingType bookingType;
    
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    
    @Column(name = "UPDATED_DATE")
    private Date lastUpdatedDate;
    

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public boolean isWeddingSelected() {
        return weddingSelected;
    }

    public void setWeddingSelected(boolean weddingSelected) {
        this.weddingSelected = weddingSelected;
    }

    public boolean isMehandiSelected() {
        return mehandiSelected;
    }

    public void setMehandiSelected(boolean mehandiSelected) {
        this.mehandiSelected = mehandiSelected;
    }

    public boolean isAcSelected() {
        return acSelected;
    }

    public void setAcSelected(boolean acSelected) {
        this.acSelected = acSelected;
    }

    public boolean isAcAddSelected() {
        return acAddSelected;
    }

    public void setAcAddSelected(boolean acAddSelected) {
        this.acAddSelected = acAddSelected;
    }

    public boolean isIshaSelected() {
        return ishaSelected;
    }

    public void setIshaSelected(boolean ishaSelected) {
        this.ishaSelected = ishaSelected;
    }

    public boolean isNicaSelected() {
        return nicaSelected;
    }

    public void setNicaSelected(boolean nicaSelected) {
        this.nicaSelected = nicaSelected;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public int getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(int advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public int getTotalEventCost() {
        return totalEventCost;
    }

    public void setTotalEventCost(int totalEventCost) {
        this.totalEventCost = totalEventCost;
    }

    public int getMobileNumber1() {
        return mobileNumber1;
    }

    public void setMobileNumber1(int mobileNumber1) {
        this.mobileNumber1 = mobileNumber1;
    }

    public int getMobileNumber2() {
        return mobileNumber2;
    }

    public void setMobileNumber2(int mobileNumber2) {
        this.mobileNumber2 = mobileNumber2;
    }

    public String getEventDateStatus() {
        return eventDateStatus;
    }

    public void setEventDateStatus(String eventDateStatus) {
        this.eventDateStatus = eventDateStatus;
    }

    public BookingType getBookingType() {
        return bookingType;
    }

    public void setBookingType(BookingType bookingType) {
        this.bookingType = bookingType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public boolean isReceptionSelected() {
        return receptionSelected;
    }

    public void setReceptionSelected(boolean receptionSelected) {
        this.receptionSelected = receptionSelected;
    }

    @Override
    public String toString() {
        return "Event{" + "eventId=" + eventId + ", "
                + "eventDate=" + eventDate + ", firstName=" 
                + firstName + ", middleName=" + middleName 
                + ", lastName=" + lastName + ", addressLine1=" 
                + addressLine1 + ", addressLine2=" + addressLine2 
                + ", addressLine3=" + addressLine3 + ", district=" 
                + district + ", state=" + state + ", pinCode=" + pinCode 
                + ", weddingSelected=" + weddingSelected + ", mehandiSelected=" 
                + mehandiSelected + ", acSelectedSelected=" + acSelected 
                + ", acAddSelected=" + acAddSelected + ", ishaSelected=" 
                + ishaSelected + ", nicaSelected=" + nicaSelected 
                + ", eventCategory=" + eventCategory + ", totalEventCost=" 
                + totalEventCost + ", mobileNumber1=" + mobileNumber1 
                + ", mobileNumber2=" + mobileNumber2 + ", eventDateStatus=" 
                + eventDateStatus + ", bookingType=" + bookingType + ", createdDate=" 
                + createdDate + ", lastUpdatedDate=" + lastUpdatedDate + '}';
    }   
}
