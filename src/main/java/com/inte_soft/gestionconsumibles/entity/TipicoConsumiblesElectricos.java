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
public class TipicoConsumiblesElectricos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONSUMIBLE_E")
    private int idConsumibleE;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CODIGO")
    private Master master;
    @Column(name = "CMAX")
    private Integer cMax;
    @Column(name = "CMIN")
    private Integer cMin;

    public TipicoConsumiblesElectricos() {
    }

    public TipicoConsumiblesElectricos(int idConsumibleE, Master master, Integer cMax, Integer cMin) {
        this.idConsumibleE = idConsumibleE;
        this.master = master;
        this.cMax = cMax;
        this.cMin = cMin;
    }

    public int getIdConsumibleE() {
        return idConsumibleE;
    }

    public void setIdConsumibleE(int idConsumibleE) {
        this.idConsumibleE = idConsumibleE;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }
    
    public Integer getMax() {
        return cMax;
    }

    public void setMax(Integer max) {
        this.cMax = max;
    }

    public Integer getMin() {
        return cMin;
    }

    public void setMin(Integer cMin) {
        this.cMin = cMin;
    }

}
