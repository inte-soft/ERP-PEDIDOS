package com.inte_soft.gestionconsumibles.controller;

import com.inte_soft.gestionconsumibles.entity.Pedidos;
import com.inte_soft.gestionconsumibles.entity.PedidosCompras;
import com.inte_soft.gestionconsumibles.service.PedidosComprasService;
import com.inte_soft.gestionconsumibles.serviceImplement.PedidosComprasServiceImplement;

import java.util.List;

public class PedidosComprasController {
    
    private PedidosComprasService pedidosComprasService;

    public PedidosComprasController() {
        this.pedidosComprasService = new PedidosComprasServiceImplement();
    }

    
    public List<PedidosCompras> listPedidosCompras(Pedidos pedidos) {
        return pedidosComprasService.listPedidosCompras(pedidos);

    }

    public void UpdatePedidoCompras(List<PedidosCompras> listPedidosCompras, Pedidos pedido) {
        pedidosComprasService.UpdatePedidoCompras(listPedidosCompras, pedido);
    }
}
