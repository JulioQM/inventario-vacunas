package com.sistema.vacunas.repositorios;
import com.sistema.vacunas.entidades.TipoVacunas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoVacunaRepository extends JpaRepository<TipoVacunas,Long> {
    public TipoVacunas findByNombre(String nombre);
    public TipoVacunas findById(long id_vacuna);
}
