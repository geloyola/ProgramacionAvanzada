// Se declara el paquete donde se encuentra la clase IllegalOrphanException
package Persistencia.exceptions;

// Se importan las clases necesarias para trabajar con listas
import java.util.ArrayList;
import java.util.List;

// Se define una clase personalizada que extiende la clase Exception
public class IllegalOrphanException extends Exception {
    
    // Se declara una lista de mensajes que se utilizarán para almacenar los detalles de la excepción
    private List<String> messages;
    
    // Constructor que recibe una lista de mensajes y llama al constructor de la clase base (Exception)
    public IllegalOrphanException(List<String> messages) {
        // Llama al constructor de la clase Exception, pasando el primer mensaje de la lista (si existe)
        super((messages != null && messages.size() > 0 ? messages.get(0) : null));
        
        // Si la lista de mensajes es nula, se inicializa con una nueva lista vacía
        if (messages == null) {
            this.messages = new ArrayList<String>();
        }
        // Si la lista no es nula, se asigna la lista proporcionada a la variable messages
        else {
            this.messages = messages;
        }
    }
    
    // Método getter que devuelve la lista de mensajes almacenados
    public List<String> getMessages() {
        return messages;
    }
}

