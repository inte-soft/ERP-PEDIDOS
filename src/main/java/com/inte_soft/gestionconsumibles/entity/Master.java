/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Formula;



/**
 *
 * @author alejo
 */
@Entity
@Table(name = "master")
public class Master implements java.io.Serializable {
    
    @Id
    private String codigo;
    private String descripcion;
    private String tipo;
    private String referencia;
    private String marca;
    private String unidad;
    private double precio_lista;
    private String fecha_actualizacion;
    private double descuento_basico;
    private double descuento_proyecto;
    @Formula("PRECIO_LISTA * DESCUENTO_BASICO")
    private double precio_descuento;
    @Formula("PRECIO_LISTA * DESCUENTO_PROYECTO")
    private double precio_descuento_proyecto;
    private double precio_ultima_compra;

    public Master() {
    }

    public Master(String codigo, String descripcion, String tipo, String referencia, String marca, String unidad,
            double precio_lista, String fecha_actualizacion, double descuento_basico, double descuento_proyecto,
            double precio_descuento, double precio_descuento_proyecto, double precio_ultima_compra) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.referencia = referencia;
        this.marca = marca;
        this.unidad = unidad;
        this.precio_lista = precio_lista;
        this.fecha_actualizacion = fecha_actualizacion;
        this.descuento_basico = descuento_basico;
        this.descuento_proyecto = descuento_proyecto;
        this.precio_descuento = precio_descuento;
        this.precio_descuento_proyecto = precio_descuento_proyecto;
        this.precio_ultima_compra = precio_ultima_compra;
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

    public double getPrecio_lista() {
        return precio_lista;
    }

    public void setPrecio_lista(double precio_lista) {
        this.precio_lista = precio_lista;
    }

    public String getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(String fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public double getDescuento_basico() {
        return descuento_basico;
    }

    public void setDescuento_basico(double descuento_basico) {
        this.descuento_basico = descuento_basico;
    }

    public double getDescuento_proyecto() {
        return descuento_proyecto;
    }

    public void setDescuento_proyecto(double descuento_proyecto) {
        this.descuento_proyecto = descuento_proyecto;
    }

    public double getPrecio_descuento() {
        return precio_descuento;
    }

    public void setPrecio_descuento(double precio_descuento) {
        this.precio_descuento = precio_descuento;
    }

    public double getPrecio_descuento_proyecto() {
        return precio_descuento_proyecto;
    }

    public void setPrecio_descuento_proyecto(double precio_descuento_proyecto) {
        this.precio_descuento_proyecto = precio_descuento_proyecto;
    }

    public double getPrecio_ultima_compra() {
        return precio_ultima_compra;
    }

    public void setPrecio_ultima_compra(double precio_ultima_compra) {
        this.precio_ultima_compra = precio_ultima_compra;
    }
    
    
    
}
