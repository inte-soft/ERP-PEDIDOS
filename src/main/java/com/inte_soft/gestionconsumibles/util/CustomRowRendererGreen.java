package com.inte_soft.gestionconsumibles.util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomRowRendererGreen extends DefaultTableCellRenderer {
    private Font customFont;
    private Color customColor;

    public CustomRowRendererGreen(Font font, Color color) {
        customFont = font;
        customColor = color;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


        Double pendiente =  Double.parseDouble(table.getValueAt(row, 10).toString());


        if (pendiente == 0){
            component.setFont(customFont);
            component.setForeground(customColor);
        } else {
            // Restaura el formato predeterminado de la fila
            component.setFont(table.getFont());
            component.setForeground(table.getForeground());
        }

        return component;
    }
}





