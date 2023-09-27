/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.Interfaces;

import javax.swing.ImageIcon;

/**
 *
 * @author RiCh_LiKe
 */
public class PanelUsuarioBuscar extends javax.swing.JFrame {

    /**
     * Creates new form PanelUsuarioBuscar
     */
    public PanelUsuarioBuscar() {
        initComponents();
        ImageIcon icono = new ImageIcon("imagenes/ventana.jpg");
        setIconImage(icono.getImage());
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnPelis = new javax.swing.JButton();
        btnSeries = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        btnPelis.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnPelis.setForeground(new java.awt.Color(255, 255, 255));
        btnPelis.setText("Buscar peliculas");
        btnPelis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPelis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPelisMouseClicked(evt);
            }
        });

        btnSeries.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSeries.setForeground(new java.awt.Color(255, 255, 255));
        btnSeries.setText("Buscar series");
        btnSeries.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeries.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSeriesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSeries, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPelis, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnPelis, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSeries, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPelisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPelisMouseClicked
        // TODO add your handling code here:
        PanelBusquedaPelis pbp = new PanelBusquedaPelis();
        pbp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPelisMouseClicked

    private void btnSeriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeriesMouseClicked
        // TODO add your handling code here:
        PanelBusquedaSerie pbs = new PanelBusquedaSerie();
        pbs.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSeriesMouseClicked

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPelis;
    private javax.swing.JButton btnSeries;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
