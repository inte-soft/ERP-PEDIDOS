/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.serviceImplement;

import com.inte_soft.gestionconsumibles.dao.AreaCompaniaDao;
import com.inte_soft.gestionconsumibles.entity.AreaCompania;
import com.inte_soft.gestionconsumibles.service.AreaCompaniaServices;
import java.util.List;

/**
 *
 * @author alejo
 */
public class AreaCompaniaServiceImplement implements AreaCompaniaServices {
    
    private AreaCompaniaDao areaCompaniaDao;
    @Override
    public List<AreaCompania> getAllUsers() {
        areaCompaniaDao = new AreaCompaniaDao();
        return areaCompaniaDao.getAll();
    }
    
}
