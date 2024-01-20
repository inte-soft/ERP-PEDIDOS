package com.inte_soft.gestionconsumibles.dto;

import java.math.BigInteger;

public class PedidoConsumiblesDto {
    
    private BigInteger idPedidoC;
    private Integer idPedido;
    private String item;
    private String codigo;
    private String descripcion;
    private String tipo;
    private String referencia;
    private String marca;
    private String unidad;
    private Float cantidad;
    private Double valor;
    private String observacion;
    private Integer minimo;
    private Integer maximo;
    

    public PedidoConsumiblesDto() {
    }

    public PedidoConsumiblesDto(BigInteger idPedidoC, Integer idPedido, String item, String codigo, String descripcion, String tipo, String referencia, String marca, String unidad, Float cantidad, Double valor, String observacion, Integer minimo, Integer maximo) {
        this.idPedidoC = idPedidoC;
        this.idPedido = idPedido;
        this.item = item;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.referencia = referencia;
        this.marca = marca;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.valor = valor;
        this.observacion = observacion;
        this.minimo = minimo;
        this.maximo = maximo;
    }

    

    public BigInteger getIdPedidoC() {
        return idPedidoC;
    }

    public void setIdPedidoC(BigInteger idPedidoC) {
        this.idPedidoC = idPedidoC;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
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

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getMinimo() {
        return minimo;
    }

    public void setMinimo(Integer minimo) {
        this.minimo = minimo;
    }

    public Integer getMaximo() {
        return maximo;
    }

    public void setMaximo(Integer maximo) {
        this.maximo = maximo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    
    
    
    
}
