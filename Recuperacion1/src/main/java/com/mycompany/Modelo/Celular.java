
package com.mycompany.Modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Celular implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int idCel;
    String numero;
    String estado;
    double saldo;
    double Megas;
    
    @OneToOne
    @JoinColumn(name="cliente_id", referencedColumnName = "idClie")
    Cliente cedulaCliente;
    
    public Celular() {
    }

    public Celular(int idCel, String numero, String estado, int saldo, int Megas) {
        this.idCel = idCel;
        this.numero = numero;
        this.estado = estado;
        this.saldo = saldo;
        this.Megas = Megas;
    }

    public Cliente getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(Cliente cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }
    
    public int getIdCel() {
        return idCel;
    }

    public void setIdCel(int idCel) {
        this.idCel = idCel;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getMegas() {
        return Megas;
    }

    public void setMegas(double Megas) {
        this.Megas = Megas;
    }
    
    
}
