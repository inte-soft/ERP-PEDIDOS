package com.inte_soft.gestionconsumibles.serviceImplement;

import com.inte_soft.gestionconsumibles.dao.PedidoComprasDao;
import com.inte_soft.gestionconsumibles.entity.Pedidos;
import com.inte_soft.gestionconsumibles.entity.PedidosCompras;
import com.inte_soft.gestionconsumibles.service.PedidosComprasService;
import com.inte_soft.gestionconsumibles.service.PedidosServices;

import java.util.List;

public class PedidosComprasServiceImplement implements PedidosComprasService {

    @Override
    public List<PedidosCompras> listPedidosCompras() {
        PedidoComprasDao pedidoComprasDao = new PedidoComprasDao();
        return pedidoComprasDao.listPedidosCompras();
    }

    @Override
    public void UpdatePedidoCompras(List<PedidosCompras> listPedidosCompras, Pedidos pedido) {
        PedidoComprasDao pedidoComprasDao = new PedidoComprasDao();
        pedidoComprasDao.UpdatePedidoCompras(listPedidosCompras, pedido);
    }

}
