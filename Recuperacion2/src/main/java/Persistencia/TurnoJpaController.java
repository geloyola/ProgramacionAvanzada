// Se declara el paquete donde se encuentra la clase TurnoJpaController
package Persistencia;

// Se importan las clases necesarias para manejar las operaciones de persistencia de JPA
import Modelo.Turno;
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

// La clase TurnoJpaController maneja las operaciones CRUD para la entidad Turno
public class TurnoJpaController implements Serializable {

    // Constructor que recibe un EntityManagerFactory y lo asigna a la variable emf
    public TurnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // Variable que almacena la fábrica de EntityManager, que se utiliza para crear instancias de EntityManager
    private EntityManagerFactory emf = null;

    // Método que retorna una nueva instancia de EntityManager
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    // Constructor por defecto que crea un EntityManagerFactory utilizando la configuración de persistencia "Turnos"
    public TurnoJpaController(){
        emf = Persistence.createEntityManagerFactory("Turnos");
    }

    // Método para crear (guardar) un Turno en la base de datos
    public void create(Turno turno) {
        EntityManager em = null;
        try {
            em = getEntityManager();  // Obtiene el EntityManager
            em.getTransaction().begin();  // Inicia la transacción
            em.persist(turno);  // Persiste (guarda) el objeto turno en la base de datos
            em.getTransaction().commit();  // Realiza el commit de la transacción
        } finally {
            if (em != null) {
                em.close();  // Cierra el EntityManager
            }
        }
    }

    // Método para editar (actualizar) un Turno en la base de datos
    public void edit(Turno turno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();  // Obtiene el EntityManager
            em.getTransaction().begin();  // Inicia la transacción
            turno = em.merge(turno);  // Fusiona los cambios del objeto turno con la base de datos
            em.getTransaction().commit();  // Realiza el commit de la transacción
        } catch (Exception ex) {
            // Si ocurre una excepción, verifica si la entidad ya no existe en la base de datos
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = turno.getId_turno();
                if (findTurno(id) == null) {
                    throw new NonexistentEntityException("The turno with id " + id + " no longer exists.");
                }
            }
            throw ex;  // Lanza la excepción si ocurrió un error
        } finally {
            if (em != null) {
                em.close();  // Cierra el EntityManager
            }
        }
    }

    // Método para eliminar un Turno de la base de datos
    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();  // Obtiene el EntityManager
            em.getTransaction().begin();  // Inicia la transacción
            Turno turno;
            try {
                turno = em.getReference(Turno.class, id);  // Obtiene una referencia al turno con el ID proporcionado
                turno.getId_turno();  // Accede a la ID del turno para lanzar la excepción si no existe
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turno with id " + id + " no longer exists.", enfe);
            }
            em.remove(turno);  // Elimina el turno de la base de datos
            em.getTransaction().commit();  // Realiza el commit de la transacción
        } finally {
            if (em != null) {
                em.close();  // Cierra el EntityManager
            }
        }
    }

    // Método para obtener todos los turnos de la base de datos
    public List<Turno> findTurnoEntities() {
        return findTurnoEntities(true, -1, -1);  // Llama al método privado sin aplicar límite de resultados
    }

    // Método para obtener una lista paginada de turnos
    public List<Turno> findTurnoEntities(int maxResults, int firstResult) {
        return findTurnoEntities(false, maxResults, firstResult);  // Llama al método privado con límites de resultados
    }

    // Método privado para encontrar turnos con soporte de paginación
    private List<Turno> findTurnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();  // Obtiene el EntityManager
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();  // Crea una consulta de criterios
            cq.select(cq.from(Turno.class));  // Define la selección de la consulta (todas las entidades Turno)
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

    // Método para encontrar un Turno por su ID
    public Turno findTurno(int id) {
        EntityManager em = getEntityManager();  // Obtiene el EntityManager
        try {
            return em.find(Turno.class, id);  // Busca el turno por su ID
        } finally {
            em.close();  // Cierra el EntityManager
        }
    }

    // Método para obtener el número total de turnos en la base de datos
    public int getTurnoCount() {
        EntityManager em = getEntityManager();  // Obtiene el EntityManager
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();  // Crea una consulta de criterios
            Root<Turno> rt = cq.from(Turno.class);  // Define la raíz de la consulta
            cq.select(em.getCriteriaBuilder().count(rt));  // Cuenta el número total de turnos
            Query q = em.createQuery(cq);  // Crea la consulta
            return ((Long) q.getSingleResult()).intValue();  // Retorna el número total de turnos
        } finally {
            em.close();  // Cierra el EntityManager
        }
    }
}
