package com.sistema.vacunas.modelo.dto;

public class PersonaDTO {
    private Integer personaId;
    private String fecha_nacimiento;
    private String direccion;
    private String telefono;
    private String estado_vacuna;
    private String fecha_vacunacion;
    private Integer numero_dosis;
    private Integer usuario;
    private Integer tipoVacunas;

    public PersonaDTO() {
    }

    public PersonaDTO(Integer personaId, String fecha_nacimiento, String direccion, String telefono, String estado_vacuna, String fecha_vacunacion, Integer numero_dosis, Integer usuario, Integer tipoVacunas) {
        this.personaId= personaId;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado_vacuna = estado_vacuna;
        this.fecha_vacunacion = fecha_vacunacion;
        this.numero_dosis = numero_dosis;
        this.usuario = usuario;
        this.tipoVacunas = tipoVacunas;
    }

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado_vacuna() {
        return estado_vacuna;
    }

    public void setEstado_vacuna(String estado_vacuna) {
        this.estado_vacuna = estado_vacuna;
    }

    public String getFecha_vacunacion() {
        return fecha_vacunacion;
    }

    public void setFecha_vacunacion(String fecha_vacunacion) {
        this.fecha_vacunacion = fecha_vacunacion;
    }

    public Integer getNumero_dosis() {
        return numero_dosis;
    }

    public void setNumero_dosis(Integer numero_dosis) {
        this.numero_dosis = numero_dosis;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Integer getTipoVacunas() {
        return tipoVacunas;
    }

    public void setTipoVacunas(Integer tipoVacunas) {
        this.tipoVacunas = tipoVacunas;
    }
}
