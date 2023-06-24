/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inte_soft.gestionconsumibles.service;

import com.inte_soft.gestionconsumibles.dto.UsuariosDto;
import com.inte_soft.gestionconsumibles.entity.Usuarios;
import java.util.List;

/**
 *
 * @author alejo
 */

public interface UsuariosServices {
    public String createUser(UsuariosDto usuariosDto);
    public Usuarios getPassword(String user);
    public List<UsuariosDto> getAllUsers();
}
