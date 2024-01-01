/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.dao;

import com.inte_soft.gestionconsumibles.entity.TipicoConsumiblesElectricos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alejo
 */@Stateless
public class TipicosConsumiblesEDao {
    @PersistenceContext
    private EntityManagerFactory entityManagerFactory;

    public TipicosConsumiblesEDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }
    
     public void close() {
        entityManagerFactory.close();
    }
    
     public List<TipicoConsumiblesElectricos> getAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<TipicoConsumiblesElectricos> tipicoConsumiblesElectricosList = entityManager
                .createQuery("SELECT t FROM TipicoConsumiblesElectricos t",TipicoConsumiblesElectricos.class)
                .getResultList();
        
        entityManager.getTransaction().commit();
        entityManager.close();
        return tipicoConsumiblesElectricosList;  
    }
    
     public void batchCreate(List<TipicoConsumiblesElectricos> tipicoConsumiblesList) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            int batchSize = 200; // Elige el tamaño del lote adecuado según tus necesidades.
            int count = 0;

            for (TipicoConsumiblesElectricos tipicoConsumibles : tipicoConsumiblesList) {
                entityManager.persist(tipicoConsumibles);
                count++;

                if (count % batchSize == 0) {
                    entityManager.flush();
                    entityManager.clear();
                    transaction.commit();
                    
                }
                
            }

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    
    public void deleteAll (){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM TipicoConsumiblesElectricos").executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
     public TipicoConsumiblesElectricos findById(String id){
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
       TipicoConsumiblesElectricos tipicoConsumiblesElectricos = entityManager.find(
               TipicoConsumiblesElectricos.class, id);
       entityManager.getTransaction().commit();
       entityManager.close();
       return tipicoConsumiblesElectricos;
    }
      public void create (TipicoConsumiblesElectricos tipicoConsumiblesElectricos){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(tipicoConsumiblesElectricos);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
