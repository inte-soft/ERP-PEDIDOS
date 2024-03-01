/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.inte_soft.gestionconsumibles.formularios;

import com.inte_soft.gestionconsumibles.controller.MasterController;
import com.inte_soft.gestionconsumibles.controller.TConsumiblesEController;
import com.inte_soft.gestionconsumibles.controller.TConsumiblesMController;
import com.inte_soft.gestionconsumibles.entity.Usuarios;
import com.inte_soft.gestionconsumibles.util.SplashProceso;
import com.inte_soft.gestionconsumibles.util.WindowSingleton;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Inte-Soft
 */
public class Principal extends javax.swing.JFrame {
    
    
    /**
     * Creates new form Principal
     */
    
    private JDesktopPane escritorio;
    private JProgressBar jProgressBar;
    private MasterController masterController;
    private TConsumiblesEController consumiblesEController;
    private TConsumiblesMController consumiblesMController;
    private WindowSingleton windowAlmacen;
    private WindowSingleton windowMxMinE;
    private WindowSingleton windowMxMinM;
    private WindowSingleton windowUsuarios;
    private WindowSingleton windowGestionConsumibles;
    private WindowSingleton windowpedidosEspeciales;
    private WindowSingleton windowOtProgramada;

    
    private Usuarios usuarios;
    public Principal(Usuarios usuarios ) {
        jProgressBar = new JProgressBar(0, 100);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoIcono.png")).getImage());
        escritorio = new JDesktopPane();
        this.setContentPane(escritorio);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.usuarios=usuarios;
        this.windowAlmacen = new WindowSingleton();
        this.windowMxMinE = new WindowSingleton();
        this.windowMxMinM = new WindowSingleton();
        this.windowUsuarios = new WindowSingleton();
        this.windowGestionConsumibles = new WindowSingleton();
        this.windowOtProgramada = new WindowSingleton();
        this.windowpedidosEspeciales = new WindowSingleton();


    if(!this.usuarios.getpAdminUser()){
        this.jMAdministrar.setVisible(false);
    }
    
    if(!this.usuarios.getpAlmacen()){
        this.jAlmacen.setVisible(false);
    }
    
    if(!this.usuarios.getpIngenieria()){
        this.jMIngenieria.setVisible(false);
    }
    
    if(!this.usuarios.getpProduccion()){
        this.jMProduccion.setVisible(false);
    }
    
    if(!this.usuarios.getpComercial()){
        
    }
    
    if(!this.usuarios.getpCompras()){
        this.compras.setVisible(false);
        
    }
    
    
    }

    public Principal() {
        jProgressBar = new JProgressBar(0, 100);
        initComponents();
        escritorio = new JDesktopPane();
        this.setContentPane(escritorio);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMAdministrar = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        actualizarMaestro = new javax.swing.JMenuItem();
        jMIngenieria = new javax.swing.JMenu();
        cElectricos = new javax.swing.JMenuItem();
        cMecanicos = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        cargarCElectricos = new javax.swing.JMenuItem();
        cargarCMecanicos = new javax.swing.JMenuItem();
        jAlmacen = new javax.swing.JMenu();
        jMAlmacen = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMProduccion = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        compras = new javax.swing.JMenu();
        maxMinE = new javax.swing.JMenuItem();
        maxMinM = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1193, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );

        jMAdministrar.setText("Administrar");

        jMenuItem1.setText("Gestionar Usuarios");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMAdministrar.add(jMenuItem1);

