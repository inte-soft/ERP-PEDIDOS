/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.serviceImplement;

import com.inte_soft.gestionconsumibles.dao.AreaCompañiaDao;
import com.inte_soft.gestionconsumibles.dao.UsuariosDao;
import com.inte_soft.gestionconsumibles.dto.UsuariosDto;
import com.inte_soft.gestionconsumibles.entity.Usuarios;
import com.inte_soft.gestionconsumibles.service.UsuariosServices;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author alejo
 */

public class UsuariosServiceImplement implements UsuariosServices{
    
    private UsuariosDao usuariosDao;
    private UsuariosDto usuariosDto;
    
    @Override
    public String createUser(UsuariosDto usuariosDto) {
        Usuarios usuarios = new Usuarios();
        AreaCompañiaDao areaCompañiaDao = new AreaCompañiaDao();
        usuarios.setIdUsuario(usuariosDto.getIdUsuario());
        usuarios.setUsuario(usuariosDto.getUsuario());
        usuarios.setContraseña(usuariosDto.getContraseña());
        usuarios.setNombres(usuariosDto.getNombre());
        usuarios.setApellidos(usuariosDto.getContraseña());
        usuarios.setAreaCompañia(areaCompañiaDao.getById(usuariosDto.getIdAreaCompañia()));
        usuarios.setIdUsuario(usuariosDto.getIdUsuario());
        
        usuariosDao = new UsuariosDao();
        usuariosDao.crate(usuarios);
        return "user create succeful";
       
    }

    @Override
    public Usuarios getPassword(String user) {
     usuariosDao = new UsuariosDao();
     Usuarios usuarios = usuariosDao.getByUser(user);
     
     return usuarios;
    }

    @Override
    public List<UsuariosDto> getAllUsers() {
        usuariosDao = new UsuariosDao();
        List<Usuarios> usuarios = usuariosDao.getAll();
        List<UsuariosDto> usuariosDtoList = new ArrayList();
        
        for(Usuarios user : usuarios){
            UsuariosDto usuariosDto = new UsuariosDto();
            usuariosDto.setIdUsuario(user.getIdUsuario());
            usuariosDto.setUsuario(user.getUsuario());
            usuariosDto.setContraseña(user.getContraseña());
            usuariosDto.setNombre(user.getNombres());
            usuariosDto.setApellido(user.getApellidos());
            usuariosDto.setIdAreaCompañia(user.getAreaCompañia().getNombreArea());
            usuariosDto.setpAlmacen(user.getpAlmacen());
            usuariosDto.setpIngenieria(user.getpIngenieria());
            usuariosDto.setpAdminUser(user.getpAdminUser());
            usuariosDto.setpCompras(user.getpCompras());
            usuariosDto.setpComercial(user.getpComercial());
            usuariosDto.setpProduccion(user.getpProduccion());
            
            usuariosDtoList.add(usuariosDto);
          
        }
        return usuariosDtoList;
    }
    
    
}
