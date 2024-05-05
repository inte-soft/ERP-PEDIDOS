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
    private ModelarTabla modelarTabla1;
    private List<PedidoDto> listPedidoDto;
    private Usuarios usuarios;
    private DefaultTableModel model2;


    /**
     * Creates new form pedidosEspeciales
     */
    public pedidosEspeciales(Usuarios usuarios, WindowSingleton windowSingleton) {

        initComponents();
        this.windowSingleton = windowSingleton;
        this.pedidosController = new PedidosController();
        this.modelarTabla = new ModelarTabla(this.jTpedidosEspeciales);
        this.modelarTabla1 = new ModelarTabla(this.jTpedidosEspeciales1);
        this.model = this.modelarTabla.getModel();
        this.model2 = this.modelarTabla1.getModel();
        this.usuarios = usuarios;
        loadPedidosCompras();
        loadPedidosComprasOk();
        // nuevo hilo con una rutina que se ejecute cada 5 minutos
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(600000);
                    loadPedidosCompras();
                    loadPedidosComprasOk();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTpedidosEspeciales = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButtonActualizar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTpedidosEspeciales1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pedidos Especiales");

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

        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonActualizar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButtonActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sin Pedir", jPanel1);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("OT:");

        jTextField2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton4.setText("Desplegar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButtonActualizar1.setText("Actualizar");
        jButtonActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizar1ActionPerformed(evt);
            }
        });

        jTpedidosEspeciales1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTpedidosEspeciales1);
        if (jTpedidosEspeciales1.getColumnModel().getColumnCount() > 0) {
            jTpedidosEspeciales1.getColumnModel().getColumn(0).setMinWidth(100);
            jTpedidosEspeciales1.getColumnModel().getColumn(0).setMaxWidth(100);
            jTpedidosEspeciales1.getColumnModel().getColumn(1).setMinWidth(100);
            jTpedidosEspeciales1.getColumnModel().getColumn(1).setMaxWidth(100);
            jTpedidosEspeciales1.getColumnModel().getColumn(2).setMinWidth(100);
            jTpedidosEspeciales1.getColumnModel().getColumn(2).setMaxWidth(700);
            jTpedidosEspeciales1.getColumnModel().getColumn(3).setMinWidth(100);
            jTpedidosEspeciales1.getColumnModel().getColumn(3).setMaxWidth(1000);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonActualizar1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButtonActualizar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pedidos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void dispose() {
        super.dispose();
        windowSingleton.setCloseWindow();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //validar si hay un afila seleccionada
        String tipo = "sinComprar";
        desplegar(this.jTpedidosEspeciales, tipo,this.usuarios);


    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void desplegar(JTable jTable, String tipo,Usuarios usuarios){
        if (jTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un pedido");
            return;
        }else {
            Pedidos pedidos = pedidosController.findById(
                    Integer.parseInt(jTable.getValueAt(
                            jTable.getSelectedRow(), 0).toString()));


            GestionarPedidos gestionarPedidos = new GestionarPedidos(usuarios, pedidos,this, tipo);
            gestionarPedidos.setModal(true);
            gestionarPedidos.setVisible(true);

        }
    }
    public void loadPedidosComprasOk(){
        this.listPedidoDto = pedidosController.listPedidosComprasOk();
        this.model2.setRowCount(0);
        for (PedidoDto pedidoDto : listPedidoDto) {
            this.model2.addRow(new Object[]{
                    pedidoDto.getIdPedido(),
                    pedidoDto.getOt(),
                    pedidoDto.getFecha(),
                    pedidoDto.getPersona()
            });
        }
        
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.modelarTabla.filter(this.jTextField1.getText(),1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        loadPedidosCompras();
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.modelarTabla1.filter(this.jTextField2.getText(),1);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String tipo = "comprado";
        desplegar(this.jTpedidosEspeciales1, tipo, this.usuarios);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButtonActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizar1ActionPerformed
        loadPedidosComprasOk();
    }//GEN-LAST:event_jButtonActualizar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonActualizar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable jTpedidosEspeciales;
    private javax.swing.JTable jTpedidosEspeciales1;
    // End of variables declaration//GEN-END:variables
}
