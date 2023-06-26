/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.inte_soft.gestionconsumibles.formularios;

import com.inte_soft.gestionconsumibles.controller.AreaCompaniaController;
import com.inte_soft.gestionconsumibles.controller.UsuariosController;
import com.inte_soft.gestionconsumibles.dto.UsuariosDto;
import com.inte_soft.gestionconsumibles.entity.Usuarios;
import com.inte_soft.gestionconsumibles.util.AdvertenciaModal;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author alejo
 */
public class User extends javax.swing.JDialog {
    private GestionUsuarios gestionUsuarios;
    private int id;
    private boolean modifyFlag= false;
    /**
     * Creates new form User
     */
    public User() {
        initComponents();
        this.setComboBox();
        
    }
    public User(GestionUsuarios gestionUsuarios) {
        initComponents();
        this.setComboBox();
        this.gestionUsuarios = gestionUsuarios;
    }
    public User(Usuarios user,GestionUsuarios gestionUsuarios) {
        this.gestionUsuarios = gestionUsuarios;
        initComponents();
        this.setComboBox();
        this.id = (user.getIdUsuario());
        this.name.setText(user.getNombres());
        this.lastName.setText(user.getApellidos());
        this.user.setText(user.getUsuario());
        this.password.setText(user.getContraseña());
        for (int i = 0; i < this.areas.getItemCount(); i++) {
            String item = this.areas.getItemAt(i);
            if (item.equals(user.getAreaCompania().getNombreArea())) {
                this.areas.setSelectedItem(item);
                break;
            }
        }
        this.pAdminUser.setSelected(user.getpAdminUser());
        this.pAlmacen.setSelected(user.getpAlmacen());
        this.pIngenieria.setSelected(user.getpIngenieria());
        this.pComercial.setSelected(user.getpComercial());
        this.pCompras.setSelected(user.getpCompras());
        this.pProduccion.setSelected(user.getpProduccion());
        this.modifyFlag = true;
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        user = new javax.swing.JTextField();
        areas = new javax.swing.JComboBox<>();
        pAlmacen = new javax.swing.JCheckBox();
        pIngenieria = new javax.swing.JCheckBox();
        pAdminUser = new javax.swing.JCheckBox();
        pCompras = new javax.swing.JCheckBox();
        pComercial = new javax.swing.JCheckBox();
        pProduccion = new javax.swing.JCheckBox();
        ejecutar = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

        jLabel1.setText("Nombres");

        jLabel2.setText("Apellidos");

        jLabel3.setText("Usuario");

        jLabel4.setText("Contraseña");

        jLabel5.setText("Area");

        jLabel6.setText("Permiso Almacen");

        jLabel7.setText("Permiso Ingenieria");

        jLabel8.setText("Permiso Admin Usuario");

        jLabel9.setText("Permiso Compras");

        jLabel10.setText("Permiso Comercial");

        jLabel11.setText("Permiso Produccion");

        ejecutar.setText("Guardar");
        ejecutar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ejecutarMouseReleased(evt);
            }
        });

        jToggleButton2.setText("Salir");
        jToggleButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ejecutar)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pAlmacen)
                            .addComponent(pIngenieria)
                            .addComponent(pAdminUser)
                            .addComponent(pCompras)
                            .addComponent(pComercial)
                            .addComponent(pProduccion)
                            .addComponent(name)
                            .addComponent(lastName)
                            .addComponent(user)
                            .addComponent(areas, 0, 126, Short.MAX_VALUE)
                            .addComponent(password))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(areas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(pAlmacen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(pIngenieria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(pAdminUser))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9))
                    .addComponent(pCompras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(pComercial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(pProduccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ejecutar)
                    .addComponent(jToggleButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ejecutarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ejecutarMouseReleased
        UsuariosController usuariosController = new UsuariosController();
        UsuariosDto usuariosDto = new UsuariosDto();
        
        if(!(this.name.getText().trim().isEmpty() || this.lastName.getText().trim().isEmpty()
                || this.user.getText().trim().isEmpty() || this.password.getText().trim().isEmpty())){
        usuariosDto.setNombre(this.name.getText());
        usuariosDto.setApellido(this.lastName.getText());
        usuariosDto.setUsuario(this.user.getText());
        usuariosDto.setContraseña(this.password.getText());
        usuariosDto.setIdAreaCompañia(this.areas.getSelectedItem().toString());
        usuariosDto.setpAlmacen(this.pAlmacen.isSelected());
        usuariosDto.setpIngenieria(this.pIngenieria.isSelected());
        usuariosDto.setpAdminUser(this.pAdminUser.isSelected());
        usuariosDto.setpComercial(this.pComercial.isSelected());
        usuariosDto.setpCompras(this.pCompras.isSelected());
        usuariosDto.setpProduccion(this.pProduccion.isSelected());
        if (!modifyFlag){
            usuariosController.createUser(usuariosDto,this);
            this.dispose();
        }else{
            usuariosDto.setIdUsuario(this.id);
            usuariosController.modifyUser(usuariosDto, this);
            this.dispose();
        }
        
        }else{
            
            AdvertenciaModal advertenciaModal = new AdvertenciaModal();
            advertenciaModal.advertenciaModal(this,"Tiene campos pendientes por diligenciar", "Advertencia");
            
           
        }
        
        gestionUsuarios.loadUserData();
        
    }//GEN-LAST:event_ejecutarMouseReleased

    
    
    private void jToggleButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton2MouseClicked
         this.dispose();
    }//GEN-LAST:event_jToggleButton2MouseClicked

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
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
 
    }
    public void setComboBox(){
        AreaCompaniaController areaCompaniaController = new AreaCompaniaController();
        List<String> listNameAreas = areaCompaniaController.getAll();
        for(String area : listNameAreas){
            this.areas.addItem(area);
        }
    }
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> areas;
    private javax.swing.JToggleButton ejecutar;
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
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTextField lastName;
    private javax.swing.JTextField name;
    private javax.swing.JCheckBox pAdminUser;
    private javax.swing.JCheckBox pAlmacen;
    private javax.swing.JCheckBox pComercial;
    private javax.swing.JCheckBox pCompras;
    private javax.swing.JCheckBox pIngenieria;
    private javax.swing.JCheckBox pProduccion;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
