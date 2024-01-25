package com.inte_soft.gestionconsumibles.service;

import com.inte_soft.gestionconsumibles.entity.Ot;

import java.util.List;

public interface OtService {
    List<Ot> getOts();

    void createOt(Ot ot);

    void updateOt(Ot ot);

    void updateOtAlistado(List<Ot> listOt);
}
