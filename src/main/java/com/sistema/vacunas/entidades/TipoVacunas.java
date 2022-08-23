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
@Table(name = "tipo_vacunas")
public class TipoVacunas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipv_id",nullable = false)
    private  long id;
    @Column(name = "tipv_nombre",nullable = false,unique = true,length = 50)
    private String nombre;
    @CreationTimestamp
    @Column(name = "tipv_fecha_creacion",updatable = false)
    private Timestamp fecha_creacion;
    @UpdateTimestamp
    @Column(name = "tipv_fecha_actualizacion")
    private Timestamp fecha_actualizacion;
    @ColumnDefault("true")
    @Column(name = "tipv_estado")
    private boolean estado=true;
    //bi-directional many-to-one association to PERSONA
    /*
     *la relacion seria : una persona puede tener muchos muchos tiposVacunas
     * y un tipoVacuna puede tener un persona
     */
    @OneToMany(mappedBy="tipoVacunas")
    @JsonIgnore
    private List<Persona> persona;
    /*getter y setter*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public List<Persona> getPersona() {
        return persona;
    }

    public void setPersona(List<Persona> persona) {
        this.persona = persona;
    }
    /*creacion del contructor*/

    public TipoVacunas() {

    }
}
