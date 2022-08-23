package com.sistema.vacunas.controladores;

import com.sistema.vacunas.DTO.RolDTO;
import com.sistema.vacunas.entidades.Rol;
import com.sistema.vacunas.servicios.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping("/")
    public Rol guardarRol(@RequestBody Rol rol)throws Exception{
        return rolService.guardarRol(rol);
    }
    @GetMapping("/")
    public List<RolDTO> obtenerTodos(){
        return rolService.listarRol();
    }


    @GetMapping("/{nombre}")
    public Rol obtenerRol(@PathVariable("nombre") String nombre){
        return rolService.obtenerRol(nombre);
    }

    @DeleteMapping("/{id}")
    public void eliminarRol(@PathVariable("id")long id) throws Exception{
        rolService.eliminarRol(id);
    }
    @PutMapping("/{id}")
    public Rol actualizarRol(@PathVariable("id") long id,@RequestBody Rol rol)throws Exception{
        return  rolService.actualizarRol(id,rol);
    }
}
