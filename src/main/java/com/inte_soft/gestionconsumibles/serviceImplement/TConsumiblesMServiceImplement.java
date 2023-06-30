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
        
        tipicosConsumiblesMDao = new TipicosConsumiblesMDao();
        tipicosConsumiblesMDao.deleteAll();
        try(FileInputStream fileInpuStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(fileInpuStream)){
            
            Sheet sheet = (Sheet) workbook.getSheetAt(0);
            for(Row row :sheet){
                TipicoConsumiblesMecanicos tipicoConsumiblesMecanicos = new TipicoConsumiblesMecanicos();
                masterDao = new MasterDao();
                Master master = masterDao.findById(row.getCell(0).toString());
                tipicoConsumiblesMecanicos.setMaster(master);
                tipicosConsumiblesMDao = new TipicosConsumiblesMDao();
                tipicosConsumiblesMDao.create(tipicoConsumiblesMecanicos);
                
                  
            }
                
               
            } catch (IOException ex) {
            Logger.getLogger(MasterServiceImplement.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
    

