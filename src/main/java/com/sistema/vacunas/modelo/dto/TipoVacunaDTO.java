package com.sistema.vacunas.modelo.dto;

public class TipoVacunaDTO {
    private  Integer tipoVacunasId;
    private String nombre;

    public TipoVacunaDTO() {
    }
    public TipoVacunaDTO(Integer tipoVacunasId, String nombre) {
        this.tipoVacunasId = tipoVacunasId;
        this.nombre = nombre;
    }

    public Integer getTipoVacunasId() {
        return tipoVacunasId;
    }

    public void setTipoVacunasId(Integer tipoVacunasId) {
        tipoVacunasId = tipoVacunasId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
