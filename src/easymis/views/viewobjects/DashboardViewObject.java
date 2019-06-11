package easymis.views.viewobjects;

/**
 *
 * @author RashidKP
 */
public class DashboardViewObject {
    
    private EventAvailability weddingAvailability;
    
    private EventAvailability mehandiAvailability;
    
    private EventAvailability ishaHallAvailability;
    
    private EventAvailability nicaLoungeAvailability;
    
    private EventAvailability receptionAvailability;
    
    private int totalBookingThisYear;  
    
    private int totalBlockingThisYear;
    
    private int totalCancellationThisYear;
    
    private int averageBookingMonthly;
    
    private int totalDiamonBookingThisYear;
    
    private String diamondNotifications;

    public EventAvailability getWeddingAvailability() {
        return weddingAvailability;
    }

    public void setWeddingAvailability(EventAvailability weddingAvailability) {
        this.weddingAvailability = weddingAvailability;
    }

    public EventAvailability getMehandiAvailability() {
        return mehandiAvailability;
    }

    public void setMehandiAvailability(EventAvailability mehandiAvailability) {
        this.mehandiAvailability = mehandiAvailability;
    }

    public EventAvailability getIshaHallAvailability() {
        return ishaHallAvailability;
    }

    public void setIshaHallAvailability(EventAvailability ishaHallAvailability) {
        this.ishaHallAvailability = ishaHallAvailability;
    }

    public EventAvailability getNicaLoungeAvailability() {
        return nicaLoungeAvailability;
    }

    public void setNicaLoungeAvailability(EventAvailability nicaLoungeAvailability) {
        this.nicaLoungeAvailability = nicaLoungeAvailability;
    }

    public EventAvailability getReceptionAvailability() {
        return receptionAvailability;
    }

    public void setReceptionAvailability(EventAvailability receptionAvailability) {
        this.receptionAvailability = receptionAvailability;
    }

    public int getTotalBookingThisYear() {
        return totalBookingThisYear;
    }

    public void setTotalBookingThisYear(int totalBookingThisYear) {
        this.totalBookingThisYear = totalBookingThisYear;
    }

    public int getTotalBlockingThisYear() {
        return totalBlockingThisYear;
    }

    public void setTotalBlockingThisYear(int totalBlockingThisYear) {
        this.totalBlockingThisYear = totalBlockingThisYear;
    }

    public int getTotalCancellationThisYear() {
        return totalCancellationThisYear;
    }

    public void setTotalCancellationThisYear(int totalCancellationThisYear) {
        this.totalCancellationThisYear = totalCancellationThisYear;
    }

    public int getAverageBookingMonthly() {
        return averageBookingMonthly;
    }

    public void setAverageBookingMonthly(int averageBookingMonthly) {
        this.averageBookingMonthly = averageBookingMonthly;
    }

    public int getTotalDiamonBookingThisYear() {
        return totalDiamonBookingThisYear;
    }

    public void setTotalDiamonBookingThisYear(int totalDiamonBookingThisYear) {
        this.totalDiamonBookingThisYear = totalDiamonBookingThisYear;
    }

    public String getDiamondNotifications() {
        return diamondNotifications;
    }

    public void setDiamondNotifications(String diamondNotifications) {
        this.diamondNotifications = diamondNotifications;
    }

}
