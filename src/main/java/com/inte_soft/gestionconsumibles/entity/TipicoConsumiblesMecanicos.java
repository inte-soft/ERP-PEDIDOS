/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.entity;

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
@Table(name = "tipico_consumibles_electricos")
public class TipicoConsumiblesMecanicos {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ID_CONSUMIBLE_M")
   private int idConsumibleM;
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "CODIGO")
   private Master master;

    public TipicoConsumiblesMecanicos() {
    }

    public TipicoConsumiblesMecanicos(int idConsumibleM, Master master) {
        this.idConsumibleM = idConsumibleM;
        this.master = master;
    }

    public int getIdConsumibleM() {
        return idConsumibleM;
    }

    public void setIdConsumibleM(int idConsumibleM) {
        this.idConsumibleM = idConsumibleM;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }
   
   
}
