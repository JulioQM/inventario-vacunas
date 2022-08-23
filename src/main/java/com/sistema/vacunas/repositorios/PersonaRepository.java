package com.sistema.vacunas.repositorios;
import com.sistema.vacunas.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
    public Persona findByEstado(String estado_vacuna);
}
// ojo aqui van metodos genericos, el repository es un almacen de metodos genericos ya existentes.
// esta clase siempre extiende del repositorio
