package Ejecutor; // Define el paquete donde está la clase

import Vista.Ventana; // Importa la clase Turnos desde el paquete 'igu' de tu aplicación

// Clase principal de la aplicación
public class Evaluacion1 {

    // Método principal que se ejecuta al iniciar la aplicación
    public static void main(String[] args) {
        
        Ventana tur = new Ventana(); // Crea una nueva instancia de la clase Turnos (probablemente una ventana gráfica)
        
        // Hace visible la ventana de la interfaz de usuario
        tur.setVisible(true);
        
        // Centra la ventana en la pantalla
        tur.setLocationRelativeTo(null);
    }
}
