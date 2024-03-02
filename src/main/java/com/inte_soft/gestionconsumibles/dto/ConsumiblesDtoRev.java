/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.dto;

import java.math.BigInteger;

/**
 *
 * @author alejo
 */
public class ConsumiblesDtoRev {
    
    private BigInteger idPdedidoConsumibles;
    private Integer idPedido;
    private String ot;
    private String codigo;
    private String descripcion;
    private String tipo;
    private String referencia;
    private String marca;
    private String unidad;
    private Float cantidad;

    public ConsumiblesDtoRev() {
    }

    public ConsumiblesDtoRev(BigInteger idPdedidoConsumibles, Integer idPedido, String ot, String codigo, String descripcion, String tipo, String referencia, String marca, String unidad, Float cantidad) {
        this.idPdedidoConsumibles = idPdedidoConsumibles;
        this.idPedido = idPedido;
        this.ot = ot;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.referencia = referencia;
        this.marca = marca;
        this.unidad = unidad;
        this.cantidad = cantidad;
    }

    public BigInteger getIdPdedidoConsumibles() {
        return idPdedidoConsumibles;
    }

    public void setIdPdedidoConsumibles(BigInteger idPdedidoConsumibles) {
        this.idPdedidoConsumibles = idPdedidoConsumibles;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getOt() {
        return ot;
    }

    public void setOt(String ot) {
        this.ot = ot;
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

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    

   


    
    
}
