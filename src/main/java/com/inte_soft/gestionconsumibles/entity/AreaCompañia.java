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
@Table(name = "area_compañia")
public class AreaCompañia implements java.io.Serializable {
    
    @Id
    private int areaCompañia;
    private String nombreArea;

    public AreaCompañia() {
    }

    public AreaCompañia(int areaCompañia, String nombreArea) {
        this.areaCompañia = areaCompañia;
        this.nombreArea = nombreArea;
    }
    
    @Id
    @Column(name = "ID_AREA")
    public int getAreaCompañia() {
        return areaCompañia;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setAreaCompañia(int areaCompañia) {
        this.areaCompañia = areaCompañia;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }
    
    
}
