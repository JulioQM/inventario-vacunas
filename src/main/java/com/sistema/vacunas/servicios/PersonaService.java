package com.sistema.vacunas.servicios;
import com.sistema.vacunas.DTO.PersonaDTO;
import com.sistema.vacunas.entidades.Persona;
import java.util.List;

public interface PersonaService {
    public Persona guardarPersona(long id_usuario,long id_vacuna,Persona persona) throws Exception;

    public List<PersonaDTO> listarPersona();

    public Persona obtenerPersona(String cedula);

    public void eliminarPersona(long persId) throws Exception;
}
