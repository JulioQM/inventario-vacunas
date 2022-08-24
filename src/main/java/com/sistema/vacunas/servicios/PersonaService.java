package com.sistema.vacunas.servicios;
import com.sistema.vacunas.modelo.dto.PersonaDTO;
import com.sistema.vacunas.modelo.entidades.Persona;
import java.util.List;

public interface PersonaService {
    public List<PersonaDTO> listarPersona();
    public Persona guardarPersona(PersonaDTO persona) throws Exception;
    public Persona actualizarPersona(long idPersona,Persona persona) throws Exception;
    public String eliminarPersona(long persId) throws Exception;
}
