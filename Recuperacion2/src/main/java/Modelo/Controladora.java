package Modelo;

import Persistencia.ControladoraPersistencia;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String cedulaPropietario, String nombrePropietario, String apellidoPropietario,
            String placaVehiculo, String marcaVehiculo, String estadoVehiculo,
            String espacioVehiculo, String diaTurno, String horaTurno) {

        Propietario propietario = new Propietario();

        propietario.setCedula(cedulaPropietario);

        propietario.setNombre(nombrePropietario);

        propietario.setApellidos(apellidoPropietario);

        Vehiculo vehiculo = new Vehiculo();

        vehiculo.setPlaca(placaVehiculo);

        vehiculo.setMarca(marcaVehiculo);

        vehiculo.setEstado(estadoVehiculo);

        vehiculo.setEstado(espacioVehiculo);

        Turno turno = new Turno();

        turno.setDia(diaTurno);

        turno.setDia(horaTurno);

        controlPersis.guardar(propietario, turno, vehiculo);

    }
}
