/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Fabrica.Fabrica;
import dataTypes.DataCantInd;
import dataTypes.DataPedido;
import dataTypes.DataProducto;
import interfaces.IControladorRestaurantes;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fede
 */
public class VerInfoProducto extends javax.swing.JInternalFrame {

    Fabrica f = Fabrica.getInstance();
    IControladorRestaurantes cr = f.getIControladorRestaurantes();

    /**
     * Creates new form VerInfoProducto
     */
    public VerInfoProducto() {
        initComponents();
        txtDescripcion1.setLineWrap(true);
        LlenarTablaProductos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion1 = new javax.swing.JTextArea();
        txtPrecio = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        chkActiva = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblPromo = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProductosPromo = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Ver Información de Producto");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Restaurante", "Nick"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProductos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 560));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Producto"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseClicked(evt);
            }
        });

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Precio", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPedidosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPedidos);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 450, 150));

        txtDescripcion1.setEditable(false);
        txtDescripcion1.setBackground(new java.awt.Color(240, 240, 240));
        txtDescripcion1.setColumns(20);
        txtDescripcion1.setRows(2);
        txtDescripcion1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtDescripcion1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 230, 70));

        txtPrecio.setEditable(false);
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 75, 230, -1));

        txtNombre.setEditable(false);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 230, -1));

        chkActiva.setText("Promoción Activa");
        chkActiva.setEnabled(false);
        jPanel1.add(chkActiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        jLabel3.setText("Producto:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        jLabel8.setText("Precio:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 75, -1, -1));

        lblPromo.setText("Productos en la promoción:");
        jPanel1.add(lblPromo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        lblImagen.setBackground(new java.awt.Color(204, 204, 204));
        lblImagen.setIconTextGap(0);
        lblImagen.setOpaque(true);
        jPanel1.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, 120));

        tblProductosPromo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductosPromo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosPromoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblProductosPromo);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, 140));

        jLabel9.setText("Descripción:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 490, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed
    private void LlenarTablaProductos() {

        DefaultTableModel tm = (DefaultTableModel) tblProductos.getModel();

        tm.setRowCount(0);
        Set<DataProducto> productos = cr.listarProductos();

        Iterator<DataProducto> it = productos.iterator();
        while (it.hasNext()) {
            DataProducto dp = it.next();
            tm.addRow(new Object[]{dp.getNombre(), dp.getNombreRes(), dp.getNickRestaurante()});
        }
        tblProductos.removeColumn(tblProductos.getColumnModel().getColumn(2));
    }

    private void LlenarDatosProducto() {
        DataProducto dp = cr.verInfoProducto();
        txtNombre.setText(dp.getNombre());
        chkActiva.setSelected(dp.getAcivada());
        txtDescripcion1.setText(dp.getDescripcion());
        txtPrecio.setText(Integer.toString(dp.getPrecioUnitario()));
        if (!"".equals(dp.getImagen())){
                try {
           
             BufferedImage img = ImageIO.read(new File(dp.getImagen()));
             lblImagen.setIcon(new ImageIcon(img.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
            } 
            catch (IOException e) {
                 e.getMessage();
            }       
        }
        else
            lblImagen.setIcon(null);
   

    }

    private void LlenarTablaPedidos() {
        DefaultTableModel tm = (DefaultTableModel) tblPedidos.getModel();

        tm.setRowCount(0);
        Set<DataPedido> pedidos = cr.mostrarPedidosQueLoContienen();

        Iterator<DataPedido> it = pedidos.iterator();
        while (it.hasNext()) {

            DataPedido dp = it.next();

            tm.addRow(new Object[]{dp.getNickCliente(), dp.getPrecioTotal(), dp.getFecha().toString()});
        }

    }

    private void LlenarTablaProductosPromo() {
        DefaultTableModel tm = (DefaultTableModel) tblProductosPromo.getModel();

        tm.setRowCount(0);
        Set<DataCantInd> productos = cr.verInfoProducto().getIndividuales();

        Iterator<DataCantInd> it = productos.iterator();
        while (it.hasNext()) {

            DataCantInd dp = it.next();

            tm.addRow(new Object[]{dp.getIndividual().getNombre(), dp.getCantidad()});
        }
    }

    private void tblPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidosMouseClicked


    }//GEN-LAST:event_tblPedidosMouseClicked

    private void jScrollPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane3MouseClicked

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        DefaultTableModel tm = (DefaultTableModel) tblProductos.getModel();

        cr.seleccionarRestaurante(tm.getValueAt(tblProductos.getSelectedRow(), 2).toString());
        cr.seleccionarProductoDeRestaurante(tm.getValueAt(tblProductos.getSelectedRow(), 0).toString());

        LlenarDatosProducto();
        LlenarTablaPedidos();
        if (cr.verInfoProducto().getTipo() == 1) {
            jScrollPane4.setVisible(true);
            lblPromo.setVisible(true);
            chkActiva.setVisible(true);
            LlenarTablaProductosPromo();
        } else {
            tm = (DefaultTableModel) tblProductosPromo.getModel();
            jScrollPane4.setVisible(false);
            lblPromo.setVisible(false);

            tm.setRowCount(0);
            chkActiva.setVisible(false);
        }


    }//GEN-LAST:event_tblProductosMouseClicked

    private void tblProductosPromoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosPromoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblProductosPromoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkActiva;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblPromo;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTable tblProductosPromo;
    private javax.swing.JTextArea txtDescripcion1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
