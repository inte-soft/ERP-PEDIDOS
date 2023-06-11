/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.dao;

import com.inte_soft.gestionconsumibles.entity.Master;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alejo
 */
@Stateless
public class MasterDao {
    
    @PersistenceContext
    final private EntityManagerFactory entityManagerFactory;

    public MasterDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }

    public void close() {
        entityManagerFactory.close();
    }

   public List<Master> getAll(){
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
       
       List<Master> master = entityManager.createQuery
        ("SELECT m FROM Master m", Master.class)
               .getResultList();
       
       entityManager.getTransaction().commit();
       entityManager.close();
       return master;
   }
   
   public void updateMaster(Master master){
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
       
       entityManager.merge(master);
       
       entityManager.getTransaction().commit();
       entityManager.close();
   }
   
   public void createMaster(Master master){
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
       
       entityManager.persist(master);
       
       entityManager.getTransaction().commit();
       entityManager.close();
   }
}
    

