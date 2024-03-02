package com.inte_soft.gestionconsumibles.dto;

import com.inte_soft.gestionconsumibles.entity.Ot;

import java.math.BigInteger;

public class EntregaDto {

        private BigInteger id;
        private String ot;
        private String item;
        private String codigo;
        private String descripcion;
        private String tipo;
        private String referencia;
        private String marca;
        private String unidad;
        private Float cantidad;
        private Integer max;
        private Integer min;
        private double alistado;
        private String area;
        private String observacion;


        public EntregaDto() {
        }

        public EntregaDto(BigInteger id, String ot, String item, String codigo, String descripcion, String tipo, String referencia, String marca, String unidad, Float cantidad, Integer max, Integer min, double alistado, String area, String observacion) {
            this.id = id;
            this.ot = ot;
            this.item = item;
            this.codigo = codigo;
            this.descripcion = descripcion;
            this.tipo = tipo;
            this.referencia = referencia;
            this.marca = marca;
            this.unidad = unidad;
            this.cantidad = cantidad;
            this.max = max;
            this.min = min;
            this.alistado = alistado;
            this.area = area;
            this.observacion = observacion;
        }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getOt() {
        return ot;
    }

    public void setOt(String ot) {
        this.ot = ot;
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

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public double getAlistado() {
            return alistado;
        }

        public void setAlistado(double alistado) {
            this.alistado = alistado;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getObservacion() {
            return observacion;
        }

        public void setObservacion(String observacion) {
            this.observacion = observacion;
        }




}
