/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.dao;

import com.inte_soft.gestionconsumibles.dto.PedidoDto;
import com.inte_soft.gestionconsumibles.entity.Pedidos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

    public Pedidos createPedido(Pedidos pedidos) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(pedidos);
        Pedidos pedidosr = pedidos;
        entityManager.getTransaction().commit();
        entityManager.close();
        return pedidos;
    }

    public Pedidos findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Pedidos pedidos = entityManager.find(Pedidos.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return pedidos;
    }

    public List<Pedidos> findWhithoutRevision(int ot) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String queryString = "SELECT p "
                + "FROM Pedidos p "
                + "WHERE p.revisado = false ";
        if (ot != 0) {
            queryString += "AND p.ot = :ot ";
        }

        TypedQuery<Pedidos> query = entityManager.createQuery(queryString, Pedidos.class);

        if (ot != 0) {
            query.setParameter("ot", ot);
        }

        List<Pedidos> resultList = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return resultList;
    }

    public boolean existeOT(int ot) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String queryString = "SELECT COUNT(p) FROM Pedidos p WHERE p.ot = :ot";
        TypedQuery<Long> query = entityManager.createQuery(queryString, Long.class);
        query.setParameter("ot", ot);

        Long count = query.getSingleResult();

        entityManager.getTransaction().commit();
        entityManager.close();

        return count > 0;
    }

    public void checkPedidos(Pedidos pedidos) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.merge(pedidos);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public void merge(Pedidos pedido) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(pedido);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<PedidoDto> listPedidos() {
        //metodo ppara listar todos los pedisos adicionales ordenados por fecha decendete y que no aparazcan pedidos de ot que esten marcadas como terminadas
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String queryString = "SELECT new com.inte_soft.gestionconsumibles.dto.PedidoDto(p.idPedido, p.ot, p.persona, p.area, p.fecha, p.operacion, p.revisado, p.tipoPedido, p.visto, i.entrega, p.comprado) "
                + "FROM Pedidos p "
                + "LEFT JOIN Ot o ON p.ot = o.ot "
                + "LEFT JOIN Item i ON o.id = i.ot "
                + "WHERE (p.ot NOT IN (SELECT o.ot FROM Ot o WHERE o.terminado = TRUE )) AND p.operacion LIKE '%Adicional%' AND p.comprado = TRUE "
                + "ORDER BY i.entrega DESC";
        
        
        TypedQuery<PedidoDto> query = entityManager.createQuery(queryString, PedidoDto.class);
        List<PedidoDto> resultList = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return resultList;

    }

    public List<Pedidos> listPedidosSearchByOt(String ot) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String queryString = "SELECT p "
                + "FROM Pedidos p "
                + "WHERE p.ot = :ot and p.comprado = TRUE "
                + "ORDER BY p.fecha DESC";

        TypedQuery<Pedidos> query = entityManager.createQuery(queryString, Pedidos.class);
        query.setParameter("ot",ot);
        List<Pedidos> resultList = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return resultList;
    }

    public List<PedidoDto> listPedidosCompras() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String queryString = "SELECT new com.inte_soft.gestionconsumibles.dto.PedidoDto(p.idPedido, p.ot, p.persona, p.area, p.fecha, p.operacion, p.revisado, p.tipoPedido, p.visto, i.entrega, p.comprado) "
                + "FROM Pedidos p "
                + "JOIN Ot o ON p.ot = o.ot "
                + "JOIN PedidosCompras pc ON p.idPedido = pc.pedido "
                + "LEFT JOIN Item i ON pc.item = i.item "
                + "WHERE p.operacion LIKE 'Compras%' and p.comprado = FALSE "
                + "ORDER BY i.entrega DESC";

        TypedQuery<PedidoDto> query = entityManager.createQuery(queryString, PedidoDto.class);
        List<PedidoDto> resultList = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return resultList;
    }

    public List<PedidoDto> listPedidosComprasOk() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String queryString = "SELECT new com.inte_soft.gestionconsumibles.dto.PedidoDto(p.idPedido, p.ot, p.persona, p.area, p.fecha, p.operacion, p.revisado, p.tipoPedido, p.visto, i.entrega, p.comprado) "
                + "FROM Pedidos p "
                + "LEFT JOIN Ot o ON p.ot = o.ot "
                + "LEFT JOIN Item i ON o.id = i.ot AND o.id = i.ot "
                + "WHERE p.operacion LIKE 'Compras%' and p.comprado = TRUE "
                + "ORDER BY p.fecha DESC";

        TypedQuery<PedidoDto> query = entityManager.createQuery(queryString, PedidoDto.class);
        List<PedidoDto> resultList = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return resultList;
    }

    public List<Pedidos> findByOt(String ot) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String queryString = "SELECT p "
                + "FROM Pedidos p "
                + "WHERE p.ot = :ot";

        TypedQuery<Pedidos> query = entityManager.createQuery(queryString, Pedidos.class);
        query.setParameter("ot", ot);
        List<Pedidos> resultList = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return resultList;
    }

    public void updatePedido(Pedidos p) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(p);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