        actualizarMaestro.setText("Actualizar Maestro");
        actualizarMaestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarMaestroActionPerformed(evt);
            }
        });
        jMAdministrar.add(actualizarMaestro);

        jMenuBar1.add(jMAdministrar);

        jMIngenieria.setText("Ingenieria");

        cElectricos.setText("Pedido Consummibles Electricos");
        cElectricos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cElectricosActionPerformed(evt);
            }
        });
        jMIngenieria.add(cElectricos);

        cMecanicos.setText("Pedido Consumibles mecanicos");
        cMecanicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cMecanicosActionPerformed(evt);
            }
        });
        jMIngenieria.add(cMecanicos);

        jMenu4.setText("Administrar");

        cargarCElectricos.setText("Cargar Tipico Electrico");
        cargarCElectricos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cargarCElectricosMouseClicked(evt);
            }
        });
        cargarCElectricos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarCElectricosActionPerformed(evt);
            }
        });
        jMenu4.add(cargarCElectricos);

        cargarCMecanicos.setText("Cargar Tipico Mecanico");
        cargarCMecanicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarCMecanicosActionPerformed(evt);
            }
        });
        jMenu4.add(cargarCMecanicos);

        jMIngenieria.add(jMenu4);

        jMenuBar1.add(jMIngenieria);

        jAlmacen.setText("Almacen");
        jAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlmacenActionPerformed(evt);
            }
        });

        jMAlmacen.setText("Almacen");
        jMAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMAlmacenMouseClicked(evt);
            }
        });
        jMAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMAlmacenActionPerformed(evt);
            }
        });
        jAlmacen.add(jMAlmacen);

        jMenuItem5.setText("Ot´s Programadas");
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem5MouseClicked(evt);
            }
        });
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jAlmacen.add(jMenuItem5);

        jMenuBar1.add(jAlmacen);

        jMProduccion.setText("Produccion");

        jMenuItem2.setText("Busqueda");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMProduccion.add(jMenuItem2);

        jMenuBar1.add(jMProduccion);

        compras.setText("Compras");
        compras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comprasMouseClicked(evt);
            }
        });
        compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprasActionPerformed(evt);
            }
        });

        maxMinE.setText("Maximos y minimos Electricos");
        maxMinE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxMinEActionPerformed(evt);
            }
        });
        compras.add(maxMinE);

        maxMinM.setText("Maximos y minimos Mecanicos");
        maxMinM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxMinMActionPerformed(evt);
            }
        });
        compras.add(maxMinM);

        jMenuItem3.setText("Pedidos Especiales");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem3MouseClicked(evt);
            }
        });
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        compras.add(jMenuItem3);

        jMenuBar1.add(compras);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.openGestionUsuarios();
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void actualizarMaestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarMaestroActionPerformed

        String filePath = "";
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("xls & xlsm", "xlsx", "xlsm");
        jFileChooser.setFileFilter(fileNameExtensionFilter);
        SplashProceso splashProceso = new SplashProceso("Procesando...");
        int respuesta = jFileChooser.showOpenDialog(this);
        
        if(respuesta==JFileChooser.APPROVE_OPTION){
            
            filePath = jFileChooser.getSelectedFile().getPath();
            final String finalFilePath = filePath;
             masterController = new MasterController();
            splashProceso.mostrarSplash();
            this.setEnabled(false);
            Thread thread = new Thread(() -> {
                masterController.updateMaster(finalFilePath);
                splashProceso.cerrarSplash();
            
        });
        thread.start();
        this.setEnabled(true);
           
            
        }
    }//GEN-LAST:event_actualizarMaestroActionPerformed

    private void cargarCElectricosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarCElectricosMouseClicked
        String filePath = "";
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("xls & xlsm", "xlsx", "xlsm");
        jFileChooser.setFileFilter(fileNameExtensionFilter);
        SplashProceso splashProceso = new SplashProceso("Procesando...");
        int respuesta = jFileChooser.showOpenDialog(this);
        
        if(respuesta==JFileChooser.APPROVE_OPTION){
            
            filePath = jFileChooser.getSelectedFile().getPath();
            final String finalFilePath = filePath;
             masterController = new MasterController();
            splashProceso.mostrarSplash();
            this.setEnabled(false);
            Thread thread = new Thread(() -> {
                masterController.updateMaster(finalFilePath);
                splashProceso.cerrarSplash();
            
        });
        thread.start();
        this.setEnabled(true);
           
            
        }
    }//GEN-LAST:event_cargarCElectricosMouseClicked

    private void cElectricosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cElectricosActionPerformed

        if(!windowGestionConsumibles.getWindowState()){
            windowGestionConsumibles.setOpenWindow();
            GestionConsumibles gestionConsumibles = new GestionConsumibles(this.usuarios, windowGestionConsumibles);
            escritorio.add(gestionConsumibles);
            gestionConsumibles.tipoConsumibles("CONSUMIBLES ELECTRICOS" );
            gestionConsumibles.setVisible(true);
        }else {
            JOptionPane.showMessageDialog(null, "La ventana ya esta abierta", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_cElectricosActionPerformed

    private void cargarCElectricosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarCElectricosActionPerformed
        String filePath = "";
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("xls & xlsm", "xlsx", "xlsm");
        jFileChooser.setFileFilter(fileNameExtensionFilter);
        SplashProceso splashProceso = new SplashProceso("Procesando...");
        int respuesta = jFileChooser.showOpenDialog(this);
        
        if(respuesta==JFileChooser.APPROVE_OPTION){
            
            filePath = jFileChooser.getSelectedFile().getPath();
            final String finalFilePath = filePath;
            consumiblesEController = new TConsumiblesEController();
            splashProceso.mostrarSplash();
            this.setEnabled(false);
            Thread thread = new Thread(() -> {
                consumiblesEController.create(finalFilePath);
                splashProceso.cerrarSplash();
            
        });
        thread.start();
        this.setEnabled(true);
           
            
        }
    }//GEN-LAST:event_cargarCElectricosActionPerformed

    private void cargarCMecanicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarCMecanicosActionPerformed
        String filePath = "";
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("xls & xlsm", "xlsx", "xlsm");
        jFileChooser.setFileFilter(fileNameExtensionFilter);
        SplashProceso splashProceso = new SplashProceso("Procesando...");
        int respuesta = jFileChooser.showOpenDialog(this);
        
        if(respuesta==JFileChooser.APPROVE_OPTION){
            
            filePath = jFileChooser.getSelectedFile().getPath();
            final String finalFilePath = filePath;
            consumiblesMController = new TConsumiblesMController();
            splashProceso.mostrarSplash();
            this.setEnabled(false);
            Thread thread = new Thread(() -> {
                consumiblesMController.create(finalFilePath);
                splashProceso.cerrarSplash();
            
        });
        thread.start();
        this.setEnabled(true);
           
            
        }
    }//GEN-LAST:event_cargarCMecanicosActionPerformed

    private void cMecanicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cMecanicosActionPerformed
        if(!windowGestionConsumibles.getWindowState()){
            windowGestionConsumibles.setOpenWindow();
            GestionConsumibles gestionConsumibles = new GestionConsumibles(this.usuarios, windowGestionConsumibles);
            escritorio.add(gestionConsumibles);
            gestionConsumibles.tipoConsumibles("CONSUMIBLES MECANICOS");
            gestionConsumibles.setVisible(true);
        }else {
            JOptionPane.showMessageDialog(null, "La ventana ya esta abierta", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_cMecanicosActionPerformed

    private void jMAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMAlmacenActionPerformed
        if(!windowAlmacen.getWindowState()){
            windowAlmacen.setOpenWindow();
            PedidosAlmacen pedidosAlmacen = new PedidosAlmacen("Almacen", this.usuarios, windowAlmacen);
            escritorio.add(pedidosAlmacen);
            pedidosAlmacen.setVisible(true);
        }else {
            JOptionPane.showMessageDialog(null, "La ventana ya esta abierta", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jMAlmacenActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (!windowAlmacen.getWindowState()) {
            windowAlmacen.setOpenWindow();
            PedidosAlmacen pedidosAlmacen = new PedidosAlmacen("Produccion", this.usuarios, windowAlmacen);
            escritorio.add(pedidosAlmacen);
            pedidosAlmacen.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "La ventana ya esta abierta", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void maxMinEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxMinEActionPerformed
        if (!windowMxMinE.getWindowState()) {
            windowMxMinE.setOpenWindow();
            MaxMin maxMin = new MaxMin("Electricos",windowMxMinE);
            escritorio.add(maxMin);
            maxMin.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "La ventana ya esta abierta", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_maxMinEActionPerformed

    private void maxMinMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxMinMActionPerformed
        if(!windowMxMinM.getWindowState()){
            windowMxMinM.setOpenWindow();
            MaxMin maxMin = new MaxMin("Mecanicos", windowMxMinM);
            escritorio.add(maxMin);
            maxMin.setVisible(true);
        }else {
            JOptionPane.showMessageDialog(null, "La ventana ya esta abierta", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_maxMinMActionPerformed

    private void comprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comprasMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comprasMouseClicked

    private void jMAlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMAlmacenMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMAlmacenMouseClicked

    private void comprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprasActionPerformed
            
    }//GEN-LAST:event_comprasActionPerformed

    private void jMenuItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItem3MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (!windowpedidosEspeciales.getWindowState()) {
            windowpedidosEspeciales.setOpenWindow();
            pedidosEspeciales pedidosCompras = new pedidosEspeciales(this.usuarios, windowpedidosEspeciales);
            escritorio.add(pedidosCompras);
            pedidosCompras.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "La ventana ya esta abierta", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlmacenActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jAlmacenActionPerformed

    private void jMenuItem5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem5MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItem5MouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        if (!windowOtProgramada.getWindowState()) {
            windowOtProgramada.setOpenWindow();
            otsProgramadas fechaProgramada = new otsProgramadas(this.windowOtProgramada);
            escritorio.add(fechaProgramada);
            fechaProgramada.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "La ventana ya esta abierta", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    public void openGestionUsuarios(){
        if(!windowUsuarios.getWindowState()){
            windowUsuarios.setOpenWindow();
            GestionUsuarios gestionUsuarios = new GestionUsuarios(windowUsuarios);
            escritorio.add(gestionUsuarios);
            gestionUsuarios.setVisible(true);
            gestionUsuarios.loadUserData();
        }else {
            JOptionPane.showMessageDialog(null, "La ventana ya esta abierta", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }


    }
    
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
     private void maximizeFrame() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem actualizarMaestro;
    private javax.swing.JMenuItem cElectricos;
    private javax.swing.JMenuItem cMecanicos;
    private javax.swing.JMenuItem cargarCElectricos;
    private javax.swing.JMenuItem cargarCMecanicos;
    private javax.swing.JMenu compras;
    private javax.swing.JMenu jAlmacen;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMAdministrar;
    private javax.swing.JMenuItem jMAlmacen;
    private javax.swing.JMenu jMIngenieria;
    private javax.swing.JMenu jMProduccion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem maxMinE;
    private javax.swing.JMenuItem maxMinM;
    // End of variables declaration//GEN-END:variables
}

