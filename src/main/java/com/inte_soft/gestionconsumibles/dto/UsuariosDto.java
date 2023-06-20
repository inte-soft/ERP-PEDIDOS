/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.dto;

/**
 *
 * @author alejo
 */
public class UsuariosDto {
    private int idUsuario;
    private String usuario;
    private String contraseña;
    private String nombre;
    private String apellido;
    private String idAreaCompañia;

    public UsuariosDto() {
    }
    
    

    public UsuariosDto(int idUsuario, String usuario, String contraseña, String nombre, String apellido, String idAreaCompañia) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idAreaCompañia = idAreaCompañia;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setIdAreaCompañia(String idAreaCompañia) {
        this.idAreaCompañia = idAreaCompañia;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getIdAreaCompañia() {
        return idAreaCompañia;
    }
    
    
    
}
