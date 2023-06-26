/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.inte_soft.gestionconsumibles;


import com.inte_soft.gestionconsumibles.formularios.Login;
import com.inte_soft.gestionconsumibles.formularios.SplashScreen;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

        EntityManager em = emf.createEntityManager();

        // Realiza operaciones de comprobación (por ejemplo, obtener una entidad)
        // ...

        // Cierra el EntityManager y el EntityManagerFactory
        em.close();
        emf.close(); // Pausa de 2 segundos (ajusta el tiempo según tus necesidades)
        } catch (Exception e) {
            e.printStackTrace();
        }

        splash.setVisible(false);

        //Crear y mostrar la ventana principal de la aplicación
        SwingUtilities.invokeLater(() -> {
            
            login.setVisible(true);
                       
        });       
    }
}
