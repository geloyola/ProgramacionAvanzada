
package com.mycompany.Modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Recargas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int idReca;
    double valor;
    double saldo;
    double megas;

    @ManyToOne
    @JoinColumn(name = "id_celular") 
    Celular celular;

    public Recargas() {
    }

    public Recargas(int idReca, int valor, int saldo, int megas) {
        this.idReca = idReca;
        this.valor = valor;
        this.saldo = saldo;
        this.megas = megas;
    }

    public Celular getCelular() {
        return celular;
    }

    public void setCelular(Celular celular) {
        this.celular = celular;
    }

    public int getIdReca() {
        return idReca;
    }

    public void setIdReca(int idReca) {
        this.idReca = idReca;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo() {
        this.saldo = valor * (2.0 / 3);
    }

    public double getMegas() {
        return megas;
    }

    public void setMegas() {
        this.megas = valor * (5000.0 / 3);
    }

}
