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
    private boolean pAlmacen;
    private boolean pIngenieria;
    private boolean pAdminUser;
    private boolean pCompras;
    private boolean pComercial;
    private boolean pProduccion;

    public UsuariosDto() {
    }

    public UsuariosDto(int idUsuario, String usuario, String contraseña, String nombre, String apellido, String idAreaCompañia, boolean pAlmacen, boolean pIngenieria, boolean pAdminUser, boolean pCompras, boolean pComercial, boolean pProduccion) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idAreaCompañia = idAreaCompañia;
        this.pAlmacen = pAlmacen;
        this.pIngenieria = pIngenieria;
        this.pAdminUser = pAdminUser;
        this.pCompras = pCompras;
        this.pComercial = pComercial;
        this.pProduccion = pProduccion;
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

    public void setpAlmacen(boolean pAlmacen) {
        this.pAlmacen = pAlmacen;
    }

    public void setpIngenieria(boolean pIngenieria) {
        this.pIngenieria = pIngenieria;
    }

    public void setpAdminUser(boolean pAdminUser) {
        this.pAdminUser = pAdminUser;
    }

    public void setpComercial(boolean pComercial) {
        this.pComercial = pComercial;
    }

    public void setpProduccion(boolean pProduccion) {
        this.pProduccion = pProduccion;
    }

    public void setpCompras(boolean pCompras) {
        this.pCompras = pCompras;
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

    public boolean getpAlmacen() {
        return pAlmacen;
    }

    public boolean getpIngenieria() {
        return pIngenieria;
    }

    public boolean getpAdminUser() {
        return pAdminUser;
    }

    public boolean getpComercial() {
        return pComercial;
    }

    public boolean getpProduccion() {
        return pProduccion;
    }

    public boolean getpCompras() {
        return pCompras;
    }
    
    
    
}
