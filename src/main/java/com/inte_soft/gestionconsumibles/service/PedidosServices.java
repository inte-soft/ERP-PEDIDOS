/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inte_soft.gestionconsumibles.service;

import com.inte_soft.gestionconsumibles.entity.Pedidos;
import java.util.List;

/**
 *
 * @author alejo
 */
public interface PedidosServices {
    
    public void checkPedidos(List<Pedidos> listPedidos);
    
    public List<Pedidos> findWhithoutRevison();
}
