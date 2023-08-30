/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.controller;

import com.inte_soft.gestionconsumibles.entity.Pedidos;
import com.inte_soft.gestionconsumibles.service.PedidosServices;
import com.inte_soft.gestionconsumibles.serviceImplement.PedidosServiceImplement;
import java.util.List;

/**
 *
 * @author alejo
 */
public class PedidosController {
    private PedidosServices pedidosServices;
    public PedidosController(){
        pedidosServices = new PedidosServiceImplement();
    }
    
    public void applyCheck(List<Pedidos> listPedidos){
        pedidosServices.checkPedidos(listPedidos);
    }
    
    public List<Pedidos> listPedidosWhithoutRevision (){
        return pedidosServices.findWhithoutRevison();
        
    }

    public void updatePedido(Pedidos pedido) {
       pedidosServices.updatePedido(pedido);
    }
}
