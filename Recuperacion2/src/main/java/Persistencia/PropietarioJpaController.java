// Se declara el paquete donde se encuentra la clase PropietarioJpaController
package Persistencia;

// Se importan las clases necesarias para trabajar con las entidades y excepciones de JPA
import Modelo.Propietario;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

// La clase PropietarioJpaController maneja las operaciones CRUD para la entidad Propietario.
public class PropietarioJpaController implements Serializable {

    // Constructor que recibe un EntityManagerFactory y lo asigna a la variable emf
    public PropietarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // Variable que almacena la fábrica de EntityManager, que se utiliza para crear instancias de EntityManager
    private EntityManagerFactory emf = null;

    // Método que retorna una nueva instancia de EntityManager
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Constructor por defecto que crea una fábrica de EntityManager con el nombre "Turnos" en la configuración de persistencia
    public PropietarioJpaController(){
        emf = Persistence.createEntityManagerFactory("Turnos");
    }

    // Método para crear (guardar) un Propietario en la base de datos
    public void create(Propietario propietario) {
        EntityManager em = null;
        try {
            em = getEntityManager();  // Obtiene el EntityManager
            em.getTransaction().begin();  // Inicia la transacción
            em.persist(propietario);  // Persiste (guarda) el propietario
            em.getTransaction().commit();  // Realiza el commit de la transacción
        } finally {
            if (em != null) {
                em.close();  // Cierra el EntityManager
            }
        }
    }

    // Método para editar (actualizar) un Propietario en la base de datos
    public void edit(Propietario propietario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();  // Obtiene el EntityManager
            em.getTransaction().begin();  // Inicia la transacción
            propietario = em.merge(propietario);  // Fusiona los cambios del propietario con la base de datos
            em.getTransaction().commit();  // Realiza el commit de la transacción
        } catch (Exception ex) {
            // Si ocurre una excepción, verifica si la entidad ya no existe en la base de datos
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = propietario.getId_propietario();
                if (findPropietario(id) == null) {
                    throw new NonexistentEntityException("The propietario with id " + id + " no longer exists.");
                }
            }
            throw ex;  // Lanza la excepción si ocurrió un error
        } finally {
            if (em != null) {
                em.close();  // Cierra el EntityManager
            }
        }
    }

    // Método para eliminar un Propietario de la base de datos
    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();  // Obtiene el EntityManager
            em.getTransaction().begin();  // Inicia la transacción
            Propietario propietario;
            try {
                propietario = em.getReference(Propietario.class, id);  // Obtiene una referencia al propietario con el ID
                propietario.getId_propietario();  // Accede a la ID del propietario para lanzar la excepción si no existe
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The propietario with id " + id + " no longer exists.", enfe);
            }
            em.remove(propietario);  // Elimina el propietario de la base de datos
            em.getTransaction().commit();  // Realiza el commit de la transacción
        } finally {
            if (em != null) {
                em.close();  // Cierra el EntityManager
            }
        }
    }

    // Método para obtener todos los propietarios de la base de datos
    public List<Propietario> findPropietarioEntities() {
        return findPropietarioEntities(true, -1, -1);  // Llama al método privado sin límites de resultados
    }

    // Método para obtener una lista paginada de propietarios
    public List<Propietario> findPropietarioEntities(int maxResults, int firstResult) {
        return findPropietarioEntities(false, maxResults, firstResult);  // Llama al método privado con límites de resultados
    }

    // Método privado que obtiene una lista de propietarios, con soporte de paginación
    private List<Propietario> findPropietarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();  // Obtiene el EntityManager
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();  // Crea una consulta de criterios
            cq.select(cq.from(Propietario.class));  // Define la selección de la consulta (todas las entidades Propietario)
            Query q = em.createQuery(cq);  // Crea la consulta
            if (!all) {  // Si no se solicitan todos los resultados
                q.setMaxResults(maxResults);  // Limita la cantidad de resultados
                q.setFirstResult(firstResult);  // Define el primer resultado de la página
            }
            return q.getResultList();  // Retorna los resultados de la consulta
        } finally {
            em.close();  // Cierra el EntityManager
        }
    }

    // Método para encontrar un Propietario por su ID
    public Propietario findPropietario(int id) {
        EntityManager em = getEntityManager();  // Obtiene el EntityManager
        try {
            return em.find(Propietario.class, id);  // Busca el propietario por su ID
        } finally {
            em.close();  // Cierra el EntityManager
        }
    }

    // Método para obtener el número total de propietarios en la base de datos
    public int getPropietarioCount() {
        EntityManager em = getEntityManager();  // Obtiene el EntityManager
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();  // Crea una consulta de criterios
            Root<Propietario> rt = cq.from(Propietario.class);  // Define la raíz de la consulta
            cq.select(em.getCriteriaBuilder().count(rt));  // Cuenta el número total de propietarios
            Query q = em.createQuery(cq);  // Crea la consulta
            return ((Long) q.getSingleResult()).intValue();  // Retorna el número total de propietarios
        } finally {
            em.close();  // Cierra el EntityManager
        }
    }
}
