package com.sistema.vacunas.servicios.impl;
import com.sistema.vacunas.DTO.PersonaDTO;
import com.sistema.vacunas.entidades.Persona;
import com.sistema.vacunas.entidades.TipoVacunas;
import com.sistema.vacunas.entidades.Usuario;
import com.sistema.vacunas.repositorios.PersonaRepository;
import com.sistema.vacunas.repositorios.TipoVacunaRepository;
import com.sistema.vacunas.repositorios.UsuarioRepository;
import com.sistema.vacunas.servicios.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
/*Inyección de dependencia*/
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoVacunaRepository tipoVacunaRepository;

    @Override
    public Persona guardarPersona(long id_usuario,long id_vacuna,Persona persona) throws Exception {
        TipoVacunas vacuna=tipoVacunaRepository.findById(id_usuario);
        Usuario usuario=usuarioRepository.findById(id_usuario);
        if(vacuna==null || usuario==null){
            throw new Exception("El existe rolo y usuario");
        }
        persona.setTipoVacunas(vacuna);
        persona.setUsuario(usuario);
        return personaRepository.save(persona);
    }


    @Override
    public List<PersonaDTO> listarPersona() {
        List<PersonaDTO> listaPersonaDTO=new ArrayList<>();
        for (Persona persona:personaRepository.findAll()) {
            PersonaDTO nuevoDTO=new PersonaDTO((int)persona.getId(),persona.getFecha_nacimiento(),
                    persona.getDireccion(),persona.getTelefono()
            ,persona.getEstado_vacuna(),persona.getFecha_vacunacion(),persona.getNumero_dosis(),persona.getUsuario().getCedula(),persona.getTipoVacunas().getNombre());
          listaPersonaDTO.add(nuevoDTO);
        }
        return listaPersonaDTO;
    }

    @Override
    public Persona obtenerPersona(String cedula) {
        return null;
    }

    @Override
    public void eliminarPersona(long persId) throws Exception {

    }
}
