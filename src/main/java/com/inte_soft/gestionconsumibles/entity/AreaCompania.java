/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alejo
 */
@Entity
@Table(name = "area_compania")
public class AreaCompania implements java.io.Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AREA")
    private Integer idArea;
    @Column(name = "NOMBRE_AREA")
    private String nombreArea;

    public AreaCompania() {
    }

    public AreaCompania(int areaCompania, String nombreArea) {
        this.idArea = areaCompania;
        this.nombreArea = nombreArea;
    }
    
    @Id
    @Column(name = "ID_AREA")
    public Integer getAreaCompania() {
        return idArea;
    }

    @Column(name = "NOMBRE_AREA")
    public String getNombreArea() {
        return nombreArea;
    }
    @Column(name = "ID_AREA")
    public void setAreaCompania(Integer idArea) {
        this.idArea = idArea;
    }
    @Column(name = "NOMBRE_AREA")
    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }
    
    
}
