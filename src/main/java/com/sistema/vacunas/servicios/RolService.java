package com.sistema.vacunas.servicios;
import com.sistema.vacunas.DTO.RolDTO;
import com.sistema.vacunas.entidades.Rol;
import java.util.List;

public interface RolService {
    public Rol guardarRol(Rol rol) throws  Exception;
    public List<RolDTO> listarRol();
    public Rol obtenerRol(String nombre);
    public void eliminarRol(long rolId) throws Exception;
    public Rol actualizarRol(long rolId,Rol rol) throws Exception;
}
