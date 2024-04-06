package com.inte_soft.gestionconsumibles.serviceImplement;

import com.inte_soft.gestionconsumibles.dao.ItemDao;
import com.inte_soft.gestionconsumibles.dao.OtDao;
import com.inte_soft.gestionconsumibles.dao.PedidoComprasDao;
import com.inte_soft.gestionconsumibles.entity.Ot;
import com.inte_soft.gestionconsumibles.entity.Pedidos;
import com.inte_soft.gestionconsumibles.entity.PedidosCompras;
import com.inte_soft.gestionconsumibles.service.PedidosComprasService;
import com.inte_soft.gestionconsumibles.service.PedidosServices;
import java.util.ArrayList;

import java.util.List;

public class PedidosComprasServiceImplement implements PedidosComprasService {

    @Override
    public List<PedidosCompras> listPedidosCompras(Pedidos pedidos) {
        PedidoComprasDao pedidoComprasDao = new PedidoComprasDao();
        return pedidoComprasDao.listPedidosCompras(pedidos);
    }

    @Override
    public void UpdatePedidoCompras(List<PedidosCompras> listPedidosCompras, List<PedidosCompras> listPedidosComprasUpdate, Pedidos pedido) {
        PedidoComprasDao pedidoComprasDao = new PedidoComprasDao();
        pedidoComprasDao.UpdatePedidoCompras(listPedidosCompras, listPedidosComprasUpdate, pedido);
        try {
            List<String> lisItem = new ArrayList<>();
            OtDao otDao = new OtDao();
            Ot ot = otDao.getByOt(pedido.getOt().toString()).get();

            //bucar los items que se van a actualizar sin repetir
            for (PedidosCompras p : listPedidosCompras) {
                if (!lisItem.contains(p.getItem())) {
                    lisItem.add(p.getItem());
                }
            }
            //actualizar los items segun la ot
            ItemDao itemDao = new ItemDao();
            for (String item : lisItem) {
                itemDao.updateItemAlistadoFalse(ot, item);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        
    }

}
