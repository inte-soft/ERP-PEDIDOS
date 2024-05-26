/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.inte_soft.gestionconsumibles.formularios;

import com.inte_soft.gestionconsumibles.controller.PedidoConsumiblesController;
import com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoOt;
import com.inte_soft.gestionconsumibles.dto.PendientesDto;
import com.inte_soft.gestionconsumibles.util.ExcelExporter;
import com.inte_soft.gestionconsumibles.util.ModelarTabla;
import com.inte_soft.gestionconsumibles.util.WindowSingleton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author alejo
 */
public class Pendientes extends javax.swing.JInternalFrame {

    private WindowSingleton windowSingleton;
    private DefaultTableModel model;
    private List<PendientesDto> consumiblesDtoOtList;

    private TableRowSorter<DefaultTableModel> sorter;

    private ModelarTabla modelarTabla;
    /**
     * Creates new form Pendientes
     */
    public Pendientes() {
        initComponents();
    }

    public Pendientes(WindowSingleton windowSingleton) {
        this.windowSingleton = windowSingleton;
        initComponents();
        this.model = modelarTabla(jTable1);
        loadPendientes();
    }
    public  DefaultTableModel modelarTabla(JTable jTable){
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        jTable.setModel(model);
        jTable.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(model);
        jTable.setRowSorter(sorter);
        return model;
    }
    @Override
    public void dispose() {
        super.dispose(); //To change body of generated methods, choose Tools | Templates.
        windowSingleton.setCloseWindow();
    }

    public void loadPendientes() {
        PedidoConsumiblesController pedidoConsumiblesController = new PedidoConsumiblesController();
        //la idea es traer todos los consumibles pendientes de alistamiento tanto electricos como mecanicos y mostrarlos en la tabla
        consumiblesDtoOtList = pedidoConsumiblesController.getConsumiblesPendientes();
        model.setRowCount(0);
        for (PendientesDto pendientesDto  : consumiblesDtoOtList) {
            model.addRow(new Object[]{
                    pendientesDto.getOt(),
                    pendientesDto.getCodigo(),
                    pendientesDto.getDescripcion(),
                    pendientesDto.getTipo(),
                    pendientesDto.getReferencia(),
                    pendientesDto.getMarca(),
                    pendientesDto.getUnidad(),
                    pendientesDto.getCantidad(),
                    pendientesDto.getAlistado(),
                    Double.parseDouble(String.format(Locale.US, "%.1f",pendientesDto.getCantidad()-pendientesDto.getAlistado())),
                    pendientesDto.getArea().replace("CONSUMIBLES ","")
            });
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
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextBuscar = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OT", "Codigo", "Descripcion", "Tipo", "Referencia", "Marca", "Unidad", "Cantidad", "Alistado", "Pendiente", "Consumibles"
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

        jButton1.setText("Exportar a Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar:");

        jTextBuscar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1255, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel1)
                    .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTable1.getRowCount()>0) {
            ExcelExporter excelExporter = new ExcelExporter();
            excelExporter.exportTable(jTable1);
        }else{
            JOptionPane.showMessageDialog(rootPane, "debes tener datos para poder exportar","Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        loadPendientes();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBuscarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextBuscarKeyReleased
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextBuscar;
    // End of variables declaration//GEN-END:variables
}
