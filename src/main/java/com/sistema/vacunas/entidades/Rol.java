package com.sistema.vacunas.entidades;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
/*Declaracion de atributos de la tabla*/
@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id",nullable = false)
    private  long id;
    @Column(name = "role_nombre",nullable = false,unique = true,length = 50)
    private String nombre;
    @Column(name = "role_descripcion",nullable = false,length = 100)
    private String descripcion;
    @CreationTimestamp
    @Column(name = "role_fecha_creacion",updatable = false)
    private Timestamp fecha_creacion;
    @UpdateTimestamp
    @Column(name = "role_fecha_actualizacion")
    private Timestamp fecha_actualizacion;
    @ColumnDefault("true")
    @Column(name = "role_estado")
    private boolean estado=true;

    //bi-directional many-to-one association to USUARIO
    /*
    *la relacion seria : un usuario puede tener muchos roles
    * y un rol puede tener un usuario
    */

    @OneToMany(mappedBy="rol")
    @JsonIgnore
    private List<Usuario> usuario;

    /*getter y setter*/
    public long getId() {return id; }
    public void setId(long id) { this.id = id;    }
    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuarios(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    /*creacion del contructor*/

    public Rol() {
        super();
    }

    public Rol(long id) {
        this.id = id;
    }

    public Rol(String nombre, String descripcion) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Rol(long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;

    }
}
