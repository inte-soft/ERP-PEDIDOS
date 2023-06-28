/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.controller;

import com.inte_soft.gestionconsumibles.entity.TipicoConsumiblesMecanicos;
import com.inte_soft.gestionconsumibles.service.TConsumiblesMService;
import com.inte_soft.gestionconsumibles.serviceImplement.TConsumiblesMServiceImplement;
import java.util.List;

/**
 *
 * @author alejo
 */
public class TConsumiblesMController {
    private TConsumiblesMService consumiblesMService;
    
    public TConsumiblesMController() {
        consumiblesMService = new TConsumiblesMServiceImplement();
        
    }
    
    public List<TipicoConsumiblesMecanicos> getAll(){
        return  consumiblesMService.getAll();
        
    }
    
    public void create(String filePath) {
        consumiblesMService.create(filePath);
    }
    
}
