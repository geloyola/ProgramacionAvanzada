package Modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_turno;
    private String anden;
    private String dia;
    private String hora_Disponible;
     @OneToOne
    private Vehiculo unVehiculo;

    public Turno() {
    }

    public Turno(int id_turno, String anden, String dia, String hora_Disponible) {
        this.id_turno = id_turno;
        this.anden = anden;
        this.dia = dia;
        this.hora_Disponible = hora_Disponible;
    }

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public String getAnden() {
        return anden;
    }

    public void setAnden(String anden) {
        this.anden = anden;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora_Disponible() {
        return hora_Disponible;
    }

    public void setHora_Disponible(String hora_Disponible) {
        this.hora_Disponible = hora_Disponible;
    }

}
