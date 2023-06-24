/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.controller;

import com.inte_soft.gestionconsumibles.entity.Usuarios;
import com.inte_soft.gestionconsumibles.service.UsuariosServices;

/**
 *
 * @author alejo
 */
public class UsuariosController {
    
   private UsuariosServices usuariosServices;
   
   public boolean login(String user, String password){
       Usuarios usuario = usuariosServices.getPassword(user);
       boolean ingreso = false;
       if(usuario.getContraseña().equals(password)){
           ingreso= true;
       }
       return ingreso;
   }
   
   public void getAllUser(){
       
   }
}
