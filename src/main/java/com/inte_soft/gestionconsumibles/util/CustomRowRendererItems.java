package com.inte_soft.gestionconsumibles.util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class CustomRowRendererItems extends DefaultTableCellRenderer {

    private int column;
    private static final Border SELECTED_BORDER = new LineBorder(Color.BLUE, 2);

    public CustomRowRendererItems() {
        this.column = 6;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


        Integer estado =  Integer.parseInt(table.getValueAt(row, this.column).toString());

        switch(estado){
            case 1:
                component.setFont(table.getFont());
                component.setBackground(new Color(0,0,255,200));
                break;
            case 2:
                component.setBackground(new Color(0,0,0,0));
                break;
            case 4:
                component.setFont(table.getFont());
                component.setBackground(new Color(255,0,0,100));
                break;
            default :
                component.setBackground(new Color(0,0,0,0));
                break;
                
        }
        if (isSelected){
            component.setForeground(Color.BLACK);
            component.setBackground(new Color(0,150,150,100));
        }
        /*
        if (estado == 0){
            component.setFont(table.getFont());
            component.setForeground(table.getForeground());
            // poner fondo de verde claro
            component.setBackground(new Color(0, 255, 0, 50));
        } else {

            component.setFont(customFont);
            component.setForeground(customColor);
            component.setBackground(table.getBackground());
        }
           */
        return component;
    }
}





