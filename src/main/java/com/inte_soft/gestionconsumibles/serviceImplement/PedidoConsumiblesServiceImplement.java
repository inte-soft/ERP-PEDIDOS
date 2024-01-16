/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.serviceImplement;

import com.inte_soft.gestionconsumibles.dao.MasterDao;
import com.inte_soft.gestionconsumibles.dao.PedidoComprasDao;
import com.inte_soft.gestionconsumibles.dao.PedidoConsumiblesDao;
import com.inte_soft.gestionconsumibles.dao.PedidosDao;
import com.inte_soft.gestionconsumibles.dto.*;
import com.inte_soft.gestionconsumibles.entity.AreaCompania;
import com.inte_soft.gestionconsumibles.entity.PedidoConsumibles;
import com.inte_soft.gestionconsumibles.entity.Pedidos;
import com.inte_soft.gestionconsumibles.entity.PedidosCompras;
import com.inte_soft.gestionconsumibles.service.PedidoConsumiblesServices;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alejo
 */
public class PedidoConsumiblesServiceImplement implements PedidoConsumiblesServices {

    private PedidoConsumiblesDao pedidoConsumiblesDao;
    private PedidoComprasDao pedidoComprasDao;

    @Override
    public void crearPedidoConsumibles(List<PedidoConsumibles> pedidoConsumibleses, AreaCompania area, String persona,
            String Operacion, String ot, String tipoPedido, List<PedidosCompras> listPedidosCompras) {
        MasterDao masterDao = new MasterDao();
        PedidosDao pedidosDao = new PedidosDao();
        Pedidos pedidos = new Pedidos();
        pedidos.setOt(Integer.parseInt(ot));
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

        if(!listPedidosCompras.isEmpty()){
            Pedidos pedidosCom = new Pedidos();
            pedidosCom.setOt(Integer.parseInt(ot));
            pedidosCom.setPersona(persona);
            pedidosCom.setArea(area);
            pedidosCom.setOperacion("Pedido Compras");
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
    public List<ConsumiblesDto> consumiblesPedidosSearch(int ot, String descripcion, String tipoPedido) {
        pedidoConsumiblesDao = new PedidoConsumiblesDao();
        return pedidoConsumiblesDao.filteredSearch(ot, descripcion, tipoPedido);
    }

    @Override
    public List<ConsumiblesDtoRev> consumiblesPedidosSearchByRev(List<Integer> ots) {
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
}
