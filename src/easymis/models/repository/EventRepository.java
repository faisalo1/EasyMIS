/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymis.models.repository;

import easymis.models.entity.EventDetails;
import easymis.models.entity.TransactionStatus;
import easymis.utils.QueryConstants;
import java.util.List;

/**
 *
 * @author RashidKP
 * 
 */

public class EventRepository extends AbstractRepository{
private static EventRepository uniqueInstance = new EventRepository();

    private EventRepository() {
    }
    
    public static EventRepository getUniqueInstance(){
        return uniqueInstance;
    }
    
    public TransactionStatus create(EventDetails eventDetails){
        return persist(eventDetails);
    }
    
    public List<EventDetails> fetchAllEvents(){
        return retrieve(QueryConstants.FETCH_ALL_EVENTS, null, EventDetails.class);
    }
}
