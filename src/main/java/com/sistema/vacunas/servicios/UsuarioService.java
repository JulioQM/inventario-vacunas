package com.sistema.vacunas.servicios;
import com.sistema.vacunas.modelo.dto.UsuarioDTO;
import com.sistema.vacunas.modelo.entidades.Usuario;
import java.util.List;

public interface UsuarioService {
    public List<UsuarioDTO> listarUsuario();
    public Usuario guardarUsuario(UsuarioDTO usuario) throws  Exception;
    public Usuario actualizarUsuario(long id_usuario,Usuario usuario)throws Exception;
    public void eliminarUsuario(long userId) throws Exception;
    public Usuario ingresarSistema(Usuario usuario) throws Exception;

}

