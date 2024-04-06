package com.inte_soft.gestionconsumibles.dto;

public class PendientesDto {
    private String ot;
    private String codigo;
    private String descripcion;
    private String tipo;
    private String referencia;
    private String marca;
    private String unidad;
    private double cantidad;
    private double alistado;
    private String area;

    public PendientesDto() {
    }

    public PendientesDto(String ot, String codigo, String descripcion, String tipo, String referencia, String marca, String unidad, double cantidad, double alistado, String area) {
        this.ot = ot;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.referencia = referencia;
        this.marca = marca;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.alistado = alistado;
        this.area = area;
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

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getAlistado() {
        return alistado;
    }

    public void setAlistado(double alistado) {
        this.alistado = alistado;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
