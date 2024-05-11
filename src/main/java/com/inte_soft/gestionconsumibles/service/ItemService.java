package com.inte_soft.gestionconsumibles.service;

import com.inte_soft.gestionconsumibles.entity.Item;
import com.inte_soft.gestionconsumibles.entity.Ot;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    void createItem(Item item);

    List<Item> getItems();

    public Optional<Item> getItemByOtAndItem(Ot ot, String item);

    public void updateItem(Item item);
}
