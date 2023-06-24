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
@Table(name = "usuarios")
public class Usuarios implements java.io.Serializable {
    
    @Id
    private int idUsuario;
    private String usuario;
    private String contraseña;
    private String nombres;
    private String apellidos;
    private AreaCompania areaCompania;
    private boolean pAlmacen;
    private boolean pIngenieria;
    private boolean pAdminUser;
    private boolean pCompras;
    private boolean pComercial;
    private boolean pProduccion;
    
    

    public Usuarios() {
    }

    public Usuarios(String usuario, String contraseña, String nombre, String apellido, AreaCompania areaCompañia, boolean pAlmacen, boolean pIngenieria, boolean pAdminUser, boolean pCompras, boolean pComercial, boolean pProduccion) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombres = nombre;
        this.apellidos = apellido;
        this.areaCompania = areaCompañia;
        this.pAlmacen = pAlmacen;
        this.pIngenieria = pIngenieria;
        this.pAdminUser = pAdminUser;
        this.pCompras = pCompras;
        this.pComercial = pComercial;
        this.pProduccion = pProduccion;
    }

    
    
    @Id
    @Column(name = "ID_USUARIO")
    public int getIdUsuario() {
        return idUsuario;
    }
    
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Column(name = "USUARIO")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    @Column(name = "P_ALMACEN")
    public void setpAlmacen(boolean pAlmacen) {
        this.pAlmacen = pAlmacen;
    }
    
    @Column(name = "P_INGENIERIA")
    public void setpIngenieria(boolean pIngenieria) {
        this.pIngenieria = pIngenieria;
    }

    @Column(name = "P_ADMIN_USER")
    public void setpAdminUser(boolean pAdminUser) {
        this.pAdminUser = pAdminUser;
    }

    @Column(name = "P_COMERCIAL")
    public void setpComercial(boolean pComercial) {
        this.pComercial = pComercial;
    }

    @Column(name = "P_PRODUCCION")
    public void setpProduccion(boolean pProduccion) {
        this.pProduccion = pProduccion;
    }
    
    @Column(name = "CONTRASEÑA")
    public String getContraseña() {
        return contraseña;
    }

    @Column(name = "CONTRASEÑA")
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Column(name = "NOMBRES")
    public String getNombres() {
        return nombres;
    }

    @Column(name = "NOMBRES")
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    @Column(name = "APELLIDOS")
    public String getApellidos() {
        return apellidos;
    }

    @Column(name = "APELLIDOS")
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_AREA")
    public AreaCompania getAreaCompania() {
        return areaCompania;
    }

    @Column(name = "ID_AREA")
    public void setAreaCompania(AreaCompania areaCompania) {
        this.areaCompania = areaCompania;
    }
 
    @Column(name = "P_COMPRAS")
    public void setpCompras(boolean pCompras) {
        this.pCompras = pCompras;
    }

    @Column(name = "P_ALMACEN")
    public boolean getpAlmacen() {
        return pAlmacen;
    }

    @Column(name = "P_INGENIERIA")
    public boolean getpIngenieria() {
        return pIngenieria;
    }
    @Column(name = "P_ADMIN_USER")
    public boolean getpAdminUser() {
        return pAdminUser;
    }

    @Column(name = "P_COMERCIAL")
    public boolean getpComercial() {
        return pComercial;
    }

    @Column(name = "P_PRODUCCION")
    public boolean getpProduccion() {
        return pProduccion;
    }
    @Column(name = "P_COMPRAS")
    public boolean getpCompras() {
        return pCompras;
    }

    
    
    
}
