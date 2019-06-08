package easymis.models.repository;

import easymis.models.entity.DomainObject;
import easymis.models.entity.TransactionStatus;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TemporalType;

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

    public <T extends DomainObject> List<T> retrieve(String queryString, List<QueryParams> params, Class<T> responseObject) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("company-provider");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<T> resultList = null;
        try {
            Query query = em.createQuery(queryString);
            if(params != null && !params.isEmpty()){
                params.stream().forEach((queryParam) -> {
                    if(queryParam.getParamDateValue() != null){
                        query.setParameter(queryParam.getParamName(), queryParam.getParamDateValue(), TemporalType.DATE);
                    }else{
                        query.setParameter(queryParam.getParamName(), queryParam.getParamValue());
                    }
                });
            }
            resultList = query.getResultList();
            if(resultList != null && !resultList.isEmpty())
                return resultList;
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            em.close();
        }
        return resultList;
    }
    
    public TransactionStatus update(Object object) {
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

    private TransactionStatus fillTransactionStatus(Exception exception) {
        TransactionStatus status = new TransactionStatus();
        if (exception != null) {
            status.setSuccess(false);
            status.setMessage(exception.getLocalizedMessage());
        } else {
            status.setSuccess(true);
        }
        return status;
    }
}
