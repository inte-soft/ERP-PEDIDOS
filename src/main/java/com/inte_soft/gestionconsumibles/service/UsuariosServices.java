/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inte_soft.gestionconsumibles.service;

import com.inte_soft.gestionconsumibles.dto.UsuariosDto;
import com.inte_soft.gestionconsumibles.entity.Usuarios;
import java.util.List;
import javax.swing.JDialog;

/**
 *
 * @author alejo
 */

public interface UsuariosServices {
    public boolean validateUser (String User, JDialog modal);
    public void createUser(UsuariosDto usuariosDto, JDialog modal);
    public Usuarios getPassword(String user);
    public List<UsuariosDto> getAllUsers();
    public Usuarios getById(int user);

    public void modifyUser(UsuariosDto usuariosDto, JDialog modal);

    public void deleteUser(int id);
}
