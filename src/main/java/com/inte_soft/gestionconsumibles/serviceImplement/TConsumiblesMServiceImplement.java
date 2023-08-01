/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.serviceImplement;

import com.inte_soft.gestionconsumibles.dao.MasterDao;
import com.inte_soft.gestionconsumibles.dao.TipicosConsumiblesMDao;
import com.inte_soft.gestionconsumibles.entity.Master;
import com.inte_soft.gestionconsumibles.entity.TipicoConsumiblesMecanicos;
import com.inte_soft.gestionconsumibles.service.TConsumiblesMService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author alejo
 */
public class TConsumiblesMServiceImplement implements TConsumiblesMService{
    private MasterDao masterDao;
    private TipicosConsumiblesMDao tipicosConsumiblesMDao;
    @Override
    public List<TipicoConsumiblesMecanicos> getAll() {
        tipicosConsumiblesMDao = new TipicosConsumiblesMDao();
        List<TipicoConsumiblesMecanicos> tipicoConsumiblesMecanicoses = tipicosConsumiblesMDao.getAll();
        List<TipicoConsumiblesMecanicos> tceslist = new ArrayList();
        
        for(TipicoConsumiblesMecanicos consumiblesMecanicos : tipicoConsumiblesMecanicoses){
            TipicoConsumiblesMecanicos tipicoConsumiblesMecanicos = new TipicoConsumiblesMecanicos();
            tipicoConsumiblesMecanicos.setMaster(consumiblesMecanicos.getMaster());
            tceslist.add(tipicoConsumiblesMecanicos);
          
        }
        return tceslist;
    }

    @Override
    public void create(String string) {
    String excelFilePath = string;
    
    try (FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
         Workbook workbook = new XSSFWorkbook(fileInputStream)) {
        
        Sheet sheet = workbook.getSheetAt(0);
        List<TipicoConsumiblesMecanicos> tipicoConsumiblesList = new ArrayList<>();
        
               tipicosConsumiblesMDao = new TipicosConsumiblesMDao();
               tipicosConsumiblesMDao.deleteAll();
               int count=0;
        
        for (Row row : sheet) {
            count++;
            masterDao = new MasterDao();
            TipicoConsumiblesMecanicos tipicoConsumiblesMecanicos = new TipicoConsumiblesMecanicos();
            Master master = masterDao.findById(row.getCell(0).toString());
            masterDao.close();
            tipicoConsumiblesMecanicos.setMaster(master);
            tipicoConsumiblesList.add(tipicoConsumiblesMecanicos);
            if (count==100) {
                       count=0;
                       TipicosConsumiblesMDao tipicosConsumiblesMDao2 = new TipicosConsumiblesMDao();
                       tipicosConsumiblesMDao2.batchCreate(tipicoConsumiblesList);
                       tipicoConsumiblesList.clear();
                       tipicosConsumiblesMDao2.close();
                       
                   }
        }
        
        TipicosConsumiblesMDao tipicosConsumiblesMDao3 = new TipicosConsumiblesMDao();
        tipicosConsumiblesMDao3.batchCreate(tipicoConsumiblesList);
        
        masterDao.close();
        tipicosConsumiblesMDao.close();
        
    } catch (IOException ex) {
        Logger.getLogger(MasterServiceImplement.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Dato no adecuado", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
}
}
    

