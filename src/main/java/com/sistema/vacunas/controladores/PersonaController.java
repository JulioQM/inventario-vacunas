package com.sistema.vacunas.controladores;

import com.sistema.vacunas.DTO.PersonaDTO;
import com.sistema.vacunas.entidades.Persona;
import com.sistema.vacunas.servicios.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    @PostMapping("/{id_usuario}/{id_vacuna}")
       public Persona crearRegistro(@PathVariable("id_usuario") long id_usuario,@PathVariable("id_vacuna") long id_vacuna,@RequestBody Persona persona) throws Exception{
        return personaService.guardarPersona(id_usuario,id_vacuna,persona);

    }

}
