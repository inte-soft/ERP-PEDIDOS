/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.inte_soft.gestionconsumibles.formularios;

import com.inte_soft.gestionconsumibles.controller.PedidoConsumiblesController;
import com.inte_soft.gestionconsumibles.controller.PedidosController;
import com.inte_soft.gestionconsumibles.dto.ConsumiblesDto;
import com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoOt;
import com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoRev;
import com.inte_soft.gestionconsumibles.dto.PedidoConsumiblesDto;
import com.inte_soft.gestionconsumibles.entity.PedidoConsumibles;
import com.inte_soft.gestionconsumibles.entity.Pedidos;
import com.inte_soft.gestionconsumibles.entity.Usuarios;
import com.inte_soft.gestionconsumibles.util.CustomRowRenderer;
import com.inte_soft.gestionconsumibles.util.ExcelExporter;
import com.inte_soft.gestionconsumibles.util.JTablePrinter;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Inte-Soft
 */
public class PedidosAlmacen extends javax.swing.JInternalFrame {

    /**
     * Creates new form PedidosAlmacen
     * inicializar proyecto
     */
    private  Usuarios usuario;
    private HashMap<Integer, ArrayList<?>> map;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    private DefaultTableModel model4;
    private DefaultTableModel model6;
    private TableRowSorter<DefaultTableModel> sorter;
    private List<Pedidos> listPedidos;
    private List<Integer> listOts;
    public PedidosAlmacen(String departamento, Usuarios usuario) {
        initComponents();
        map = new HashMap<>();
        listOts = new ArrayList<>();
        jLabel7.setText("");
        this.verPedidos();
        if(departamento == "Produccion"){
            this.jTabbedPane1.removeTabAt(3);
            this.jTabbedPane1.removeTabAt(2);
            this.jTabbedPane1.removeTabAt(0);
            
            
        }
        this.usuario = usuario;
        this.model1 = modelarTabla(jTable1);
        
        Runnable tarea = () -> {
       this.verPedidos();
    };

    // Programa la tarea para ejecutarse cada 5 minutos
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    scheduler.scheduleAtFixedRate(tarea, 0, 5, TimeUnit.MINUTES);
    }
    public DefaultTableModel modelarTabla(JTable jTable){
        DefaultTableModel model =  (DefaultTableModel) jTable.getModel();
        jTable.setModel(model);
        jTable.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(model);
        jTable.setRowSorter(sorter);
        return model;
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tbn_verPedido = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTxtOt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtDescripcion = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jBDesplegar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jBImprimir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jBExport = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextOtSearch = new javax.swing.JTextField();
        jBSearch = new javax.swing.JButton();
        jBExportByOt = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pedidos Almacen");
        setToolTipText("");
        setName(""); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# Pedido", "OT", "Fecha", "Solicitante", "Tipo Pedido", "Visto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(5).setMinWidth(0);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        tbn_verPedido.setText("Ver Pedido");
        tbn_verPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbn_verPedidoActionPerformed(evt);
            }
        });

        jLabel4.setText("Busqueda");

        jTextSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextSearchKeyReleased(evt);
            }
        });

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1129, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tbn_verPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(35, 35, 35))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbn_verPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pedidos", jPanel1);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OT", "Codigo", "Descripcion", "Tipo", "Referencia", "Marca", "Unidad", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setMinWidth(25);
            jTable4.getColumnModel().getColumn(1).setMinWidth(50);
            jTable4.getColumnModel().getColumn(2).setMinWidth(300);
            jTable4.getColumnModel().getColumn(6).setMinWidth(20);
            jTable4.getColumnModel().getColumn(7).setMinWidth(5);
        }

        jLabel1.setText("OT:");

        jLabel2.setText("Descripcion:");

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jBDesplegar.setText("Desplegar");
        jBDesplegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDesplegarActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo Pedido");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "CONSUMIBLES ELECTRICOS", "CONSUMIBLES MECANICOS" }));

        jBImprimir.setText("Imprimir");
        jBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1129, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtOt, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBDesplegar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTxtOt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jTxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBDesplegar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Busqueda", jPanel2);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Marca", "Tipo", "Referencia", "Unidad", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable6);

        jBExport.setText("Exportar a Excel");
        jBExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExportActionPerformed(evt);
            }
        });

        jBActualizar.setText("Actualizar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1129, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jBExport, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBActualizar)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBExport, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Revision Total", jPanel3);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OT", "Codigo", "Descripcion", "Marca", "Tipo", "Referencia", "Unidad", "Cantidad"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel5.setText("OT");

        jBSearch.setText("Buscar");
        jBSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSearchActionPerformed(evt);
            }
        });

        jBExportByOt.setText("Exportar a Excel");
        jBExportByOt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExportByOtActionPerformed(evt);
            }
        });

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setText("OTs:");

        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1135, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextOtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSearch)
                        .addGap(33, 33, 33)
                        .addComponent(jBExportByOt)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextOtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBExportByOt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSearch)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Revision OT", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String ot = jTextOtSearch.getText();
        
        if(!ot.isEmpty()){
            String textoOts = jLabel7.getText();
            if (textoOts.isEmpty()) {
                jLabel7.setText(textoOts + ot);
                listOts.add(Integer.parseInt(ot));
                
            }else{
                jLabel7.setText(textoOts+", " +ot);
                listOts.add(Integer.parseInt(ot));
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Debe escribir una OT en el campo de OTs para poder agregarlas a la busqueda", "Advertencia", JOptionPane.WARNING_MESSAGE);

        }
        jTextOtSearch.setText("");

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jBExportByOtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExportByOtActionPerformed
        export(this.jTable2);
    }//GEN-LAST:event_jBExportByOtActionPerformed

    private void jBSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSearchActionPerformed
        
        updatePedidosSinRevisarOts(jTable2, listOts);
        listOts.clear();
        jLabel7.setText("");
    }//GEN-LAST:event_jBSearchActionPerformed

    private void jBExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExportActionPerformed
        export(this.jTable6);
    }//GEN-LAST:event_jBExportActionPerformed

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
        Date fecha = new Date();
        String header = "OT: " + this.jTable4.getValueAt(0, 0).toString() + "     " + fecha;
        String footer = "Elabora: " + this.usuario.getNombres() + " " + this.usuario.getApellidos();
        JTablePrinter jTablePrinter = new JTablePrinter();
        jTablePrinter.printTable(this.jTable4, header, footer);

    }//GEN-LAST:event_jBImprimirActionPerformed

    private void jBDesplegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDesplegarActionPerformed
        int row = this.jTable4.getSelectedRow();
        if(row>=0){
            PedidoConsumiblesController pedidoConsumiblesController = new PedidoConsumiblesController();
            String ot = this.jTable4.getValueAt(row, 0).toString();
            List<ConsumiblesDtoOt> listConsumiblesDtoOt = pedidoConsumiblesController.consumiblesPedidosSearcFilter(
                Integer.parseInt(this.jTable4.getValueAt(row, 0).toString()), this.jComboBox1.getSelectedItem().toString());
            Consumibles consumibles = new Consumibles("VISUALIZACION",
                listConsumiblesDtoOt, this.usuario, ot);
            consumibles.setVisible(true);

        }else{
            JOptionPane.showMessageDialog(null, "Debe Seleccionar una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jBDesplegarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if(!this.jTxtOt.getText().isBlank() || !this.jTxtDescripcion.getText().isBlank()){
            PedidoConsumiblesController pedidoConsumiblesController = new PedidoConsumiblesController();
            DefaultTableModel model =  (DefaultTableModel) jTable4.getModel();
            model.setRowCount(0);
            List<ConsumiblesDto> listConsumiblesDto = pedidoConsumiblesController.consumiblesPedidosSearch(
                Integer.parseInt(this.jTxtOt.getText()), this.jTxtDescripcion.getText(),
                this.jComboBox1.getSelectedItem().toString());
            for (ConsumiblesDto consumiblesDto : listConsumiblesDto) {
                Object[] rowData  = {
                    consumiblesDto.getOt(),
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
        }else{
            JOptionPane.showMessageDialog(null, "Debe diligenciar una OT o una Descripcion", "Advertencia", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        model.setNumRows(0);
        this.verPedidos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextSearchKeyReleased
        filter();
    }//GEN-LAST:event_jTextSearchKeyReleased

    private void tbn_verPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbn_verPedidoActionPerformed
        int row = this.jTable1.getSelectedRow();
        if(row>=0){
            PedidoConsumiblesController pedidoConsumiblesController = new PedidoConsumiblesController();
            String ot = this.jTable1.getValueAt(row, 1).toString();
            List<PedidoConsumiblesDto> listPedidoConsumiblesDto = pedidoConsumiblesController.findByIdPedido(
                Integer.parseInt(this.jTable1.getValueAt(row, 0).toString()));
            Consumibles consumibles = new Consumibles( listPedidoConsumiblesDto,this.usuario,ot);
            consumibles.setVisible(true);
            Pedidos pedido = new Pedidos();
            PedidosController pedidosController = new PedidosController();
            for(Pedidos pedidos : this.listPedidos){
                int idList = pedidos.getIdPedido();
                int id = Integer.parseInt(this.jTable1.getValueAt(row, 0).toString());
                if(id == idList){
                    pedido = pedidos;
                    break;
                }
            }

            pedido.setVisto(Boolean.TRUE);
            pedidosController.updatePedido(pedido);
            this.verPedidos();

        }else{
            JOptionPane.showMessageDialog(null, "Debe Seleccionar una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_tbn_verPedidoActionPerformed
    private void export(JTable jTable){
        ExcelExporter excelExporter = new ExcelExporter();
        excelExporter.exportTable(jTable);
        List<Pedidos> listPedidos = (List<Pedidos>) this.map.get(1);
        PedidosController pedidosController = new PedidosController();
        model2 = modelarTabla(jTable2);
        model2.setRowCount(0);
        model6 = modelarTabla(jTable6);
        model6.setRowCount(0);
        pedidosController.applyCheck(listPedidos);
    }    private void filter(){
        try {
            sorter.setRowFilter(RowFilter.regexFilter(this.jTextSearch.getText()));
            
        }catch(Exception e){
            
        }
    }
    public void verPedidos(){
        PedidosController pedidosController = new PedidosController();
        DefaultTableModel model =  (DefaultTableModel) jTable1.getModel();
        this.listPedidos = pedidosController.listPedidosWhithoutRevision(0);
        model.setNumRows(0);
        // Crea una instancia de tu CustomCellRenderer
        Font customFont = new Font("Arial", Font.BOLD, 14);
        Color customColor = Color.BLUE;
        CustomRowRenderer customRowRenderer = new CustomRowRenderer(customFont, customColor);
        jTable1.setDefaultRenderer(Object.class, customRowRenderer);
        for (Pedidos pedidos : this.listPedidos) {
            Object[] rowData  = {
                pedidos.getIdPedido(),
                pedidos.getOt(),
                pedidos.getFecha(),
                pedidos.getPersona(),
                pedidos.getOperacion(),
                pedidos.isVisto()
            };
            model.addRow(rowData);
            
        }
    }
    private void updatePedidosSinRevisarOts(JTable table, List<Integer> ots){
        PedidoConsumiblesController pedidoConsumiblesController = new PedidoConsumiblesController();
        DefaultTableModel model =  (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        map = pedidoConsumiblesController.consumiblesWhithoutCheck(ots);
        if(this.map == null){
            return;
        }
        ArrayList<ConsumiblesDtoRev> listConsumiblesDtoRevs = (ArrayList<ConsumiblesDtoRev>) map.get(2);
        for (ConsumiblesDtoRev consumiblesDto : listConsumiblesDtoRevs) {
            Object[] rowData  = {
                consumiblesDto.getOt(),
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBDesplegar;
    private javax.swing.JButton jBExport;
    private javax.swing.JButton jBExportByOt;
    private javax.swing.JButton jBImprimir;
    private javax.swing.JButton jBSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextOtSearch;
    private javax.swing.JTextField jTextSearch;
    private javax.swing.JTextField jTxtDescripcion;
    private javax.swing.JTextField jTxtOt;
    private javax.swing.JButton tbn_verPedido;
    // End of variables declaration//GEN-END:variables
}
