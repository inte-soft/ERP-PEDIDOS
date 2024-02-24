package com.inte_soft.gestionconsumibles.dao;

import com.inte_soft.gestionconsumibles.entity.Ot;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class OtDao {

    @PersistenceContext
    private final EntityManagerFactory entityManagerFactory;

    public OtDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }

    public void close() {
        entityManagerFactory.close();
    }


    public List<Ot> getOts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Ot> ots = entityManager.createQuery(
                "SELECT o FROM Ot o WHERE o.terminado = FALSE",
                Ot.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return ots;

    }

    public Ot createOt(Ot ot) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(ot);

        entityManager.getTransaction().commit();
        entityManager.close();
        return ot;
    }

    public void updateOt(Ot ot) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(ot);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Optional<Ot> getByOt(String ot) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Ot ot1 = entityManager.createQuery(
                    "SELECT o FROM Ot o WHERE o.ot = :ot",
                    Ot.class).setParameter("ot", ot).getSingleResult();
            return Optional.of(ot1);
        } catch (Exception e) {
            return Optional.empty();
        } finally {
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }

    public void updateOtAlistado(List<Ot> listOt) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        for (Ot ot : listOt) {
            entityManager.merge(ot);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
