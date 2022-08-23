package com.sistema.vacunas.controladores;

import com.sistema.vacunas.DTO.UsuarioDTO;
import com.sistema.vacunas.entidades.Usuario;
import com.sistema.vacunas.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public List<UsuarioDTO> listarUsuario() {
        return usuarioService.listarUsuario();
    }

    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody UsuarioDTO usuarioDto) throws Exception {
       return usuarioService.guardarUsuario(usuarioDto);
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario) throws Exception {
        return usuarioService.ingresarSistema(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable("id") long id, @RequestBody Usuario usuario) throws Exception {
        return usuarioService.actualizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable("id") long id) throws Exception {
        usuarioService.eliminarUsuario(id);
    }

}

// aqui va el consumo de la api
// me quede en el minuto 20, creacion de api