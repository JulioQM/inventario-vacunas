package com.sistema.vacunas.repositorios;
import com.sistema.vacunas.modelo.entidades.Persona;
import com.sistema.vacunas.modelo.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
    public Persona findByEstado(String estado_vacuna);
    public Persona findById(long idRol);
    public Persona deleteById(long id);

}

