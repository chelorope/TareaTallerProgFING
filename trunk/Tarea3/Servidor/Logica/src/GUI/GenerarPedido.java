/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Fabrica.Fabrica;
import dataTypes.DataCliente;
import dataTypes.DataPedido;
import dataTypes.DataProducto;
import dataTypes.DataRestaurante;
import entidades.Producto;
import interfaces.IControladorPedidos;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Marcelo
 */
public class GenerarPedido extends javax.swing.JInternalFrame {
    
    Fabrica F = Fabrica.getInstance();
    IControladorPedidos cp  = F.getIControladorPedidos();
    Set<DataCliente> clientes;
    Set<String> categorias;
    Set<DataRestaurante> restaurantes;
    DefaultTableModel TmodelC, TmodelR, TmodelI, TmodelP;
    DataCliente cliente;
    ListModel Lmodel;
    String categoria;
    boolean clienteSeleccionado = false;
    int precioTotal;
    
    public GenerarPedido() {
        initComponents();
        precioTotal = 0;
        Resultado.setText(String.valueOf(0));
        
        clientes = cp.listarClientes();
        TmodelC = (DefaultTableModel) ListaClientes.getModel();
        for( DataCliente DC : clientes){
            TmodelC.insertRow(TmodelC.getRowCount(), new Object[]{DC.getNick(),DC.getMail()});
        }
        
        LlenarTreeRestaurantes();
        
    }
    
