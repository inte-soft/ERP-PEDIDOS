/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.controller;

import com.inte_soft.gestionconsumibles.entity.AreaCompania;
import com.inte_soft.gestionconsumibles.serviceImplement.AreaCompaniaServiceImplement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alejo
 */
public class AreaCompaniaController {
    
    private AreaCompaniaServiceImplement areaCompaniaServiceImplment;
    
    public List<String> getAll(){
        areaCompaniaServiceImplment = new AreaCompaniaServiceImplement();
        List<AreaCompania> listArea = areaCompaniaServiceImplment.getAllUsers();
        List<String> listNameAreas = new ArrayList<>();
        for(AreaCompania list : listArea){
           listNameAreas.add(list.getNombreArea());
        }
        
        return listNameAreas;
    }
}
