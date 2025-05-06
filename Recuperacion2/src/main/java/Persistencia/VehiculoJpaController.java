// Se declara el paquete donde se encuentra la clase VehiculoJpaController
package Persistencia;

// Se importan las clases necesarias para manejar las operaciones de persistencia de JPA
import Modelo.Vehiculo;
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

// La clase VehiculoJpaController maneja las operaciones CRUD para la entidad Vehiculo
public class VehiculoJpaController implements Serializable {

    // Constructor que recibe un EntityManagerFactory y lo asigna a la variable emf
    public VehiculoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // Variable que almacena la fábrica de EntityManager, que se utiliza para crear instancias de EntityManager
    private EntityManagerFactory emf = null;

    // Método que retorna una nueva instancia de EntityManager
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    // Constructor por defecto que crea un EntityManagerFactory utilizando la configuración de persistencia "Turnos"
    public VehiculoJpaController(){
        emf = Persistence.createEntityManagerFactory("Turnos");
    }

    // Método para crear (guardar) un Vehiculo en la base de datos
    public void create(Vehiculo vehiculo) {
        EntityManager em = null;
        try {
            em = getEntityManager();  // Obtiene el EntityManager
            em.getTransaction().begin();  // Inicia la transacción
            em.persist(vehiculo);  // Persiste (guarda) el objeto vehiculo en la base de datos
            em.getTransaction().commit();  // Realiza el commit de la transacción
        } finally {
            if (em != null) {
                em.close();  // Cierra el EntityManager
            }
        }
    }

    // Método para editar (actualizar) un Vehiculo en la base de datos
    public void edit(Vehiculo vehiculo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();  // Obtiene el EntityManager
            em.getTransaction().begin();  // Inicia la transacción
            vehiculo = em.merge(vehiculo);  // Fusiona los cambios del objeto vehiculo con la base de datos
            em.getTransaction().commit();  // Realiza el commit de la transacción
        } catch (Exception ex) {
            // Si ocurre una excepción, verifica si la entidad ya no existe en la base de datos
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = vehiculo.getId_vehiculo();
                if (findVehiculo(id) == null) {
                    throw new NonexistentEntityException("The vehiculo with id " + id + " no longer exists.");
                }
            }
            throw ex;  // Lanza la excepción si ocurrió un error
        } finally {
            if (em != null) {
                em.close();  // Cierra el EntityManager
            }
        }
    }

    // Método para eliminar un Vehiculo de la base de datos
    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();  // Obtiene el EntityManager
            em.getTransaction().begin();  // Inicia la transacción
            Vehiculo vehiculo;
            try {
                vehiculo = em.getReference(Vehiculo.class, id);  // Obtiene una referencia al vehiculo con el ID proporcionado
                vehiculo.getId_vehiculo();  // Accede a la ID del vehiculo para lanzar la excepción si no existe
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vehiculo with id " + id + " no longer exists.", enfe);
            }
            em.remove(vehiculo);  // Elimina el vehiculo de la base de datos
            em.getTransaction().commit();  // Realiza el commit de la transacción
        } finally {
            if (em != null) {
                em.close();  // Cierra el EntityManager
            }
        }
    }

    // Método para obtener todos los vehiculos de la base de datos
    public List<Vehiculo> findVehiculoEntities() {
        return findVehiculoEntities(true, -1, -1);  // Llama al método privado sin aplicar límite de resultados
    }

    // Método para obtener una lista paginada de vehiculos
    public List<Vehiculo> findVehiculoEntities(int maxResults, int firstResult) {
        return findVehiculoEntities(false, maxResults, firstResult);  // Llama al método privado con límites de resultados
    }

    // Método privado para encontrar vehiculos con soporte de paginación
    private List<Vehiculo> findVehiculoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();  // Obtiene el EntityManager
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();  // Crea una consulta de criterios
            cq.select(cq.from(Vehiculo.class));  // Define la selección de la consulta (todas las entidades Vehiculo)
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

    // Método para encontrar un Vehiculo por su ID
    public Vehiculo findVehiculo(int id) {
        EntityManager em = getEntityManager();  // Obtiene el EntityManager
        try {
            return em.find(Vehiculo.class, id);  // Busca el vehiculo por su ID
        } finally {
            em.close();  // Cierra el EntityManager
        }
    }

    // Método para obtener el número total de vehiculos en la base de datos
    public int getVehiculoCount() {
        EntityManager em = getEntityManager();  // Obtiene el EntityManager
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();  // Crea una consulta de criterios
            Root<Vehiculo> rt = cq.from(Vehiculo.class);  // Define la raíz de la consulta
            cq.select(em.getCriteriaBuilder().count(rt));  // Cuenta el número total de vehiculos
            Query q = em.createQuery(cq);  // Crea la consulta
            return ((Long) q.getSingleResult()).intValue();  // Retorna el número total de vehiculos
        } finally {
            em.close();  // Cierra el EntityManager
        }
    }
}
