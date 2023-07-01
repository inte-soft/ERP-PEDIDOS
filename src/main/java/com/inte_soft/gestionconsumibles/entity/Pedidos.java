/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.entity;

import java.util.Date;
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
@Table(name = "pedidos")
public class Pedidos  implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDIDO")
    private int idPedido;
    @Column(name = "OT")
    private int ot;
    @Column(name = "PERSONA_ELABORA")
    private String persona;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_AREA")
    private AreaCompania area;
    @Column(name = "FECHA")
    private Date fecha;
    @Column(name = "OPERACION")
    private String operacion;
    @Column(name = "REVISADO")
    private boolean revisado;
    

    public Pedidos() {
    }

    public Pedidos(int ot,String persona, AreaCompania area, Date fecha, String operacion, boolean revisado) {
        this.persona = persona;
        this.ot = ot;
        this.area = area;
        this.fecha = fecha;
        this.operacion = operacion;
        this.revisado = revisado;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getOt() {
        return ot;
    }

    public void setOt(int ot) {
        this.ot = ot;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public AreaCompania getArea() {
        return area;
    }

    public void setArea(AreaCompania area) {
        this.area = area;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public boolean isRevisado() {
        return revisado;
    }

    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }

    
   
    
   
}

