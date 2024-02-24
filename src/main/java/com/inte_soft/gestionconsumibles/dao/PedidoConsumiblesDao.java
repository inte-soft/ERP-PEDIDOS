/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.dao;

import com.inte_soft.gestionconsumibles.dto.*;
import com.inte_soft.gestionconsumibles.entity.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author alejo
 */
public class PedidoConsumiblesDao {

    @PersistenceContext
    private final EntityManagerFactory entityManagerFactory;

    public PedidoConsumiblesDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");

    }

    public void close() {

        entityManagerFactory.close();
    }

    public List<PedidoConsumiblesDto> findByIdPedido(int idPedido) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // Primera consulta para obtener todos los datos de PedidoConsumibles
        List<PedidoConsumibles> pedidoConsumiblesList = entityManager
                .createQuery("SELECT pc FROM PedidoConsumibles pc WHERE pc.pedidos.idPedido = :idPedido", PedidoConsumibles.class)
                .setParameter("idPedido", idPedido)
                .getResultList();


        // Consulta para obtener todos los datos de TipicoConsumiblesMecanicos
        List<MaxMinElectDTO> maxMinMecanicosList = entityManager
                .createQuery("SELECT new com.inte_soft.gestionconsumibles.dto.MaxMinElectDTO(tcm.master.codigo, tcm.master.descripcion, tcm.cMax, tcm.cMin) FROM TipicoConsumiblesMecanicos tcm", MaxMinElectDTO.class)
                .getResultList();

        // Consulta para obtener todos los datos de TipicoConsumiblesElectricos
        List<MaxMinElectDTO> maxMinElectricosList = entityManager
                .createQuery("SELECT new com.inte_soft.gestionconsumibles.dto.MaxMinElectDTO(tce.master.codigo, tce.master.descripcion, tce.cMax, tce.cMin) FROM TipicoConsumiblesElectricos tce", MaxMinElectDTO.class)
                .getResultList();

        // Combinar los resultados en una sola lista
        List<MaxMinElectDTO> maxMinElectDTOList = new ArrayList<>();
        maxMinElectDTOList.addAll(maxMinMecanicosList);
        maxMinElectDTOList.addAll(maxMinElectricosList);



        // Crear una lista de PedidoConsumiblesDto combinando los dos conjuntos de datos
        List<PedidoConsumiblesDto> pedidoConsumiblesDtoList = new ArrayList<>();
        for (PedidoConsumibles pc : pedidoConsumiblesList) {
            Boolean flag = false;
            for (MaxMinElectDTO mme : maxMinElectDTOList) {
                if (pc.getCodigo().equals(mme.getCodigo())) {
                    PedidoConsumiblesDto dto = new PedidoConsumiblesDto();
                    dto.setIdPedidoC(pc.getIdPedidoConsumibles());
                    dto.setIdPedido(pc.getPedidos().getIdPedido());
                    dto.setItem(pc.getItem());
                    dto.setCodigo(pc.getCodigo());
                    dto.setDescripcion(pc.getDescripcion());
                    dto.setTipo(pc.getTipo());
                    dto.setReferencia(pc.getReferencia());
                    dto.setMarca(pc.getMarca());
                    dto.setUnidad(pc.getUnidad());
                    dto.setCantidad(pc.getCantidad());
                    dto.setValor(pc.getValor());
                    dto.setObservacion(pc.getObservacion());
                    dto.setMinimo(mme.getMin());
                    dto.setMaximo(mme.getMax());
                    pedidoConsumiblesDtoList.add(dto);
                    flag = true;
                    break;
                    
                }
            }
            if(!flag){
               PedidoConsumiblesDto dto = new PedidoConsumiblesDto();
                    dto.setIdPedidoC(pc.getIdPedidoConsumibles());
                    dto.setIdPedido(pc.getPedidos().getIdPedido());
                    dto.setItem(pc.getItem());
                    dto.setCodigo(pc.getCodigo());
                    dto.setDescripcion(pc.getDescripcion());
                    dto.setTipo(pc.getTipo());
                    dto.setReferencia(pc.getReferencia());
                    dto.setMarca(pc.getMarca());
                    dto.setUnidad(pc.getUnidad());
                    dto.setCantidad(pc.getCantidad());
                    dto.setValor(pc.getValor());
                    dto.setObservacion(pc.getObservacion());
                    dto.setMinimo(0);
                    dto.setMaximo(0);
                    pedidoConsumiblesDtoList.add(dto);
            }
        }

        entityManager.getTransaction().commit();
        entityManager.close();

        return pedidoConsumiblesDtoList;
    }

    private static PedidoConsumiblesDto getPedidoConsumiblesDto(Object object) {
        Object[] objects = (Object[]) object;
        return new PedidoConsumiblesDto(
                (BigInteger) objects[0],
                (Integer) objects[1],
                (String) objects[2],
                (String) objects[3],
                (String) objects[4],
                (String) objects[5],
                (String) objects[6],
                (String) objects[7],
                (String) objects[8],
                (Float)  objects[9],
                (Double) objects[10],
                (String) objects[11],
                (Integer) objects[12],
                (Integer) objects[13]
        );
    }

    public void createPedido(PedidoConsumibles pedidoConsumibles) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(pedidoConsumibles);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public List<ConsumiblesDto> filteredSearch(Integer ot, String descripcion, String tipoPedido) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String queryString = "SELECT NEW com.inte_soft.gestionconsumibles.dto.ConsumiblesDto(p.ot, pc.codigo, pc.descripcion, pc.tipo, pc.referencia, pc.marca, pc.unidad, SUM(pc.cantidad)) "
                + "FROM PedidoConsumibles pc "
                + "JOIN pc.pedidos p "
                + "WHERE 1=1 ";

        if (ot != null) {
            queryString += "AND p.ot = :ot ";
        }
        if (descripcion != null && !descripcion.isEmpty()) {
            queryString += "AND pc.descripcion LIKE :descripcion ";
        }
        if (tipoPedido != null && !tipoPedido.isBlank()) {
            queryString += "AND p.tipoPedido = :tipoPedido ";
        }
        queryString += "GROUP BY p.ot, pc.codigo, pc.descripcion, pc.tipo, pc.referencia, pc.marca, pc.unidad";

        TypedQuery<ConsumiblesDto> query = entityManager.createQuery(queryString, ConsumiblesDto.class);

        if (ot != null) {
            query.setParameter("ot", ot);
        }
        if (descripcion != null && !descripcion.isEmpty()) {
            query.setParameter("descripcion", "%" + descripcion + "%");
        }
        if (tipoPedido != null && !tipoPedido.isBlank()) {
            query.setParameter("tipoPedido", tipoPedido);
        }

        List<ConsumiblesDto> resultList = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return resultList;
    }

    public List<ConsumiblesDtoOt> filteredSearchByOt(Integer ot, String tipoPedido) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String queryString = "SELECT NEW com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoOt(p.ot, pc.item, pc.codigo, pc.descripcion, pc.tipo, pc.referencia, pc.marca, pc.unidad, SUM(pc.cantidad)) "
                + "FROM PedidoConsumibles pc "
                + "JOIN pc.pedidos p "
                + "WHERE 1=1 ";

        if (ot != null) {
            queryString += "AND p.ot = :ot ";
        }
        if (tipoPedido != null && !tipoPedido.isBlank()) {
            queryString += "AND p.tipoPedido = :tipoPedido ";
        }
        queryString += "GROUP BY p.ot, pc.item, pc.codigo, pc.descripcion, pc.tipo, pc.referencia, pc.marca, pc.unidad";

        TypedQuery<ConsumiblesDtoOt> query = entityManager.createQuery(queryString, ConsumiblesDtoOt.class);

        if (ot != null) {
            query.setParameter("ot", ot);
        }
        if (tipoPedido != null && !tipoPedido.isBlank()) {
            query.setParameter("tipoPedido", tipoPedido);
        }
        List<ConsumiblesDtoOt> resultList = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return resultList;
    }

    public List<ConsumiblesDtoRev> filterSearchByRev(List<Integer> ots) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String queryString = "SELECT NEW com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoRev(pc.idPedidoConsumibles, p.idPedido, p.ot, pc.codigo, pc.descripcion, pc.tipo, pc.referencia, pc.marca, pc.unidad, pc.cantidad) "
                + "FROM PedidoConsumibles pc "
                + "JOIN pc.pedidos p "
                + "WHERE p.ot IN (:ots) "
                + "AND pc.revisado = false "
                + "ORDER BY p.ot, pc.codigo";
        TypedQuery<ConsumiblesDtoRev> query = entityManager.createQuery(queryString, ConsumiblesDtoRev.class);
        query.setParameter("ots", ots);
        List<ConsumiblesDtoRev> resultList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }

    public List<MaxMinElectDTO> consumiblesElectricosMaxMinList() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String queryString = "SELECT NEW com.inte_soft.gestionconsumibles.dto.MaxMinElectDTO(pc.master.codigo, pc.master.descripcion, pc.cMax, pc.cMin) "
                + "FROM TipicoConsumiblesElectricos pc";

        TypedQuery<MaxMinElectDTO> query = entityManager.createQuery(queryString, MaxMinElectDTO.class);

        List<MaxMinElectDTO> resultList = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return resultList;
    }

    public void updateMaxMinE(List<MaxMinElectDTO> listMaxMinElectDTO) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        for (MaxMinElectDTO maxMinElectDTO : listMaxMinElectDTO) {
            entityManager.createQuery(
                    "UPDATE TipicoConsumiblesElectricos "
                    + "SET cMax = :max, cMin = :min "
                    + "WHERE codigo = :codigo")
                    .setParameter("max", maxMinElectDTO.getMax())
                    .setParameter("min", maxMinElectDTO.getMin())
                    .setParameter("codigo", maxMinElectDTO.getCodigo())
                    .executeUpdate();
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<MaxMinElectDTO> consumiblesMecanicosMaxMinList() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String queryString = "SELECT NEW com.inte_soft.gestionconsumibles.dto.MaxMinElectDTO(pc.master.codigo, pc.master.descripcion, pc.cMax, pc.cMin) "
                + "FROM TipicoConsumiblesMecanicos pc";

        TypedQuery<MaxMinElectDTO> query = entityManager.createQuery(queryString, MaxMinElectDTO.class);

        List<MaxMinElectDTO> resultList = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return resultList;
    }

    public void updateMaxMinM(List<MaxMinElectDTO> listMaxMinElectDTO) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (MaxMinElectDTO maxMinElectDTO : listMaxMinElectDTO) {
            entityManager.createQuery(
                    "UPDATE TipicoConsumiblesMecanicos "
                    + "SET cMax = :max, cMin = :min "
                    + "WHERE codigo = :codigo")
                    .setParameter("max", maxMinElectDTO.getMax())
                    .setParameter("min", maxMinElectDTO.getMin())
                    .setParameter("codigo", maxMinElectDTO.getCodigo())
                    .executeUpdate();
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void applycheck(List<ConsumiblesDtoRev> listConsumiblesDtoRev) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (ConsumiblesDtoRev consumiblesDtoRev : listConsumiblesDtoRev) {
            entityManager.createQuery(
                    "UPDATE PedidoConsumibles "
                    + "SET revisado = true "
                    + "WHERE idPedidoConsumibles = :idPedidoConsumibles")
                    .setParameter("idPedidoConsumibles", consumiblesDtoRev.getIdPdedidoConsumibles())
                    .executeUpdate();
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        // realizar una query para validar que si todos los consumibles que tengan el mismo idPedido estan revisados y de ser asi marcar en la tabla pedidos como revisado
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        entityManager2.getTransaction().begin();

        List<Integer> idPedidosUnicos = listConsumiblesDtoRev.stream()
                .map(ConsumiblesDtoRev::getIdPedido)
                .distinct()
                .collect(Collectors.toList());

        for (Integer idPedido : idPedidosUnicos) {
            // Check if there are any unrevised PedidoConsumibles left for the current idPedido
            long unrevisedCount = entityManager2
                    .createQuery("SELECT COUNT(pc) FROM PedidoConsumibles pc WHERE pc.pedidos.idPedido = :idPedido AND pc.revisado = false", Long.class)
                    .setParameter("idPedido", idPedido)
                    .getSingleResult();

            // If there are no unrevised PedidoConsumibles left, set revisado to true in Pedidos
            if (unrevisedCount == 0) {
                entityManager2.createQuery(
                                "UPDATE Pedidos "
                                        + "SET revisado = true "
                                        + "WHERE idPedido = :idPedido")
                        .setParameter("idPedido", idPedido)
                        .executeUpdate();
            }
        }

        entityManager2.getTransaction().commit();
        entityManager2.close();


    }

    public List<ConsumiblesDtoOt> filteredSearchByOtArea(int ot, String area) {

    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
        String queryString = "SELECT NEW com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoOt(p.ot," +
                " pc.item, pc.codigo, pc.descripcion, pc.tipo, pc.referencia, pc.marca, pc.unidad, SUM(pc.cantidad)," +
                " AVG(COALESCE(tce.cMax, tcm.cMax)), AVG(COALESCE(tce.cMin, tcm.cMin)), SUM(pc.alistado), pc.observacion) "
            + "FROM PedidoConsumibles pc "
            + "JOIN pc.pedidos p "
            + "LEFT JOIN TipicoConsumiblesElectricos tce ON pc.codigo = tce.master.codigo "
            + "LEFT JOIN TipicoConsumiblesMecanicos tcm ON pc.codigo = tcm.master.codigo "
            + "WHERE 1=1 ";

    if (ot != 0) {
        queryString += "AND p.ot = :ot ";
    }
    if (area != null && !area.isBlank()) {
        queryString += "AND p.tipoPedido = :area ";
    }
    queryString += "GROUP BY p.ot, pc.item, pc.codigo, pc.descripcion, pc.tipo, pc.referencia, pc.marca, pc.unidad";

    TypedQuery<ConsumiblesDtoOt> query = entityManager.createQuery(queryString, ConsumiblesDtoOt.class);

    if (ot != 0) {
        query.setParameter("ot", ot);
    }
    if (area != null && !area.isBlank()) {
        query.setParameter("area", area);
    }
    List<ConsumiblesDtoOt> resultList = query.getResultList();

    entityManager.getTransaction().commit();
    entityManager.close();

    return resultList;
}

    public List<ConsumiblesDtoOt> getConsumiblesByOtAndItem(Ot ot, List<String> listItem, String area) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String queryString = "SELECT NEW com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoOt(p.ot, pc.codigo, pc.descripcion, pc.tipo, pc.referencia, pc.marca, pc.unidad, SUM(pc.cantidad), AVG(COALESCE(tce.cMax, tcm.cMax)), AVG(COALESCE(tce.cMin, tcm.cMin)), SUM(pc.alistado), p.tipoPedido) "
                + "FROM PedidoConsumibles pc "
                + "JOIN pc.pedidos p "
                + "LEFT JOIN TipicoConsumiblesElectricos tce ON pc.codigo = tce.master.codigo "
                + "LEFT JOIN TipicoConsumiblesMecanicos tcm ON pc.codigo = tcm.master.codigo "
                + "WHERE p.ot = :ot "
                + "AND pc.item IN (:listItem) "
                + "AND p.tipoPedido = :area "
                + "GROUP BY p.ot, pc.codigo, pc.descripcion, pc.tipo, pc.referencia, pc.marca, pc.unidad, p.tipoPedido";
        TypedQuery<ConsumiblesDtoOt> query = entityManager.createQuery(queryString, ConsumiblesDtoOt.class);
        query.setParameter("ot", Integer.parseInt(ot.getOt()));
        query.setParameter("listItem", listItem);
        query.setParameter("area", area);
        List<ConsumiblesDtoOt> resultList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }
}
