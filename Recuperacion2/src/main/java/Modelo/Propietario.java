// Se declara el paquete donde se encuentra la clase Propietario
package Modelo;

// Importaciones necesarias para trabajar con serialización y JPA (Java Persistence API)
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// La anotación @Entity indica que esta clase es una entidad de JPA (será mapeada a una tabla en la base de datos)
@Entity
public class Propietario implements Serializable {
    
    // La anotación @Id indica que este campo es la clave primaria de la entidad
    @Id
    // La anotación @GeneratedValue indica que este campo se generará automáticamente (usando una secuencia en la base de datos)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_propietario; // Atributo para almacenar el ID del propietario
    
    private String cedula; // Atributo para almacenar la cédula del propietario
    private String Nombre; // Atributo para almacenar el nombre del propietario
    private String Apellidos; // Atributo para almacenar los apellidos del propietario

    // Constructor vacío, necesario para que JPA pueda instanciar objetos de esta clase
    public Propietario() {
    }

    // Constructor con parámetros para crear un objeto Propietario con valores específicos
    public Propietario(int id_propietario, String cedula, String Nombre, String Apellidos) {
        this.id_propietario = id_propietario;
        this.cedula = cedula;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
    }

    // Getter para obtener el valor de id_propietario
    public int getId_propietario() {
        return id_propietario;
    }

    // Setter para establecer el valor de id_propietario
    public void setId_propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    // Getter para obtener el valor de cedula
    public String getCedula() {
        return cedula;
    }

    // Setter para establecer el valor de cedula
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    // Getter para obtener el valor de Nombre
    public String getNombre() {
        return Nombre;
    }

    // Setter para establecer el valor de Nombre
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    // Getter para obtener el valor de Apellidos
    public String getApellidos() {
        return Apellidos;
    }

    // Setter para establecer el valor de Apellidos
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }
}
