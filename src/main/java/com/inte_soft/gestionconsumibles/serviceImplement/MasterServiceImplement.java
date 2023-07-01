/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.serviceImplement;

import com.inte_soft.gestionconsumibles.dao.MasterDao;
import com.inte_soft.gestionconsumibles.entity.Master;
import com.inte_soft.gestionconsumibles.service.MasterService;
import com.inte_soft.gestionconsumibles.util.EvaluateCell;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author alejo
 */
public class MasterServiceImplement implements MasterService {
    private EvaluateCell evaluateCell;
    private Master master;

    @Override
    public void getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateMaster(String string) {
         String excelFilePath = string;
        
        try(FileInputStream fileInpuStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(fileInpuStream)){
            
            Sheet sheet = (Sheet) workbook.getSheetAt(0);
            Master master = new Master();
            MasterDao masterDao = new MasterDao();
            for(Row row :sheet){
                Optional <Master> currentMaster = Optional.ofNullable(
                        masterDao.findById(row.getCell(0).toString()));
                if(currentMaster.isPresent()){
                master.setCodigo(row.getCell(0).toString());
                master.setDescripcion(row.getCell(1).toString());
                master.setTipo(row.getCell(2).toString());
                master.setReferencia(row.getCell(3).toString());
                master.setMarca(row.getCell(4).toString());
                master.setUnidad(row.getCell(5).toString());
                master.setPrecio_lista(row.getCell(6).getNumericCellValue());
                master.setFecha_actualizacion(row.getCell(7).toString());
                master.setDescuento_basico(row.getCell(8).getNumericCellValue());
                master.setDescuento_proyecto(row.getCell(9).getNumericCellValue());
                master.setPrecio_ultima_compra(row.getCell(10).getNumericCellValue());
                    
                masterDao.merge(master);
                }else{
                master.setCodigo(row.getCell(0).toString());
                master.setDescripcion(row.getCell(1).toString());
                master.setTipo(row.getCell(2).toString());
                master.setReferencia(row.getCell(3).toString());
                master.setMarca(row.getCell(4).toString());
                master.setUnidad(row.getCell(5).toString());
                master.setPrecio_lista(row.getCell(6).getNumericCellValue());
                master.setFecha_actualizacion(row.getCell(7).toString());
                master.setDescuento_basico(row.getCell(8).getNumericCellValue());
                master.setDescuento_proyecto(row.getCell(9).getNumericCellValue());
                master.setPrecio_ultima_compra(row.getCell(10).getNumericCellValue());
                    
                masterDao.createMaster(master);
                    
                }
                  
            }
                
               
            } catch (IOException ex) {
            Logger.getLogger(MasterServiceImplement.class.getName()).log(Level.SEVERE, null, ex);
            }
     
        }


    @Override
    public void createMaster(String string) {
        String excelFilePath = string;
        
        try(FileInputStream fileInpuStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(fileInpuStream)){
            
            Sheet sheet = (Sheet) workbook.getSheetAt(0);
            Master master = new Master();
            MasterDao masterDao = new MasterDao();
            for(Row row :sheet){
  
                master.setCodigo(row.getCell(0).toString());
                master.setDescripcion(row.getCell(1).toString());
                master.setTipo(row.getCell(2).toString());
                master.setReferencia(row.getCell(3).toString());
                master.setMarca(row.getCell(4).toString());
                master.setUnidad(row.getCell(5).toString());
                master.setPrecio_lista(row.getCell(6).getNumericCellValue());
                master.setFecha_actualizacion(row.getCell(7).toString());
                master.setDescuento_basico(row.getCell(8).getNumericCellValue());
                master.setDescuento_proyecto(row.getCell(9).getNumericCellValue());
                master.setPrecio_ultima_compra(row.getCell(12).getNumericCellValue());
                    
                masterDao.createMaster(master);
                  
            }
                
               
            } catch (IOException ex) {
            Logger.getLogger(MasterServiceImplement.class.getName()).log(Level.SEVERE, null, ex);
            }
     
        }

    @Override
    public Master getByCode(String string) {
        MasterDao masterDao = new MasterDao();
        Master master = new Master();
        Optional <Master> currentMaster = Optional.ofNullable(
                        masterDao.findById(string));
        
        if (currentMaster.isPresent()) {
            
            return masterDao.findById(string);
        }else{
            return master;
        }

    }

    @Override
    public List<Object[]> filteredSearch(String codigo, String descripcion, String referencia) {
        MasterDao masterDao = new MasterDao();
        return masterDao.filteredSearch(codigo, descripcion, referencia);
    }
    
}
