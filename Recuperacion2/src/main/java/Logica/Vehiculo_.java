package Logica;

import Modelo.Vehiculo;
import Modelo.Propietario;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-01T01:33:15", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile SingularAttribute<Vehiculo, String> marca;
    public static volatile SingularAttribute<Vehiculo, String> estado;
    public static volatile SingularAttribute<Vehiculo, Integer> id_vehiculo;
    public static volatile SingularAttribute<Vehiculo, Propietario> unPropietario;
    public static volatile SingularAttribute<Vehiculo, String> placa;

}