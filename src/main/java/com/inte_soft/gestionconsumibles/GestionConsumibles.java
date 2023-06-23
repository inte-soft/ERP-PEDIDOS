/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.inte_soft.gestionconsumibles;


import com.inte_soft.gestionconsumibles.formularios.Login;
import com.inte_soft.gestionconsumibles.formularios.Principal;
import com.inte_soft.gestionconsumibles.formularios.SplashScreen;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


/**
 *
 * @author Inte-Soft
 */
public class GestionConsumibles {

    
    public static void main(String[] args) {
        SplashScreen splash = new SplashScreen();
        Login login = new Login();
        splash.setVisible(true);

        try {
            Thread.sleep(2000); // Pausa de 2 segundos (ajusta el tiempo según tus necesidades)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        splash.setVisible(false);

        //Crear y mostrar la ventana principal de la aplicación
        SwingUtilities.invokeLater(() -> {
            
            login.setVisible(true);
                       
        });       
    }
}
