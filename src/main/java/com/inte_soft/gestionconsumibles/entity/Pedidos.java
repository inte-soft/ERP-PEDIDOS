/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
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
    private Usuario usuario;
    private AreaCompañia areaCompañia;

    public Pedidos() {
    }

    public Pedidos(int idPedido, Usuario usuario, AreaCompañia areaCompañia) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public AreaCompañia getAreaCompañia() {
        return areaCompañia;
    }

    public void setAreaCompañia(AreaCompañia areaCompañia) {
        this.areaCompañia = areaCompañia;
    }
    
}

