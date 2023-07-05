/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.dao;


import com.inte_soft.gestionconsumibles.entity.Pedidos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alejo
 */
public class PedidosDao {
    @PersistenceContext
    private final EntityManagerFactory entityManagerFactory;

    public PedidosDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }

    public void close() {
        entityManagerFactory.close();
    }
    
    public Pedidos createPedido(Pedidos pedidos){
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
       
       entityManager.persist(pedidos);
       Pedidos pedidosr = pedidos;
       entityManager.getTransaction().commit();
       entityManager.close();
       return pedidos;
   }
    
    public Pedidos findById(String id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
       Pedidos pedidos = entityManager.find(Pedidos.class, id);
       entityManager.getTransaction().commit();
       entityManager.close();
       return pedidos;
    }
    
  
}
