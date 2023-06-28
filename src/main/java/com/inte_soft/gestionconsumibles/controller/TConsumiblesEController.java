/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.controller;

import com.inte_soft.gestionconsumibles.entity.TipicoConsumiblesElectricos;
import com.inte_soft.gestionconsumibles.service.TConsumiblesEService;
import com.inte_soft.gestionconsumibles.serviceImplement.TConsumiblesEServiceImplement;
import java.util.List;

/**
 *
 * @author alejo
 */
public class TConsumiblesEController {
    private TConsumiblesEService consumiblesEService;
    
    public TConsumiblesEController() {
        consumiblesEService = new TConsumiblesEServiceImplement();
        
    }
    
    public List<TipicoConsumiblesElectricos> getAll(){
        return  consumiblesEService.getAll();
        
    }
    
    public void create(String filePath) {
        consumiblesEService.create(filePath);
    }
    
}
