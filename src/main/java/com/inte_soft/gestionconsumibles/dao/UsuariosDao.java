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

/**
 *
 * @author alejo
 */
public class UsuariosDao {
    @PersistenceContext
    private EntityManagerFactory entityManagerFactory;
    
    public UsuariosDao (){
        entityManagerFactory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
    }
    
    public void close(){
        entityManagerFactory.close();
    }
    
    
    
    public List<Usuarios> getAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Usuarios> usuariosList = entityManager
                .createQuery("SELECT u FROM u",Usuarios.class)
                .getResultList();
        
        entityManager.getTransaction().commit();
        entityManager.close();
        return usuariosList;  
    } 
    
    public Usuarios getById (String idUsuario){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Usuarios usuarios = entityManager
                .find(Usuarios.class,"idUsuario");
        entityManager.getTransaction().commit();
        entityManager.close();
        return usuarios;
    }
    
    public Usuarios getByUser (String user){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Usuarios usuario = entityManager
                .createQuery("SELECT u FROM u WHERE u.usuario = :user", Usuarios.class)
                .setParameter("usuario", user)
                .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return usuario;    
    }
    
    public void update (Usuarios usuarios){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(usuarios);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public void crate (Usuarios usuarios){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(usuarios);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
