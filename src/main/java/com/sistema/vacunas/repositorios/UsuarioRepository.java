package com.sistema.vacunas.repositorios;
import com.sistema.vacunas.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    public Usuario findByCedula(String cedula);
    public Usuario findById(long id);
    public Usuario deleteById(long id);


}
