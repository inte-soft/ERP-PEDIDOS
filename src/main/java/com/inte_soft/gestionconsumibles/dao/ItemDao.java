package com.inte_soft.gestionconsumibles.dao;

import com.inte_soft.gestionconsumibles.entity.Item;
import com.inte_soft.gestionconsumibles.entity.Ot;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class ItemDao {

    @PersistenceContext
    private final EntityManagerFactory entityManagerFactory;


    public ItemDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }

    public void close() {
        entityManagerFactory.close();
    }

    public void createItem(Item item) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
entityManager.getTransaction().begin();

        entityManager.persist(item);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public List<Item> getItems() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Item> items = entityManager.createQuery("SELECT i FROM Item i", Item.class).getResultList();
        entityManager.close();
        return items;
    }

    public Optional<Item> getItemByOtAndItem(Ot ot, Integer item) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Optional<Item> itemOptional = Optional.ofNullable(entityManager.find(Item.class, item));
        entityManager.close();
        return itemOptional;
    }

    public void updateItem(Item item) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(item);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Item> getItemsByOt(Ot ot) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Item> items = entityManager.createQuery("SELECT i FROM Item i WHERE i.ot = :ot", Item.class).setParameter("ot", ot).getResultList();
        entityManager.close();
        return items;
    }
}
