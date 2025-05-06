
package com.mycompany.Presentacion;

import com.mycompany.Modelo.Celular;
import com.mycompany.Modelo.Cliente;
import com.mycompany.Modelo.Recargas;
import com.mycompany.Persistencia.CelularJpaController;
import com.mycompany.Persistencia.ClienteJpaController;
import com.mycompany.Persistencia.RecargasJpaController;
import javax.swing.JOptionPane;


public class interfaz extends javax.swing.JFrame {

    public interfaz() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cliente = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextCedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextApellido = new javax.swing.JTextField();
        celular = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextNumero = new javax.swing.JTextField();
        jTextEstado = new javax.swing.JTextField();
        jTextSaldo = new javax.swing.JTextField();
        jTextMegas = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        recarga = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextValidarNumero = new javax.swing.JTextField();
        jBValidarNumero = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextValorRecarga = new javax.swing.JTextField();
        jBHacerRecarga = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cliente.setText("Cliente");

        jLabel2.setText("Cedula: ");

        jLabel3.setText("Nombres:");

        jLabel4.setText("Apellidos:");

        celular.setText("celular");

        jLabel6.setText("Numero:");

        jLabel7.setText("Estado:");

        jLabel8.setText("Saldo:");

        jLabel9.setText("Megas:");

        jButton1.setText("INGRESAR ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        recarga.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        recarga.setForeground(new java.awt.Color(51, 51, 51));
        recarga.setText("Recarga");

        jLabel11.setText("Numero:");

        jBValidarNumero.setText("Validar");
        jBValidarNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBValidarNumeroActionPerformed(evt);
            }
        });

        jLabel13.setText("Valor:");

        jBHacerRecarga.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jBHacerRecarga.setText("Hacer Recarga");
        jBHacerRecarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHacerRecargaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(66, 66, 66)
                                        .addComponent(jLabel8))
                                    .addComponent(jLabel9))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(105, 105, 105)
                                                .addComponent(jTextValidarNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextMegas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(102, 102, 102)
                                                .addComponent(jTextValorRecarga, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jBHacerRecarga)
                                            .addComponent(jBValidarNumero)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton1)
                                            .addComponent(jTextSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(134, 134, 134)
                                        .addComponent(jLabel13))))
                            .addComponent(cliente)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                            .addComponent(jTextNombre))
                                        .addGap(72, 72, 72)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(130, 130, 130))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(celular)
                                        .addGap(166, 166, 166)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(recarga)
                                    .addComponent(jLabel11))))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(cliente))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(recarga)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextValidarNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jBValidarNumero))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(celular)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jTextNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jTextSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel13)))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextValorRecarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBHacerRecarga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextMegas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(67, 67, 67)
                .addComponent(jButton1)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
        String cedula = jTextCedula.getText().trim();
        String nombre = jTextNombre.getText();
        String apellido = jTextApellido.getText();
        String numero = jTextNumero.getText();
        String estado = jTextEstado.getText();

        double saldo = Double.parseDouble(jTextSaldo.getText().trim());
        double megas = Double.parseDouble(jTextMegas.getText().trim());

        // Creación de objetos
        Cliente cliente = new Cliente();
        cliente.setCedula(cedula);
        cliente.setNombres(nombre);
        cliente.setApellidos(apellido);

        Celular telefono = new Celular();
        telefono.setNumero(numero);
        telefono.setEstado(estado);
        telefono.setSaldo(saldo);
        telefono.setMegas(megas);

        telefono.setCedulaCliente(cliente);

        new ClienteJpaController().create(cliente);
        new CelularJpaController().create(telefono);

        JOptionPane.showMessageDialog(this, "Datos insertados correctamente.");


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBValidarNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBValidarNumeroActionPerformed
        // TODO add your handling code here:
        try {
            String numeroIngresado = jTextValidarNumero.getText().trim();

            if (numeroIngresado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese un número.");
                return;
            }

            CelularJpaController celularController = new CelularJpaController();
            Celular celular = celularController.buscarCelularPorNumero(numeroIngresado);

            if (celular != null) {
                JOptionPane.showMessageDialog(this, "El número está registrado");
            } else {
                JOptionPane.showMessageDialog(this, "El número no está registrado.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al validar el número: " + e.getMessage());
            e.printStackTrace();
        }


    }//GEN-LAST:event_jBValidarNumeroActionPerformed

    private void jBHacerRecargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHacerRecargaActionPerformed
        // TODO add your handling code here:
        String numero = jTextValidarNumero.getText().trim();
        double valorRecarga = Double.parseDouble(jTextValorRecarga.getText().trim());

        try {
            CelularJpaController celularJPA = new CelularJpaController();
            Celular celular = celularJPA.buscarCelularPorNumero(numero);

            if (celular != null) {
                if (celular.getEstado().equalsIgnoreCase("Activo")) {

                    Recargas recarga = new Recargas();
                    recarga.setValor(valorRecarga);
                    recarga.setSaldo();
                    recarga.setMegas();
                    recarga.setCelular(celular);

                    new RecargasJpaController().create(recarga);

                    JOptionPane.showMessageDialog(null, "se realizó la recarga");
                } else {
                    JOptionPane.showMessageDialog(null, "El celular no está activo, no se puede recargar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Celular no encontrado.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrió un error al realizar la recarga.");
        }


    }//GEN-LAST:event_jBHacerRecargaActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel celular;
    private javax.swing.JLabel cliente;
    private javax.swing.JButton jBHacerRecarga;
    private javax.swing.JButton jBValidarNumero;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextApellido;
    private javax.swing.JTextField jTextCedula;
    private javax.swing.JTextField jTextEstado;
    private javax.swing.JTextField jTextMegas;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextNumero;
    private javax.swing.JTextField jTextSaldo;
    private javax.swing.JTextField jTextValidarNumero;
    private javax.swing.JTextField jTextValorRecarga;
    private javax.swing.JLabel recarga;
    // End of variables declaration//GEN-END:variables
}
