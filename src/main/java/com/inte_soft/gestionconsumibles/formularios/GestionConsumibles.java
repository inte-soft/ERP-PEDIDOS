/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.inte_soft.gestionconsumibles.formularios;

import javax.swing.JFrame;

/**
 *
 * @author Inte-Soft
 */
public class GestionConsumibles extends javax.swing.JInternalFrame {

    /**
     * Creates new form gestionConsumibles
     */
    private JFrame jFrame;
    public GestionConsumibles(JFrame jFrame) {
        initComponents();
        this.jFrame = jFrame;
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

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion Consumibles");
        setVisible(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ot", "Item", "Codigo", "Descripción", "Tipo", "Referencia", "Marca", "Unidad", "Cantidad", "Valor", "Inicial y/o Adicional", "Fecha", "Operación", "Revisado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        lbOt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbOt.setText("OT:");

        jLabel1.setText("PEDIDO:");

        lbtipoPedido.setText("TIPO PEDIDO:");

        cbSeleccion1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Pedido Inicial", "Pedido Adicional" }));

        btnGestionar.setText("Gestionar");
        btnGestionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGestionarMouseClicked(evt);
            }
        });
        btnGestionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarActionPerformed(evt);
            }
        });

        jButton1.setText("Enviar Pedido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbOt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtOt, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbtipoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbSeleccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGestionar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbOt)
                    .addComponent(txtOt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbSeleccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtipoPedido)
                    .addComponent(cbSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGestionar)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnGestionarActionPerformed

    private void btnGestionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionarMouseClicked
        // TODO add your handling code here:
        Consumibles consumibles = new Consumibles();
        consumibles.setModal(true);
        consumibles.setVisible(true);
    }//GEN-LAST:event_btnGestionarMouseClicked
    public void tipoConsumibles(String item){
        this.cbSeleccion.addItem(item);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGestionar;
    private javax.swing.JComboBox<String> cbSeleccion;
    private javax.swing.JComboBox<String> cbSeleccion1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbOt;
    private javax.swing.JLabel lbtipoPedido;
    private javax.swing.JTextField txtOt;
    // End of variables declaration//GEN-END:variables
}
