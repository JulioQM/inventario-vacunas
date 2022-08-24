package com.sistema.vacunas.servicios;
import com.sistema.vacunas.modelo.dto.RolDTO;
import com.sistema.vacunas.modelo.entidades.Rol;
import java.util.List;

public interface RolService {
    public List<RolDTO> listarRol();
    public Rol guardarRol(Rol rol) throws  Exception;
    public Rol actualizarRol(long rolId,Rol rol) throws Exception;
    public void eliminarRol(long rolId) throws Exception;

}
