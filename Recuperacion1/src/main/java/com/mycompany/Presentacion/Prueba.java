
package com.mycompany.Presentacion;

import com.mycompany.Persistencia.CelularJpaController;
import com.mycompany.Persistencia.ClienteJpaController;
import com.mycompany.Persistencia.RecargasJpaController;


public class Prueba {

    public static void main(String[] args) {
        try {
            
            CelularJpaController JPACelular = new CelularJpaController();
            ClienteJpaController JPACliente = new ClienteJpaController();
            RecargasJpaController JPARecargas = new RecargasJpaController();

            System.out.println("Tablas creadas ");
        } catch (Exception e) {
            System.out.println("Error al crear las tablas: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
