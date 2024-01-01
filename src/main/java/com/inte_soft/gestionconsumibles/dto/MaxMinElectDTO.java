package com.inte_soft.gestionconsumibles.dto;

public class MaxMinElectDTO {
    private String codigo;
    private String descripcion;
    private Integer max;
    private Integer min;

    public MaxMinElectDTO() {
    }
    public MaxMinElectDTO(String codigo, String descripcion, Integer max, Integer min) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.max = max;
        this.min = min;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Integer getMax() {
        return max;
    }
    public Integer getMin() {
        return min;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setMax(Integer max) {
        this.max = max;
    }
    public void setMin(Integer min) {
        this.min = min;
    }

}
