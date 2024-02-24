package com.inte_soft.gestionconsumibles.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Ot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "OT")
    private String ot;

    @Column(name = "TERMINADO")
    private Boolean terminado;
    
    @Column(name = "ALISTADO")
    private  Boolean alistado;

    public Ot() {
    }

    public Ot(Integer id, String ot, Boolean terminado, Boolean alistado) {
        this.id = id;
        this.ot = ot;
        this.terminado = terminado;
        this.alistado = alistado;
    }

    public Ot(String ot, Boolean terminado, Boolean alistado) {
        this.ot = ot;
        this.terminado = terminado;
        this.alistado = alistado;
    }

    public Ot(String ot, Boolean terminado) {
        this.ot = ot;
        this.terminado = terminado;
    }

    public Integer getIdOt() {
        return id;
    }

    public void setIdOt(Integer id) {
        this.id = id;
    }

    public String getOt() {
        return ot;
    }

    public void setOt(String ot) {
        this.ot = ot;
    }

    public Boolean getTerminado() {
        return terminado;
    }

    public void setTerminado(Boolean terminado) {
        this.terminado = terminado;
    }

    public Boolean getAlistado() {
        return alistado;
    }

    public void setAlistado(Boolean alistado) {
        this.alistado = alistado;
    }
    
    
}
