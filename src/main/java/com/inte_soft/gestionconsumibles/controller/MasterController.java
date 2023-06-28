/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.controller;

import com.inte_soft.gestionconsumibles.service.MasterService;
import com.inte_soft.gestionconsumibles.serviceImplement.MasterServiceImplement;

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
}
