package com.sistema.vacunas.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UsuarioDTO {

    private  Integer id;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String email;
    //@JsonIgnore
    private String clave;
    private Integer rol;

    private boolean estado;

    public UsuarioDTO() {
    }
    public UsuarioDTO(Integer id, String cedula, String nombres, String apellidos, String email) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
    }

    public UsuarioDTO( Integer id,String cedula, String nombres, String apellidos, String email,Integer rol,boolean estado) {
        this.id=id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.rol=rol;
        this.estado=estado;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
