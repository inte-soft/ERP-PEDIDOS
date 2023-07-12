/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.util;

import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JTable;

/**
 *
 * @author alejo
 */
public class JTablePrinter {
         public static void printTable(JTable table, String jobName) throws PrinterException {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName(jobName);
        
        job.setPrintable((graphics, pageFormat, pageIndex) -> {
            if (pageIndex >= getNumberOfPages(table, pageFormat)) {
                return Printable.NO_SUCH_PAGE;
            }
            
            int x = (int) pageFormat.getImageableX();
            int y = (int) pageFormat.getImageableY();
            graphics.translate(x, y);
            
            Graphics2D g2d = (Graphics2D) graphics;
            double scaleX = pageFormat.getImageableWidth() / table.getWidth();
            double scaleY = pageFormat.getImageableHeight() / table.getRowHeight();
            g2d.scale(scaleX, scaleY);
            
            // Calcular la porción de la tabla a imprimir en la página actual
            int startIndex = pageIndex * table.getVisibleRect().height / table.getRowHeight();
            int endIndex = (pageIndex + 1) * table.getVisibleRect().height / table.getRowHeight();
            
            // Imprimir encabezados de columna en la primera página
            if (pageIndex == 0) {
                table.getTableHeader().print(g2d);
                g2d.translate(0, table.getTableHeader().getHeight());
            }
            
            // Imprimir porción de la tabla en la página actual
            g2d.translate(0, -startIndex * table.getRowHeight());
            table.print(g2d);
            
            return Printable.PAGE_EXISTS;
        });
        
        if (job.printDialog()) {
            job.print();
        }
    }
    
    private static int getNumberOfPages(JTable table, PageFormat pageFormat) {
        int tableHeight = table.getRowCount() * table.getRowHeight();
        int printableHeight = (int) pageFormat.getImageableHeight();
        
        return (int) Math.ceil((double) tableHeight / printableHeight);
    }
}
