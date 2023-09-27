/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.Interfaces;

import poo.ClasesDominio.Cliente;
import poo.ClasesDominio.Tarjeta;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import poo.ClasesDominio.GuardarLeerFicheros;



/**
 *
 * @author RiCh_LiKe
 */
public class PanelRegistro extends javax.swing.JFrame {

    private JFrame principal;
    
    public PanelRegistro(JFrame v) {
        initComponents();
        ImageIcon icono = new ImageIcon("imagenes/ventana.jpg");
        setIconImage(icono.getImage());
        this.setLocationRelativeTo(null);
        principal = v;
        principal.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fondo1 = new poo.Interfaces.Fondo();
        jPanel1 = new javax.swing.JPanel();
        panelInicioSesion = new poo.Interfaces.PanelTransparente();
        labelTitulo = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();
        labelContrasena = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JLabel();
        labelContrasena3 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        labelCorreo1 = new javax.swing.JLabel();
        labelCorreo2 = new javax.swing.JLabel();
        labelContrasena4 = new javax.swing.JLabel();
        labelCorreo3 = new javax.swing.JLabel();
        labelCorreo4 = new javax.swing.JLabel();
        labelCorreo5 = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        Calendar calendar=Calendar.getInstance();
        Date hoy= calendar.getTime();
        SpinnerDateModel sdm = new SpinnerDateModel(hoy, null, null, Calendar.DAY_OF_MONTH);
        txtFechaCaducidad = new javax.swing.JSpinner(sdm);
        btnAtras = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setOpaque(false);

        panelInicioSesion.setBackground(new java.awt.Color(51, 51, 51));
        panelInicioSesion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ImageIcon icon = new ImageIcon("imagenes/logo.png");

        labelTitulo.setIcon(icon);

        labelCorreo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCorreo.setForeground(new java.awt.Color(255, 255, 255));
        labelCorreo.setText("Correo:");

        labelContrasena.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelContrasena.setForeground(new java.awt.Color(255, 255, 255));
        labelContrasena.setText("Contraseña:");

        txtCorreo.setBackground(new java.awt.Color(102, 102, 102));
        txtCorreo.setBorder(null);

        txtContrasena.setBackground(new java.awt.Color(102, 102, 102));
        txtContrasena.setBorder(null);

        btnConfirmar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseClicked(evt);
            }
        });

        labelContrasena3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelContrasena3.setForeground(new java.awt.Color(255, 255, 255));
        labelContrasena3.setText("Crear una cuenta");
        labelContrasena3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtDni.setBackground(new java.awt.Color(102, 102, 102));
        txtDni.setBorder(null);

        txtNombre.setBackground(new java.awt.Color(102, 102, 102));
        txtNombre.setBorder(null);

        labelCorreo1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCorreo1.setForeground(new java.awt.Color(255, 255, 255));
        labelCorreo1.setText("Nombre:");

        labelCorreo2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCorreo2.setForeground(new java.awt.Color(255, 255, 255));
        labelCorreo2.setText("DNI:");

        labelContrasena4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelContrasena4.setForeground(new java.awt.Color(255, 255, 255));
        labelContrasena4.setText("Introducir tarjeta");
        labelContrasena4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelCorreo3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCorreo3.setForeground(new java.awt.Color(255, 255, 255));
        labelCorreo3.setText("Numero:");

        labelCorreo4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCorreo4.setForeground(new java.awt.Color(255, 255, 255));
        labelCorreo4.setText("Fecha caducidad:");

        labelCorreo5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCorreo5.setForeground(new java.awt.Color(255, 255, 255));
        labelCorreo5.setText("Saldo:");

        txtNum.setBackground(new java.awt.Color(102, 102, 102));
        txtNum.setBorder(null);

        txtSaldo.setBackground(new java.awt.Color(102, 102, 102));
        txtSaldo.setBorder(null);

        txtFechaCaducidad.setEditor(new JSpinner.DateEditor(txtFechaCaducidad, "dd/MM/yyyy"));
        txtFechaCaducidad.setBorder(null);

        btnAtras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnAtras.setText("Atras");
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelInicioSesionLayout = new javax.swing.GroupLayout(panelInicioSesion);
        panelInicioSesion.setLayout(panelInicioSesionLayout);
        panelInicioSesionLayout.setHorizontalGroup(
            panelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioSesionLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInicioSesionLayout.createSequentialGroup()
                        .addGroup(panelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCorreo)
                            .addGroup(panelInicioSesionLayout.createSequentialGroup()
                                .addComponent(labelCorreo1)
                                .addGap(282, 282, 282)
                                .addComponent(labelCorreo3))
                            .addComponent(labelCorreo2)
                            .addGroup(panelInicioSesionLayout.createSequentialGroup()
                                .addGroup(panelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelContrasena)
                                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(140, 140, 140)
                                .addGroup(panelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panelInicioSesionLayout.createSequentialGroup()
                                        .addComponent(btnAtras)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnConfirmar))
                                    .addGroup(panelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelCorreo4)
                                        .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFechaCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelCorreo5)))))
                        .addGap(38, 38, 38))
                    .addGroup(panelInicioSesionLayout.createSequentialGroup()
                        .addComponent(labelContrasena3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelContrasena4)
                        .addGap(43, 43, 43))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioSesionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInicioSesionLayout.setVerticalGroup(
            panelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioSesionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelContrasena3)
                    .addComponent(labelContrasena4))
                .addGap(18, 18, 18)
                .addGroup(panelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCorreo3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(txtNum, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCorreo2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCorreo4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCorreo5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(panelInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout fondo1Layout = new javax.swing.GroupLayout(fondo1);
        fondo1.setLayout(fondo1Layout);
        fondo1Layout.setHorizontalGroup(
            fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        fondo1Layout.setVerticalGroup(
            fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unchecked")
    private void btnConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseClicked
                
        
        GuardarLeerFicheros.cargarDatosClientes();
        
        clientes = GuardarLeerFicheros.obtenerArrayClientes();                  // Leer del fichero.dat los Objetos y añadirlos al arrayList
        
        // Crear el cliente con los parametros escritos por el usuario
        double saldo= Double.parseDouble(txtSaldo.getText());
        
            //Pasamos de Date a LocalDate
        Date caducidad= (Date) txtFechaCaducidad.getValue();
        Instant instant = Instant.ofEpochMilli(caducidad.getTime());
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        
            //Prueba Tarjeta
        Tarjeta tj=new Tarjeta(txtNum.getText(),localDate,saldo);
        
        String correo=txtCorreo.getText();
        Cliente cli=new Cliente(txtDni.getText(),txtNombre.getText(),correo,txtContrasena.getText(),tj);
        
        clientes.add(cli);                                  // Añadir el cliente al arrayList

        GuardarLeerFicheros.guardarDatosClientes();         // Guardar el nuevo arrayList en el fichero.dat

        PanelSuscrispcion ps = new PanelSuscrispcion();     // Llevarte a la pagina de inicio de sesion
        
        ps.client  = cli;
        
        ps.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnConfirmarMouseClicked

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        volverInicio();     // Llevarte a la pagina de inicio de sesion
    }//GEN-LAST:event_btnAtrasMouseClicked

    public void volverInicio(){
        
        PanelInicioSesion pis = new PanelInicioSesion();
        pis.setVisible(true);
        this.dispose();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtras;
    private javax.swing.JLabel btnConfirmar;
    private poo.Interfaces.Fondo fondo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelContrasena;
    private javax.swing.JLabel labelContrasena3;
    private javax.swing.JLabel labelContrasena4;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelCorreo1;
    private javax.swing.JLabel labelCorreo2;
    private javax.swing.JLabel labelCorreo3;
    private javax.swing.JLabel labelCorreo4;
    private javax.swing.JLabel labelCorreo5;
    private javax.swing.JLabel labelTitulo;
    private poo.Interfaces.PanelTransparente panelInicioSesion;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JSpinner txtFechaCaducidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables

    private static ArrayList <Cliente> clientes = new ArrayList<>();

}