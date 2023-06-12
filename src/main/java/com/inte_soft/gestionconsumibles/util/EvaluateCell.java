/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

/**
 *
 * @author alejo
 */
public class EvaluateCell {
    
    public  CellValue evaluateCell ( Cell cell){
        
        FormulaEvaluator formulaEvaluator = cell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
        return formulaEvaluator.evaluate(cell);
    }
    
}
