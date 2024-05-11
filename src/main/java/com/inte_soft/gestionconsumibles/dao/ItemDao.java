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
        List<Item> items = entityManager.createQuery("SELECT i FROM Item i " +
                        "WHERE i.cerrado = FALSE " +
                    "ORDER BY i.entrega ASC ",
                Item.class).getResultList();
        entityManager.close();
        return items;
    }

    public Optional<Item> getItemByOtAndItem(Ot ot, String item) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Item item1 = entityManager.createQuery(
                    "SELECT i FROM Item i WHERE i.ot = :ot AND i.item = :item",
                    Item.class).setParameter("ot", ot).setParameter("item", item).getSingleResult();
            return Optional.of(item1);
        } catch (Exception e) {
            return Optional.empty();
        } finally {
            entityManager.close();
        }
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
        List<Item> items = entityManager.createQuery(
                "SELECT i FROM Item i WHERE i.ot = :ot",
                Item.class).setParameter("ot", ot).getResultList();
        entityManager.close();
        return items;
    }

    public void updateItemAlistado(Ot ot, String item) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createQuery("UPDATE Item i SET i.alistado = TRUE WHERE i.ot = :ot AND i.item = :item")
                .setParameter("ot", ot)
                .setParameter("item", Integer.parseInt(item))
                .executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateItemAlistadoFalse(Ot ot1, String item) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createQuery("UPDATE Item i SET i.alistado = FALSE WHERE i.ot = :ot AND i.item = :item")
                .setParameter("ot", ot1)
                .setParameter("item", Integer.parseInt(item))
                .executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
