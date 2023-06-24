/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author alejo
 */
@Entity
@Table(name = "pedido_consumibles")
public class Pedidos  implements java.io.Serializable{
    @Id
    private int idPedido;
    private Usuarios usuario;
    private AreaCompania areaCompañia;

    public Pedidos() {
    }

    public Pedidos(int idPedido, Usuarios usuario, AreaCompania areaCompañia) {
        this.idPedido = idPedido;
        this.usuario = usuario;
        this.areaCompañia = areaCompañia;
    }
    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO")
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public AreaCompania getAreaCompañia() {
        return areaCompañia;
    }

    public void setAreaCompañia(AreaCompania areaCompañia) {
        this.areaCompañia = areaCompañia;
    }
    
}

