package com.inte_soft.gestionconsumibles.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "PEDIDOS_COMPRAS")
public class PedidosCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedidos pedido;
    @Column(name = "item")
    private String item;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "marca")
    private String marca;
    @Column(name = "unidad")
    private String unidad;
    @Column(name = "cantidad")
    private float cantidad;
    @Column(name = "valor")
    private double valor;
    @Column(name = "comprado")
    private Boolean comprado;
    @Column(name = "fecha_compra")
    private Date fechaCompra;

    @Column(name = "comprador")
    private String comprador;

    public PedidosCompras() {
    }

    public PedidosCompras(Integer id, Pedidos pedido, String item, String codigo, String descripcion, String tipo, String referencia, String marca, String unidad, float cantidad, double valor, Boolean comprado, Date fechaCompra, String comprador) {
       this.id = id;
        this.pedido = pedido;
        this.item = item;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.referencia = referencia;
        this.marca = marca;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.valor = valor;
        this.comprado = comprado;
        this.fechaCompra = fechaCompra;
        this.comprador = comprador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Boolean getComprado() {
        return comprado;
    }

    public void setComprado(Boolean comprado) {
        this.comprado = comprado;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

}
