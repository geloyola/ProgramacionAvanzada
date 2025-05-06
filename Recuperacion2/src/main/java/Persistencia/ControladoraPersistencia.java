// Se declara el paquete donde se encuentra la clase ControladoraPersistencia
package Persistencia;

// Se importan las clases necesarias para manejar las entidades Propietario, Turno y Vehiculo
import Modelo.Propietario;
import Modelo.Turno;
import Modelo.Vehiculo;

// La clase ControladoraPersistencia se encarga de manejar las operaciones de persistencia (guardar) de las entidades
public class ControladoraPersistencia {
    
    // Se crea una instancia del controlador de la entidad Propietario
    PropietarioJpaController propirtarioJpa = new PropietarioJpaController();
    
    // Se crea una instancia del controlador de la entidad Turno
    TurnoJpaController turnoJpa = new TurnoJpaController();
    
    // Se crea una instancia del controlador de la entidad Vehiculo
    VehiculoJpaController vehiculoJpa = new VehiculoJpaController();
    
    // Método para guardar las entidades Propietario, Turno y Vehiculo
    public void guardar(Propietario propietario, Turno turno, Vehiculo vehiculo) {
        
        // Se llama al método create del controlador de Propietario para guardar el objeto propietario
        propirtarioJpa.create(propietario);
        
        // Se llama al método create del controlador de Turno para guardar el objeto turno
        turnoJpa.create(turno);
        
        // Se llama al método create del controlador de Vehiculo para guardar el objeto vehiculo
        vehiculoJpa.create(vehiculo);
    }
}
