package com.inte_soft.gestionconsumibles.util;

import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;

public class CustomRowRendererBlue extends DefaultTableCellRenderer {
    private Font customFont;
    private Color customColor;

    public CustomRowRendererBlue(Font font, Color color) {
        customFont = font;
        customColor = color;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Obtén el valor de la columna 5 (visto)
        boolean isVisto = (boolean) table.getValueAt(row, 5);

        // Aplica el formato personalizado a toda la fila si es "False"
        if (!isVisto) {
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





