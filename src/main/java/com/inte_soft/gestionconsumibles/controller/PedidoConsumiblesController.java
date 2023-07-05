/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.controller;

import com.inte_soft.gestionconsumibles.dto.ConsumiblesDto;
import com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoOt;
import com.inte_soft.gestionconsumibles.entity.AreaCompania;
import com.inte_soft.gestionconsumibles.entity.PedidoConsumibles;
import com.inte_soft.gestionconsumibles.service.PedidoConsumiblesServices;
import com.inte_soft.gestionconsumibles.serviceImplement.PedidoConsumiblesServiceImplement;
import java.util.List;

/**
 *
 * @author alejo
 */
public class PedidoConsumiblesController {
    private PedidoConsumiblesServices pedidoConsumiblesServices;
    public PedidoConsumiblesController() {
        pedidoConsumiblesServices = new PedidoConsumiblesServiceImplement();
    }
    
    public void crearPedidoConsumibles(List<PedidoConsumibles> pedidoConsumibleses, AreaCompania area, String persona, String Operacion, String ot){
        pedidoConsumiblesServices.crearPedidoConsumibles(pedidoConsumibleses, area, persona, Operacion, ot);
    }
    
    public List<ConsumiblesDto> consumiblesPedidosSearch(int ot, String descripcion){
        return pedidoConsumiblesServices.consumiblesPedidosSearch(ot, descripcion);
    }
    public List<ConsumiblesDtoOt> consumiblesPedidosSearchOt(int ot){
        return pedidoConsumiblesServices.consumiblesPedidosSearchByOt(ot);
    }
}
