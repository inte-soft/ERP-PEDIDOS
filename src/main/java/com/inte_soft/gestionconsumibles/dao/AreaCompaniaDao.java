/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.dao;

import com.inte_soft.gestionconsumibles.entity.AreaCompania;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alejo
 */
public class AreaCompaniaDao {
    
    @PersistenceContext
    private final EntityManagerFactory entityManagerFactory;
   
    public  AreaCompaniaDao (){
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }
    
    public void close(){
        entityManagerFactory.close();
    }
    public List<AreaCompania> getAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<AreaCompania> areaCompaniaList = entityManager
                .createQuery("SELECT a FROM AreaCompania a",AreaCompania.class)
                .getResultList();
        
        entityManager.getTransaction().commit();
        entityManager.close();
        return areaCompaniaList;  
    }
    
    public AreaCompania getById(Integer idArea){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AreaCompania areaCompañia = entityManager
                .find(AreaCompania.class, idArea);
        entityManager.getTransaction().commit();
        entityManager.close();
        return areaCompañia;
    }
    public AreaCompania getByNombreArea(String nombreArea){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AreaCompania areaCompania = entityManager
                .createQuery("SELECT a FROM AreaCompania a WHERE a.nombreArea = :nombre", AreaCompania.class)
                .setParameter("nombre", nombreArea)
                .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return areaCompania;    
    }
    
}
