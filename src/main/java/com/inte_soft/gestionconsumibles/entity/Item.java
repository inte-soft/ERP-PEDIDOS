package com.inte_soft.gestionconsumibles.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ITEM")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ITEM")
    private String item;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_OT")
    private Ot ot;
    @Column(name = "cerrado")
    private Boolean cerrado;

    @Column(name = "ENTREGA")
    private Date entrega;
    
    @Column(name= "ESTADO")
    private Integer estado;
    
    @Column(name= "RECIBE")
    private String recibe;
    
    @Column(name="FECHA_RECIBE")
    private Date fechaRecibe;
    
    @Column(name= "OBSERVACION")
    private String observacion;

    public Item() {
    }

    public Item(Integer id, String item, Ot ot, Boolean cerrado, Date entrega, Integer estado, String recibe, Date fechaRecibe, String observacion) {
        this.id = id;
        this.item = item;
        this.ot = ot;
        this.cerrado = cerrado;
        this.entrega = entrega;
        this.estado = estado;
        this.recibe = recibe;
        this.fechaRecibe = fechaRecibe;
        this.observacion = observacion;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Ot getOt() {
        return ot;
    }

    public void setOt(Ot ot) {
        this.ot = ot;
    }

    public Boolean getCerrado() {
        return cerrado;
    }

    public void setCerrado(Boolean cerrado) {
        this.cerrado = cerrado;
    }

    public Date getEntrega() {
        return entrega;
    }

    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getRecibe() {
        return recibe;
    }

    public void setRecibe(String recibe) {
        this.recibe = recibe;
    }

    public Date getFechaRecibe() {
        return fechaRecibe;
    }

    public void setFechaRecibe(Date fechaRecibe) {
        this.fechaRecibe = fechaRecibe;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    

}
