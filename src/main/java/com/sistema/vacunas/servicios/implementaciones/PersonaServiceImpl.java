package com.sistema.vacunas.servicios.implementaciones;
import com.sistema.vacunas.modelo.dto.PersonaDTO;
import com.sistema.vacunas.modelo.entidades.Persona;
import com.sistema.vacunas.modelo.entidades.TipoVacunas;
import com.sistema.vacunas.modelo.entidades.Usuario;
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
    public List<PersonaDTO> listarPersona() {
        List<PersonaDTO> listaPersonaDTO=new ArrayList<>();
        for (Persona persona:personaRepository.findAll()) {
            PersonaDTO nuevoDTO=new PersonaDTO((int)persona.getId(),persona.getFecha_nacimiento(),
                    persona.getDireccion(),
                    persona.getTelefono(),
                    persona.getEstado_vacuna(),
                    persona.getFecha_vacunacion(),
                    persona.getNumero_dosis(),
                    (int)persona.getUsuario().getId(),
                    (int)persona.getTipoVacunas().getId());
            listaPersonaDTO.add(nuevoDTO);
        }
        return listaPersonaDTO;
    }

    @Override
    public Persona guardarPersona(PersonaDTO personaDto) throws Exception {
        Usuario usuarioId=usuarioRepository.findById(personaDto.getUsuario());
        TipoVacunas tipoVacunasId=tipoVacunaRepository.findById(personaDto.getTipoVacunas());
        if(usuarioId==null||tipoVacunasId==null){
            throw new Exception("El idUsuario o idVacunas no esta presente");
        }else{
            Persona persona=new Persona(
                    personaDto.getFecha_nacimiento(),
                    personaDto.getDireccion(),
                    personaDto.getTelefono(),
                    personaDto.getEstado_vacuna(),
                    personaDto.getFecha_vacunacion(),
                    personaDto.getNumero_dosis(),
                    usuarioId,
                    tipoVacunasId
            );
            return personaRepository.save(persona);
        }
    }

    @Override
    public Persona actualizarPersona(long idPersona,Persona persona) throws Exception {
        Persona localPersona=personaRepository.findById(idPersona);
        if(localPersona!=null){
            Persona actualizar=new Persona(
                    localPersona.getId(),
                    persona.getFecha_nacimiento(),
                    persona.getDireccion(),
                    persona.getTelefono(),
                    persona.getEstado_vacuna(),
                    persona.getFecha_vacunacion(),
                    persona.getNumero_dosis(),
                    localPersona.getFecha_creacion(),
                    localPersona.getUsuario(),
                    localPersona.getTipoVacunas()
            );
            return personaRepository.save(actualizar);
        }

        throw new Exception("Id de persona no encontrado");
    }

    @Override
    public String eliminarPersona(long persId) throws Exception {
        Persona buscar=personaRepository.findById(persId);
        if(buscar!=null){
            personaRepository.deleteById(persId);
            return "Persona con id "+persId+" eliminado correctamente";
        }
        throw new Exception("Id de la persona no existe");

    }
}
