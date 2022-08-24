package com.sistema.vacunas.servicios.implementaciones;
import com.sistema.vacunas.modelo.dto.UsuarioDTO;
import com.sistema.vacunas.modelo.entidades.Rol;
import com.sistema.vacunas.modelo.entidades.Usuario;
import com.sistema.vacunas.repositorios.RolRepository;
import com.sistema.vacunas.repositorios.UsuarioRepository;
import com.sistema.vacunas.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<UsuarioDTO> listarUsuario() {
        List<UsuarioDTO> listaUsuarioDTO = new ArrayList<>();
        for (Usuario usuario : usuarioRepository.findAll()) {
            UsuarioDTO nuevoDTO = new UsuarioDTO(
                    ((int) usuario.getId()),
                    usuario.getCedula(),
                    usuario.getNombres(),
                    usuario.getApellidos(),
                    usuario.getEmail(),
                    ((int) usuario.getRol().getId()),
                    usuario.isEstado()
            );
            listaUsuarioDTO.add(nuevoDTO);
        }
        return listaUsuarioDTO;
    }
    @Override
    public Usuario guardarUsuario(UsuarioDTO usuarioDto) throws Exception {
        Rol rolId = rolRepository.findById(usuarioDto.getRol());
        System.out.println("imprimendo id.....rol..." + usuarioDto.getRol());
        Usuario usuarioLocal = usuarioRepository.findByCedula(usuarioDto.getCedula());
        if (rolId == null) {
            throw new Exception("El rol no esta presente");
        }
        if (usuarioLocal != null) {
            System.out.println("El usuario con esa cedula ya existe");
            throw new Exception("El usuario con esa cedula  ya esta presente");
        } else {
            Usuario usuario = new Usuario(
                    usuarioDto.getCedula(),
                    usuarioDto.getNombres(),
                    usuarioDto.getApellidos(),
                    usuarioDto.getEmail(),
                    usuarioDto.getClave(),
                    rolId
            );
            return usuarioRepository.save(usuario);
        }
    }

    @Override
    public Usuario actualizarUsuario(long id_usuario, Usuario usuario) throws Exception {
        Usuario localUsuario = usuarioRepository.findById(id_usuario);
        if (localUsuario != null) {
            Usuario actualizar = new Usuario(
                    localUsuario.getId(),
                    usuario.getCedula(),
                    usuario.getNombres(),
                    usuario.getApellidos(),
                    usuario.getEmail(),
                    usuario.getClave(),
                    localUsuario.getFecha_creacion(),
                    localUsuario.getRol());
            return usuarioRepository.save(actualizar);
        }
        throw new Exception("Id no encontrado");

    }

    @Override
    public void eliminarUsuario(long userId) throws Exception {
        usuarioRepository.deleteById(userId);
    }

    @Override
    public Usuario ingresarSistema(Usuario usuario) throws Exception {
        Usuario login = usuarioRepository.findByCedula(usuario.getCedula());
        if (login != null && login.getClave().equals(usuario.getClave())) {
            System.out.println("Bienvenidos al sistemas");
            System.out.println("login..." + login.getCedula() + "..." + login.getClave());
            System.out.println("usaurio..." + usuario.getCedula() + "..." + usuario.getClave());
            return login;

        }
        throw new Exception("Crendenciales incorrectas");
    }

}
