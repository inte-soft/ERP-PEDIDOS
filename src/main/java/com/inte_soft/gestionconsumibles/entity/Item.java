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
    private Integer item;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_OT")
    private Ot ot;
    @Column(name = "cerrado")
    private Boolean cerrado;

    @Column(name = "ENTREGA")
    private Date entrega;
    public Item() {
    }

    public Item(Integer item, Ot ot, Boolean cerrado, Date entrega) {
        this.item = item;
        this.ot = ot;
        this.cerrado = cerrado;
        this.entrega = entrega;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
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
}
