/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.controller;

import com.inte_soft.gestionconsumibles.dto.*;
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
import javax.swing.JOptionPane;

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
            AreaCompania area, String persona, String Operacion, String ot, String tipoPedido) {

        pedidoConsumiblesServices.crearPedidoConsumibles(pedidoConsumibleses, area, persona, Operacion, ot, tipoPedido);
    }

    public List<ConsumiblesDto> consumiblesPedidosSearch(int ot, String descripcion, String tipoPedido) {
        return pedidoConsumiblesServices.consumiblesPedidosSearch(ot, descripcion, tipoPedido);
    }

    public HashMap consumiblesWhithoutCheck(List<Integer> ots) {
        HashMap<Integer, ArrayList<?>> map = new HashMap<>();
        List<Pedidos> listPedidos = new ArrayList<>();
        List<ConsumiblesDtoRev> listConsumiblesDtoRevs  = new ArrayList<>();
        for (int ot : ots) {
            boolean otExiste = pedidosServices.checkOtExiste(ot);
            if (!otExiste) {
                JOptionPane.showMessageDialog(null, "La OT " + ot + " no tiene pedidos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                continue;
            }else {
            List<Pedidos> listPedidosTemporal = pedidosServices.findWhithoutRevison(ot);
            List<ConsumiblesDtoRev> listConsumiblesDtoRevsTemporal = pedidoConsumiblesServices.consumiblesPedidosSearchByRev(listPedidosTemporal);
            
            if (listConsumiblesDtoRevsTemporal.size() == 0) {
                JOptionPane.showMessageDialog(null, "La OT " + ot + " no tiene pedidos para exportar", "Advertencia", JOptionPane.WARNING_MESSAGE);
                continue;
            }else{
                listConsumiblesDtoRevs.addAll(listConsumiblesDtoRevsTemporal);
                listPedidos.addAll(listPedidosTemporal);
            }
            
            }
        }

        if(listConsumiblesDtoRevs.size()!=0){
            map.put(1, new ArrayList<>(listPedidos));
            map.put(2, new ArrayList<>(listConsumiblesDtoRevs));
            return map;
        }else{
           JOptionPane.showMessageDialog(null, "Las OTs que ingreso no tiene pedidos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }


    public List<PedidoConsumiblesDto> findByIdPedido(int idPedido) {
        return pedidoConsumiblesServices.findByIdPedido(idPedido);
    }

    public List<ConsumiblesDtoOt> consumiblesPedidosSearcFilter(int ot, String tipoPedido) {
        return pedidoConsumiblesServices.consumiblesPedidosSearchFilter(ot, tipoPedido);
    }

    public List<MaxMinElectDTO> consumiblesElectricosMaxMinList() {
        return pedidoConsumiblesServices.consumiblesElectricosMaxMinList();
    }

    public void updateMaxMin(List<MaxMinElectDTO> listMaxMinElectDTO) {
        pedidoConsumiblesServices.updateMaxMinE(listMaxMinElectDTO);
    }

    public List<MaxMinElectDTO> consumiblesMecanicosMaxMinList() {
        return pedidoConsumiblesServices.consumiblesMecanicosMaxMinList();
    }

    public void updateMaxMinMecanicos(List<MaxMinElectDTO> listMaxMinElectDTO) {
        pedidoConsumiblesServices.updateMaxMinM(listMaxMinElectDTO);
    }
}
