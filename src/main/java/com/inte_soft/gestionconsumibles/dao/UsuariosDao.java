/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.dao;

import com.inte_soft.gestionconsumibles.entity.Usuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.swing.JOptionPane;

/**
 *
 * @author alejo
 */
public class UsuariosDao {
    @PersistenceContext
    private EntityManagerFactory entityManagerFactory;
    
    public UsuariosDao (){
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }
    
    public void close(){
        entityManagerFactory.close();
    }
    
    
    
    public List<Usuarios> getAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Usuarios> usuariosList = entityManager
                .createQuery("SELECT u FROM Usuarios u",Usuarios.class)
                .getResultList();
        
        entityManager.getTransaction().commit();
        entityManager.close();
        return usuariosList;  
    } 
    
    public Usuarios getById (int idUsuario){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Usuarios usuarios = entityManager
                .find(Usuarios.class,idUsuario);
        entityManager.getTransaction().commit();
        entityManager.close();
        return usuarios;
    }
    
    public Usuarios getByUser (String user){
       try{
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Usuarios usuario = entityManager
                    .createQuery("SELECT u FROM Usuarios u WHERE u.usuario = :user", Usuarios.class)
                    .setParameter("user", user)
                    .getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
            return usuario; 
       }catch(Exception e){
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Usuario no encontrado" + e, "Advertencia", JOptionPane.WARNING_MESSAGE);
           JOptionPane.getRootFrame().setAlwaysOnTop(true);
           Usuarios usuario = null;
           return usuario;
       }
            
    }
    
    public void update (Usuarios usuarios){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(usuarios);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public void create (Usuarios usuarios){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(usuarios);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void getUserString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void delete(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Usuarios usuarios = entityManager.find(Usuarios.class, id);

        if (usuarios != null) {
            entityManager.remove(usuarios);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

        entityManager.close();}
}
