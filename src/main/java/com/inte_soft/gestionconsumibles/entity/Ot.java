package com.inte_soft.gestionconsumibles.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Ot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OT")
    private Integer idOt;
    @Column(name = "OT")
    private Integer ot;
    @Column(name = "FECHA_ALMACEN")
    private Date fechaAlmacen;

    @Column(name = "TERMINADO")
    private Boolean terminado;
    
    @Column(name = "ALISTADO")
    private  Boolean alistado;

    public Ot() {
    }

    public Ot(Integer idOt, Integer ot, Date fechaAlmacen, Boolean terminado, Boolean alistado) {
        this.idOt = idOt;
        this.ot = ot;
        this.fechaAlmacen = fechaAlmacen;
        this.terminado = terminado;
        this.alistado = alistado;
    }

    public Ot(Integer ot, Date fechaAlmacen, Boolean terminado, Boolean alistado) {
        this.ot = ot;
        this.fechaAlmacen = fechaAlmacen;
        this.terminado = terminado;
        this.alistado = alistado;
    }

    public Ot(Integer ot, Date fechaAlmacen, Boolean terminado) {
        this.ot = ot;
        this.fechaAlmacen = fechaAlmacen;
        this.terminado = terminado;
    }

    public Integer getIdOt() {
        return idOt;
    }

    public void setIdOt(Integer idOt) {
        this.idOt = idOt;
    }

    public Integer getOt() {
        return ot;
    }

    public void setOt(Integer ot) {
        this.ot = ot;
    }

    public Date getFechaAlmacen() {
        return fechaAlmacen;
    }

    public void setFechaAlmacen(Date fechaAlmacen) {
        this.fechaAlmacen = fechaAlmacen;
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
