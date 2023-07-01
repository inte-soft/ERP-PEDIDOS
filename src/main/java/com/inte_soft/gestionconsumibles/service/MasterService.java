/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inte_soft.gestionconsumibles.service;

import com.inte_soft.gestionconsumibles.entity.Master;
import java.util.List;

/**
 *
 * @author alejo
 */

public interface MasterService {
    
    public void getAll();
    public void updateMaster(String filepath);
    public void createMaster(String filepath);
    public Master getByCode(String code);
    public List<Object[]> filteredSearch (String codigo, String descripcion, String referencia);
    
}
