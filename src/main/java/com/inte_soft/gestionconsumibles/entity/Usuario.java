/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author alejo
 */
@Entity
@Table(name = "pedido_consumibles")
public class Usuario implements java.io.Serializable {
    
    @Id
    private int idUsuario;
    private String usuario;
    private String contraseña;
    private String nombre;
    private String apellido;
    private AreaCompañia areaCompañia;

    public Usuario() {
    }

    public Usuario(int idUsuario, String usuario, String contraseña, String nombre, String apellido, AreaCompañia areaCompañia) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.areaCompañia = areaCompañia;
    }
    
    @Id
    @Column(name = "ID_USUARIO")
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_AREA")
    public AreaCompañia getAreaCompañia() {
        return areaCompañia;
    }

    public void setAreaCompañia(AreaCompañia areaCompañia) {
        this.areaCompañia = areaCompañia;
    }
    
    
}
