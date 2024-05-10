/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.serviceImplement;

import com.inte_soft.gestionconsumibles.dao.*;
import com.inte_soft.gestionconsumibles.dto.*;
import com.inte_soft.gestionconsumibles.entity.*;
import com.inte_soft.gestionconsumibles.service.PedidoConsumiblesServices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alejo
 */
public class PedidoConsumiblesServiceImplement implements PedidoConsumiblesServices {

    private PedidoConsumiblesDao pedidoConsumiblesDao;
    private PedidoComprasDao pedidoComprasDao;

    @Override
    public void crearPedidoConsumibles(List<PedidoConsumibles> pedidoConsumibleses, AreaCompania area, String persona,
            String Operacion, String ot, String tipoPedido, List<PedidosCompras> listPedidosCompras, String typeOperacionCompras) {
        MasterDao masterDao = new MasterDao();
        PedidosDao pedidosDao = new PedidosDao();
         if(!pedidoConsumibleses.isEmpty()){
        Pedidos pedidos = new Pedidos();
        pedidos.setOt((ot));
        pedidos.setPersona(persona);
        pedidos.setArea(area);
        pedidos.setOperacion(Operacion);
        pedidos.setFecha(new Date());
        pedidos.setTipoPedido(tipoPedido);
        pedidos.setComprado(true);
        Pedidos pedidosPersist = pedidosDao.createPedido(pedidos);



        

        for (PedidoConsumibles pc : pedidoConsumibleses) {
            try {
                PedidoConsumibles pedidoConsumibles = new PedidoConsumibles();
                pedidoConsumibles.setPedidos(pedidosPersist);
                pedidoConsumibles.setItem(pc.getItem());
                pedidoConsumibles.setCodigo(pc.getCodigo());
                pedidoConsumibles.setDescripcion(pc.getDescripcion());
                pedidoConsumibles.setTipo(pc.getTipo());
                pedidoConsumibles.setReferencia(pc.getReferencia());
                pedidoConsumibles.setMarca(pc.getMarca());
                pedidoConsumibles.setUnidad(pc.getUnidad());
                pedidoConsumibles.setCantidad(pc.getCantidad());
                pedidoConsumibles.setValor(masterDao.findById(pc.getCodigo()).getPrecio_descuento() * pc.getCantidad());
                pedidoConsumibles.setRevisado(false);
                pedidoConsumiblesDao = new PedidoConsumiblesDao();
                pedidoConsumiblesDao.createPedido(pedidoConsumibles);
            } catch (Exception e) {

                e.printStackTrace();

            }
        }

             List<String> listItem = new ArrayList<>();
             //buscar los items de los pedidos sin repetir
             for (PedidoConsumibles pc : pedidoConsumibleses) {
                 if (!listItem.contains(pc.getItem())) {
                     listItem.add(pc.getItem());
                 }
             }

             try {


                 //modificar el campo alistado de los items de la ot
                 ItemDao itemDao = new ItemDao();
                 OtDao OtDao = new OtDao();
                 Ot ot1 = OtDao.getOtByOt(ot);
                 for (String item : listItem) {
                     itemDao.updateItemAlistadoFalse(ot1, item);
                 }
             }catch (Exception e) {
                 e.printStackTrace();
             }
         }
         


       

        if(!listPedidosCompras.isEmpty()){
            Pedidos pedidosCom = new Pedidos();
            pedidosCom.setOt((ot));
            pedidosCom.setPersona(persona);
            pedidosCom.setArea(area);
            pedidosCom.setOperacion(typeOperacionCompras);
            pedidosCom.setFecha(new Date());
            pedidosCom.setTipoPedido(tipoPedido);
            pedidosCom.setComprado(false);
            Pedidos pedidosPersistCompras = pedidosDao.createPedido(pedidosCom);

            for (PedidosCompras  pc : listPedidosCompras) {
                try {
                    PedidosCompras pedidoConsumibles = new PedidosCompras();
                    pedidoConsumibles.setPedido(pedidosPersistCompras);
                    pedidoConsumibles.setItem(pc.getItem());
                    pedidoConsumibles.setCodigo(pc.getCodigo());
                    pedidoConsumibles.setDescripcion(pc.getDescripcion());
                    pedidoConsumibles.setTipo(pc.getTipo());
                    pedidoConsumibles.setReferencia(pc.getReferencia());
                    pedidoConsumibles.setMarca(pc.getMarca());
                    pedidoConsumibles.setUnidad(pc.getUnidad());
                    pedidoConsumibles.setCantidad(pc.getCantidad());
                    pedidoConsumibles.setValor(masterDao.findById(pc.getCodigo()).getPrecio_descuento() * pc.getCantidad());
                    pedidoConsumibles.setComprado(false);
                    pedidoComprasDao = new PedidoComprasDao();
                    pedidoComprasDao.createPedido(pedidoConsumibles);



                } catch (Exception e) {

                    e.printStackTrace();

                }
            }
        }



    }

    @Override
    public List<ConsumiblesDto> consumiblesPedidosSearch(String ot, String descripcion, String tipoPedido) {
        pedidoConsumiblesDao = new PedidoConsumiblesDao();
        return pedidoConsumiblesDao.filteredSearch(ot, descripcion, tipoPedido);
    }

