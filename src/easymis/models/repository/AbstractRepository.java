package easymis.models.repository;

import easymis.models.entity.DomainObject;
import easymis.models.entity.TransactionStatus;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author RashidKP
 */
public class AbstractRepository {

    public TransactionStatus persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("company-provider");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TransactionStatus status = null;
        try {
            em.persist(object);
            em.getTransaction().commit();
            status = fillTransactionStatus(null);
        } catch (Exception e) {
            em.getTransaction().rollback();
            status = fillTransactionStatus(e);
        } finally {
            em.close();
        }
        return status;
    }
//
//    public DomainObject retrieve(DomainObject domainObject, String queryString) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("company-provider");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        Query q1 = em.createNativeQuery(queryString", domainObject.class);
//        return null;
//    }

    private TransactionStatus fillTransactionStatus(Exception exception) {
        TransactionStatus status = new TransactionStatus();
        if (exception != null) {
            status.setSuccess(false);
            status.setErrorMessage(exception.getLocalizedMessage());
        } else {
            status.setSuccess(true);
        }
        return status;
    }
}
