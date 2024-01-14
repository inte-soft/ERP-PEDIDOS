/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.inte_soft.gestionconsumibles.formularios;

import com.inte_soft.gestionconsumibles.GestionConsumibles;
import com.inte_soft.gestionconsumibles.controller.PedidosController;
import com.inte_soft.gestionconsumibles.dto.PedidoDto;
import com.inte_soft.gestionconsumibles.entity.Pedidos;
import com.inte_soft.gestionconsumibles.entity.Usuarios;
import com.inte_soft.gestionconsumibles.util.ModelarTabla;
import com.inte_soft.gestionconsumibles.util.WindowSingleton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class pedidosEspeciales extends javax.swing.JInternalFrame {

    private PedidosController pedidosController;
    private WindowSingleton windowSingleton;
    private DefaultTableModel model;
    private ModelarTabla modelarTabla;
    private List<PedidoDto> listPedidoDto;
    private Usuarios usuarios;

    /**
     * Creates new form pedidosEspeciales
     */
    public pedidosEspeciales(Usuarios usuarios) {

        initComponents();
        this.pedidosController = new PedidosController();
        this.modelarTabla = new ModelarTabla(this.jTpedidosEspeciales);
        this.model = this.modelarTabla.getModel();
        this.usuarios = usuarios;
        loadPedidosCompras();
    }
    
    public void loadPedidosCompras() {
        this.listPedidoDto = pedidosController.listPedidosCompras();
        this.model.setRowCount(0);
        for (PedidoDto pedidoDto : listPedidoDto) {
            this.model.addRow(new Object[]{
                    pedidoDto.getIdPedido(),
                    pedidoDto.getOt(),
                    pedidoDto.getFecha(),
                    pedidoDto.getPersona()
            });
        }
    }

    pedidosEspeciales(WindowSingleton WindowpedidosEspeciales) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        jTpedidosEspeciales = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Pedidos Especiales");

        jTpedidosEspeciales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# Pedido", "OT", "Fecha", "Solicitante"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTpedidosEspeciales);
        if (jTpedidosEspeciales.getColumnModel().getColumnCount() > 0) {
            jTpedidosEspeciales.getColumnModel().getColumn(0).setMinWidth(100);
            jTpedidosEspeciales.getColumnModel().getColumn(0).setMaxWidth(100);
            jTpedidosEspeciales.getColumnModel().getColumn(1).setMinWidth(100);
            jTpedidosEspeciales.getColumnModel().getColumn(1).setMaxWidth(100);
            jTpedidosEspeciales.getColumnModel().getColumn(2).setMinWidth(100);
            jTpedidosEspeciales.getColumnModel().getColumn(2).setMaxWidth(700);
            jTpedidosEspeciales.getColumnModel().getColumn(3).setMinWidth(100);
            jTpedidosEspeciales.getColumnModel().getColumn(3).setMaxWidth(1000);
        }

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("OT:");

        jTextField1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("Desplegar");
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
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(464, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(65, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //validar si hay un afila seleccionada
        if (this.jTpedidosEspeciales.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un pedido");
            return;
        }else {
            Pedidos pedidos = pedidosController.findById(
                    Integer.parseInt(this.jTpedidosEspeciales.getValueAt(
                            this.jTpedidosEspeciales.getSelectedRow(), 0).toString()));


            GestionarPedidos gestionarPedidos = new GestionarPedidos(usuarios, pedidos);
            gestionarPedidos.setModal(true);
            gestionarPedidos.setVisible(true);

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.modelarTabla.filter(this.jTextField1.getText(),1);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable jTpedidosEspeciales;
    // End of variables declaration//GEN-END:variables
}
