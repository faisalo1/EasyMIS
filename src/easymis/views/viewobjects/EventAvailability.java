package easymis.views.viewobjects;

/**
 *
 * @author RashidKP
 */
public enum EventAvailability {
    AVAILABLE("Available"),
    NOT_AVAILABLE("Not Available");
    
    private String value;
    EventAvailability(final String value){
        this.value = value;
    }
    
    public String getValue(){
        return value;
    }
    
    @Override
    public String toString(){
        return this.getValue();
    }
}