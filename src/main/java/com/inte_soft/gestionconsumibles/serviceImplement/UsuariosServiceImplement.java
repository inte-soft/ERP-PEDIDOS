/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.inte_soft.gestionconsumibles.dao.AreaCompañiaDao;
import com.inte_soft.gestionconsumibles.dao.UsuariosDao;
import com.inte_soft.gestionconsumibles.dto.UsuariosDto;
import com.inte_soft.gestionconsumibles.entity.Usuarios;
import com.inte_soft.gestionconsumibles.service.UsuariosServices;


/**
 *
 * @author alejo
 */

public class UsuariosServiceImplement implements UsuariosServices{
    
    private UsuariosDao usuariosDao;
    
    @Override
    public String CreateUser(UsuariosDto usuariosDto) {
     Usuarios usuarios = new Usuarios();
        AreaCompañiaDao areaCompañiaDao = new AreaCompañiaDao();
        usuarios.setIdUsuario(usuariosDto.getIdUsuario());
        usuarios.setUsuario(usuariosDto.getUsuario());
        usuarios.setContraseña(usuariosDto.getContraseña());
        usuarios.setNombre(usuariosDto.getNombre());
        usuarios.setApellido(usuariosDto.getContraseña());
        usuarios.setAreaCompañia(areaCompañiaDao.getById(usuariosDto.getIdAreaCompañia()));
        usuarios.setIdUsuario(usuariosDto.getIdUsuario());
        
        usuariosDao = new UsuariosDao();
        usuariosDao.crate(usuarios);
        return "user create succeful";
       
     }
}
