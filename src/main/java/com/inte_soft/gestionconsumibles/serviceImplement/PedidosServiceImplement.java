/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.serviceImplement;

import com.inte_soft.gestionconsumibles.dao.PedidosDao;
import com.inte_soft.gestionconsumibles.entity.Pedidos;
import com.inte_soft.gestionconsumibles.service.PedidosServices;
import java.util.List;

/**
 *
 * @author alejo
 */
public class PedidosServiceImplement implements  PedidosServices{

    private PedidosDao pedidosDao;
    

    @Override
    public void checkPedidos(List<Pedidos> listPedidos) {
        for (Pedidos pedidos : listPedidos) {
            pedidos.setRevisado(true);
            pedidosDao = new PedidosDao();
            pedidosDao.checkPedidos(pedidos);
        }
        
        
    }

    @Override
    public List<Pedidos> findWhithoutRevison() {
        pedidosDao = new PedidosDao();
        return pedidosDao.findWhithoutRevision();
    }

    @Override
    public void updatePedido(Pedidos pedido) {
        pedidosDao = new PedidosDao();
        pedidosDao.merge(pedido);
    }
    
}