    @Override
    public List<ConsumiblesDtoRev> consumiblesPedidosSearchByRev(List<String> ots) {
        pedidoConsumiblesDao = new PedidoConsumiblesDao();
        return pedidoConsumiblesDao.filterSearchByRev(ots);
    }

    @Override
    public List<PedidoConsumiblesDto> findByIdPedido(int idPedido) {
        pedidoConsumiblesDao = new PedidoConsumiblesDao();
        return pedidoConsumiblesDao.findByIdPedido(idPedido);
    }

    @Override
    public List<MaxMinElectDTO> consumiblesElectricosMaxMinList() {
        pedidoConsumiblesDao = new PedidoConsumiblesDao();
        return pedidoConsumiblesDao.consumiblesElectricosMaxMinList();
    }

    @Override
    public void updateMaxMinE(List<MaxMinElectDTO> listMaxMinElectDTO) {
        pedidoConsumiblesDao = new PedidoConsumiblesDao();
        pedidoConsumiblesDao.updateMaxMinE(listMaxMinElectDTO);
    }

    @Override
    public void updateMaxMinM(List<MaxMinElectDTO> listMaxMinElectDTO) {
        pedidoConsumiblesDao = new PedidoConsumiblesDao();
        pedidoConsumiblesDao.updateMaxMinM(listMaxMinElectDTO);
    }

    @Override
    public void applycheck(List<ConsumiblesDtoRev> listConsumiblesDtoRev) {
        pedidoConsumiblesDao = new PedidoConsumiblesDao();
        pedidoConsumiblesDao.applycheck(listConsumiblesDtoRev);
    }

    @Override
    public List<MaxMinElectDTO> consumiblesMecanicosMaxMinList() {
        pedidoConsumiblesDao = new PedidoConsumiblesDao();
        return pedidoConsumiblesDao.consumiblesMecanicosMaxMinList();
    }

    @Override
    public List<ConsumiblesDtoOt> consumiblesPedidosSearchFilter(int ot, String tipoPedido) {
        pedidoConsumiblesDao = new PedidoConsumiblesDao();
        return pedidoConsumiblesDao.filteredSearchByOt(ot, tipoPedido);
    }

    @Override
    public List<ConsumiblesDtoOt> consumiblesPedidosSearchOtArea(int ot, String area) {
        pedidoConsumiblesDao = new PedidoConsumiblesDao();
        return pedidoConsumiblesDao.filteredSearchByOtArea(ot, area);
    }

    @Override
    public List<ConsumiblesDtoOt> getConsumiblesByOtAndItem(Ot ot, List<String> listItem, String area) {
        pedidoConsumiblesDao = new PedidoConsumiblesDao();
        return pedidoConsumiblesDao.getConsumiblesByOtAndItem(ot, listItem, area);
    }

    @Override
    public List<EntregaDto> getConsumiblesByOtAndItemUnicConsumible(Ot ot, List<String> listItem, String area, String codigo) {
        pedidoConsumiblesDao = new PedidoConsumiblesDao();
        return pedidoConsumiblesDao.getConsumiblesByOtAndItemUnicConsumible(ot,listItem,area,codigo);
    }

    @Override
    public void updateEntregaConsumibles(List<EntregaDto> consumiblesEntregaDto, List<String> listItem) {
        //un bucle donde se busque el pedido pol el id y se axtualizce el campo alistado y observacio

        pedidoConsumiblesDao = new PedidoConsumiblesDao();
        for (EntregaDto e : consumiblesEntregaDto) {
            Optional<PedidoConsumibles> pedidoConsumibles = pedidoConsumiblesDao.findById(e.getId());
            if (pedidoConsumibles.isPresent()) {
                PedidoConsumibles pedidoConsumible = pedidoConsumibles.get();
                pedidoConsumible.setAlistado(e.getAlistado());
                pedidoConsumible.setObservacion(e.getObservacion());
                pedidoConsumiblesDao.updatePedido(pedidoConsumible);
            }

        }
        // buscar los todos los pedidos de la ot y revisar en pedidos consumibles si la cantidad y la cantidad alistada son iguales y marcar el item como alistado
        String ot = consumiblesEntregaDto.get(0).getOt();
        OtDao OtDao = new OtDao();
        Ot ot1 = OtDao.getOtByOt(ot);
        PedidosDao pedidosDao = new PedidosDao();
        for (String item : listItem) {
            List<PedidoConsumibles> pedidoConsumibles = pedidoConsumiblesDao.getConsumiblesByOyAndListItem(ot, item);
            if (pedidoConsumibles.size() > 0) {
                Boolean alistado = true;
                for (PedidoConsumibles pc : pedidoConsumibles) {
                    if (Double.parseDouble(String.valueOf(pc.getCantidad())) != pc.getAlistado()) {
                        alistado = false;
                    }
                }
                ItemDao itemDao = new ItemDao();
                if (alistado) {
                    itemDao.updateItemAlistado(ot1, item);
                }
            }
        }

    }

    @Override
    public List<PendientesDto> getConsumiblesPendientes() {
        pedidoConsumiblesDao = new PedidoConsumiblesDao();
        return pedidoConsumiblesDao.getConsumiblesPendientes();
    }


}
