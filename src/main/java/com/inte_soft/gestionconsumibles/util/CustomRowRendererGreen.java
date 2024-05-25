package com.inte_soft.gestionconsumibles.util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomRowRendererGreen extends DefaultTableCellRenderer {
    private Font customFont;
    private Color customColor;
    private int column;

    public CustomRowRendererGreen(Font font, Color color,int column) {
        customFont = font;
        customColor = color;
        this.column = column;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


        Double pendiente =  Double.parseDouble(table.getValueAt(row, this.column).toString());


        if (pendiente == 0){
            component.setFont(table.getFont());
            component.setForeground(table.getForeground());
            // poner fondo de verde claro
            component.setBackground(new Color(0, 255, 0, 50));
        } else {

            component.setFont(customFont);
            component.setForeground(customColor);
            component.setBackground(table.getBackground());
        }

        return component;
    }
}





