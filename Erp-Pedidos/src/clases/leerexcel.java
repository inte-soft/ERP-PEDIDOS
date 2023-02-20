
package clases;

import com.healthmarketscience.jackcess.impl.query.QueryImpl.Row;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author alejo
 */
public class leerexcel {
    
    /**
     *
     * @param args
     */
    public static void main (String[] args) throws IOException{
        try{
            List cellData = new ArrayList();
            FileInputStream f = new FileInputStream("C:\\Users\\alejo\\OneDrive\\Documents\\NetBeansProjects\\ERP-PEDIDOS\\Erp-Pedidos\\MAESTRO DE EQUIPOS V2.xlsx");
            XSSFWorkbook libro= new XSSFWorkbook(f);
            XSSFSheet hoja = libro.getSheetAt(0);
            int rows = hoja.getLastRowNum();
            //int cols = hoja.getLastRowNum();
            
            for( int r=0;r<rows;r++){
                 XSSFRow row = hoja.getRow(r);
                 XSSFCell celda = row.getCell(0);
                 String valor = celda.getStringCellValue();
                 if("00010"==valor){
                     System.out.println("eureka");
                 }//else{
                    // System.out.println("fail");
                 //}
            }
            
        }catch(FileNotFoundException ex){
            
            ex.printStackTrace();
        {
            
        }
    }
    }
}
