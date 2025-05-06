package Modelo;

import Persistencia.ControladoraPersistencia;

public class Controladora {

    // Se crea una instancia de la clase ControladoraPersistencia para poder utilizar sus métodos
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    // Método guardar que recibe información relacionada con un propietario, vehículo y turno.
    public void guardar(String cedulaPropietario, String nombrePropietario, String apellidoPropietario,
            String placaVehiculo, String marcaVehiculo, String estadoVehiculo,
            String espacioVehiculo, String diaTurno, String horaTurno) {
        // Se crea un objeto de tipo Propietario para guardar los datos del propietario  
        Propietario propietario = new Propietario();
        // Se asigna el valor de cedulaPropietario al atributo cedula del objeto propietario
        propietario.setCedula(cedulaPropietario);
        
        // Se asigna el valor de nombrePropietario al atributo nombre del objeto propietario
        propietario.setNombre(nombrePropietario);
        
        // Se asigna el valor de apellidoPropietario al atributo apellidos del objeto propietario
        propietario.setApellidos(apellidoPropietario);
        

       // Se crea un objeto de tipo Vehiculo para guardar los datos del vehículo
        Vehiculo vehiculo = new Vehiculo();
        
        // Se asigna el valor de placaVehiculo al atributo placa del objeto vehiculo
        vehiculo.setPlaca(placaVehiculo);
        
        // Se asigna el valor de marcaVehiculo al atributo marca del objeto vehiculo
        vehiculo.setMarca(marcaVehiculo);
        
        // Se asigna el valor de estadoVehiculo al atributo estado del objeto vehiculo
        vehiculo.setEstado(estadoVehiculo);
        
        // Se asigna el valor de espacioVehiculo al atributo espacio del objeto vehiculo
        vehiculo.setEstado(espacioVehiculo);

          // Se crea un objeto de tipo Turno para guardar los datos del turno
        Turno turno = new Turno();
        
        // Se asigna el valor de diaTurno al atributo dia del objeto turno
        turno.setDia(diaTurno);
        
        // Se asigna el valor de horaTurno al atributo hora del objeto turno
        turno.setDia(horaTurno); // Este parece un error, debería ser `turno.setHora(horaTurno);`
        
        // Se guarda la información de propietario, turno y vehículo utilizando la clase ControladoraPersistencia
        controlPersis.guardar(propietario, turno, vehiculo);

    }
}
