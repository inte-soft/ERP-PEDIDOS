/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.dao;

import com.inte_soft.gestionconsumibles.entity.TipicoConsumiblesElectricos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alejo
 */
public class TipicosConsumiblesEDao {
    @PersistenceContext
    private EntityManagerFactory entityManagerFactory;

    public TipicosConsumiblesEDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }
    
     public List<TipicoConsumiblesElectricos> getAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<TipicoConsumiblesElectricos> usuariosList = entityManager
                .createQuery("SELECT t FROM TipicoConsumiblesElectricos t",TipicoConsumiblesElectricos.class)
                .getResultList();
        
        entityManager.getTransaction().commit();
        entityManager.close();
        return usuariosList;  
    }
    
     public void create (TipicoConsumiblesElectricos tipicoConsumiblesElectricos){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(tipicoConsumiblesElectricos);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public void deleteAll (){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM TipicoConsumiblesElectricos").executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
