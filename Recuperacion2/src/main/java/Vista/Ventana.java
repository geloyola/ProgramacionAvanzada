package Vista;

import Modelo.Controladora;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class Ventana extends javax.swing.JFrame {
    
    Controladora control = new Controladora();

    public Ventana() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        txtApellido = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JLabel();
        txtEstado = new javax.swing.JLabel();
        txtAnden = new javax.swing.JLabel();
        txtDia = new javax.swing.JLabel();
        txtHora = new javax.swing.JLabel();
        inserCedula = new javax.swing.JTextField();
        inserNombre = new javax.swing.JTextField();
        inserApellido = new javax.swing.JTextField();
        inserPlaca = new javax.swing.JTextField();
        inserMarca = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        cmbAnden = new javax.swing.JComboBox<>();
        inserDia = new javax.swing.JTextField();
        bntIngresarTurno = new javax.swing.JButton();
        cmbHoradisponivles = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("turnos  vehiculos");

        txtCedula.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtCedula.setText("Cedula");

        txtNombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtNombre.setText("Nombre");

        txtApellido.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtApellido.setText("Apellido");

        txtPlaca.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtPlaca.setText("Placa");

        txtMarca.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtMarca.setText("Marca");

        txtEstado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtEstado.setText("Estado");

        txtAnden.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtAnden.setText("Anden");

        txtDia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtDia.setText("Dia");

        txtHora.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtHora.setText("Hora");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En buen estado", "En mal estado ", " " }));

        cmbAnden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Area de lavado ", "Area de Mantenimiento", "Area de Cambio de Aseite ", " " }));

        bntIngresarTurno.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        bntIngresarTurno.setText("Ingresar Turno");
        bntIngresarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntIngresarTurnoActionPerformed(evt);
            }
        });

        cmbHoradisponivles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10:00.am", "11:00.am", "12:00.am", "13:00.am", " ", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(txtAnden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inserCedula)
                            .addComponent(inserNombre)
                            .addComponent(inserApellido)
                            .addComponent(inserPlaca)
                            .addComponent(inserMarca)
                            .addComponent(cmbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbAnden, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inserDia)
                            .addComponent(cmbHoradisponivles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(59, 59, 59)
                        .addComponent(bntIngresarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCedula)
                            .addComponent(inserCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre)
                            .addComponent(inserNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido)
                            .addComponent(inserApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPlaca)
                            .addComponent(inserPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMarca)
                            .addComponent(inserMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEstado)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAnden)
                            .addComponent(cmbAnden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtDia)
                        .addGap(5, 5, 5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bntIngresarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(inserDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHora)
                    .addComponent(cmbHoradisponivles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntIngresarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntIngresarTurnoActionPerformed
        String cedulaPropietario = inserCedula.getText();
        String nombrePropietario = inserNombre.getText();
        String apellidoPropietario = inserApellido.getText();
        String placaVehiculo = inserPlaca.getText();
        String marcaVehiculo = inserMarca.getText();
        String estadoVehiculo = (String) cmbEstado.getSelectedItem();
        String espacioVehiculo = (String) cmbAnden.getSelectedItem();
        String diaTurno = inserDia.getText();
        String horaTurno = (String) cmbHoradisponivles.getSelectedItem();
        
        control.guardar(cedulaPropietario,nombrePropietario,apellidoPropietario,  placaVehiculo,
                marcaVehiculo,estadoVehiculo,
                espacioVehiculo,diaTurno,horaTurno);
        
     
    }//GEN-LAST:event_bntIngresarTurnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntIngresarTurno;
    private javax.swing.JComboBox<String> cmbAnden;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbHoradisponivles;
    private javax.swing.JTextField inserApellido;
    private javax.swing.JTextField inserCedula;
    private javax.swing.JTextField inserDia;
    private javax.swing.JTextField inserMarca;
    private javax.swing.JTextField inserNombre;
    private javax.swing.JTextField inserPlaca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtAnden;
    private javax.swing.JLabel txtApellido;
    private javax.swing.JLabel txtCedula;
    private javax.swing.JLabel txtDia;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JLabel txtHora;
    private javax.swing.JLabel txtMarca;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtPlaca;
    // End of variables declaration//GEN-END:variables
}
