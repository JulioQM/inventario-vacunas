package com.sistema.vacunas.entidades;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;

/*Declaracion de atributos de la tabla*/
@Entity
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pers_id",nullable = false)
    private  long id;
    @Column(name = "pers_fecha_nacimiento",nullable = false,length = 50)
    private String fecha_nacimiento;
    @Column(name = "pers_direccion",nullable = false,length = 50)
    private String direccion;
    @Column(name = "pers_telefono",nullable = false,length = 15)
    private String telefono;
    @ColumnDefault("'No Vacunado'")
    @Column(name = "pers_estado_vacuna",length = 50)
    private String estado_vacuna;
    @Column(name = "pers_fecha_vacunacion",length = 15)
    private String fecha_vacunacion;
    @ColumnDefault("0")
    @Column(name = "pers_numero_dosis")
    private Integer numero_dosis;
    @CreationTimestamp
    @Column(name = "pers_fecha_creacion",updatable = false)
    private Timestamp fecha_creacion;
    @UpdateTimestamp
    @Column(name = "pers_fecha_actualizacion")
    private Timestamp fecha_actualizacion;
    @ColumnDefault("true")
    @Column(name = "pers_estado")
    private boolean estado=true;
    /*relacion de usuario y tipo de vacunas*/
    @ManyToOne
    @JoinColumn(name = "usua_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "tipv_id")
    private TipoVacunas tipoVacunas;

    /*getter y setter*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoVacunas getTipoVacunas() {
        return tipoVacunas;
    }

    public void setTipoVacunas(TipoVacunas tipoVacunas) {
        this.tipoVacunas = tipoVacunas;
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
    public Persona() {
    }
}
