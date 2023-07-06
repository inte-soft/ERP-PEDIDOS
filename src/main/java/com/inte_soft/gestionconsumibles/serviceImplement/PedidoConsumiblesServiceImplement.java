/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.serviceImplement;

import com.inte_soft.gestionconsumibles.dao.MasterDao;
import com.inte_soft.gestionconsumibles.dao.PedidoConsumiblesDao;
import com.inte_soft.gestionconsumibles.dao.PedidosDao;
import com.inte_soft.gestionconsumibles.dto.ConsumiblesDto;
import com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoOt;
import com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoRev;
import com.inte_soft.gestionconsumibles.entity.AreaCompania;
import com.inte_soft.gestionconsumibles.entity.PedidoConsumibles;
import com.inte_soft.gestionconsumibles.entity.Pedidos;
import com.inte_soft.gestionconsumibles.service.PedidoConsumiblesServices;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alejo
 */
public class PedidoConsumiblesServiceImplement implements PedidoConsumiblesServices{
    private PedidoConsumiblesDao pedidoConsumiblesDao;
    @Override
    public void crearPedidoConsumibles(List<PedidoConsumibles> pedidoConsumibleses, AreaCompania area, String persona, String Operacion, String ot) {
        MasterDao masterDao = new MasterDao();
        PedidosDao pedidosDao = new PedidosDao();
        Pedidos pedidos = new Pedidos();
        pedidos.setOt(Integer.parseInt(ot));
        pedidos.setPersona(persona);
        pedidos.setArea(area);
        pedidos.setOperacion(Operacion);
        pedidos.setFecha(new Date());
        Pedidos pedidosPersist = pedidosDao.createPedido(pedidos);
       
        for(PedidoConsumibles pc : pedidoConsumibleses){
            try{
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
           
            

            pedidoConsumiblesDao = new PedidoConsumiblesDao();
            pedidoConsumiblesDao.createPedido(pedidoConsumibles);
        }catch(Exception e){
           
            e.printStackTrace();
            
        }
        }
        
    }

    @Override
    public List<ConsumiblesDto> consumiblesPedidosSearch(int ot, String descripcion) {
        pedidoConsumiblesDao = new PedidoConsumiblesDao();
        return pedidoConsumiblesDao.filteredSearch(ot, descripcion);
    }

    @Override
    public List<ConsumiblesDtoOt> consumiblesPedidosSearchByOt(int ot) {
        pedidoConsumiblesDao = new PedidoConsumiblesDao();
        return pedidoConsumiblesDao.filteredSearchByOt(ot);
    }

    @Override
    public List<ConsumiblesDtoRev> consumiblesPedidosSearchByRev(List<Pedidos> listPedidos) {
        pedidoConsumiblesDao = new PedidoConsumiblesDao();
        return pedidoConsumiblesDao.filterSearchByRev(listPedidos);
    }
    
}
