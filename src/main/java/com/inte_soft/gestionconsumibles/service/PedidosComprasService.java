package com.inte_soft.gestionconsumibles.service;

import com.inte_soft.gestionconsumibles.entity.Pedidos;
import com.inte_soft.gestionconsumibles.entity.PedidosCompras;

import java.util.List;

public interface PedidosComprasService {
    List<PedidosCompras> listPedidosCompras();

    void UpdatePedidoCompras(List<PedidosCompras> listPedidosCompras, Pedidos pedido);
}
