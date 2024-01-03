/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.serviceImplement;

import com.inte_soft.gestionconsumibles.dao.PedidosDao;
import com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoRev;
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
    public List<Pedidos> findWhithoutRevison(int ot) {
        pedidosDao = new PedidosDao();
        return pedidosDao.findWhithoutRevision(ot);
    }

    @Override
    public void updatePedido(Pedidos pedido) {
        pedidosDao = new PedidosDao();
        pedidosDao.merge(pedido);
    }

    @Override
    public boolean checkOtExiste(int ot) {
        pedidosDao = new PedidosDao();
        return pedidosDao.existeOT(ot);
    }
    
}
