/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.serviceImplement;

import com.inte_soft.gestionconsumibles.dao.MasterDao;
import com.inte_soft.gestionconsumibles.dao.TipicosConsumiblesEDao;
import com.inte_soft.gestionconsumibles.entity.Master;
import com.inte_soft.gestionconsumibles.entity.TipicoConsumiblesElectricos;
import com.inte_soft.gestionconsumibles.service.TConsumiblesEService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
public class TConsumiblesEServiceImplement implements  TConsumiblesEService{
    private MasterDao masterDao;
    private TipicosConsumiblesEDao tipicosConsumiblesEDao;
    
    

    @Override
    public void create(String string) {
        String excelFilePath = string;
        masterDao = new MasterDao();
        tipicosConsumiblesEDao = new TipicosConsumiblesEDao();
        tipicosConsumiblesEDao.deleteAll();
        try(FileInputStream fileInpuStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(fileInpuStream)){
            
            Sheet sheet = (Sheet) workbook.getSheetAt(0);
            TipicoConsumiblesElectricos tipicoConsumiblesElectricos = new TipicoConsumiblesElectricos();
            for(Row row :sheet){
                Optional <TipicoConsumiblesElectricos> currenttipicosOptional = Optional.ofNullable(
                        tipicosConsumiblesEDao.findById(row.getCell(0).toString()));
                if(currenttipicosOptional.isPresent()){
                tipicoConsumiblesElectricos.setMaster(masterDao.findById(row.getCell(0).toString()));
                
                tipicosConsumiblesEDao.create(tipicoConsumiblesElectricos);
                }
                  
            }
                
               
            } catch (IOException ex) {
            Logger.getLogger(MasterServiceImplement.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public List<TipicoConsumiblesElectricos> getAll() {
        tipicosConsumiblesEDao = new TipicosConsumiblesEDao();
        List<TipicoConsumiblesElectricos> tipicoConsumiblesElectricoses = tipicosConsumiblesEDao.getAll();
        List<TipicoConsumiblesElectricos> tceslist = new ArrayList();
        
        for(TipicoConsumiblesElectricos consumiblesElectricos : tipicoConsumiblesElectricoses){
            TipicoConsumiblesElectricos tipicoConsumiblesElectricos = new TipicoConsumiblesElectricos();
            tipicoConsumiblesElectricos.setMaster(consumiblesElectricos.getMaster());
            tceslist.add(tipicoConsumiblesElectricos);
          
        }
        return tceslist;
    }
    
}
