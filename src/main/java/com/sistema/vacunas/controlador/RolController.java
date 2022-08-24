package com.sistema.vacunas.controlador;
import com.sistema.vacunas.modelo.dto.RolDTO;
import com.sistema.vacunas.modelo.entidades.Rol;
import com.sistema.vacunas.servicios.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/")
    public List<RolDTO> listarRol(){
        return rolService.listarRol();
    }
    @PostMapping("/")
    public Rol guardarRol(@RequestBody Rol rol)throws Exception{
        return rolService.guardarRol(rol);
    }
    @PutMapping("/{id}")
    public Rol actualizarRol(@PathVariable("id") long id,@RequestBody Rol rol)throws Exception{
        return  rolService.actualizarRol(id,rol);
    }
    @DeleteMapping("/{id}")
    public void eliminarRol(@PathVariable("id")long id) throws Exception{
        rolService.eliminarRol(id);
    }
}
