/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.logging.Logger;
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
@Table(name = "PEDIDOS_CONSUMIBLES")
public class PedidoConsumibles implements java.io.Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDIDO_CONSUMIBLES")
    private BigInteger  idPedidoConsumibles;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PEDIDO")
    private Pedidos pedidos;
    @Column(name = "ITEM")
    private String item;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "REFERENCIA")
    private String referencia;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "UNIDAD")
    private String unidad;
    @Column(name = "CANTIDAD")
    private float cantidad;
    @Column(name = "VALOR")
    private double valor;
    @Column(name = "REVISADO")
    private Boolean revisado;

    @Column(name = "ALISTADO")
    private double alistado;
    @Column(name = "OBSERVACION")
    private String observacion;


    public PedidoConsumibles() {
    }

    public PedidoConsumibles(BigInteger idPedidoConsumibles, Pedidos pedidos, String item, String codigo, String descripcion, String tipo, String referencia, String marca, String unidad, float cantidad, double valor, Boolean revisado, double alistado, String observacion) {
        this.idPedidoConsumibles = idPedidoConsumibles;
        this.pedidos = pedidos;
        this.item = item;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.referencia = referencia;
        this.marca = marca;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.valor = valor;
        this.revisado = revisado;
        this.alistado = alistado;
        this.observacion = observacion;
    }

    



    public BigInteger getIdPedidoConsumibles() {
        return idPedidoConsumibles;
    }

    public void setIdPedidoConsumibles(BigInteger idPedidoConsumibles) {
        this.idPedidoConsumibles = idPedidoConsumibles;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Boolean getRevisado() {
        return revisado;
    }

    public void setRevisado(Boolean revisado) {
        this.revisado = revisado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public double getAlistado() {
        return alistado;
    }

    public void setAlistado(double alistado) {
        this.alistado = alistado;
    }


    
    
    
   
    
}
