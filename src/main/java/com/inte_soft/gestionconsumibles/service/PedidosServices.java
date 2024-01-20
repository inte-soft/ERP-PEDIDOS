/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inte_soft.gestionconsumibles.service;

import com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoRev;
import com.inte_soft.gestionconsumibles.dto.PedidoDto;
import com.inte_soft.gestionconsumibles.entity.Pedidos;
import java.util.List;

/**
 *
 * @author alejo
 */
public interface PedidosServices {

    
    public List<Pedidos> findWhithoutRevison(int ot);

    public void updatePedido(Pedidos pedido);

    public boolean checkOtExiste(int ot);

    List<PedidoDto> listPedidos();

    List<Pedidos> listPedidosSearchByOt(String ot);

    List<PedidoDto> listPedidosCompras();

    Pedidos findById(int i);

    List<PedidoDto> listPedidosComprasOk();
}
