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
import javax.swing.JOptionPane;

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
   public void createUser(UsuariosDto usuario){
       if (!usuariosServices.validateUser(usuario.getUsuario().toString())){
           usuariosServices.createUser(usuario);
       }else{
           JOptionPane.showMessageDialog(null, "Usuario ya existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
       }
       
   }

    public Usuarios getById(int id) {
        return usuariosServices.getById( id);
    }

    public void modifyUser(UsuariosDto usuariosDto) {
        usuariosServices.modifyUser(usuariosDto);
    }

    public void deleteUser(int id) {
        usuariosServices.deleteUser(id);
    }
}
