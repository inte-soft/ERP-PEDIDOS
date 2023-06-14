/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.dao;

import com.inte_soft.gestionconsumibles.entity.PedidoConsumibles;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alejo
 */
public class PedidoConsumiblesDao {
    
    @PersistenceContext
    private final EntityManagerFactory entityManagerFactory;
    
    public PedidoConsumiblesDao(){
        entityManagerFactory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        
    }
    
    public void close(){
        
        entityManagerFactory.close();
    }
    
    public List<PedidoConsumibles> findByIdPedido (String idpedido){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<PedidoConsumibles> pedidoConsumiblesList = entityManager
                .createQuery("SELECT pc FROM pc WHERE pc.Pedido.idPedido = :idPedido", PedidoConsumibles.class)
                .setParameter("idPedido", idpedido)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return pedidoConsumiblesList;
    }
    
}
