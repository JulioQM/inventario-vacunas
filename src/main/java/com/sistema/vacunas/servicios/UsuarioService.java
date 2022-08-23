package com.sistema.vacunas.servicios;
import com.sistema.vacunas.DTO.UsuarioDTO;
import com.sistema.vacunas.entidades.Usuario;
import java.util.List;

public interface UsuarioService {
    public Usuario guardarUsuario(UsuarioDTO usuario) throws  Exception;
    public Usuario ingresarSistema(Usuario usuario) throws Exception;
    public List<UsuarioDTO> listarUsuario();
    public Usuario obtenerUsuario(String cedula);
    public Usuario actualizarUsuario(long id_usuario,Usuario usuario)throws Exception;

    public void eliminarUsuario(long userId) throws Exception;

}

