/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.dao;

import com.inte_soft.gestionconsumibles.dto.ConsumiblesDto;
import com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoOt;
import com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoRev;
import com.inte_soft.gestionconsumibles.entity.PedidoConsumibles;
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
public class PedidoConsumiblesDao {
    
    @PersistenceContext
    private final EntityManagerFactory entityManagerFactory;
    
    public PedidoConsumiblesDao(){
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        
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
    
    public void createPedido(PedidoConsumibles pedidoConsumibles){
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
       entityManager.persist(pedidoConsumibles);
       entityManager.getTransaction().commit();
       entityManager.close();
       
   }
    
    public List<ConsumiblesDto> filteredSearch(Integer ot, String descripcion) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();

    String queryString = "SELECT NEW com.inte_soft.gestionconsumibles.dto.ConsumiblesDto(p.ot, pc.codigo, pc.descripcion, pc.tipo, pc.referencia, pc.marca, pc.unidad, SUM(pc.cantidad)) " +
            "FROM PedidoConsumibles pc " +
            "JOIN pc.pedidos p " +
            "WHERE 1=1 ";

    if (ot != null) {
        queryString += "AND p.ot = :ot ";
    }
    if (descripcion != null && !descripcion.isEmpty()) {
        queryString += "AND pc.descripcion LIKE :descripcion ";
    }
    
    queryString += "GROUP BY p.ot, pc.codigo, pc.descripcion, pc.tipo, pc.referencia, pc.marca, pc.unidad";

    TypedQuery<ConsumiblesDto> query = entityManager.createQuery(queryString, ConsumiblesDto.class);

    if (ot != null) {
        query.setParameter("ot", ot);
    }
    if (descripcion != null && !descripcion.isEmpty()) {
        query.setParameter("descripcion", "%" + descripcion + "%");
    }

    List<ConsumiblesDto> resultList = query.getResultList();

    entityManager.getTransaction().commit();
    entityManager.close();

    return resultList;
}

    public List<ConsumiblesDtoOt> filteredSearchByOt(Integer ot) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();

    String queryString = "SELECT NEW com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoOt(p.ot, pc.item, pc.codigo, pc.descripcion, pc.tipo, pc.referencia, pc.marca, pc.unidad, SUM(pc.cantidad)) " +
            "FROM PedidoConsumibles pc " +
            "JOIN pc.pedidos p " +
            "WHERE 1=1 ";

    if (ot != null) {
        queryString += "AND p.ot = :ot ";
    }
    
    queryString += "GROUP BY p.ot, pc.item, pc.codigo, pc.descripcion, pc.tipo, pc.referencia, pc.marca, pc.unidad";

    TypedQuery<ConsumiblesDtoOt> query = entityManager.createQuery(queryString, ConsumiblesDtoOt.class);

    if (ot != null) {
        query.setParameter("ot", ot);
    }

    List<ConsumiblesDtoOt> resultList = query.getResultList();

    entityManager.getTransaction().commit();
    entityManager.close();

    return resultList;
}
    
        public List<ConsumiblesDtoRev> filterSearchByRev(List<Pedidos> listPedidos) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            String queryString = "SELECT NEW com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoRev( pc.codigo, pc.descripcion, pc.tipo, pc.referencia, pc.marca, pc.unidad, SUM(pc.cantidad)) " +
                    "FROM PedidoConsumibles pc " +
                    "JOIN pc.pedidos p " +
                    "WHERE p.revisado = false ";

            if (listPedidos != null && !listPedidos.isEmpty()) {
                queryString += "AND p.idPedido IN (";
                for (int i = 0; i < listPedidos.size(); i++) {
                    queryString += ":idPedido" + i;
                    if (i < listPedidos.size() - 1) {
                        queryString += ",";
                    }
                }
                queryString += ")";
            }

            queryString += "GROUP BY pc.codigo, pc.descripcion, pc.tipo, pc.referencia, pc.marca, pc.unidad";

            TypedQuery<ConsumiblesDtoRev> query = entityManager.createQuery(queryString, ConsumiblesDtoRev.class);

            if (listPedidos != null && !listPedidos.isEmpty()) {
                for (int i = 0; i < listPedidos.size(); i++) {
                    query.setParameter("idPedido" + i, listPedidos.get(i).getIdPedido());
                }
            }

            List<ConsumiblesDtoRev> resultList = query.getResultList();

            entityManager.getTransaction().commit();
            entityManager.close();

            return resultList;
        }
}
