/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.serviceImplement;

import com.inte_soft.gestionconsumibles.dao.AreaCompaniaDao;
import com.inte_soft.gestionconsumibles.dao.UsuariosDao;
import com.inte_soft.gestionconsumibles.dto.UsuariosDto;
import com.inte_soft.gestionconsumibles.entity.Usuarios;
import com.inte_soft.gestionconsumibles.service.UsuariosServices;
import com.inte_soft.gestionconsumibles.util.AdvertenciaModal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;


/**
 *
 * @author alejo
 */

public class UsuariosServiceImplement implements UsuariosServices{
    
    private UsuariosDao usuariosDao;
    private UsuariosDto usuariosDto;
    
    @Override
    public void createUser(UsuariosDto usuariosDto, JDialog modal) {
        AreaCompaniaDao areaCompaniaDao = new AreaCompaniaDao();
        Usuarios usuarios = new Usuarios();
        
        try{
            Integer area = areaCompaniaDao.getByNombreArea(usuariosDto.getIdAreaCompañia()).getAreaCompania();
            usuarios.setUsuario(usuariosDto.getUsuario());
            usuarios.setContraseña(usuariosDto.getContraseña());
            usuarios.setNombres(usuariosDto.getNombre());
            usuarios.setApellidos(usuariosDto.getApellido());
            usuarios.setAreaCompania(areaCompaniaDao.getById(area));
            usuarios.setpAlmacen(usuariosDto.getpAlmacen());
            usuarios.setpIngenieria(usuariosDto.getpIngenieria());
            usuarios.setpAdminUser(usuariosDto.getpAdminUser());
            usuarios.setpCompras(usuariosDto.getpCompras());
            usuarios.setpComercial(usuariosDto.getpComercial());
            usuarios.setpProduccion(usuariosDto.getpProduccion());
            

            usuariosDao = new UsuariosDao();
            usuariosDao.create(usuarios);
        }catch(Exception e){
           
            e.printStackTrace();
            AdvertenciaModal advertenciaModal = new AdvertenciaModal();
            advertenciaModal.advertenciaModal(modal,"Error al crear el usuario. Consulta la consola para obtener más detalles", "Error");
            
        }
        
        
        
       
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
            usuariosDto.setIdAreaCompañia(user.getAreaCompania().getNombreArea());
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

    @Override
    public boolean validateUser(String user, JDialog modal) {
        usuariosDao = new UsuariosDao();
        List<Usuarios> usuariosList = usuariosDao.getAll();
        for(Usuarios usuarios : usuariosList){
            
          if(user.equals(usuarios.getUsuario().toString())){
              return true;
          }
            
        }
        
       return false; 
        
    }

    @Override
    public Usuarios getById(int id) {
        usuariosDao = new UsuariosDao();
        return usuariosDao.getById(id);
    }

    @Override
    public void modifyUser(UsuariosDto usuariosDto, JDialog modal) {
        AreaCompaniaDao areaCompaniaDao = new AreaCompaniaDao();
        Usuarios usuarios = new Usuarios();
        try{
            Integer area = areaCompaniaDao.getByNombreArea(usuariosDto.getIdAreaCompañia()).getAreaCompania();
            usuarios.setIdUsuario(usuariosDto.getIdUsuario());
            usuarios.setUsuario(usuariosDto.getUsuario());
            usuarios.setContraseña(usuariosDto.getContraseña());
            usuarios.setNombres(usuariosDto.getNombre());
            usuarios.setApellidos(usuariosDto.getApellido());
            usuarios.setAreaCompania(areaCompaniaDao.getById(area));
            usuarios.setpAlmacen(usuariosDto.getpAlmacen());
            usuarios.setpIngenieria(usuariosDto.getpIngenieria());
            usuarios.setpAdminUser(usuariosDto.getpAdminUser());
            usuarios.setpCompras(usuariosDto.getpCompras());
            usuarios.setpComercial(usuariosDto.getpComercial());
            usuarios.setpProduccion(usuariosDto.getpProduccion());
            

            usuariosDao = new UsuariosDao();
            usuariosDao.update(usuarios);
        }catch(Exception e){
            e.printStackTrace();
            AdvertenciaModal advertenciaModal = new AdvertenciaModal();
            advertenciaModal.advertenciaModal(modal,"No se puede modificar el usuario", "Error");;
            
            
        }
        
    }

    @Override
    public void deleteUser(int id) {
        usuariosDao = new UsuariosDao();
            usuariosDao.delete(id);
    }
    
    
}
