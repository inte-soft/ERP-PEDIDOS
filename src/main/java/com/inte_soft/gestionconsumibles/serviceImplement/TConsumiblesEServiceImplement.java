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
import javax.swing.JOptionPane;
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

           try (FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
                Workbook workbook = new XSSFWorkbook(fileInputStream)) {

               Sheet sheet = workbook.getSheetAt(0);
               List<TipicoConsumiblesElectricos> tipicoConsumiblesList = new ArrayList<>();

                      tipicosConsumiblesEDao = new TipicosConsumiblesEDao();
                      tipicosConsumiblesEDao.deleteAll();
                      int count=0;
               for (Row row : sheet) {
                   count++;
                   masterDao = new MasterDao();
                   TipicoConsumiblesElectricos tipicoConsumiblesElectricos = new TipicoConsumiblesElectricos();
                   Master master = masterDao.findById(row.getCell(0).toString());
                   tipicoConsumiblesElectricos.setMaster(master);
                   tipicoConsumiblesList.add(tipicoConsumiblesElectricos);
                   masterDao.close();
                   if (count==200) {
                       count=0;
                       TipicosConsumiblesEDao tipicosConsumiblesEDao2 = new TipicosConsumiblesEDao();
                       tipicosConsumiblesEDao2.batchCreate(tipicoConsumiblesList);
                       tipicoConsumiblesList.clear();
                       tipicosConsumiblesEDao2.close();
                       
                   }
               }
               TipicosConsumiblesEDao tipicosConsumiblesEDao3 = new TipicosConsumiblesEDao();
               tipicosConsumiblesEDao3.batchCreate(tipicoConsumiblesList);

               masterDao.close();
               tipicosConsumiblesEDao.close();

           } catch (IOException ex) {
               Logger.getLogger(MasterServiceImplement.class.getName()).log(Level.SEVERE, null, ex);
               JOptionPane.showMessageDialog(null, "Dato no adecuado", "Advertencia", JOptionPane.WARNING_MESSAGE);
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
