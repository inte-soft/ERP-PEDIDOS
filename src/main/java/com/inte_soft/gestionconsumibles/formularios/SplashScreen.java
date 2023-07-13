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
    private Image splashImageCargando; // Imagen de fondo del splash
    
    public SplashScreen() {
        // Establecer el tamaño y la posición de la ventana
        setSize(1000, 500);
        setLocationRelativeTo(null);
        
        // Cargar la imagen de fondo del splash (ajusta la ruta según la ubicación de tu imagen en el proyecto)
        splashImage = new ImageIcon("src\\main\\java\\com\\inte_soft\\gestionconsumibles\\formularios\\imagenes\\splashscreen\\logoNuevo.png").getImage();
        int newWidth = 300;  // Nuevo ancho de la imagen
        int newHeight = 300; // Nuevo alto de la imagen
        splashImage = splashImage.getScaledInstance(newWidth,
                newHeight, Image.SCALE_SMOOTH);
        splashImageCargando = new ImageIcon("src\\main\\java\\com\\inte_soft\\gestionconsumibles\\formularios\\imagenes\\splashscreen\\loading-green-loading.gif").getImage();
        int newWidthCargando = 50;  // Nuevo ancho de la imagen
        int newHeightCargando = 50; // Nuevo alto de la imagen
        splashImageCargando = splashImageCargando.getScaledInstance(newWidthCargando,
                newHeightCargando, Image.SCALE_SMOOTH);
        /*JLabel titleLabel = new JLabel("SyncWorks");
        titleLabel.setBounds(440, 250, 120, 50);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.red);
        add(titleLabel);*/
        
        // Crear una JProgressBar
        JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(100, 400, 900, 100);
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setStringPainted(false);
        Color colorSplash = new Color(201, 239, 200);
        progressBar.setBackground(colorSplash);
        progressBar.setForeground(Color.BLUE);
        add(progressBar);
        
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        // Dibujar la imagen de fondo del splash
        g.drawImage(splashImage, 350, 80, this);
        g.drawImage(splashImageCargando, 490, 350, this);
    }
}