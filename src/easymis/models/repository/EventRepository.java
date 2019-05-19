/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymis.models.repository;

import easymis.models.entity.EventDetails;
import easymis.models.entity.TransactionStatus;

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
}
