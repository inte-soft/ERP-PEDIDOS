package com.inte_soft.gestionconsumibles.serviceImplement;

import com.inte_soft.gestionconsumibles.dao.PedidoComprasDao;
import com.inte_soft.gestionconsumibles.entity.Pedidos;
import com.inte_soft.gestionconsumibles.entity.PedidosCompras;
import com.inte_soft.gestionconsumibles.service.PedidosComprasService;
import com.inte_soft.gestionconsumibles.service.PedidosServices;

import java.util.List;

public class PedidosComprasServiceImplement implements PedidosComprasService {

    @Override
    public List<PedidosCompras> listPedidosCompras(Pedidos pedidos) {
        PedidoComprasDao pedidoComprasDao = new PedidoComprasDao();
        return pedidoComprasDao.listPedidosCompras(pedidos);
    }

    @Override
    public void UpdatePedidoCompras(List<PedidosCompras> listPedidosCompras, List<PedidosCompras> listPedidosComprasUpdate, Pedidos pedido) {
        PedidoComprasDao pedidoComprasDao = new PedidoComprasDao();
        pedidoComprasDao.UpdatePedidoCompras(listPedidosCompras, listPedidosComprasUpdate, pedido);
    }

}
