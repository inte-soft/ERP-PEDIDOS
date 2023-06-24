/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.dao;

import com.inte_soft.gestionconsumibles.entity.AreaCompania;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alejo
 */
public class AreaCompañiaDao {
    
    @PersistenceContext
    private final EntityManagerFactory entityManagerFactory;
   
    public  AreaCompañiaDao (){
        entityManagerFactory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
    }
    
    public void close(){
        entityManagerFactory.close();
    }
    
    public AreaCompania getById(String idArea){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AreaCompania areaCompañia = entityManager
                .find(AreaCompania.class, "idArea");
        entityManager.getTransaction().commit();
        entityManager.close();
        return areaCompañia;
    }
    
}
