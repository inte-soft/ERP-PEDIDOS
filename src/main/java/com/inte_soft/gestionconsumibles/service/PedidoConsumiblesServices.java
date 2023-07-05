/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inte_soft.gestionconsumibles.service;



import com.inte_soft.gestionconsumibles.dto.ConsumiblesDto;
import com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoOt;
import com.inte_soft.gestionconsumibles.entity.AreaCompania;
import com.inte_soft.gestionconsumibles.entity.PedidoConsumibles;
import java.util.List;



/**
 *
 * @author alejo
 */
public interface PedidoConsumiblesServices {
   public void crearPedidoConsumibles(List<PedidoConsumibles> pedidoConsumibleses, AreaCompania area, String persona , String Operacion, String ot);

    public List<ConsumiblesDto> consumiblesPedidosSearch(int ot, String descripcion);
    
    public List<ConsumiblesDtoOt> consumiblesPedidosSearchByOt(int ot);
    
}
