package com.inte_soft.gestionconsumibles.controller;

import com.inte_soft.gestionconsumibles.entity.Ot;
import com.inte_soft.gestionconsumibles.service.OtService;
import com.inte_soft.gestionconsumibles.serviceImplement.OtServiceImplement;

import java.util.List;

public class OtController {

    private OtService otService;

    public OtController() {
        otService = new OtServiceImplement();
    }
    
    
    public List<Ot> getOts() {
        return otService.getOts();

    }

    public void createOt(Ot ot) {
        otService.createOt(ot);
    }

    public void updateOt(Ot ot) {
        otService.updateOt(ot);

    }

    public void updateOtAlistado(List<Ot> listOt) {
        otService.updateOtAlistado(listOt);
    }
}
