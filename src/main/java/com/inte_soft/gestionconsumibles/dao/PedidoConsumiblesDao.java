/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.dao;

import com.inte_soft.gestionconsumibles.dto.*;
import com.inte_soft.gestionconsumibles.entity.Master;
import com.inte_soft.gestionconsumibles.entity.PedidoConsumibles;
import com.inte_soft.gestionconsumibles.entity.Pedidos;
import com.inte_soft.gestionconsumibles.entity.TipicoConsumiblesElectricos;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
                    dto.setMinimo(mme.getMin());
                    dto.setMaximo(mme.getMax());
                    pedidoConsumiblesDtoList.add(dto);
                }
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
                (Double) objects[9],
                (Integer) objects[10],
                (Integer) objects[11]
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

    public List<ConsumiblesDtoRev> filterSearchByRev(List<Pedidos> listPedidos) {
        if (listPedidos == null || listPedidos.isEmpty()) {
            return Collections.emptyList();
        }
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String queryString = "SELECT NEW com.inte_soft.gestionconsumibles.dto.ConsumiblesDtoRev( pc.pedidos.ot, pc.codigo, pc.descripcion, pc.tipo, pc.referencia, pc.marca, pc.unidad, SUM(pc.cantidad)) "
                + "FROM PedidoConsumibles pc "
                + "JOIN pc.pedidos p "
                + "WHERE p.revisado = false ";

        if (listPedidos != null && listPedidos.size() > 0) {
            queryString += "AND p.idPedido IN (";
            for (int i = 0; i < listPedidos.size(); i++) {
                queryString += ":idPedido" + i;
                if (i < listPedidos.size() - 1) {
                    queryString += ",";
                }
            }
            queryString += ")";
        }

        queryString += " GROUP BY pc.pedidos.ot, pc.codigo, pc.descripcion, pc.tipo, pc.referencia, pc.marca, pc.unidad";

        TypedQuery<ConsumiblesDtoRev> query = entityManager.createQuery(queryString, ConsumiblesDtoRev.class);

        if (listPedidos != null && listPedidos.size() > 0) {
            for (int i = 0; i < listPedidos.size(); i++) {
                query.setParameter("idPedido" + i, listPedidos.get(i).getIdPedido());
            }
        }

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
                    + "SET eMax = :max, eMin = :min "
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
}
