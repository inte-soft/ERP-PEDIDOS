/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.inte_soft.gestionconsumibles.formularios;

import com.inte_soft.gestionconsumibles.controller.PedidosComprasController;
import com.inte_soft.gestionconsumibles.entity.Pedidos;
import com.inte_soft.gestionconsumibles.entity.PedidosCompras;
import com.inte_soft.gestionconsumibles.entity.Usuarios;
import com.inte_soft.gestionconsumibles.util.JTablePrinter;
import com.inte_soft.gestionconsumibles.util.ModelarTabla;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Usuario
 */
public class GestionarPedidos extends javax.swing.JDialog {

    /**
     * Creates new form gestionarPedidos
     */

    private Usuarios usuarios;
    private PedidosComprasController pedidosComprasController;
    private ModelarTabla modelarTabla;
    private DefaultTableModel model;
    private Pedidos pedidos;
    private pedidosEspeciales pedidosEspeciales;
    private List<PedidosCompras> listPedidosCompras;


    public GestionarPedidos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public GestionarPedidos(Usuarios usuarios, Pedidos pedido, pedidosEspeciales pedidosEspeciales, String tipo ) {
        initComponents();
        this.usuarios = usuarios;
        this.pedidosComprasController = new PedidosComprasController();
        this.modelarTabla = new ModelarTabla(this.tbListadoConsumibles);
        this.model = this.modelarTabla.getModel();
        this.pedidos = pedido;
        loadPedidosCompras(this.pedidos);
        this.pedidosEspeciales = pedidosEspeciales;
        // validar si  es comprado o no y deshabilitar edicion para todas la columnas de la tabla
        if(tipo == "comprado"){

            this.tbListadoConsumibles.setEnabled(false);
            this.jButton2.setEnabled(false);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbListadoConsumibles = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar pedidos");
        setModal(true);
        setResizable(false);

        tbListadoConsumibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Item", "Codigo", "Descripción", "Tipo", "Referencia", "Marca", "Unidad", "Cant", "FechaCompra", "Comprado", "valor", "Observacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbListadoConsumibles);
        if (tbListadoConsumibles.getColumnModel().getColumnCount() > 0) {
            tbListadoConsumibles.getColumnModel().getColumn(0).setMinWidth(50);
            tbListadoConsumibles.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbListadoConsumibles.getColumnModel().getColumn(0).setMaxWidth(100);
            tbListadoConsumibles.getColumnModel().getColumn(1).setMinWidth(50);
            tbListadoConsumibles.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbListadoConsumibles.getColumnModel().getColumn(1).setMaxWidth(100);
            tbListadoConsumibles.getColumnModel().getColumn(2).setMinWidth(50);
            tbListadoConsumibles.getColumnModel().getColumn(2).setPreferredWidth(120);
            tbListadoConsumibles.getColumnModel().getColumn(2).setMaxWidth(120);
            tbListadoConsumibles.getColumnModel().getColumn(3).setMinWidth(300);
            tbListadoConsumibles.getColumnModel().getColumn(3).setPreferredWidth(900);
            tbListadoConsumibles.getColumnModel().getColumn(3).setMaxWidth(900);
            tbListadoConsumibles.getColumnModel().getColumn(4).setMinWidth(100);
            tbListadoConsumibles.getColumnModel().getColumn(4).setPreferredWidth(500);
            tbListadoConsumibles.getColumnModel().getColumn(4).setMaxWidth(500);
            tbListadoConsumibles.getColumnModel().getColumn(5).setMinWidth(100);
            tbListadoConsumibles.getColumnModel().getColumn(5).setPreferredWidth(500);
            tbListadoConsumibles.getColumnModel().getColumn(5).setMaxWidth(500);
            tbListadoConsumibles.getColumnModel().getColumn(6).setMinWidth(100);
            tbListadoConsumibles.getColumnModel().getColumn(6).setPreferredWidth(300);
            tbListadoConsumibles.getColumnModel().getColumn(6).setMaxWidth(300);
            tbListadoConsumibles.getColumnModel().getColumn(7).setMinWidth(100);
            tbListadoConsumibles.getColumnModel().getColumn(7).setPreferredWidth(300);
            tbListadoConsumibles.getColumnModel().getColumn(7).setMaxWidth(300);
            tbListadoConsumibles.getColumnModel().getColumn(8).setMinWidth(100);
            tbListadoConsumibles.getColumnModel().getColumn(8).setPreferredWidth(300);
            tbListadoConsumibles.getColumnModel().getColumn(8).setMaxWidth(300);
            tbListadoConsumibles.getColumnModel().getColumn(9).setMinWidth(100);
            tbListadoConsumibles.getColumnModel().getColumn(9).setPreferredWidth(300);
            tbListadoConsumibles.getColumnModel().getColumn(9).setMaxWidth(300);
            tbListadoConsumibles.getColumnModel().getColumn(10).setMinWidth(100);
            tbListadoConsumibles.getColumnModel().getColumn(10).setPreferredWidth(300);
            tbListadoConsumibles.getColumnModel().getColumn(10).setMaxWidth(300);
            tbListadoConsumibles.getColumnModel().getColumn(11).setMinWidth(0);
            tbListadoConsumibles.getColumnModel().getColumn(11).setPreferredWidth(0);
            tbListadoConsumibles.getColumnModel().getColumn(11).setMaxWidth(0);
            tbListadoConsumibles.getColumnModel().getColumn(12).setMinWidth(200);
            tbListadoConsumibles.getColumnModel().getColumn(12).setPreferredWidth(800);
            tbListadoConsumibles.getColumnModel().getColumn(12).setMaxWidth(800);
        }

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Codigo:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar Compras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1506, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(45, 45, 45))))
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jButton3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void stopEditing(JTable table) {
        if (table.isEditing()) {
            TableCellEditor cellEditor = table.getCellEditor();
            if (cellEditor != null) {
                cellEditor.stopCellEditing();
            }
        }
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // metodo para guardar las compras primero se valida si hay algun check seleccionado
        stopEditing(this.tbListadoConsumibles);
        Integer count = 0;
        if (this.tbListadoConsumibles.getRowCount() > 0) {
            List<PedidosCompras> listPedidosCompras = new ArrayList<>();
            List<PedidosCompras> listPedidosComprasUpdate = new ArrayList<>();

            for (int i = 0; i < this.tbListadoConsumibles.getRowCount(); i++) {
                Boolean flag = false;
                for(PedidosCompras pedidosCompras: this.listPedidosCompras){
                    if(this.tbListadoConsumibles.getValueAt(i, 2).toString()==pedidosCompras.getCodigo() && pedidosCompras.getComprado()== Boolean.TRUE){
                        flag = true;
                    }   
                }
                if(flag){
                    continue;
                }
                if ((Boolean) this.tbListadoConsumibles.getValueAt(i, 10)) {
                    // se crea el objeto pedido compra
                    PedidosCompras pedidosCompras = new PedidosCompras();
                    pedidosCompras.setId(i);
                    pedidosCompras.setId((Integer) this.tbListadoConsumibles.getValueAt(i, 0));
                    pedidosCompras.setItem( this.tbListadoConsumibles.getValueAt(i, 1).toString());
                    pedidosCompras.setCodigo(this.tbListadoConsumibles.getValueAt(i, 2).toString());
                    pedidosCompras.setDescripcion(this.tbListadoConsumibles.getValueAt(i, 3).toString());
                    pedidosCompras.setTipo(this.tbListadoConsumibles.getValueAt(i, 4).toString());
                    pedidosCompras.setReferencia(this.tbListadoConsumibles.getValueAt(i, 5).toString());
                    pedidosCompras.setMarca(this.tbListadoConsumibles.getValueAt(i, 6).toString());
                    pedidosCompras.setUnidad(this.tbListadoConsumibles.getValueAt(i, 7).toString());
                    pedidosCompras.setCantidad((Float) (this.tbListadoConsumibles.getValueAt(i, 8)));
                    pedidosCompras.setComprado((Boolean) this.tbListadoConsumibles.getValueAt(i, 10));
                    pedidosCompras.setValor((Double)this.tbListadoConsumibles.getValueAt(i, 11));

                    pedidosCompras.setPedido(this.pedidos);
                    pedidosCompras.setFechaCompra(new Date());
                    pedidosCompras.setComprador(this.usuarios.getNombres()+" "+this.usuarios.getApellidos());
                    String observacion = "";
                    if (!this.tbListadoConsumibles.getValueAt(i, 12).equals(null) ) {
                        observacion = this.tbListadoConsumibles.getValueAt(i, 12).toString();
                    }
                    pedidosCompras.setObservacion(observacion);
                    // se llama al metodo para guardar el pedido
                    listPedidosCompras.add(pedidosCompras);
                    count++;
                } else {
                    // se crea el objeto pedido compra
                    PedidosCompras pedidosCompras = new PedidosCompras();
                    pedidosCompras.setId(i);
                    pedidosCompras.setId((Integer) this.tbListadoConsumibles.getValueAt(i, 0));
                    pedidosCompras.setItem( this.tbListadoConsumibles.getValueAt(i, 1).toString());
                    pedidosCompras.setCodigo(this.tbListadoConsumibles.getValueAt(i, 2).toString());
                    pedidosCompras.setDescripcion(this.tbListadoConsumibles.getValueAt(i, 3).toString());
                    pedidosCompras.setTipo(this.tbListadoConsumibles.getValueAt(i, 4).toString());
                    pedidosCompras.setReferencia(this.tbListadoConsumibles.getValueAt(i, 5).toString());
                    pedidosCompras.setMarca(this.tbListadoConsumibles.getValueAt(i, 6).toString());
                    pedidosCompras.setUnidad(this.tbListadoConsumibles.getValueAt(i, 7).toString());
                    pedidosCompras.setCantidad((Float) (this.tbListadoConsumibles.getValueAt(i, 8)));
                    pedidosCompras.setComprado((Boolean) this.tbListadoConsumibles.getValueAt(i, 10));
                    pedidosCompras.setValor((Double)this.tbListadoConsumibles.getValueAt(i, 11));

                    pedidosCompras.setPedido(this.pedidos);
                    pedidosCompras.setFechaCompra(new Date());
                    String observacion = "";
                    if (!this.tbListadoConsumibles.getValueAt(i, 12).equals(null) ) {
                        observacion = this.tbListadoConsumibles.getValueAt(i, 12).toString();
                    }
                    pedidosCompras.setObservacion(observacion);
                    // se llama al metodo para guardar el pedido
                    listPedidosComprasUpdate.add(pedidosCompras);

                }
            }
            this.pedidosComprasController.UpdatePedidoCompras(listPedidosCompras, listPedidosComprasUpdate, this.pedidos);
            this.dispose();
        } else if (count == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un item en la casilla de comprado");
        }
        this.pedidosEspeciales.loadPedidosCompras();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.modelarTabla.filter(this.jTextField1.getText(),null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // metodo para imprimir el listado de pedidos
        Date fecha = new Date();
        String header = "OT" + this.pedidos.getOt() +
                " Item: "+ tbListadoConsumibles.getValueAt(0,1)+
                " " + fecha.toString();
        String footer = "Elabora: " + this.usuarios.getNombres() + " " + this.usuarios.getApellidos();
        JTablePrinter jTablePrinter = new JTablePrinter();
        jTablePrinter.printTable(tbListadoConsumibles, header, footer);

    }//GEN-LAST:event_jButton3ActionPerformed

    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(GestionarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionarPedidos dialog = new GestionarPedidos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void loadPedidosCompras(Pedidos pedidos){
        this.model.setRowCount(0);
        this.listPedidosCompras =this.pedidosComprasController.listPedidosCompras(pedidos);
        for (PedidosCompras pedidosCompras : listPedidosCompras) {
            Object[] fila = new Object[13];
            fila[0] = pedidosCompras.getId();
            fila[1] = pedidosCompras.getItem();
            fila[2] = pedidosCompras.getCodigo();
            fila[3] = pedidosCompras.getDescripcion();
            fila[4] = pedidosCompras.getTipo();
            fila[5] = pedidosCompras.getReferencia();
            fila[6] = pedidosCompras.getMarca();
            fila[7] = pedidosCompras.getUnidad();
            fila[8] = pedidosCompras.getCantidad();
            if(pedidosCompras.getFechaCompra()== null){
                fila[9] ="";
            }else {
            fila[9] = pedidosCompras.getFechaCompra().toString();
            }
            fila[10] = pedidosCompras.getComprado();
            fila[11] = pedidosCompras.getValor();
            if (pedidosCompras.getObservacion() == null) {
                pedidosCompras.setObservacion("");
            }
            fila[12] = pedidosCompras.getObservacion();
            

            this.model.addRow(fila);


        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbListadoConsumibles;
    // End of variables declaration//GEN-END:variables
}
