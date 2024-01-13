package com.inte_soft.gestionconsumibles.serviceImplement;

import com.inte_soft.gestionconsumibles.entity.Ot;
import com.inte_soft.gestionconsumibles.service.OtService;
import com.inte_soft.gestionconsumibles.dao.OtDao;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public class OtServiceImplement implements OtService {
    @Override
    public List<Ot> getOts() {
        OtDao otDao = new OtDao();
        return otDao.getOts();
    }

    @Override
    public void createOt(Ot ot) {
        //validar si existe la ot
        Optional<Ot> otOptional = getByOt(ot.getOt());
        if (otOptional.isPresent()) {
            JOptionPane.showMessageDialog(null, "La OT ya existe");
            return;
        }
        OtDao otDao = new OtDao();
        otDao.createOt(ot);
    }

    private Optional<Ot> getByOt(Integer ot) {
        OtDao otDao = new OtDao();
        return otDao.getByOt(ot);
    }

    @Override
    public void updateOt(Ot ot) {
        OtDao otDao = new OtDao();
        otDao.updateOt(ot);
    }
}
