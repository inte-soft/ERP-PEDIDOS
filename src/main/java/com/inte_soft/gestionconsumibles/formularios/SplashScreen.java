/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.formularios;

/**
 *
 * @author alejo
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;


public class SplashScreen extends JWindow {
    
    private Image splashImage; // Imagen de fondo del splash
    
    public SplashScreen() {
        // Establecer el tamaño y la posición de la ventana
        setSize(1000, 500);
        setLocationRelativeTo(null);
        
        // Cargar la imagen de fondo del splash (ajusta la ruta según la ubicación de tu imagen en el proyecto)
        splashImage = new ImageIcon("src\\main\\java\\com\\inte_soft\\gestionconsumibles\\formularios\\imagenes\\splashscreen\\hoja.png").getImage();
        int newWidth = 100;  // Nuevo ancho de la imagen
        int newHeight = 100; // Nuevo alto de la imagen
        splashImage = splashImage.getScaledInstance(newWidth,
                newHeight, Image.SCALE_SMOOTH);
        JLabel titleLabel = new JLabel("ERP");
        titleLabel.setBounds(440, 250, 120, 50);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel);
        
        // Crear una JProgressBar
        JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(50, 400, 900, 100);
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.LIGHT_GRAY);
        progressBar.setForeground(Color.BLUE);
        add(progressBar);
        
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        // Dibujar la imagen de fondo del splash
        g.drawImage(splashImage, 450, 100, this);
    }
}