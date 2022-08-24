package com.sistema.vacunas.modelo.entidades;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/*Declaracion de atributos de la tabla*/
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usua_id",nullable = false)
    private  long id;
    @Column(name = "usua_cedula",nullable = false,unique = true,length = 10)
    private String cedula;
    @Column(name = "usua_nombres",nullable = false,length = 50)
    private String nombres;
    @Column(name = "usua_apellidos",nullable = false,length = 50)
    private String apellidos;
    @Column(name = "usua_email",nullable = false,length = 50)
    private String email;
    @Column(name = "usua_clave",nullable = false,length = 32)
    private String clave;
    @CreationTimestamp
    @Column(name = "usua_fecha_creacion",updatable = false)
    private Timestamp fecha_creacion;
    @UpdateTimestamp
    @Column(name = "usua_fecha_actualizacion")
    private Timestamp fecha_actualizacion;
    @ColumnDefault("true")
    @Column(name = "usua_estado")
    private boolean estado=true;

    // relacion de rol
    // la relacion se lee de izquierda a derecha
    // por ejemplo " 1 rol pertenece a muchos usuarios "
    // ojo en una clave foranea siempre es la anotación @ManyToOne
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Rol rol;

    @OneToMany(mappedBy="usuario")
    @JsonIgnore // ignora la consulta de la tabla en ejecucion
    private List<Persona> persona;

    /*getter y setter*/
    public long getId() {
        return id;
    }

    public List<Persona> getPersona() {
        return persona;
    }

    public void setPersona(List<Persona> persona) {
        this.persona = persona;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Timestamp getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Timestamp fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    /*creacion del contructor*/
    public Usuario() {
        super();
    }

    public Usuario(String cedula, String nombres, String apellidos, String email, String clave, Rol rol) {
        super();
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.clave = clave;
        this.rol = rol;
    }

    public Usuario(long id, String cedula, String nombres, String apellidos, String email, String clave, Timestamp fecha_creacion, Rol rol) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.clave = clave;
        this.fecha_creacion = fecha_creacion;
        this.rol = rol;
    }
}
