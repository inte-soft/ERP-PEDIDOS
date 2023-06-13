/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
@Table(name = "PEDIDO_CONSUMIBLES")
public class PedidoConsumibles implements java.io.Serializable {
    
    @Id
    private BigInteger  idPedidoConsumibles;
    private Pedidos pedidos;
    private int ot;
    private int item;
    private Integer codigo;
    private String descripcion;
    private String tipo;
    private String referencia;
    private String marca;
    private String unidad;
    private String cantidad;
    private Integer valor;
    private String inicial_adicional;
    private Date fecha;
    private String operation;

    public PedidoConsumibles() {
    }

    public PedidoConsumibles(BigInteger idPedidoConsumibles, Pedidos pedidos, int ot, int item, Integer codigo, String descripcion, String tipo, String referencia, String marca, String unidad, String cantidad, Integer valor, String inicial_adicional, Date fecha, String operation) {
        this.idPedidoConsumibles = idPedidoConsumibles;
        this.pedidos = pedidos;
        this.ot = ot;
        this.item = item;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.referencia = referencia;
        this.marca = marca;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.valor = valor;
        this.inicial_adicional = inicial_adicional;
        this.fecha = fecha;
        this.operation = operation;
    }
    
    @Id
    @Column(name= "ID_PEDIDO_CONSUMIBLES", unique = true, nullable = false)
    public BigInteger getIdPedidoConsumibles() {
        return idPedidoConsumibles;
    }
    
    public void setIdPedidoConsumibles(BigInteger idPedidoConsumibles) {
        this.idPedidoConsumibles = idPedidoConsumibles;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PEDIDO")
    public Pedidos getId_pedido() {
        return pedidos;
    }

    public void setId_pedido(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public int getOt() {
        return ot;
    }

    public void setOt(int ot) {
        this.ot = ot;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getInicial_adicional() {
        return inicial_adicional;
    }

    public void setInicial_adicional(String inicial_adicional) {
        this.inicial_adicional = inicial_adicional;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
    
    
    
    
}
