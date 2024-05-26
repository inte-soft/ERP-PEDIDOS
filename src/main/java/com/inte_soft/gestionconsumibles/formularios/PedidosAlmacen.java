/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.inte_soft.gestionconsumibles.formularios;

import com.inte_soft.gestionconsumibles.controller.ItemController;
import com.inte_soft.gestionconsumibles.controller.OtController;
import com.inte_soft.gestionconsumibles.controller.PedidoConsumiblesController;
import com.inte_soft.gestionconsumibles.controller.PedidosController;
import com.inte_soft.gestionconsumibles.dto.*;
import com.inte_soft.gestionconsumibles.entity.*;
import com.inte_soft.gestionconsumibles.util.*;

import java.awt.Color;
import java.awt.Font;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
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
     * Creates new form PedidosAlmacen inicializar proyecto
     */
    private Usuarios usuario;
    private HashMap<Integer, ArrayList<?>> map;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    private DefaultTableModel model3;
    private DefaultTableModel model5;
    private DefaultTableModel model6;
    private TableRowSorter<DefaultTableModel> sorter;
    private TableRowSorter<DefaultTableModel> sorter2;
    private List<PedidoDto> listPedidos;
    private List<String> listOts;
    private ModelarTabla modelarTabla;
    private ModelarTabla modelarTabla1;
    private PedidoConsumiblesController pedidoConsumiblesController;
    private WindowSingleton windowSingleton;
    private List<Item> listItems;
    private OtController otController;
    private ItemController itemController;

    public PedidosAlmacen(String departamento, Usuarios usuario, WindowSingleton windowSingleton) {
        initComponents();
        map = new HashMap<>();
        listOts = new ArrayList<>();
        jLabel7.setText("");
        jBDesplegar.setVisible(Boolean.FALSE);
        this.verPedidos();
        if (departamento == "Produccion") {
            this.jTabbedPane1.removeTabAt(4);
            this.jTabbedPane1.removeTabAt(3);
            this.jTabbedPane1.removeTabAt(2);
            this.jTabbedPane1.removeTabAt(0);

        }
        this.otController = new OtController();
        this.itemController = new ItemController();
        this.usuario = usuario;
        modelarTabla1 = new ModelarTabla(jTable1);
        this.model1 = modelarTabla1.getModel();
        this.modelarTabla = new ModelarTabla(jTable2);
        this.pedidoConsumiblesController = new PedidoConsumiblesController();
        this.windowSingleton = windowSingleton;
        this.model6 = modelarTabla(this.jTableProgramado);
        this.model5 = modelarTabla(this.jTable5);
        this.model3 = modelarTabla(this.jTable3);
        verProgramado();

        Runnable tarea = () -> {
            this.verPedidos();
            this.verProgramado();

        };

        // Programa la tarea para ejecutarse cada 5 minutos
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(tarea, 0, 5, TimeUnit.MINUTES);
    }

    public void verProgramado() {
        this.model6.setRowCount(0);
        this.model5.setRowCount(0);
        listItems = this.itemController.getItems();
        for (Item ot : listItems) {
            if (ot.getAlistado() == false) {
                Object[] rowData = {
                    ot.getId(),
                    ot.getOt().getOt(),
                    ot.getItem(),
                    ot.getEntrega(),
                    ot.getCerrado(),
                        Boolean.FALSE
                };
                this.model6.addRow(rowData);
            } else {
                Object[] rowData = {
                    ot.getId(),
                    ot.getOt().getOt(),
                    ot.getItem(),
                    ot.getEntrega()

                };
                this.model5.addRow(rowData);
            }
        }
    }

    @Override
    public void dispose() {
        windowSingleton.setCloseWindow();
        super.dispose();
    }

    public DefaultTableModel modelarTabla(JTable jTable) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
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
        SerchROT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        tbn_verPedido1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextSearch1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableProgramado = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

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
                "# Pedido", "OT", "Fecha", "Solicitante", "Tipo Pedido", "Visto", "Area de Pedido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1130, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Adicionales", jPanel1);

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
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1130, Short.MAX_VALUE)
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Busqueda", jPanel2);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idPedidoCosumibles", "idPedido", "OT", "Codigo", "Descripcion", "Marca", "Tipo", "Referencia", "Unidad", "Cantidad", "Checked"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(0);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable2.getColumnModel().getColumn(1).setMinWidth(0);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(0);
        }

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

        SerchROT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SerchROTKeyReleased(evt);
            }
        });

        jLabel8.setText("Busqueda");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jTextOtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(SerchROT, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 389, Short.MAX_VALUE)
                .addComponent(jBSearch)
                .addGap(34, 34, 34)
                .addComponent(jBExportByOt)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBExportByOt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSearch))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jButton3)
                        .addComponent(jTextOtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SerchROT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Revision OT", jPanel4);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# Pedido", "OT", "Fecha", "Solicitante", "Tipo Pedido", "Visto", "Area de Pedido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(5).setMinWidth(0);
            jTable3.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable3.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        tbn_verPedido1.setText("Ver Pedido");
        tbn_verPedido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbn_verPedido1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Busqueda");

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1130, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tbn_verPedido1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(35, 35, 35))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbn_verPedido1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pedidos", jPanel3);

        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTableProgramado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "OT", "Item", "Fecha a Entregar", "Terminado", "Seleccion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTableProgramado);
        if (jTableProgramado.getColumnModel().getColumnCount() > 0) {
            jTableProgramado.getColumnModel().getColumn(0).setMinWidth(0);
            jTableProgramado.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTableProgramado.getColumnModel().getColumn(0).setMaxWidth(0);
            jTableProgramado.getColumnModel().getColumn(4).setMinWidth(0);
            jTableProgramado.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTableProgramado.getColumnModel().getColumn(4).setMaxWidth(0);
            jTableProgramado.getColumnModel().getColumn(5).setMinWidth(100);
            jTableProgramado.getColumnModel().getColumn(5).setMaxWidth(300);
        }

        jButton5.setText("Electricos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Mecanicos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Actualizar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "OT", "Item", "Fecha a Entregar", "Terminado", "Alistado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(4).setMinWidth(0);
            jTable5.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable5.getColumnModel().getColumn(4).setMaxWidth(0);
            jTable5.getColumnModel().getColumn(5).setMinWidth(0);
            jTable5.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable5.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        jLabel10.setText("Pendietes por Alistar");

        jLabel11.setText("Alistados");

        jButton8.setText("Guardar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Programado", jPanel5);

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

    private void SerchROTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SerchROTKeyReleased
        modelarTabla.filter(SerchROT.getText(), 3);
    }//GEN-LAST:event_SerchROTKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String ot = jTextOtSearch.getText();

        if (!ot.isEmpty()) {
            String textoOts = jLabel7.getText();
            if (textoOts.isEmpty()) {
                jLabel7.setText(textoOts + ot);
                listOts.add(ot);

            } else {
                jLabel7.setText(textoOts + ", " + ot);
                listOts.add(ot);
            }

        } else {
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

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
        Date fecha = new Date();
        String header = "OT: " + this.jTable4.getValueAt(0, 0).toString() + "     " + fecha;
        String footer = "Elabora: " + this.usuario.getNombres() + " " + this.usuario.getApellidos();
        JTablePrinter jTablePrinter = new JTablePrinter();
        jTablePrinter.printTable(this.jTable4, header, footer);
    }//GEN-LAST:event_jBImprimirActionPerformed

    private void jBDesplegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDesplegarActionPerformed
        int row = this.jTable4.getSelectedRow();
        if (row >= 0) {
            PedidoConsumiblesController pedidoConsumiblesController = new PedidoConsumiblesController();
            String ot = this.jTable4.getValueAt(row, 0).toString();
            List<ConsumiblesDtoOt> listConsumiblesDtoOt = pedidoConsumiblesController.consumiblesPedidosSearcFilter(
                    Integer.parseInt(this.jTable4.getValueAt(row, 0).toString()), this.jComboBox1.getSelectedItem().toString());
            Consumibles consumibles = new Consumibles("VISUALIZACION",
                    listConsumiblesDtoOt, this.usuario, ot);
            consumibles.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBDesplegarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (!this.jTxtOt.getText().isBlank() || !this.jTxtDescripcion.getText().isBlank()) {
            PedidoConsumiblesController pedidoConsumiblesController = new PedidoConsumiblesController();
            DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
            model.setRowCount(0);
            List<ConsumiblesDto> listConsumiblesDto = pedidoConsumiblesController.consumiblesPedidosSearch(
                    (this.jTxtOt.getText()), this.jTxtDescripcion.getText(),
                    this.jComboBox1.getSelectedItem().toString());
            for (ConsumiblesDto consumiblesDto : listConsumiblesDto) {
                Object[] rowData = {
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
        } else {
            JOptionPane.showMessageDialog(null, "Debe diligenciar una OT o una Descripcion", "Advertencia", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        model.setNumRows(0);
        this.verPedidos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextSearchKeyReleased
        modelarTabla1.filter(jTextSearch.getText(), 1);
    }//GEN-LAST:event_jTextSearchKeyReleased

    private void tbn_verPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbn_verPedidoActionPerformed
        int row = this.jTable1.getSelectedRow();
        if (row >= 0) {
            PedidoConsumiblesController pedidoConsumiblesController = new PedidoConsumiblesController();
            String ot = this.jTable1.getValueAt(row, 1).toString();
            List<PedidoConsumiblesDto> listPedidoConsumiblesDto = pedidoConsumiblesController.findByIdPedido(
                    Integer.parseInt(this.jTable1.getValueAt(row, 0).toString()));
            Consumibles consumibles = new Consumibles(listPedidoConsumiblesDto, this.usuario, ot);
            consumibles.setVisible(true);
            Pedidos pedido = new Pedidos();
            PedidosController pedidosController = new PedidosController();
            for (PedidoDto pedidos : this.listPedidos) {
                int idList = pedidos.getIdPedido();
                int id = Integer.parseInt(this.jTable1.getValueAt(row, 0).toString());
                if (id == idList) {
                    pedido.setIdPedido(pedidos.getIdPedido());
                    pedido.setOt(pedidos.getOt());
                    pedido.setPersona(pedidos.getPersona());
                    pedido.setArea(pedidos.getArea());
                    pedido.setFecha(pedidos.getFecha());
                    pedido.setOperacion(pedidos.getOperacion());
                    pedido.setRevisado(pedidos.isRevisado());
                    pedido.setTipoPedido(pedidos.getTipoPedido());
                    pedido.setVisto(pedidos.isVisto());
                    pedido.setComprado(pedidos.isComprado());
                    break;
                }
            }

            pedido.setVisto(Boolean.TRUE);
            pedidosController.updatePedido(pedido);
            this.verPedidos();

        } else {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_tbn_verPedidoActionPerformed

    private void tbn_verPedido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbn_verPedido1ActionPerformed
        int row = this.jTable3.getSelectedRow();
        if (row >= 0) {
            String ot = this.jTable3.getValueAt(row, 1).toString();
            PedidosController pedidosController = new PedidosController();
            List<PedidoConsumiblesDto> listPedidoConsumiblesDto = pedidoConsumiblesController.findByIdPedido(
                    Integer.parseInt(this.jTable3.getValueAt(row, 0).toString()));
            Consumibles consumibles = new Consumibles(listPedidoConsumiblesDto, this.usuario, ot);
            consumibles.setVisible(true);
            Pedidos pedido = new Pedidos();
            for (PedidoDto pedidos : this.listPedidos) {
                int idList = pedidos.getIdPedido();
                int id = Integer.parseInt(this.jTable3.getValueAt(row, 0).toString());
                if (id == idList) {
                    pedido.setIdPedido(pedidos.getIdPedido());
                    pedido.setOt(pedidos.getOt());
                    pedido.setPersona(pedidos.getPersona());
                    pedido.setArea(pedidos.getArea());
                    pedido.setFecha(pedidos.getFecha());
                    pedido.setOperacion(pedidos.getOperacion());
                    pedido.setRevisado(Boolean.FALSE);
                    pedido.setTipoPedido(pedidos.getTipoPedido());
                    pedido.setVisto(pedidos.isVisto());
                    pedido.setComprado(pedidos.isComprado());

                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_tbn_verPedido1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String ot = this.jTextSearch1.getText().toString();
        if (ot.isBlank()) {
            JOptionPane.showMessageDialog(null, "Debe escribir un texto para buscar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            PedidosController pedidosController = new PedidosController();
            List<Pedidos> listPedidos = pedidosController.listPedidosSearchByOt(ot);
            this.model3.setRowCount(0);
            for (Pedidos pedidos : listPedidos) {
                Object[] rowData = {
                    pedidos.getIdPedido(),
                    pedidos.getOt(),
                    pedidos.getFecha(),
                    pedidos.getPersona(),
                    pedidos.getOperacion(),
                    pedidos.isVisto(),
                    pedidos.getTipoPedido()

                };
                this.model3.addRow(rowData);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    int contador1 = 0;
    for (int i = 0; i < this.jTableProgramado.getRowCount(); i++) {
        Object seleccion = this.jTableProgramado.getValueAt(i, 5);
        if (seleccion != null && (Boolean) seleccion) {
            contador1++;
        }
    }
    if (contador1 > 0) {
        Integer contador = 0;
        List<String> listItem = new ArrayList<>();
        Ot ot = new Ot();

        for (int i = 0; i < this.jTableProgramado.getRowCount(); i++) {
            Object seleccion = this.jTableProgramado.getValueAt(i, 5);
            if (seleccion != null && (Boolean) seleccion) {
                contador++;
                listItem.add(getSelectedItem(
                        Integer.parseInt(
                                jTableProgramado.getValueAt(i, 0)
                                        .toString())).getItem().toString());
                String ot1 = jTableProgramado.getValueAt(i, 1).toString();
                if (ot.getOt() == null || ot.getOt().equals(ot1)) {
                    ot = getSelectedItem(
                            Integer.parseInt(
                                    jTableProgramado.getValueAt(i, 0)
                                            .toString())).getOt();
                } else {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar OTs iguales", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
        ListadoPendiente listadoPendiente = new ListadoPendiente(this.usuario, listItem, "CONSUMIBLES ELECTRICOS", ot);
        listadoPendiente.setVisible(Boolean.TRUE);
        listadoPendiente.setLocationRelativeTo(null);
        listadoPendiente.setModal(Boolean.TRUE);
    } else {
        JOptionPane.showMessageDialog(null, "Debe chekear almenos una linea", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
}//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//Gen-FIRST:event_jButton6ActionPerformed
    int contador1 = 0;
    for (int i = 0; i < this.jTableProgramado.getRowCount(); i++) {
        Object seleccion = this.jTableProgramado.getValueAt(i, 5);
        if (seleccion != null && (Boolean) seleccion) {
            contador1++;
        }
    }
    if (contador1 > 0) {
        Integer contador = 0;
        List<String> listItem = new ArrayList<>();
        Ot ot = new Ot();

        for (int i = 0; i < this.jTableProgramado.getRowCount(); i++) {
            Object seleccion = this.jTableProgramado.getValueAt(i, 5);
            if (seleccion != null && (Boolean) seleccion) {
                contador++;
                listItem.add(getSelectedItem(
                        Integer.parseInt(
                                jTableProgramado.getValueAt(i, 0)
                                        .toString())).getItem().toString());
                String ot1 = jTableProgramado.getValueAt(i, 1).toString();
                if (ot.getOt() == null || ot.getOt().equals(ot1)) {
                    ot = getSelectedItem(
                            Integer.parseInt(
                                    jTableProgramado.getValueAt(i, 0)
                                            .toString())).getOt();
                } else {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar OTs iguales", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
        ListadoPendiente listadoPendiente = new ListadoPendiente(this.usuario, listItem, "CONSUMIBLES MECANICOS", ot);
        listadoPendiente.setVisible(Boolean.TRUE);
    } else {
        JOptionPane.showMessageDialog(null, "Debe chekear almenos una linea", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
}                                        

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        verProgramado();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int count = 0;
        List<Ot> listOt = new ArrayList<>();
        for (int i = 0; i < this.jTableProgramado.getRowCount(); i++) {
            Boolean cheked = Boolean.parseBoolean(this.jTableProgramado.getValueAt(i, 4).toString());
            if (cheked) {
                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Esta seguro que desea guardar los cambios de la OT "
                        + jTableProgramado.getValueAt(i, 1).toString() + "?",
                        "Advertencia", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    Ot ot = new Ot();
                    ot.setIdOt(Integer.parseInt(this.jTableProgramado.getValueAt(i, 0).toString()));
                    ot.setOt((this.jTableProgramado.getValueAt(i, 1).toString()));
                    String fechaStr = this.jTableProgramado.getValueAt(i, 2).toString();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // El formato de la cadena de fecha
                    /*try {
                        //ot.setFechaAlmacen(dateFormat.parse(fechaStr));
                    } catch (ParseException e) {
                        e.printStackTrace(); // Manejar la excepción adecuadamente
                    }*/
                    ot.setTerminado(Boolean.parseBoolean(this.jTableProgramado.getValueAt(i, 3).toString()));
                    ot.setAlistado(cheked);
                    listOt.add(ot);
                    count++;
                } else {
                    return;
                }
            }
        }
        if (count == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar al menos una OT alistada para guardar",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;

        } else {
            OtController otController = new OtController();
            otController.updateOtAlistado(listOt);
            verProgramado();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void export(JTable jTable) {
        //crar una jtable temporalque tenga todas las filas que fueron chequeadas en la ultima columna como true
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        JTable tempTable = new JTable();
        DefaultTableModel model2 = (DefaultTableModel) tempTable.getModel();
        for (int i = 0; i < jTable.getColumnCount(); i++) {
            model2.addColumn(jTable.getColumnName(i));
        }

        for (int i = 0; i < jTable.getRowCount(); i++) {
            String cheked = "";
            if (jTable.getValueAt(i, 10) != null) {
                cheked = jTable.getValueAt(i, 10).toString();
            } else {
                cheked = "false";
            }
            Boolean chekedBoolean = cheked == "true" ? true : false;
            if (chekedBoolean) {
                Object[] rowData = {
                    jTable.getValueAt(i, 0),
                    jTable.getValueAt(i, 1),
                    jTable.getValueAt(i, 2),
                    jTable.getValueAt(i, 3),
                    jTable.getValueAt(i, 4),
                    jTable.getValueAt(i, 5),
                    jTable.getValueAt(i, 6),
                    jTable.getValueAt(i, 7),
                    jTable.getValueAt(i, 8),
                    jTable.getValueAt(i, 9),
                    jTable.getValueAt(i, 10)
                };
                model2.addRow(rowData);

            }
        }
        List<ConsumiblesDtoRev> listConsumiblesDtoRev = new ArrayList<>();
        for (int i = 0; i < tempTable.getRowCount(); i++) {
            ConsumiblesDtoRev consumiblesDtoRev = new ConsumiblesDtoRev();
            consumiblesDtoRev.setIdPdedidoConsumibles(BigInteger.valueOf(Long.parseLong(tempTable.getValueAt(i, 0).toString())));
            consumiblesDtoRev.setIdPedido(Integer.parseInt(tempTable.getValueAt(i, 1).toString()));
            consumiblesDtoRev.setOt(tempTable.getValueAt(i, 2).toString());
            consumiblesDtoRev.setCodigo(tempTable.getValueAt(i, 3).toString());
            consumiblesDtoRev.setDescripcion(tempTable.getValueAt(i, 4).toString());
            consumiblesDtoRev.setTipo(tempTable.getValueAt(i, 5).toString());
            consumiblesDtoRev.setReferencia(tempTable.getValueAt(i, 6).toString());
            consumiblesDtoRev.setMarca(tempTable.getValueAt(i, 7).toString());
            consumiblesDtoRev.setUnidad(tempTable.getValueAt(i, 8).toString());
            consumiblesDtoRev.setCantidad(Float.parseFloat(tempTable.getValueAt(i, 9).toString()));
            listConsumiblesDtoRev.add(consumiblesDtoRev);
        }
        if (listConsumiblesDtoRev.size() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un Consumible para exportar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ExcelExporter excelExporter = new ExcelExporter();
        excelExporter.exportTable(tempTable);
        PedidosController pedidosController = new PedidosController();
        model2 = modelarTabla(jTable2);
        model2.setRowCount(0);
        this.pedidoConsumiblesController.applycheck(listConsumiblesDtoRev);
    }

    private void filter(String text) {
        if (text.isEmpty()) {
            try {
                sorter.setRowFilter(RowFilter.regexFilter(this.jTextSearch.getText()));

            } catch (Exception e) {

            }
        }else {
            try {
                sorter.setRowFilter(RowFilter.regexFilter(text));
            } catch (Exception e) {
            }
        }

    }

    public void verPedidos() {
        PedidosController pedidosController = new PedidosController();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        this.listPedidos = pedidosController.listPedidos();
        model.setNumRows(0);
        // Crea una instancia de tu CustomCellRenderer
        Font customFont = new Font("Arial", Font.BOLD, 14);
        Color customColor = Color.BLUE;
        CustomRowRendererBlue customRowRenderer = new CustomRowRendererBlue(customFont, customColor);
        jTable1.setDefaultRenderer(Object.class, customRowRenderer);
        for (PedidoDto pedidos : this.listPedidos) {
            Object[] rowData = {
                pedidos.getIdPedido(),
                pedidos.getOt(),
                pedidos.getFecha(),
                pedidos.getPersona(),
                pedidos.getOperacion(),
                pedidos.isVisto(),
                pedidos.getTipoPedido()
            };
            model.addRow(rowData);

        }
    }

    private void updatePedidosSinRevisarOts(JTable table, List<String> ots) {
        try{
        PedidoConsumiblesController pedidoConsumiblesController = new PedidoConsumiblesController();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        List<ConsumiblesDtoRev> listConsumiblesDtoRevs = pedidoConsumiblesController.consumiblesWhithoutCheck(ots);
        if (this.map == null) {
            return;
        }

        for (ConsumiblesDtoRev consumiblesDto : listConsumiblesDtoRevs) {
            Object[] rowData = {
                consumiblesDto.getIdPdedidoConsumibles(),
                consumiblesDto.getIdPedido(),
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
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public Item getSelectedItem(Integer id) {
        return this.listItems.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SerchROT;
    private javax.swing.JButton jBDesplegar;
    private javax.swing.JButton jBExportByOt;
    private javax.swing.JButton jBImprimir;
    private javax.swing.JButton jBSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTableProgramado;
    private javax.swing.JTextField jTextOtSearch;
    private javax.swing.JTextField jTextSearch;
    private javax.swing.JTextField jTextSearch1;
    private javax.swing.JTextField jTxtDescripcion;
    private javax.swing.JTextField jTxtOt;
    private javax.swing.JButton tbn_verPedido;
    private javax.swing.JButton tbn_verPedido1;
    // End of variables declaration//GEN-END:variables
}
