/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Fabrica.Fabrica;
import dataTypes.DataPedido;
import dataTypes.Estado;
import interfaces.IControladorPedidos;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fabian
 */
public class ActualizarEstadoPedido extends javax.swing.JInternalFrame {

    Fabrica F = Fabrica.getInstance();
    IControladorPedidos cp  = F.getIControladorPedidos();
    String clienteActual;
    int pedidoActual;
    Estado estadoActual, estadoNuevo;
       
    public ActualizarEstadoPedido() {
        initComponents();
        frmSelecEstado.setVisible(false);
        
        DefaultTableModel tablaE = (DefaultTableModel) TablaEstados.getModel();
        
        tablaE.setRowCount(0);
        tablaE.addRow(new Object[]{Estado.Enviado});
        tablaE.addRow(new Object[]{Estado.Recibido});
        
        DefaultTableModel tabla = (DefaultTableModel) TablaPedidosAct.getModel();
        tabla.setRowCount(0);
        
        Set<DataPedido> sdp = cp.listarPedidos();
        for(DataPedido dp : sdp){
            tabla.addRow(new Object[]{dp.getId(), dp.getNickCliente(), dp.getNickRestaurante(), dp.getFecha(),
                dp.getEstado()});
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPedidosAct = new javax.swing.JTable();
        frmSelecEstado = new javax.swing.JInternalFrame();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaEstados = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Actualizar Estado Pedido");
        setAutoscrolls(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Seleccione un Pedido:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 31, -1, -1));

        TablaPedidosAct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nro Id", "Cliente", "Restaurante", "Fecha", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaPedidosAct);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 56, -1, 108));

        frmSelecEstado.setTitle("Seleccione el nuevo Estado");
        frmSelecEstado.setVisible(true);

        jButton2.setText("Seleccionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        TablaEstados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Estados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaEstados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaEstadosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TablaEstados);

        javax.swing.GroupLayout frmSelecEstadoLayout = new javax.swing.GroupLayout(frmSelecEstado.getContentPane());
        frmSelecEstado.getContentPane().setLayout(frmSelecEstadoLayout);
        frmSelecEstadoLayout.setHorizontalGroup(
            frmSelecEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmSelecEstadoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(frmSelecEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        frmSelecEstadoLayout.setVerticalGroup(
            frmSelecEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmSelecEstadoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        getContentPane().add(frmSelecEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, 222));

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 190, -1, -1));

        jButton3.setText("Cerrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 231, 79, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DefaultTableModel tabla = (DefaultTableModel) TablaPedidosAct.getModel();
        cp.seleccionarPedido((int) tabla.getValueAt(TablaPedidosAct.getSelectedRow(), 0));
        estadoActual = (Estado) tabla.getValueAt(TablaPedidosAct.getSelectedRow(), 4);
        if(estadoActual == Estado.Recibido)
        JOptionPane.showMessageDialog(null, "El pedido ya ha sido entregado");
        else if(estadoActual == Estado.Enviado){
            cp.actualizarEstadoPedido(Estado.Recibido, null);
            tabla.setValueAt(cp.verInfoPedido().getEstado(), TablaPedidosAct.getSelectedRow(), 4);
            JOptionPane.showMessageDialog(null, "El estado del pedido ha sido cambiado a \"Recibido\"");
        }
        else{
            jButton2.setEnabled(false);
            frmSelecEstado.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel tablaP = (DefaultTableModel) TablaPedidosAct.getModel();

        estadoNuevo = (Estado) TablaEstados.getValueAt(TablaEstados.getSelectedRow(), 0);
        
        cp.actualizarEstadoPedido(estadoNuevo, null);
        tablaP.setValueAt(cp.verInfoPedido().getEstado(), TablaPedidosAct.getSelectedRow(), 4);
        JOptionPane.showMessageDialog(null, "El estado del pedido ha sido cambiado a " + estadoNuevo);
        frmSelecEstado.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TablaEstadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaEstadosMouseClicked
        jButton2.setEnabled(true);
    }//GEN-LAST:event_TablaEstadosMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEstados;
    private javax.swing.JTable TablaPedidosAct;
    private javax.swing.JInternalFrame frmSelecEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
