/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inte_soft.gestionconsumibles.service;



import com.inte_soft.gestionconsumibles.dto.*;
import com.inte_soft.gestionconsumibles.entity.*;

import java.util.List;



/**
 *
 * @author alejo
 */
public interface PedidoConsumiblesServices {
   public void crearPedidoConsumibles(List<PedidoConsumibles> pedidoConsumibleses,
           AreaCompania area, String persona , String Operacion, String ot,
                                      String tipoPedido, List<PedidosCompras> listPedidosCompras, String typeOperacionCompras);

    public List<ConsumiblesDto> consumiblesPedidosSearch(String ot, String descripcion, String tipoPedido);
    
    public List<ConsumiblesDtoOt> consumiblesPedidosSearchFilter(int ot, String tipoPedidoString);
    
    public List<ConsumiblesDtoRev> consumiblesPedidosSearchByRev(List<Integer> ots);
    
    public List<PedidoConsumiblesDto> findByIdPedido(int idPedido);

 List<MaxMinElectDTO> consumiblesElectricosMaxMinList();

 void updateMaxMinE(List<MaxMinElectDTO> maxMinElectDTOs);

 List<MaxMinElectDTO> consumiblesMecanicosMaxMinList();

 void updateMaxMinM(List<MaxMinElectDTO> listMaxMinElectDTO);

 void applycheck(List<ConsumiblesDtoRev> listConsumiblesDtoRev);

 List<ConsumiblesDtoOt> consumiblesPedidosSearchOtArea(int ot, String area);


 List<ConsumiblesDtoOt> getConsumiblesByOtAndItem(Ot ot, List<String> listItem, String area);

 List<EntregaDto> getConsumiblesByOtAndItemUnicConsumible(Ot ot, List<String> listItem, String area, String codigo);

 void updateEntregaConsumibles(List<EntregaDto> consumiblesEntregaDto);

}
