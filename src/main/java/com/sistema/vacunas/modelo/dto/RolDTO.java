package com.sistema.vacunas.modelo.dto;

public class RolDTO {

    private  Integer rolId;
    private String nombre;
    private String descripcion;

    public RolDTO() {
    }
    public RolDTO(Integer rolId, String nombre, String descripcion) {
        this.rolId = rolId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getRolId() {
        return rolId;
    }
    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
