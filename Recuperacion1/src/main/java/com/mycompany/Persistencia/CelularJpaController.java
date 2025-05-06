
package com.mycompany.Persistencia;

import com.mycompany.Modelo.Celular;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.Modelo.Cliente;
import com.mycompany.Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class CelularJpaController implements Serializable {

    public CelularJpaController() {
        this.emf = Persistence.createEntityManagerFactory("com.mycompany_Prueba_jar_1.0-SNAPSHOTPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Celular celular) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cedulaCliente = celular.getCedulaCliente();
            if (cedulaCliente != null) {
                cedulaCliente = em.getReference(cedulaCliente.getClass(), cedulaCliente.getIdClie());
                celular.setCedulaCliente(cedulaCliente);
            }
            em.persist(celular);
            if (cedulaCliente != null) {
                Celular oldCelularOfCedulaCliente = cedulaCliente.getCelular();
                if (oldCelularOfCedulaCliente != null) {
                    oldCelularOfCedulaCliente.setCedulaCliente(null);
                    oldCelularOfCedulaCliente = em.merge(oldCelularOfCedulaCliente);
                }
                cedulaCliente.setCelular(celular);
                cedulaCliente = em.merge(cedulaCliente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Celular celular) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Celular persistentCelular = em.find(Celular.class, celular.getIdCel());
            Cliente cedulaClienteOld = persistentCelular.getCedulaCliente();
            Cliente cedulaClienteNew = celular.getCedulaCliente();
            if (cedulaClienteNew != null) {
                cedulaClienteNew = em.getReference(cedulaClienteNew.getClass(), cedulaClienteNew.getIdClie());
                celular.setCedulaCliente(cedulaClienteNew);
            }
            celular = em.merge(celular);
            if (cedulaClienteOld != null && !cedulaClienteOld.equals(cedulaClienteNew)) {
                cedulaClienteOld.setCelular(null);
                cedulaClienteOld = em.merge(cedulaClienteOld);
            }
            if (cedulaClienteNew != null && !cedulaClienteNew.equals(cedulaClienteOld)) {
                Celular oldCelularOfCedulaCliente = cedulaClienteNew.getCelular();
                if (oldCelularOfCedulaCliente != null) {
                    oldCelularOfCedulaCliente.setCedulaCliente(null);
                    oldCelularOfCedulaCliente = em.merge(oldCelularOfCedulaCliente);
                }
                cedulaClienteNew.setCelular(celular);
                cedulaClienteNew = em.merge(cedulaClienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = celular.getIdCel();
                if (findCelular(id) == null) {
                    throw new NonexistentEntityException("The celular with id " + id + " no longer exists.");
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
            Celular celular;
            try {
                celular = em.getReference(Celular.class, id);
                celular.getIdCel();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The celular with id " + id + " no longer exists.", enfe);
            }
            Cliente cedulaCliente = celular.getCedulaCliente();
            if (cedulaCliente != null) {
                cedulaCliente.setCelular(null);
                cedulaCliente = em.merge(cedulaCliente);
            }
            em.remove(celular);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Celular> findCelularEntities() {
        return findCelularEntities(true, -1, -1);
    }

    public List<Celular> findCelularEntities(int maxResults, int firstResult) {
        return findCelularEntities(false, maxResults, firstResult);
    }

    private List<Celular> findCelularEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Celular.class));
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

    public Celular findCelular(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Celular.class, id);
        } finally {
            em.close();
        }
    }

    public int getCelularCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Celular> rt = cq.from(Celular.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public Celular buscarCelularPorNumero(String numero) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Celular> query = em.createQuery(
                    "SELECT c FROM Celular c WHERE c.numero = :numero", Celular.class);
            query.setParameter("numero", numero);

            List<Celular> resultados = query.getResultList();
            if (!resultados.isEmpty()) {
                return resultados.get(0); 
            }
            return null; 
        } finally {
            em.close();
        }
    }

}
