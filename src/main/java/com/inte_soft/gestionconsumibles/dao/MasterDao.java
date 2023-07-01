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
import javax.persistence.TypedQuery;

/**
 *
 * @author alejo
 */
@Stateless
public class MasterDao {
    
    @PersistenceContext
    private final EntityManagerFactory entityManagerFactory;

    public MasterDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }

    public void close() {
        entityManagerFactory.close();
    }
    
    public Master findById(String codigo){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
       Master master = entityManager.find(Master.class, codigo);
       entityManager.getTransaction().commit();
       entityManager.close();
       return master;
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
   
   public void merge(Master master){
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
   
   public List<Object[]> filteredSearch(String codigo, String descripcion, String referencia){
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();

    String queryString = "SELECT m.codigo, m.descripcion, m.marca, m.referencia FROM Master m WHERE 1=1";
   
    if (codigo != null && !codigo.isEmpty()) {
        queryString += " AND m.codigo LIKE :codigo";
    }
    if (descripcion != null && !descripcion.isEmpty()) {
        queryString += " AND m.descripcion LIKE :descripcion";
    }
    if (referencia != null && !referencia.isEmpty()) {
        queryString += " AND m.referencia LIKE :referencia";
    }

    TypedQuery<Object[]> query = entityManager.createQuery(queryString, Object[].class);
   
    if (codigo != null && !codigo.isEmpty()) {
        query.setParameter("codigo", "%" + codigo + "%");
    }
    if (descripcion != null && !descripcion.isEmpty()) {
        query.setParameter("descripcion", "%" + descripcion + "%");
    }
    if (referencia != null && !referencia.isEmpty()) {
        query.setParameter("referencia", "%" + referencia + "%");
    }

    List<Object[]> resultList = query.getResultList();

    entityManager.getTransaction().commit();
    entityManager.close();

    return resultList;
}
}
    

