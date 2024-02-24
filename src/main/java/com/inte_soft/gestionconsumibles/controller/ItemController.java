package com.inte_soft.gestionconsumibles.controller;

import com.inte_soft.gestionconsumibles.entity.Item;
import com.inte_soft.gestionconsumibles.service.ItemService;
import com.inte_soft.gestionconsumibles.serviceImplement.ItemServiceImplement;

import java.util.List;

public class ItemController {

    private ItemServiceImplement itemService;

    public ItemController() {
        itemService = new ItemServiceImplement();
    }

    public void createItem(Item item) {
        itemService.createItem(item);


    }

    public List<Item> getItems() {
        return itemService.getItems();
    }

    public void updateItem(Item item) {
        itemService.updateItem(item);
    }
}
