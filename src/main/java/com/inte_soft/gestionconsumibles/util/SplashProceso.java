/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.util;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 *
 * @author alejo
 */
public class SplashProceso {
    private String mensaje;
    private JFrame splashFrame;
    private JLabel mensajeLabel;

    public SplashProceso(String mensaje) {
        this.mensaje = mensaje;
        splashFrame = new JFrame("Advertencia");
        splashFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        splashFrame.setSize(300, 200);
        splashFrame.setResizable(false);
        splashFrame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        mensajeLabel = new JLabel(mensaje, SwingConstants.CENTER);
        mensajeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        splashFrame.getContentPane().add(mensajeLabel, BorderLayout.CENTER);
    }

    public void mostrarSplash() {
        splashFrame.setVisible(true);
    }

    public void cerrarSplash() {
        splashFrame.dispose();
    }
}
