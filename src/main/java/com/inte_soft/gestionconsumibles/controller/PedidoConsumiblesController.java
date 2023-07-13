/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.controller;

import com.inte_soft.gestionconsumibles.dto.ConsumiblesDto;
import com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoOt;
import com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoRev;
import com.inte_soft.gestionconsumibles.entity.AreaCompania;
import com.inte_soft.gestionconsumibles.entity.PedidoConsumibles;
import com.inte_soft.gestionconsumibles.entity.Pedidos;
import com.inte_soft.gestionconsumibles.service.PedidoConsumiblesServices;
import com.inte_soft.gestionconsumibles.service.PedidosServices;
import com.inte_soft.gestionconsumibles.serviceImplement.PedidoConsumiblesServiceImplement;
import com.inte_soft.gestionconsumibles.serviceImplement.PedidosServiceImplement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author alejo
 */
public class PedidoConsumiblesController {
    private PedidoConsumiblesServices pedidoConsumiblesServices;
    private PedidosServices pedidosServices; 
    public PedidoConsumiblesController() {
        pedidoConsumiblesServices = new PedidoConsumiblesServiceImplement();
        pedidosServices = new PedidosServiceImplement();
    }
    
    public void crearPedidoConsumibles(List<PedidoConsumibles> pedidoConsumibleses,
            AreaCompania area, String persona, String Operacion, String ot, String tipoPedido){
        
        pedidoConsumiblesServices.crearPedidoConsumibles(pedidoConsumibleses, area, persona, Operacion, ot, tipoPedido);
    }
    
    public List<ConsumiblesDto> consumiblesPedidosSearch(int ot, String descripcion, String tipoPedido){
        return pedidoConsumiblesServices.consumiblesPedidosSearch(ot, descripcion, tipoPedido);
    }
    
    
    public HashMap consumiblesWhithoutCheck(){
        HashMap<Integer,ArrayList<?>> map = new HashMap<>();
        List<Pedidos> listPedidos = pedidosServices.findWhithoutRevison();
        List<ConsumiblesDtoRev> listConsumiblesDtoRevs = pedidoConsumiblesServices.consumiblesPedidosSearchByRev(listPedidos);
        
        map.put(1, new ArrayList<>(listPedidos));
        map.put(2, new ArrayList<>(listConsumiblesDtoRevs));
        
        return map;
    }
    
    public List<PedidoConsumibles> findByIdPedido(int idPedido){
        return pedidoConsumiblesServices.findByIdPedido(idPedido);
    }

    public List<ConsumiblesDtoOt> consumiblesPedidosSearcFilter(int ot, String tipoPedido) {
       return pedidoConsumiblesServices.consumiblesPedidosSearchFilter(ot, tipoPedido);
    }
    
}
