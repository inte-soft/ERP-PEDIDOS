/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.controller;


import com.inte_soft.gestionconsumibles.dto.UsuariosDto;
import com.inte_soft.gestionconsumibles.entity.Usuarios;
import com.inte_soft.gestionconsumibles.service.UsuariosServices;
import java.util.List;
import com.inte_soft.gestionconsumibles.serviceImplement.UsuariosServiceImplement;
import com.inte_soft.gestionconsumibles.util.AdvertenciaModal;
import javax.swing.JDialog;

/**
 *
 * @author alejo
 */
public class UsuariosController {
    
   private UsuariosServices usuariosServices;
   
   public UsuariosController() {
       usuariosServices = new UsuariosServiceImplement();
   }
   
   public boolean login(String user, String password){
       Usuarios usuario = usuariosServices.getPassword(user);
       boolean ingreso = false;
       if(usuario.getContraseña().equals(password)){
           ingreso= true;
       }
       return ingreso;
   }
   
   public List<UsuariosDto> getAllUser(){
        return  usuariosServices.getAllUsers();
   }
   public void createUser(UsuariosDto usuario, JDialog modal){
       
       if (!usuariosServices.validateUser(usuario.getUsuario().toString(), modal)){
           usuariosServices.createUser(usuario, modal);
       }else{
           AdvertenciaModal advertenciaModal = new AdvertenciaModal();
           advertenciaModal.advertenciaModal(modal,"Usuario ya existe", "Advertencia");
           
       }
       
   }

    public Usuarios getById(int id) {
        return usuariosServices.getById( id);
    }

    public void modifyUser(UsuariosDto usuariosDto, JDialog modal) {
        usuariosServices.modifyUser(usuariosDto,  modal);
    }

    public void deleteUser(int id) {
        usuariosServices.deleteUser(id);
    }
}
