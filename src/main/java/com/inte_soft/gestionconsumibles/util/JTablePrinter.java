/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.util;


import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author alejo
 */
public class JTablePrinter {
    public  void printTable(JTable table, String header, String footer){
        MessageFormat headerPrint = new MessageFormat(header);
        MessageFormat footerPrint = new MessageFormat(footer);
        
        try{
            table.print(JTable.PrintMode.FIT_WIDTH,headerPrint,footerPrint);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, " No puede imprimirse");
        }
    }
        
}
