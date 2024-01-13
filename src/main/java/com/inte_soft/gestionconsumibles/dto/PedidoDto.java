package com.inte_soft.gestionconsumibles.dto;

import com.inte_soft.gestionconsumibles.entity.AreaCompania;

import javax.persistence.*;
import java.util.Date;

public class PedidoDto {

    private int idPedido;
    private int ot;
    private String persona;
    private AreaCompania area;
    private Date fecha;
    private String operacion;
    private boolean revisado;
    private String tipoPedido;
    private boolean visto;
    private Date fechaAlmacen;

    public PedidoDto() {
    }

    public PedidoDto(int idPedido, int ot, String persona, AreaCompania area, Date fecha, String operacion, boolean revisado, String tipoPedido, boolean visto, Date fechaAlmacen) {
        this.idPedido = idPedido;
        this.ot = ot;
        this.persona = persona;
        this.area = area;
        this.fecha = fecha;
        this.operacion = operacion;
        this.revisado = revisado;
        this.tipoPedido = tipoPedido;
        this.visto = visto;
        this.fechaAlmacen = fechaAlmacen;
    }


    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getOt() {
        return ot;
    }

    public void setOt(int ot) {
        this.ot = ot;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public AreaCompania getArea() {
        return area;
    }

    public void setArea(AreaCompania area) {
        this.area = area;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public boolean isRevisado() {
        return revisado;
    }

    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }

    public Date getFechaAlmacen() {
        return fechaAlmacen;
    }

    public void setFechaAlmacen(Date fechaAlmacen) {
        this.fechaAlmacen = fechaAlmacen;
    }
}
