/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import PersistanceEntities.DataPersProds;
import PersistanceEntities.DataPersistencia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;
import publicar.DataFecha;
import publicar.DataPedido;
import publicar.DataProducto;
import publicar.Estado;
import publicar.PublicadorMovil;
import publicar.PublicadorMovilService;

/**
 *
 * @author ut603269
 */
public class VerPedidos extends javax.swing.JInternalFrame {
    
    PublicadorMovilService service; 
    PublicadorMovil port; 
  
    public VerPedidos() {
        try{
            service = new PublicadorMovilService(Main.cargarURL());
            port = service.getPublicadorMovilPort();    
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        
        
        initComponents();
        LlenarTablaPedidos();
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
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Seleccione un pedido:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Estado", "Cliente", "Direccion"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Datos del pedido:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio Unitario", "Tipo", "Cantidad", "SubTotal"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Estado", "Fecha"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JDesktopPane esc = (JDesktopPane) this.getParent();
        this.dispose();
        Menu men = new Menu();
        esc.add(men);
        men.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();        
        try{
            DataPedido pedidoActual = port.getPedido((int) tm.getValueAt(jTable1.getSelectedRow(), 0));
            LlenarTablaProductos(pedidoActual);
        }catch(Exception e){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("MovilPU");
            EntityManager em = emf.createEntityManager();
            
            List<DataPersProds> productos = em.createQuery("SELECT a FROM DataPersProds a").getResultList();
         
            List<DataPersistencia> pedidos = em.createQuery("SELECT a FROM DataPersistencia a").getResultList();
        
            int id = (int) tm.getValueAt(jTable1.getSelectedRow(), 0);
            
            tm = (DefaultTableModel) jTable2.getModel();
            tm.setRowCount(0);     
            for (DataPersProds dprod : productos){
                if(dprod.getPedido() == id){
                    String tipo;
                    if (dprod.getTipo().equals("Individual"))
                             tipo = "Individual";
                    else
                             tipo = "Promoción";
                    tm.addRow(new Object[] {dprod.getNombre(), dprod.getPrecioU(), tipo, dprod.getCantidad(), dprod.getSubTotal()});
                    
                }
            }   
            DefaultTableModel te = (DefaultTableModel) jTable3.getModel();
            te.setRowCount(0);

            for(DataPersistencia ped : pedidos){
                if(ped.getIdP() == id){
                String fecha = ped.getFechaPreparacion();
                    te.addRow(new Object[] {"preparacion",fecha});
                    if (ped.getFechaEnviado() != null){
                        String fecha1 = (String) ped.getFechaEnviado(); 
                        te.addRow(new Object[] {"enviado", fecha1});
                        }
                    if (ped.getFechaRecibido() != null){
                        String fecha2 = (String) ped.getFechaRecibido();
                        te.addRow(new Object[] {"recibido", fecha2});
                    }
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked
      private void LlenarTablaPedidos() {
        DefaultTableModel tablaP = (DefaultTableModel) jTable1.getModel();
        try{
            List <DataPedido> pedidos = port.getPedidos().getItem();
            System.out.println(pedidos.size());

            for (DataPedido dp : pedidos){        
                tablaP.addRow(new Object[]{dp.getIdP(), dp.getEstado().toString(),dp.getNickCli(), dp.getDirCliente()});
            }   
        }catch(Exception e){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("MovilPU");
            EntityManager em = emf.createEntityManager();
            List <DataPersistencia> ress = em.createQuery("SELECT a FROM DataPersistencia a").getResultList();
            for(DataPersistencia dp : ress){
                tablaP.addRow(new Object[]{dp.getIdP(), dp.getEstado(),dp.getNickCliente(), dp.getDirCliente()});
            }
        }   
    }
      private void LlenarTablaProductos(DataPedido dp) {
        List<DataProducto> productos = dp.getProductos();
        
        DefaultTableModel tm = (DefaultTableModel) jTable2.getModel();
        tm.setRowCount(0);       
        int idp = dp.getIdP();
        for (DataProducto dprod : productos){
            String tipo;
            if (dprod.getTipo() == 0)
                     tipo = "Individual";
            else
                     tipo = "Promoción";
            tm.addRow(new Object[] {dprod.getNombre(), dprod.getPrecio(), tipo, dprod.getCantidad(), dprod.getPrecio()*dprod.getCantidad()});
        }   
        DefaultTableModel te = (DefaultTableModel) jTable3.getModel();
        te.setRowCount(0);
        
        String fecha = dp.getEstados().get(0).getDia() + "/" + dp.getEstados().get(0).getMes() + "/" + dp.getEstados().get(0).getAnio();
        te.addRow(new Object[] {"PREPARACION",fecha});
        if (dp.getEstados().get(1) != null){
            String fecha1 = dp.getEstados().get(1).getDia() + "/" + dp.getEstados().get(1).getMes() + "/" + dp.getEstados().get(1).getAnio();
            fecha1 = fecha1 + "-" + dp.getEstados().get(1).getHora() + ":" + dp.getEstados().get(1).getMinuto();
            te.addRow(new Object[] {"ENVIADO", fecha1});
            }
        if (dp.getEstados().get(2) != null){
            String fecha2 = dp.getEstados().get(2).getDia() + "/" + dp.getEstados().get(2).getMes() + "/" + dp.getEstados().get(2).getAnio();
            fecha2 = fecha2 + "-" + dp.getEstados().get(2).getHora() + ":" + dp.getEstados().get(2).getMinuto();
            te.addRow(new Object[] {"RECIBIDO", fecha2});
            }
     } 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}