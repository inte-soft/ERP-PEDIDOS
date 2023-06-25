/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private int idUsuario;
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "CONTRASEÑA")
    private String contraseña;
    @Column(name = "NOMBRES")
    private String nombres;
    @Column(name = "APELLIDOS")
    private String apellidos;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_AREA")
    private AreaCompania areaCompania;
    @Column(name = "P_ALMACEN")
    private boolean pAlmacen;
    @Column(name = "P_INGENIERIA")
    private boolean pIngenieria;
    @Column(name = "P_ADMIN_USER")
    private boolean pAdminUser;
    @Column(name = "P_COMPRAS")
    private boolean pCompras;
    @Column(name = "P_COMERCIAL")
    private boolean pComercial;
    @Column(name = "P_PRODUCCION")
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
    
    
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public AreaCompania getAreaCompania() {
        return areaCompania;
    }

    public void setAreaCompania(AreaCompania areaCompania) {
        this.areaCompania = areaCompania;
    }

    public void setpCompras(boolean pCompras) {
        this.pCompras = pCompras;
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
