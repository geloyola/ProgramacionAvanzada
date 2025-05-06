
package com.mycompany.Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.Modelo.Celular;
import com.mycompany.Modelo.Cliente;
import com.mycompany.Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rafa
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController() {
        this.emf = Persistence.createEntityManagerFactory("com.mycompany_Prueba_jar_1.0-SNAPSHOTPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Celular celular = cliente.getCelular();
            if (celular != null) {
                celular = em.getReference(celular.getClass(), celular.getIdCel());
                cliente.setCelular(celular);
            }
            em.persist(cliente);
            if (celular != null) {
                Cliente oldCedulaClienteOfCelular = celular.getCedulaCliente();
                if (oldCedulaClienteOfCelular != null) {
                    oldCedulaClienteOfCelular.setCelular(null);
                    oldCedulaClienteOfCelular = em.merge(oldCedulaClienteOfCelular);
                }
                celular.setCedulaCliente(cliente);
                celular = em.merge(celular);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getIdClie());
            Celular celularOld = persistentCliente.getCelular();
            Celular celularNew = cliente.getCelular();
            if (celularNew != null) {
                celularNew = em.getReference(celularNew.getClass(), celularNew.getIdCel());
                cliente.setCelular(celularNew);
            }
            cliente = em.merge(cliente);
            if (celularOld != null && !celularOld.equals(celularNew)) {
                celularOld.setCedulaCliente(null);
                celularOld = em.merge(celularOld);
            }
            if (celularNew != null && !celularNew.equals(celularOld)) {
                Cliente oldCedulaClienteOfCelular = celularNew.getCedulaCliente();
                if (oldCedulaClienteOfCelular != null) {
                    oldCedulaClienteOfCelular.setCelular(null);
                    oldCedulaClienteOfCelular = em.merge(oldCedulaClienteOfCelular);
                }
                celularNew.setCedulaCliente(cliente);
                celularNew = em.merge(celularNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cliente.getIdClie();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
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
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getIdClie();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            Celular celular = cliente.getCelular();
            if (celular != null) {
                celular.setCedulaCliente(null);
                celular = em.merge(celular);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
