// Se declara el paquete donde se encuentra la clase NonexistentEntityException
package Persistencia.exceptions;

// Se define una clase personalizada que extiende la clase Exception
public class NonexistentEntityException extends Exception {
    
    // Constructor que recibe un mensaje y una causa (otra excepción)
    public NonexistentEntityException(String message, Throwable cause) {
        // Llama al constructor de la clase base (Exception) pasando el mensaje y la causa
        super(message, cause);
    }
    
    // Constructor que solo recibe un mensaje (sin causa)
    public NonexistentEntityException(String message) {
        // Llama al constructor de la clase base (Exception) pasando solo el mensaje
        super(message);
    }
}

