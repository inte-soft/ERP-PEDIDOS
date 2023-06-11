/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alejo
 */
@Entity
@Table(name = "master")
public class Master {
    
    @Id
    private String codigo;
    private String descripcion;
    private String tipo;
    private String referencia;
    private String marca;
    private String unidad;
    private String precio_lista;
    private String fecha_actualizacion;
    private String descuento_basico;
    private String descuento_proyecto;
    private String precio_descuento;
    private String precio_descuento_proyecto;
    private String precio_ultima_compra;

    public Master() {
    }

    public Master(String codigo, String descripcion, String tipo, String referencia, String marca, String unidad, String precio_lista, String fecha_actualizacion, String descuento_basico, String descuento_proyecto, String precio_descuento, String precio_descuento_proyecto, String precio_ultima_compra) {
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

    public String getPrecio_lista() {
        return precio_lista;
    }

    public void setPrecio_lista(String precio_lista) {
        this.precio_lista = precio_lista;
    }

    public String getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(String fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public String getDescuento_basico() {
        return descuento_basico;
    }

    public void setDescuento_basico(String descuento_basico) {
        this.descuento_basico = descuento_basico;
    }

    public String getDescuento_proyecto() {
        return descuento_proyecto;
    }

    public void setDescuento_proyecto(String descuento_proyecto) {
        this.descuento_proyecto = descuento_proyecto;
    }

    public String getPrecio_descuento() {
        return precio_descuento;
    }

    public void setPrecio_descuento(String precio_descuento) {
        this.precio_descuento = precio_descuento;
    }

    public String getPrecio_descuento_proyecto() {
        return precio_descuento_proyecto;
    }

    public void setPrecio_descuento_proyecto(String precio_descuento_proyecto) {
        this.precio_descuento_proyecto = precio_descuento_proyecto;
    }

    public String getPrecio_ultima_compra() {
        return precio_ultima_compra;
    }

    public void setPrecio_ultima_compra(String precio_ultima_compra) {
        this.precio_ultima_compra = precio_ultima_compra;
    }
    
    
    
}
