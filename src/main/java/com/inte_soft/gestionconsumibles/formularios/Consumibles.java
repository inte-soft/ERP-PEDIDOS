/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.inte_soft.gestionconsumibles.formularios;

import com.inte_soft.gestionconsumibles.controller.TConsumiblesEController;
import com.inte_soft.gestionconsumibles.controller.TConsumiblesMController;
import com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoOt;
import com.inte_soft.gestionconsumibles.entity.TipicoConsumiblesElectricos;
import com.inte_soft.gestionconsumibles.entity.TipicoConsumiblesMecanicos;
import java.awt.Frame;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Inte-Soft
 */
public class Consumibles extends javax.swing.JDialog {

    /**
     * Creates new form consumibles
     */
    private String tipoConsumibles;
    private String item;
    private gestionConsumibles gConsumibles;
    public Consumibles(String tipoConsumibles, String item, gestionConsumibles gConsumibles) {
        initComponents();
        this.tipoConsumibles = tipoConsumibles;
        this.item = item;
        this.gConsumibles = gConsumibles;
        this.loadConsumibles(this.tipoConsumibles, this.item);
    }
    
    public Consumibles(String visualizacion, List<ConsumiblesDtoOt> listcConsumiblesDtoOts) {
        initComponents();
        if(visualizacion.equals("VISUALIZACION")){
            jButton2.setVisible(false);
            jButton3.setVisible(false);
        }
        this.loadDespliegue(listcConsumiblesDtoOts);
    }

    public Consumibles() {
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListadoConsumibles = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbListadoConsumibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Item", "Codigo", "Descripción", "Tipo", "Referencia", "Marca", "Unidad", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbListadoConsumibles);

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("Subir Pedido");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("LISTADO CONSUMIBLES");

        jButton3.setText("Agregar Consumible");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(jLabel1)
                .addContainerGap(278, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (this.tbListadoConsumibles.isEditing()) {
                    this.tbListadoConsumibles.getCellEditor().stopCellEditing();
                }
        for (int i = 0; i < this.tbListadoConsumibles.getRowCount(); i++) {
            if (this.tbListadoConsumibles.getValueAt(i, 7) != null ) {
                    Object[] row = new Object[8];
                    row[0] = this.tbListadoConsumibles.getValueAt(i, 0);
                    row[1] = this.tbListadoConsumibles.getValueAt(i, 1);
                    row[2] = this.tbListadoConsumibles.getValueAt(i, 2);
                    row[3] = this.tbListadoConsumibles.getValueAt(i, 3);
                    row[4] = this.tbListadoConsumibles.getValueAt(i, 4);
                    row[5] = this.tbListadoConsumibles.getValueAt(i, 5);
                    row[6] = this.tbListadoConsumibles.getValueAt(i, 6);
                    row[7] = this.tbListadoConsumibles.getValueAt(i, 7);
                    
                    
                    gConsumibles.addConsumiblesPedido(row);
                
                
                
            }
            
        }
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        AgregarConsumible agregarConsumible = new AgregarConsumible(new Frame(), true, this.tbListadoConsumibles);
        agregarConsumible.setVisible(true);
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
            java.util.logging.Logger.getLogger(Consumibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consumibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consumibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consumibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consumibles().setVisible(true);
            }
        });
    }
    
    public void loadConsumibles(String tipoConsumible, String item){        
        DefaultTableModel model =  (DefaultTableModel) tbListadoConsumibles.getModel();
        if (tipoConsumible == "CONSUMIBLES ELECTRICOS") {
            TConsumiblesEController cosnumiblesE = new TConsumiblesEController();
            List<TipicoConsumiblesElectricos> listConsumiblesElectricos = cosnumiblesE.getAll();
            model.setRowCount(0);
            for(TipicoConsumiblesElectricos consumiblesElectricos: listConsumiblesElectricos ){
                Object[] rowData = {
                    item,
                    consumiblesElectricos.getMaster().getCodigo(),
                    consumiblesElectricos.getMaster().getDescripcion(),
                    consumiblesElectricos.getMaster().getTipo(),
                    consumiblesElectricos.getMaster().getReferencia(),
                    consumiblesElectricos.getMaster().getMarca(),
                    consumiblesElectricos.getMaster().getUnidad(),
                };
                model.addRow(rowData);
            }
                
        }else if(tipoConsumible == "CONSUMIBLES MECANICOS") {
            TConsumiblesMController cosnumiblesM = new TConsumiblesMController();
            List<TipicoConsumiblesMecanicos> listConsumiblesMecanicos = cosnumiblesM.getAll();
            model.setRowCount(0);
            for(TipicoConsumiblesMecanicos consumiblesMecanicos: listConsumiblesMecanicos ){
                Object[] rowData = {
                    item,
                    consumiblesMecanicos.getMaster().getCodigo(),
                    consumiblesMecanicos.getMaster().getDescripcion(),
                    consumiblesMecanicos.getMaster().getMarca(),
                    consumiblesMecanicos.getMaster().getTipo(),
                    consumiblesMecanicos.getMaster().getReferencia(),
                    consumiblesMecanicos.getMaster().getUnidad(),
                };
                model.addRow(rowData);
            }
        }
    }
    public void loadDespliegue(List<ConsumiblesDtoOt> listcConsumiblesDtoOts){
        DefaultTableModel model =  (DefaultTableModel) tbListadoConsumibles.getModel();
        for (ConsumiblesDtoOt consumiblesDto : listcConsumiblesDtoOts) {
            Object[] rowData  = {
                consumiblesDto.getItem(),
                consumiblesDto.getCodigo(),
                consumiblesDto.getDescripcion(),
                consumiblesDto.getTipo(),
                consumiblesDto.getReferencia(),
                consumiblesDto.getMarca(),
                consumiblesDto.getUnidad(),
                consumiblesDto.getCantidad()
            };
                
        
            model.addRow(rowData);
        
        }
    }
    public  JTable getTable(){
        return this.tbListadoConsumibles;
    }
           
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbListadoConsumibles;
    // End of variables declaration//GEN-END:variables
}
