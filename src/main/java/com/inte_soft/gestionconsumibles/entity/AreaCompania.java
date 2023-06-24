/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Column(name = "ID_AREA")
    private int idArea;
    @Column(name = "NOMBRE_AREA")
    private String nombreArea;

    public AreaCompania() {
    }

    public AreaCompania(int areaCompañia, String nombreArea) {
        this.idArea = areaCompañia;
        this.nombreArea = nombreArea;
    }
    
    @Id
    @Column(name = "ID_AREA")
    public int getAreaCompañia(int idAreaCompañia) {
        return idArea;
    }

    @Column(name = "NOMBRE_AREA")
    public String getNombreArea() {
        return nombreArea;
    }
    @Column(name = "ID_AREA")
    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }
    @Column(name = "NOMBRE_AREA")
    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }
    
    
}
