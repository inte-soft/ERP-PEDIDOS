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
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
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
    private Usuarios usuarios;
    public Principal(Usuarios usuarios ) {
        jProgressBar = new JProgressBar(0, 100);
        initComponents();
        escritorio = new JDesktopPane();
        this.setContentPane(escritorio);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.usuarios=usuarios;
        
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jmLogin = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        actualizarMaestro = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        cElectricos = new javax.swing.JMenuItem();
        cMecanicos = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        cargarCElectricos = new javax.swing.JMenuItem();
        cargarCMecanicos = new javax.swing.JMenuItem();
        jAlmacen = new javax.swing.JMenu();
        jMAlmacen = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jmLogin.setText("Administrar");

        jMenuItem1.setText("Gestionar Usuarios");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmLogin.add(jMenuItem1);

        actualizarMaestro.setText("Actualizar Maestro");
        actualizarMaestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarMaestroActionPerformed(evt);
            }
        });
        jmLogin.add(actualizarMaestro);

        jMenuBar1.add(jmLogin);

        jMenu3.setText("Ingenieria");

        cElectricos.setText("Pedido Consummibles Electricos");
        cElectricos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cElectricosActionPerformed(evt);
            }
        });
        jMenu3.add(cElectricos);

        cMecanicos.setText("Pedido Consumibles mecanicos");
        cMecanicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cMecanicosActionPerformed(evt);
            }
        });
        jMenu3.add(cMecanicos);

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

        jMenu3.add(jMenu4);

        jMenuBar1.add(jMenu3);

        jAlmacen.setText("Almacen");

        jMAlmacen.setText("Almacen");
        jMAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMAlmacenActionPerformed(evt);
            }
        });
        jAlmacen.add(jMAlmacen);

        jMenuBar1.add(jAlmacen);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1193, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
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
        gestionConsumibles gestionConsumibles = new gestionConsumibles(this.usuarios);
        escritorio.add(gestionConsumibles);
        gestionConsumibles.tipoConsumibles("CONSUMIBLES ELECTRICOS" );
        gestionConsumibles.setVisible(true);
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
        gestionConsumibles gestionConsumibles = new gestionConsumibles(this.usuarios);
        escritorio.add(gestionConsumibles);
        gestionConsumibles.tipoConsumibles("CONSUMIBLES MECANICOS");
        gestionConsumibles.setVisible(true);
    }//GEN-LAST:event_cMecanicosActionPerformed

    private void jMAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMAlmacenActionPerformed
        PedidosAlmacen pedidosAlmacen = new PedidosAlmacen();
        escritorio.add(pedidosAlmacen);
        pedidosAlmacen.setVisible(true);
    }//GEN-LAST:event_jMAlmacenActionPerformed
    public void openGestionUsuarios(){
        GestionUsuarios gestionUsuarios = new GestionUsuarios();
        escritorio.add(gestionUsuarios);
        gestionUsuarios.setVisible(true);
        gestionUsuarios.loadUserData();
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
    private javax.swing.JMenu jAlmacen;
    private javax.swing.JMenuItem jMAlmacen;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jmLogin;
    // End of variables declaration//GEN-END:variables
}

