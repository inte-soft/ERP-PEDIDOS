/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.inte_soft.gestionconsumibles.formularios;

import com.inte_soft.gestionconsumibles.controller.PedidoConsumiblesController;
import com.inte_soft.gestionconsumibles.controller.TConsumiblesEController;
import com.inte_soft.gestionconsumibles.controller.TConsumiblesMController;
import com.inte_soft.gestionconsumibles.entity.*;
import com.inte_soft.gestionconsumibles.util.JTablePrinter;
import com.inte_soft.gestionconsumibles.util.WindowSingleton;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Inte-Soft
 */
public class GestionConsumibles extends javax.swing.JInternalFrame {

    /**
     * Creates new form GestionConsumibles
     */
    private Usuarios usuarios;
    private WindowSingleton windowSingleton;
    public GestionConsumibles(Usuarios usuarios) {
        initComponents();
        
        this.usuarios = usuarios;
    }

    public GestionConsumibles(Usuarios usuarios, WindowSingleton windowSingleton) {
        this.usuarios = usuarios;
        this.windowSingleton = windowSingleton;
        initComponents();

    }
    @Override
    public void dispose() {
        super.dispose(); //To change body of generated methods, choose Tools | Templates.
        this.windowSingleton.setCloseWindow();
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
        jTable1 = new javax.swing.JTable();
        lbOt = new javax.swing.JLabel();
        txtOt = new javax.swing.JTextField();
        cbSeleccion = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lbtipoPedido = new javax.swing.JLabel();
        cbSeleccion1 = new javax.swing.JComboBox<>();
        btnGestionar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lbOt1 = new javax.swing.JLabel();
        item = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        Imprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion Consumibles");
        setVisible(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ot", "Item", "Codigo", "Descripción", "Tipo", "Referencia", "Marca", "Unidad", "Cantidad", "Inicial y/o Adicional", "Operación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(50);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(1).setMinWidth(50);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(2).setMinWidth(50);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(3).setMinWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(900);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(900);
            jTable1.getColumnModel().getColumn(4).setMinWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(300);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(300);
            jTable1.getColumnModel().getColumn(5).setMinWidth(200);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(500);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(500);
            jTable1.getColumnModel().getColumn(6).setMinWidth(200);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(500);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(500);
            jTable1.getColumnModel().getColumn(7).setMinWidth(50);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(8).setMinWidth(50);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(9).setMinWidth(100);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(9).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(10).setMinWidth(100);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(10).setMaxWidth(200);
        }

        lbOt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbOt.setText("OT:");

        jLabel1.setText("PEDIDO:");

        lbtipoPedido.setText("TIPO PEDIDO:");

        cbSeleccion1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Pedido Inicial", "Pedido Adicional" }));

        btnGestionar.setText("Gestionar");
        btnGestionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarActionPerformed(evt);
            }
        });

        jButton1.setText("Enviar Pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbOt1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbOt1.setText("ITEM:");

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Imprimir.setText("Imprimir");
        Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbOt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtOt, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbOt1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbtipoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSeleccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGestionar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton2)
                        .addGap(31, 31, 31)
                        .addComponent(Imprimir)))
                .addGap(29, 479, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbOt)
                    .addComponent(txtOt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSeleccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGestionar)
                    .addComponent(jButton1)
                    .addComponent(lbOt1)
                    .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtipoPedido))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(Imprimir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarActionPerformed
        try {
            String item = (this.item.getText());
            Integer integer1 = 0;
            Integer integer2 = 0;
            integer1 = Integer.parseInt(item.split("\\.")[0]);
        if (item.contains(".")) {
            integer2 = Integer.parseInt(item.split("\\.")[1]);
        }
            if (integer1 < 0 || integer1 > 99 || integer2 < 0 || integer2 > 99) {
                JOptionPane.showMessageDialog(null,
                        "El item debe ser un numero con el formato 00.00",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (item.contains(",")) {
                JOptionPane.showMessageDialog(null,
                        "El item debe ser un numero con el formato 00.00",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;

            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,
                    "El item debe ser un numero con el formato 00.00",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!txtOt.getText().isBlank()
                && cbSeleccion1.getSelectedItem() != "Selecciona" 
                && !item.getText().isBlank()){
        Consumibles consumibles = new Consumibles(this.cbSeleccion.getSelectedItem().toString(),this.item.getText(), this);
        consumibles.setModal(true);
        consumibles.setVisible(true);
        this.txtOt.setEditable(false);
        this.cbSeleccion1.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(null,
                "Debe ingresar OT, Item y selecionar el tipo de pedido",
                "Advertencia", JOptionPane.WARNING_MESSAGE);            
        }   

        
    }//GEN-LAST:event_btnGestionarActionPerformed
    
    public Usuarios getUsuarios(){
        return this.usuarios;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String typeOperacionCompras = "";
        if (this.cbSeleccion1.getSelectedItem().equals("Pedido Adicional")) {
            typeOperacionCompras = "Compras Adicional";
            
        }else if(this.cbSeleccion1.getSelectedItem().equals("Pedido Inicial")){
            typeOperacionCompras = "Compras Inicial";
        }
        PedidoConsumiblesController pedidoConsumiblesController = new PedidoConsumiblesController();
        List<PedidoConsumibles> listPedidoConsumibleses = new ArrayList<>();
        if (this.jTable1.isEditing()) {
                    this.jTable1.getCellEditor().stopCellEditing();
                }
        for (int i = 0; i < this.jTable1.getRowCount(); i++) {
            PedidoConsumibles pedidoConsumibles = new PedidoConsumibles();
            
            pedidoConsumibles.setItem(jTable1.getValueAt(i, 1).toString());
            pedidoConsumibles.setCodigo(jTable1.getValueAt(i, 2).toString());
            pedidoConsumibles.setDescripcion(jTable1.getValueAt(i, 3).toString());
            pedidoConsumibles.setTipo(jTable1.getValueAt(i, 4).toString());
            pedidoConsumibles.setReferencia(jTable1.getValueAt(i, 5).toString());
            pedidoConsumibles.setMarca(jTable1.getValueAt(i, 6).toString());
            pedidoConsumibles.setUnidad(jTable1.getValueAt(i, 7).toString());
            pedidoConsumibles.setCantidad(Float.parseFloat(jTable1.getValueAt(i, 8).toString()));
            pedidoConsumibles.setRevisado(Boolean.FALSE);
            pedidoConsumibles.setAlistado(0);
            
                
           listPedidoConsumibleses.add(pedidoConsumibles);
            
        }
        List<PedidosCompras> ListPedidosCompras = new ArrayList<>();
        List<PedidoConsumibles> listPedidoConsumiblesdelete = new ArrayList<>();
        //metodo para buscar consumibles que no esten tipicos de pedidos electricos o mecanicos y meterlos en pedidos compras
        if (this.cbSeleccion.getSelectedItem().toString().equals("CONSUMIBLES ELECTRICOS") ) {
            TConsumiblesEController tConsumiblesEController = new TConsumiblesEController();
            List<TipicoConsumiblesElectricos> ListTipicoConsumiblesElectricos = tConsumiblesEController.getAll();
            for (PedidoConsumibles pc : listPedidoConsumibleses) {
                boolean isFound = false;
                for (TipicoConsumiblesElectricos tce : ListTipicoConsumiblesElectricos) {
                    if (pc.getCodigo().equals(tce.getMaster().getCodigo())) {
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    PedidosCompras pedidosCompras = new PedidosCompras();
                    pedidosCompras.setItem(pc.getItem());
                    pedidosCompras.setCodigo(pc.getCodigo());
                    pedidosCompras.setDescripcion(pc.getDescripcion());
                    pedidosCompras.setTipo(pc.getTipo());
                    pedidosCompras.setReferencia(pc.getReferencia());
                    pedidosCompras.setMarca(pc.getMarca());
                    pedidosCompras.setUnidad(pc.getUnidad());
                    pedidosCompras.setCantidad(pc.getCantidad());
                    pedidosCompras.setComprado(false);
                    ListPedidosCompras.add(pedidosCompras);
                    listPedidoConsumiblesdelete.add(pc);
                }
            }
        } else  if (this.cbSeleccion.getSelectedItem().toString().equals("CONSUMIBLES MECANICOS")){
            TConsumiblesMController tConsumiblesMController = new TConsumiblesMController();
            List<TipicoConsumiblesMecanicos> listTipicoConsumiblesMecanicos = tConsumiblesMController.getAll();
            for (PedidoConsumibles pc : listPedidoConsumibleses) {
                boolean isFound = false;
                for (TipicoConsumiblesMecanicos tcm : listTipicoConsumiblesMecanicos) {
                    if (pc.getCodigo().equals(tcm.getMaster().getCodigo())) {
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    PedidosCompras pedidosCompras = new PedidosCompras();
                    pedidosCompras.setItem(pc.getItem());
                    pedidosCompras.setCodigo(pc.getCodigo());
                    pedidosCompras.setDescripcion(pc.getDescripcion());
                    pedidosCompras.setTipo(pc.getTipo());
                    pedidosCompras.setReferencia(pc.getReferencia());
                    pedidosCompras.setMarca(pc.getMarca());
                    pedidosCompras.setUnidad(pc.getUnidad());
                    pedidosCompras.setCantidad(pc.getCantidad());
                    pedidosCompras.setComprado(false);
                    ListPedidosCompras.add(pedidosCompras);
                    listPedidoConsumiblesdelete.add(pc);
                }
            }
        }
        listPedidoConsumibleses.removeAll(listPedidoConsumiblesdelete);

        pedidoConsumiblesController.crearPedidoConsumibles(listPedidoConsumibleses,
                this.usuarios.getAreaCompania(), this.usuarios.getNombres() + " " + this.usuarios.getApellidos(),
                this.cbSeleccion1.getSelectedItem().toString(), this.txtOt.getText(),
                this.cbSeleccion.getSelectedItem().toString(), ListPedidosCompras, typeOperacionCompras);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         int rowIndex = this.jTable1.getSelectedRow();
          DefaultTableModel model =  (DefaultTableModel) jTable1.getModel();
        if(rowIndex >=0 ){
           model.removeRow(rowIndex);
            
            
        }else{
            JOptionPane.showMessageDialog(null, "No ha selecionado ningun usuario para modificar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirActionPerformed
        Date fecha = new Date();
        String header = "OT: " + this.txtOt.getText() +  "  -  "+ this.item.getText() + "    " + fecha;
        String footer = "Elabora: " + this.usuarios.getNombres() + " " + this.usuarios.getApellidos();
        JTablePrinter jTablePrinter = new JTablePrinter();
        jTablePrinter.printTable(this.jTable1, header, footer);

    }//GEN-LAST:event_ImprimirActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Imprimir;
    private javax.swing.JButton btnGestionar;
    private javax.swing.JComboBox<String> cbSeleccion;
    private javax.swing.JComboBox<String> cbSeleccion1;
    private javax.swing.JTextField item;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbOt;
    private javax.swing.JLabel lbOt1;
    private javax.swing.JLabel lbtipoPedido;
    private javax.swing.JTextField txtOt;
    // End of variables declaration//GEN-END:variables

    void tipoConsumibles(String tipo) {
        this.cbSeleccion.addItem(tipo);
    }
    public void addConsumiblesPedido(Object[] row2){
        DefaultTableModel model =  (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[jTable1.getColumnCount()];
        row[0] = this.txtOt.getText();
        row[1] = row2[0];
        row[2] = row2[1];
        row[3] = row2[2];
        row[4] = row2[3];
        row[5] = row2[4];
        row[6] = row2[5];
        row[7] = row2[6];
        row[8] = row2[7];
        row[9] = this.cbSeleccion1.getSelectedItem();
        row[10] = this.cbSeleccion.getSelectedItem();
        model.addRow(row);
    }
}