     private void LlenarTreeRestaurantes(){
        
        DefaultTreeModel tm = (DefaultTreeModel) jTree.getModel();  
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) tm.getRoot();
        Set<String> cats = cp.listarCategorias();
        Iterator<String> itc = cats.iterator();
        while (itc.hasNext()){
            String cat = itc.next();
            DefaultMutableTreeNode tCat = new DefaultMutableTreeNode(cat);
            root.add(tCat);
            
            cp.seleccionarCategoria(cat);
            Set <DataRestaurante> SDR = cp.listarRestaurantesCategoria();
            Iterator<DataRestaurante> itr = SDR.iterator();
            while (itr.hasNext()){
                        DefaultMutableTreeNode tRest = new DefaultMutableTreeNode(itr.next());  
                       
                        tCat.add(tRest);
                     
            }       
          
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

        confirmacionPedido = new javax.swing.JInternalFrame();
        jDialog1 = new javax.swing.JDialog();
        precio = new javax.swing.JLabel();
        CerrarB = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        emailCliente = new javax.swing.JLabel();
        nickCliente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        productosRestaurante = new javax.swing.JTable();
        nombreRestaurante = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        codigoPedido = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        estadoPedido = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        SeleccionarRest = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        SeleccionarCliente = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaClientes = new javax.swing.JTable();
        ConfirmarPedido = new javax.swing.JButton();
        SeleccionarProductos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaIndividuales = new javax.swing.JTable();
        Resultado = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaPromociones = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        confirmacionPedido.setClosable(true);
        confirmacionPedido.setTitle("Pedido Realizado");
        confirmacionPedido.setToolTipText("");
        confirmacionPedido.setVisible(true);

        javax.swing.GroupLayout confirmacionPedidoLayout = new javax.swing.GroupLayout(confirmacionPedido.getContentPane());
        confirmacionPedido.getContentPane().setLayout(confirmacionPedidoLayout);
        confirmacionPedidoLayout.setHorizontalGroup(
            confirmacionPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );
        confirmacionPedidoLayout.setVerticalGroup(
            confirmacionPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );

        jDialog1.setTitle("Confirmacion Pedido");

        precio.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        precio.setText("precioTotal");

        CerrarB.setText("Aceptar");
        CerrarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarBActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("Precio");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nombre");

        emailCliente.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        emailCliente.setText("jLabel2");

        nickCliente.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        nickCliente.setText("jLabel1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Email");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(emailCliente)
                    .addComponent(nickCliente))
                .addGap(307, 307, 307))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nickCliente)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailCliente)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Restaurante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

        productosRestaurante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Precio Unitario", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(productosRestaurante);

        nombreRestaurante.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        nombreRestaurante.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreRestaurante))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreRestaurante)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

        codigoPedido.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        codigoPedido.setText("jLabel1");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Estado");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Fecha-Hora");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Código");

        estadoPedido.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        estadoPedido.setText("jLabel5");

        Fecha.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Fecha.setText("jLabel3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(67, 67, 67)
                        .addComponent(estadoPedido))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(39, 39, 39)
                        .addComponent(Fecha))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(66, 66, 66)
                        .addComponent(codigoPedido)))
                .addGap(307, 307, 307))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(codigoPedido))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Fecha))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(estadoPedido))
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setText("$");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(CerrarB, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel9)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precio)))
                .addGap(20, 20, 20))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precio)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(28, 28, 28)
                .addComponent(CerrarB, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Generar Pedido");
        setAutoscrolls(true);

        SeleccionarRest.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccionar Restaurante"));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Categorías");
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree.setToolTipText("");
        jTree.setAutoscrolls(true);
        jTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTreeMouseClicked(evt);
            }
        });
        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(jTree);

        javax.swing.GroupLayout SeleccionarRestLayout = new javax.swing.GroupLayout(SeleccionarRest);
        SeleccionarRest.setLayout(SeleccionarRestLayout);
        SeleccionarRestLayout.setHorizontalGroup(
            SeleccionarRestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeleccionarRestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        SeleccionarRestLayout.setVerticalGroup(
            SeleccionarRestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeleccionarRestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SeleccionarCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccionar Cliente"));

        ListaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nick", "Mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ListaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListaClientes);

        javax.swing.GroupLayout SeleccionarClienteLayout = new javax.swing.GroupLayout(SeleccionarCliente);
        SeleccionarCliente.setLayout(SeleccionarClienteLayout);
        SeleccionarClienteLayout.setHorizontalGroup(
            SeleccionarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeleccionarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );
        SeleccionarClienteLayout.setVerticalGroup(
            SeleccionarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeleccionarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        ConfirmarPedido.setText("Generar Pedido");
        ConfirmarPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmarPedidoMouseClicked(evt);
            }
        });
        ConfirmarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarPedidoActionPerformed(evt);
            }
        });

        SeleccionarProductos.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccionar Productos"));

        TablaIndividuales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Individual", "Precio", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
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
        TablaIndividuales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaIndividualesMouseClicked(evt);
            }
        });
        TablaIndividuales.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                TablaIndividualesInputMethodTextChanged(evt);
            }
        });
        TablaIndividuales.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TablaIndividualesPropertyChange(evt);
            }
        });
        jScrollPane4.setViewportView(TablaIndividuales);

        Resultado.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        Total.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Total.setText("Total:");

        TablaPromociones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Promocion", "Precio", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
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
        TablaPromociones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPromocionesMouseClicked(evt);
            }
        });
        TablaPromociones.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                TablaPromocionesInputMethodTextChanged(evt);
            }
        });
        jScrollPane5.setViewportView(TablaPromociones);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("$");

        javax.swing.GroupLayout SeleccionarProductosLayout = new javax.swing.GroupLayout(SeleccionarProductos);
        SeleccionarProductos.setLayout(SeleccionarProductosLayout);
        SeleccionarProductosLayout.setHorizontalGroup(
            SeleccionarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeleccionarProductosLayout.createSequentialGroup()
                .addGroup(SeleccionarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SeleccionarProductosLayout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(Total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SeleccionarProductosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SeleccionarProductosLayout.setVerticalGroup(
            SeleccionarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeleccionarProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SeleccionarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SeleccionarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SeleccionarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 721, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SeleccionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SeleccionarRest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ConfirmarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(287, 287, 287))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SeleccionarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SeleccionarRest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SeleccionarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConfirmarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaClientesMouseClicked
 //       try{
            clienteSeleccionado = true;
            int row = ListaClientes.getSelectedRow();
            String Nick = ListaClientes.getModel().getValueAt(row, 0).toString();
            cp.SeleccionarCliente(Nick);
            
            
           
//        }catch(Exeption e){
    //        JOptionPane.showMessageDialog(null, e);}
        // TODO add your handling code here:
    }//GEN-LAST:event_ListaClientesMouseClicked

    private void ListaCategoriasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaCategoriasValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_ListaCategoriasValueChanged

    private void ConfirmarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarPedidoActionPerformed
        //this.getParent().add(confirmacionPedido,1);
        
        
        cp.altaPedido();
        
        boolean hayProductos = false;
        int Cantidad;
        for (int i = 0; i < TablaIndividuales.getRowCount(); i++){
            
            Cantidad = (int) TablaIndividuales.getModel().getValueAt(i, 2);
            if (Cantidad > 0){
                hayProductos = true;
                cp.SeleccionarProducto((String) TablaIndividuales.getModel().getValueAt(i, 0));
                cp.agregarProducto(Cantidad);
            }
        }
        
        for (int i = 0; i < TablaPromociones.getRowCount();i++){
            Cantidad = (int) TablaPromociones.getModel().getValueAt(i, 2);
            if (Cantidad > 0){
                hayProductos = true;
                cp.SeleccionarProducto((String) TablaPromociones.getModel().getValueAt(i, 0));
                cp.agregarProducto(Cantidad);
            }
        }
        if (clienteSeleccionado){
            if (hayProductos){
                cp.AgregarPedidoACliente();
                dispose();
                DataPedido DP = cp.verInfoPedidoGenerado();
                
                jDialog1.setSize(515, 700);
                jDialog1.setVisible(true);
                
                Set<DataProducto> SDP = DP.getProductos();
                TmodelC = (DefaultTableModel) productosRestaurante.getModel();
                for( DataProducto DaP : SDP){
                    String s;
                    if(DaP.getTipo() == Producto.Individual) s = "Individual"; else s = "Promocion";
                    TmodelC.insertRow(TmodelC.getRowCount(), new Object[]{DaP.getNombre(),DaP.getCantidad(),DaP.getPrecioUnitario(),s});
                }
                
                nickCliente.setText(String.valueOf(DP.getNickCliente()));
                emailCliente.setText(String.valueOf(DP.getMail()));
                Fecha.setText(String.valueOf(DP.getFecha().toString()));
                estadoPedido.setText(String.valueOf(DP.getEstado()));
                precio.setText(String.valueOf(DP.getPrecioTotal()));
                nombreRestaurante.setText(String.valueOf(DP.getNombreRes()));
                codigoPedido.setText(String.valueOf(DP.getId()));
                
            }else showMessageDialog(null, "Debe seleccionar al menos un producto!");
        }else showMessageDialog(null, "Debe seleccionar un cliente!");
                
        
        
        // MOSTRAR LOS DATOS DEL PEDIDO CONFIRMADO EN OTRO FRAME
    }//GEN-LAST:event_ConfirmarPedidoActionPerformed

    private void TablaIndividualesInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_TablaIndividualesInputMethodTextChanged
   
    }//GEN-LAST:event_TablaIndividualesInputMethodTextChanged

    private void TablaPromocionesInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_TablaPromocionesInputMethodTextChanged
   
    }//GEN-LAST:event_TablaPromocionesInputMethodTextChanged

    private void TablaIndividualesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TablaIndividualesPropertyChange
      
    }//GEN-LAST:event_TablaIndividualesPropertyChange

    private void ConfirmarPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmarPedidoMouseClicked
   
    }//GEN-LAST:event_ConfirmarPedidoMouseClicked

    private void jTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTreeMouseClicked
        
    }//GEN-LAST:event_jTreeMouseClicked

    private void jTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeValueChanged
       
        DefaultMutableTreeNode t = (DefaultMutableTreeNode)jTree.getLastSelectedPathComponent();
        
        
       
        if (t.getLevel() == 2){
            
            //Si selecciono otro restaurante se setea Total en 0
            precioTotal = 0;
            Resultado.setText(String.valueOf(precioTotal));
            
            DataRestaurante dr = ((DataRestaurante) t.getUserObject());
            cp.SeleccionarRestaurante(dr.getNick());
             
            //obtengo los productos del restaurante seleccionado y los pongo en sus respectivas tablas
            Set<DataProducto> individuales = cp.listarProductosDelRestaurante(1);
            Set<DataProducto> promociones = cp.listarProductosDelRestaurante(2);
            
            TmodelI = (DefaultTableModel) TablaIndividuales.getModel();
            TmodelP = (DefaultTableModel) TablaPromociones.getModel();
            TmodelI.setRowCount(0);
            TmodelP.setRowCount(0);
            for( DataProducto DI : individuales){
                TmodelI.insertRow(TmodelI.getRowCount(), new Object[]{DI.getNombre(),DI.getPrecioUnitario(), 0});
            }
            for( DataProducto DP :  promociones){
                TmodelP.insertRow(TmodelP.getRowCount(), new Object[]{DP.getNombre(),DP.getPrecioUnitario(), 0});
            }
        }
    }//GEN-LAST:event_jTreeValueChanged
    
    private void TablaPromocionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPromocionesMouseClicked
        
        String cantNueva = JOptionPane.showInputDialog(rootPane, "Ingrese la cantidad deseada", "Ingresar Cantidad", JOptionPane.PLAIN_MESSAGE);
        int row = TablaPromociones.getSelectedRow();
        int cantVieja = (int) TablaPromociones.getModel().getValueAt(row, 2);
        TablaPromociones.getModel().setValueAt(Integer.parseInt(cantNueva),row, 2);
        precioTotal = precioTotal - cantVieja * ((int) TablaPromociones.getModel().getValueAt(row, 1));
        precioTotal = precioTotal + Integer.parseInt(cantNueva) * ((int) TablaPromociones.getModel().getValueAt(row, 1));
        Resultado.setText(String.valueOf(precioTotal));                // TODO add your handling code here:
        
    }//GEN-LAST:event_TablaPromocionesMouseClicked

    private void TablaIndividualesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaIndividualesMouseClicked
                       
        String cantNueva = JOptionPane.showInputDialog(rootPane, "Ingrese la cantidad deseada", "Ingresar Cantidad", JOptionPane.PLAIN_MESSAGE);
        int row = TablaIndividuales.getSelectedRow();
        int cantVieja = (int) TablaIndividuales.getModel().getValueAt(row, 2);
        TablaIndividuales.getModel().setValueAt(Integer.parseInt(cantNueva),row, 2);
        precioTotal = precioTotal - cantVieja * ((int) TablaIndividuales.getModel().getValueAt(row, 1));
        precioTotal = precioTotal + Integer.parseInt(cantNueva) * ((int) TablaIndividuales.getModel().getValueAt(row, 1));
        Resultado.setText(String.valueOf(precioTotal));

    }//GEN-LAST:event_TablaIndividualesMouseClicked

    private void CerrarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarBActionPerformed
        jDialog1.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_CerrarBActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CerrarB;
    private javax.swing.JButton ConfirmarPedido;
    private javax.swing.JLabel Fecha;
    private javax.swing.JTable ListaClientes;
    private javax.swing.JLabel Resultado;
    private javax.swing.JPanel SeleccionarCliente;
    private javax.swing.JPanel SeleccionarProductos;
    private javax.swing.JPanel SeleccionarRest;
    private javax.swing.JTable TablaIndividuales;
    private javax.swing.JTable TablaPromociones;
    private javax.swing.JLabel Total;
    private javax.swing.JLabel codigoPedido;
    private javax.swing.JInternalFrame confirmacionPedido;
    private javax.swing.JLabel emailCliente;
    private javax.swing.JLabel estadoPedido;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTree jTree;
    private javax.swing.JLabel nickCliente;
    private javax.swing.JLabel nombreRestaurante;
    private javax.swing.JLabel precio;
    private javax.swing.JTable productosRestaurante;
    // End of variables declaration//GEN-END:variables
}
