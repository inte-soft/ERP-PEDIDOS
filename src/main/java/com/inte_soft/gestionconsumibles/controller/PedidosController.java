/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.controller;

import com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoRev;
import com.inte_soft.gestionconsumibles.dto.PedidoDto;
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
    

    
    public List<Pedidos> listPedidosWhithoutRevision (int ot){
        return pedidosServices.findWhithoutRevison(ot);
        
    }

    public void updatePedido(Pedidos pedido) {
       pedidosServices.updatePedido(pedido);
    }

    public List<PedidoDto> listPedidos() {
        return pedidosServices.listPedidos();

    }

    public List<Pedidos> listPedidosSearchByOt(String ot) {
        return pedidosServices.listPedidosSearchByOt(ot);
    }
}
