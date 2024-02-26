package com.inte_soft.gestionconsumibles.dao;

import com.inte_soft.gestionconsumibles.entity.PedidoConsumibles;
import com.inte_soft.gestionconsumibles.entity.Pedidos;
import com.inte_soft.gestionconsumibles.entity.PedidosCompras;
import org.hibernate.sql.Update;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class PedidoComprasDao {

    @PersistenceContext
    private final EntityManagerFactory entityManagerFactory;


    public PedidoComprasDao() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }

    public void close() {
        entityManagerFactory.close();
    }


    public void createPedido(PedidosCompras pedidosCompras) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(pedidosCompras);
            entityManager.getTransaction().commit();
            entityManager.close();


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public List<PedidosCompras> listPedidosCompras(Pedidos pedidos) {
        List<PedidosCompras> pedidosCompras = new ArrayList<>();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String queryString = "SELECT p " +
                "FROM PedidosCompras p " +
                "WHERE p.pedido = :pedido";
        pedidosCompras = entityManager.createQuery(queryString, PedidosCompras.class)
                .setParameter("pedido", pedidos)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return pedidosCompras;
    }

    public void UpdatePedidoCompras(List<PedidosCompras> listPedidosCompras, List<PedidosCompras> listPedidosComprasUpdate, Pedidos pedido) {

        this.updatePedidoCompras(listPedidosComprasUpdate);
        List<PedidoConsumibles> listPedidoConsumibles = new ArrayList<>();
        for (PedidosCompras pedidosCompras : listPedidosCompras) {
            PedidoConsumibles pedidoConsumibles = new PedidoConsumibles();
            pedidoConsumibles.setPedidos(pedido);
            pedidoConsumibles.setItem(pedidosCompras.getItem());
            pedidoConsumibles.setCodigo(pedidosCompras.getCodigo());
            pedidoConsumibles.setDescripcion(pedidosCompras.getDescripcion());
            pedidoConsumibles.setTipo(pedidosCompras.getTipo());
            pedidoConsumibles.setReferencia(pedidosCompras.getReferencia());
            pedidoConsumibles.setMarca(pedidosCompras.getMarca());
            pedidoConsumibles.setUnidad(pedidosCompras.getUnidad());
            pedidoConsumibles.setCantidad(pedidosCompras.getCantidad());
            pedidoConsumibles.setValor(pedidosCompras.getValor());
            pedidoConsumibles.setRevisado(true);
            pedidoConsumibles.setObservacion(pedidosCompras.getObservacion());
            pedidoConsumibles.setAlistado(0);
            listPedidoConsumibles.add(pedidoConsumibles);
            

        }



        // este metodo debe hacer una actualizacion tipo batch
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (PedidosCompras pedidosCompras : listPedidosCompras) {
            entityManager.merge(pedidosCompras);
        }
        entityManager.getTransaction().commit();
        entityManager.close();

        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        entityManager1.getTransaction().begin();
        for (PedidoConsumibles pedidoConsumibles : listPedidoConsumibles) {
            entityManager1.merge(pedidoConsumibles);
        }
        entityManager1.getTransaction().commit();
        entityManager1.close();

        //validar si todos los pedidosCompras estan comprados y de ser asi cambiar el estado del pedido a comprado
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        entityManager2.getTransaction().begin();
        String queryString = "SELECT p " +
                "FROM PedidosCompras p " +
                "WHERE p.pedido = :pedido AND p.comprado = false";
        List<PedidosCompras> pedidosCompras = entityManager2.createQuery(queryString, PedidosCompras.class)
                .setParameter("pedido", pedido)
                .getResultList();
        entityManager2.getTransaction().commit();
        entityManager2.close();



        if (pedidosCompras.isEmpty()) {
            EntityManager entityManager3 = entityManagerFactory.createEntityManager();
            entityManager3.getTransaction().begin();
            String queryString2 = "UPDATE Pedidos p " +
                    "SET p.comprado = TRUE, p.revisado = TRUE " +
                    "WHERE p.id = :id";
            entityManager3.createQuery(queryString2)
                    .setParameter("id", pedido.getIdPedido())
                    .executeUpdate();
            entityManager3.getTransaction().commit();
            entityManager3.close();
        }


    }

    public void updatePedidoCompras(List<PedidosCompras> pedidosCompras) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (PedidosCompras pedidosCompras1 : pedidosCompras) {
            entityManager.merge(pedidosCompras1);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
