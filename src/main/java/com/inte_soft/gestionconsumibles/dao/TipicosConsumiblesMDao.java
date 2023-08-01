/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.dao;

import com.inte_soft.gestionconsumibles.entity.TipicoConsumiblesMecanicos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alejo
 */
public class TipicosConsumiblesMDao {
   @PersistenceContext
    private EntityManagerFactory entityManagerFactory;

    public TipicosConsumiblesMDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }
    
    public void close() {
        entityManagerFactory.close();
    }
    
    public List<TipicoConsumiblesMecanicos> getAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<TipicoConsumiblesMecanicos> usuariosList = entityManager
                .createQuery("SELECT t FROM TipicoConsumiblesMecanicos t",TipicoConsumiblesMecanicos.class)
                .getResultList();
        
        entityManager.getTransaction().commit();
        entityManager.close();
        return usuariosList;  
    }
    
    public void create (TipicoConsumiblesMecanicos tipicoConsumiblesMecanicos){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(tipicoConsumiblesMecanicos);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public void deleteAll (){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM TipicoConsumiblesMecanicos").executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();
        
    }
    public TipicoConsumiblesMecanicos findById(String id){
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
       TipicoConsumiblesMecanicos tipicoConsumiblesMecanicos = entityManager.find(
               TipicoConsumiblesMecanicos.class, id);
       entityManager.getTransaction().commit();
       entityManager.close();
       return tipicoConsumiblesMecanicos;
    }
    
    public void batchCreate(List<TipicoConsumiblesMecanicos> tipicoConsumiblesList) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            int batchSize = 150; // Elige el tamaño del lote adecuado según tus necesidades.
            int count = 0;

            for (TipicoConsumiblesMecanicos tipicoConsumibles : tipicoConsumiblesList) {
                entityManager.persist(tipicoConsumibles);
                count++;

                if (count % batchSize == 0) {
                    entityManager.flush();
                    entityManager.clear();
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
}
