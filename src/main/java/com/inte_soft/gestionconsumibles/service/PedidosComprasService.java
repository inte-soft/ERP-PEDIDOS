package com.inte_soft.gestionconsumibles.service;

import com.inte_soft.gestionconsumibles.entity.Pedidos;
import com.inte_soft.gestionconsumibles.entity.PedidosCompras;

import java.util.List;

public interface PedidosComprasService {
    List<PedidosCompras> listPedidosCompras(Pedidos pedidos);

    void UpdatePedidoCompras(List<PedidosCompras> listPedidosCompras, List<PedidosCompras> listPedidosComprasUpdate, Pedidos pedido);
}
