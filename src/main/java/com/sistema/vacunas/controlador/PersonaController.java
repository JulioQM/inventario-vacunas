package com.sistema.vacunas.controlador;
import com.sistema.vacunas.modelo.dto.PersonaDTO;
import com.sistema.vacunas.modelo.entidades.Persona;
import com.sistema.vacunas.servicios.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public List<PersonaDTO> listaPersonas(){
        return  personaService.listarPersona();
    }
    @PostMapping("/")
    public Persona guardarPersona(@RequestBody PersonaDTO personaDto) throws Exception{
        return personaService.guardarPersona(personaDto);
    }
    @PutMapping("/{id}")
    public Persona actualizarPersona(@PathVariable("id") long idPersona, @RequestBody Persona persona) throws Exception {
        return personaService.actualizarPersona(idPersona,persona);
    }
    @DeleteMapping("/{id}")
    public String eliminarPersona(@PathVariable("id") long idPersona) throws Exception{
      return  personaService.eliminarPersona(idPersona);
    }

}
