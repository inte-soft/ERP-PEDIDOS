/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.controller;

import com.inte_soft.gestionconsumibles.entity.Master;
import com.inte_soft.gestionconsumibles.service.MasterService;
import com.inte_soft.gestionconsumibles.serviceImplement.MasterServiceImplement;
import java.util.List;

/**
 *
 * @author alejo
 */
public class MasterController {
    private MasterService masterService;
    public MasterController() {
        masterService = new MasterServiceImplement();
    }
    
    
    public void updateMaster(String filePath){
        masterService.updateMaster(filePath);
    }
    
    public List<Object[]> filteredSearch(String codigo, String descripcion, String referencia){
        return masterService.filteredSearch(codigo, descripcion, referencia);
    }
    
    public Master getByCode(String code){
     
        return masterService.getByCode(code);
    }
}
