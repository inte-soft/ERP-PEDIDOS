/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.dao;

import com.inte_soft.gestionconsumibles.entity.Master;
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

    public void testConnection() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // Realiza una consulta de prueba
        Master master = entityManager.find(Master.class, "00001");
        System.out.println("ID: " + master.getCodigo());
      

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void main(String[] args) {
        MasterDao dao = new MasterDao();
        dao.testConnection();
        dao.close();
    }
}
    

