package com.inte_soft.gestionconsumibles.serviceImplement;

import com.inte_soft.gestionconsumibles.dao.ItemDao;
import com.inte_soft.gestionconsumibles.dao.OtDao;
import com.inte_soft.gestionconsumibles.entity.Item;
import com.inte_soft.gestionconsumibles.entity.Ot;
import com.inte_soft.gestionconsumibles.service.ItemService;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public class ItemServiceImplement implements ItemService {

    private ItemDao itemDao;
    private OtDao otDao;
    @Override
    public void createItem(Item item) {
        OtDao otDao = new OtDao();
        Optional<Ot> otOptional = otDao.getByOt(item.getOt().getOt().toString());
        if (otOptional.isPresent()) {
            item.setOt(otOptional.get());
            item.getOt().setTerminado(Boolean.FALSE);
        }

        Optional<Item> itemOptional = getItemByOtAndItem(item.getOt(), item.getItem());
        if (itemOptional.isPresent()) {
            JOptionPane.showMessageDialog(null, "El item ya existe");
            return;
        }

        itemDao = new ItemDao();
        itemDao.createItem(item);
    }

    @Override
    public List<Item> getItems() {
        itemDao = new ItemDao();
        return itemDao.getItems();
    }

    @Override
    public Optional<Item> getItemByOtAndItem(Ot ot, String item) {
        itemDao = new ItemDao();
        return itemDao.getItemByOtAndItem(ot, item);
    }

    @Override
    public void updateItem(Item item) {
        // buscar si tos los items de la ot estan terminados
        List<Item> items = itemDao.getItemsByOt(item.getOt());
        Boolean terminado = Boolean.TRUE;
        Integer cantidad = 0;
        for (Item i : items) {
            if (!i.getCerrado()) {
                cantidad++;
                if (cantidad > 1) {
                    terminado = false;
                }
            }
        }

        itemDao = new ItemDao();
        itemDao.updateItem(item);
        if (terminado) {
            item.getOt().setTerminado(Boolean.TRUE);
            otDao = new OtDao();
            otDao.updateOt(item.getOt());
        }



    }
}
