/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Fabrica.Fabrica;
import dataTypes.DataFecha;
import interfaces.IControladorClientes;
import interfaces.IControladorPedidos;
import interfaces.IControladorRestaurantes;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabian
 */
public class RegistrarCliente extends javax.swing.JInternalFrame {

    Fabrica F = Fabrica.getInstance();
    IControladorClientes cc = F.getIControladorClientes();
    IControladorRestaurantes cr = F.getIControladorRestaurantes();
    IControladorPedidos cp = F.getIControladorPedidos();

    BufferedImage imagenSeleccionada = null;
    private Component seleccionarImagen;

    public RegistrarCliente() {
        initComponents();

        for (int i = 2010; i >= 1910; i--) {
            rcCmbAnio1.addItem(i);
        }
        for (int i = 1; i <= 12; i++) {
            rcCmbMes1.addItem(i);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frmRegCliente = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rcTxtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rcTxtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rcTxtApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rcTxtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rcBtnImagen = new javax.swing.JButton();
        rcBtnRegistrar = new javax.swing.JButton();
        rcBtnCancelar = new javax.swing.JButton();
        rcCmbDia = new javax.swing.JComboBox();
        rcCmbMes = new javax.swing.JComboBox();
        rcCmbAnio = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rcTxtNick = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rcTxtNick1 = new javax.swing.JTextField();
        rcTxtEmail1 = new javax.swing.JTextField();
        rcTxtNombre1 = new javax.swing.JTextField();
        rcTxtApellido1 = new javax.swing.JTextField();
        rcTxtDireccion1 = new javax.swing.JTextField();
        rcCmbAnio1 = new javax.swing.JComboBox();
        rcCmbMes1 = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        rcCmbDia1 = new javax.swing.JComboBox();
        rcBtnRegistrar1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rcBtnImagen1 = new javax.swing.JButton();
        rcBtnCancelar1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rcTxtContra = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();

        frmRegCliente.setTitle("Registrar Cliente");
        frmRegCliente.setToolTipText("");
        frmRegCliente.setVisible(true);

        jLabel1.setText("NickName:");

        jLabel2.setText("Correo Electrónico:");

        rcTxtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcTxtEmailActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellido:");

        jLabel5.setText("Dirección:");

        jLabel6.setText("Fecha de Nacimiento:");

        rcBtnImagen.setText("Seleccionar Imagen");
        rcBtnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcBtnImagenActionPerformed(evt);
            }
        });

        rcBtnRegistrar.setText("Registrar");
        rcBtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcBtnRegistrarActionPerformed(evt);
            }
        });

        rcBtnCancelar.setText("Cancelar");
        rcBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcBtnCancelarActionPerformed(evt);
            }
        });

        rcCmbDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        rcCmbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcCmbMesActionPerformed(evt);
            }
        });

        rcCmbAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcCmbAnioActionPerformed(evt);
            }
        });

        jLabel8.setText("Complete los siguientes campos:");

        jLabel15.setText("Año:");

        jLabel16.setText("Mes:");

        jLabel17.setText("Dia:");

        javax.swing.GroupLayout frmRegClienteLayout = new javax.swing.GroupLayout(frmRegCliente.getContentPane());
        frmRegCliente.getContentPane().setLayout(frmRegClienteLayout);
        frmRegClienteLayout.setHorizontalGroup(
            frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmRegClienteLayout.createSequentialGroup()
                .addGroup(frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frmRegClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(frmRegClienteLayout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel7)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(frmRegClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frmRegClienteLayout.createSequentialGroup()
                        .addGroup(frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(frmRegClienteLayout.createSequentialGroup()
                                    .addComponent(rcCmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(rcCmbDia, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(frmRegClienteLayout.createSequentialGroup()
                                    .addGroup(frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4))
                                    .addGap(32, 32, 32)
                                    .addGroup(frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(rcTxtApellido)
                                        .addComponent(rcTxtDireccion)
                                        .addComponent(rcTxtNombre)
                                        .addComponent(rcTxtEmail)
                                        .addComponent(rcTxtNick, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))))
                            .addGroup(frmRegClienteLayout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(rcBtnImagen)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(frmRegClienteLayout.createSequentialGroup()
                        .addGroup(frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(frmRegClienteLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addGap(88, 88, 88)
                                .addComponent(jLabel16)
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, frmRegClienteLayout.createSequentialGroup()
                                .addGroup(frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, frmRegClienteLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(rcCmbAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, frmRegClienteLayout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addComponent(rcBtnCancelar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)))
                        .addGroup(frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(frmRegClienteLayout.createSequentialGroup()
                                .addComponent(rcBtnRegistrar)
                                .addGap(91, 91, 91))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frmRegClienteLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(71, 71, 71))))))
        );
        frmRegClienteLayout.setVerticalGroup(
            frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmRegClienteLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rcTxtNick, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rcTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rcTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rcTxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rcTxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rcCmbAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rcCmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rcCmbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addComponent(rcBtnImagen)
                .addGap(71, 71, 71)
                .addGroup(frmRegClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rcBtnRegistrar)
                    .addComponent(rcBtnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registrar Cliente");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(rcTxtNick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 281, -1));

        rcTxtEmail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcTxtEmail1ActionPerformed(evt);
            }
        });
        jPanel1.add(rcTxtEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 281, -1));
        jPanel1.add(rcTxtNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 281, -1));
        jPanel1.add(rcTxtApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 281, -1));
        jPanel1.add(rcTxtDireccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 281, -1));

        rcCmbAnio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcCmbAnio1ActionPerformed(evt);
            }
        });
        jPanel1.add(rcCmbAnio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 76, -1));

        rcCmbMes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcCmbMes1ActionPerformed(evt);
            }
        });
        jPanel1.add(rcCmbMes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 76, -1));

        jLabel19.setText("Mes:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        rcCmbDia1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jPanel1.add(rcCmbDia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 76, -1));

        rcBtnRegistrar1.setText("Registrar");
        rcBtnRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcBtnRegistrar1ActionPerformed(evt);
            }
        });
        jPanel1.add(rcBtnRegistrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, -1, -1));

        jLabel20.setText("Dia:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, -1, -1));

        jLabel18.setText("Año:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        jLabel11.setText("Fecha de Nacimiento:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        rcBtnImagen1.setText("Seleccionar Imagen...");
        rcBtnImagen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcBtnImagen1ActionPerformed(evt);
            }
        });
        jPanel1.add(rcBtnImagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        rcBtnCancelar1.setText("Cancelar");
        rcBtnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcBtnCancelar1ActionPerformed(evt);
            }
        });
        jPanel1.add(rcBtnCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel10.setText("Dirección:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel21.setText("Apellido:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel14.setText("Nombre:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel13.setText("Correo Electrónico:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel12.setText("NickName:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel9.setText("Complete los siguientes campos:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 244, -1));
        jPanel1.add(rcTxtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 281, -1));

        jLabel22.setText("Contraseña:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rcTxtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcTxtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rcTxtEmailActionPerformed

    private void rcBtnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcBtnImagenActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(seleccionarImagen);
        File auxImg = fileChooser.getSelectedFile();
        try {
            imagenSeleccionada = ImageIO.read(auxImg);
        } catch (IOException ex) {
            imagenSeleccionada = null;
        }
        
    }//GEN-LAST:event_rcBtnImagenActionPerformed

    private void rcBtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcBtnRegistrarActionPerformed

      //  cc.altaCliente(rcTxtNick.getText(), rcTxtEmail.getText(), rcTxtNombre.getText(), rcTxtDireccion.getText(), imagenSeleccionada, new DataFecha((int) rcCmbDia1.getSelectedItem(), (int) rcCmbDia1.getSelectedItem(), (int) rcCmbDia1.getSelectedItem() ), null);
        //  JOptionPane.showMessageDialog(null, "El cliente ha sido registrado con exito,gracias por preferirnos pibete");
        //  frmRegCliente.setVisible(false);
    }//GEN-LAST:event_rcBtnRegistrarActionPerformed

    private void rcBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcBtnCancelarActionPerformed
        frmRegCliente.setVisible(false);
    }//GEN-LAST:event_rcBtnCancelarActionPerformed

    private void rcCmbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcCmbMesActionPerformed
        if ("comboBoxChanged".equals(evt.getActionCommand())) {
            Calendar c = new GregorianCalendar((int) rcCmbAnio1.getSelectedItem(), (int) rcCmbMes1.getSelectedItem() - 1, 1);

            rcCmbDia1.removeAllItems();
            for (int i = 1; i <= c.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                rcCmbDia1.addItem(i);
            }
        }
    }//GEN-LAST:event_rcCmbMesActionPerformed

    private void rcCmbAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcCmbAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rcCmbAnioActionPerformed

    private void rcBtnImagen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcBtnImagen1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(seleccionarImagen);
        File auxImg = fileChooser.getSelectedFile();
        try {
            imagenSeleccionada = ImageIO.read(auxImg);
        } catch (IOException ex) {
            imagenSeleccionada = null;
        }
    }//GEN-LAST:event_rcBtnImagen1ActionPerformed

    private void rcBtnRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcBtnRegistrar1ActionPerformed
        if (!cc.altaCliente(rcTxtNick1.getText(), rcTxtEmail1.getText(), rcTxtContra.getText(), rcTxtNombre1.getText(), rcTxtDireccion1.getText(), rcTxtApellido1.getText(), new DataFecha((int) rcCmbAnio1.getSelectedItem(), (int) rcCmbMes1.getSelectedItem(), (int) rcCmbDia1.getSelectedItem()), imagenSeleccionada)) {
            JOptionPane.showMessageDialog(null, "El cliente ha sido registrado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "El cliente que intentó registrar ya existe, intentelo de nuevo");
        }
    }//GEN-LAST:event_rcBtnRegistrar1ActionPerformed

    private void rcBtnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcBtnCancelar1ActionPerformed
        dispose();
    }//GEN-LAST:event_rcBtnCancelar1ActionPerformed

    private void rcTxtEmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcTxtEmail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rcTxtEmail1ActionPerformed

    private void rcCmbMes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcCmbMes1ActionPerformed
        if ("comboBoxChanged".equals(evt.getActionCommand())) {
            Calendar c = new GregorianCalendar((int) rcCmbAnio1.getSelectedItem(), (int) rcCmbMes1.getSelectedItem() - 1, 1);

            rcCmbDia1.removeAllItems();
            for (int i = 1; i <= c.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                rcCmbDia1.addItem(i);
            }
        }
    }//GEN-LAST:event_rcCmbMes1ActionPerformed

    private void rcCmbAnio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcCmbAnio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rcCmbAnio1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame frmRegCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton rcBtnCancelar;
    private javax.swing.JButton rcBtnCancelar1;
    private javax.swing.JButton rcBtnImagen;
    private javax.swing.JButton rcBtnImagen1;
    private javax.swing.JButton rcBtnRegistrar;
    private javax.swing.JButton rcBtnRegistrar1;
    private javax.swing.JComboBox rcCmbAnio;
    private javax.swing.JComboBox rcCmbAnio1;
    private javax.swing.JComboBox rcCmbDia;
    private javax.swing.JComboBox rcCmbDia1;
    private javax.swing.JComboBox rcCmbMes;
    private javax.swing.JComboBox rcCmbMes1;
    private javax.swing.JTextField rcTxtApellido;
    private javax.swing.JTextField rcTxtApellido1;
    private javax.swing.JTextField rcTxtContra;
    private javax.swing.JTextField rcTxtDireccion;
    private javax.swing.JTextField rcTxtDireccion1;
    private javax.swing.JTextField rcTxtEmail;
    private javax.swing.JTextField rcTxtEmail1;
    private javax.swing.JTextField rcTxtNick;
    private javax.swing.JTextField rcTxtNick1;
    private javax.swing.JTextField rcTxtNombre;
    private javax.swing.JTextField rcTxtNombre1;
    // End of variables declaration//GEN-END:variables
}
