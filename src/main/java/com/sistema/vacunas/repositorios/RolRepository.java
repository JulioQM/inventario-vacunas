package com.sistema.vacunas.repositorios;
import com.sistema.vacunas.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol,Long> {
    public Rol findByNombre(String nombre);
    public Rol findById(long idRol);
    public Rol deleteById(long id);

}
