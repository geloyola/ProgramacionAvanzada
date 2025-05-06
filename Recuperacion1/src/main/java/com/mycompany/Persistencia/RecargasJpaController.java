
package com.mycompany.Persistencia;

import com.mycompany.Modelo.Recargas;
import com.mycompany.Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class RecargasJpaController implements Serializable {

    public RecargasJpaController() {
        this.emf = Persistence.createEntityManagerFactory("com.mycompany_Prueba_jar_1.0-SNAPSHOTPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Recargas recargas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(recargas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Recargas recargas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            recargas = em.merge(recargas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = recargas.getIdReca();
                if (findRecargas(id) == null) {
                    throw new NonexistentEntityException("The recargas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Recargas recargas;
            try {
                recargas = em.getReference(Recargas.class, id);
                recargas.getIdReca();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The recargas with id " + id + " no longer exists.", enfe);
            }
            em.remove(recargas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Recargas> findRecargasEntities() {
        return findRecargasEntities(true, -1, -1);
    }

    public List<Recargas> findRecargasEntities(int maxResults, int firstResult) {
        return findRecargasEntities(false, maxResults, firstResult);
    }

    private List<Recargas> findRecargasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Recargas.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Recargas findRecargas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Recargas.class, id);
        } finally {
            em.close();
        }
    }

    public int getRecargasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Recargas> rt = cq.from(Recargas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
