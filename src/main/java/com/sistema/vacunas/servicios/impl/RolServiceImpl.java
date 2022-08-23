package com.sistema.vacunas.servicios.impl;
import com.sistema.vacunas.DTO.RolDTO;
import com.sistema.vacunas.entidades.Rol;
import com.sistema.vacunas.repositorios.RolRepository;
import com.sistema.vacunas.servicios.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolRepository rolRepository;

    @Override
    public Rol guardarRol(Rol rol) throws Exception {
        Rol rolLocal=rolRepository.findByNombre(rol.getNombre());
        if(rolLocal!=null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }else {
            rolLocal=rolRepository.save(rol);
        }
        return rolLocal;
    }

    @Override
    public List<RolDTO> listarRol() {
        List<RolDTO> listaRolDTO=new ArrayList<>();
        /*Transformo la lista original en DTO*/
        for (Rol rol:rolRepository.findAll()) {
            RolDTO nuevoDTO=new RolDTO(((int) rol.getId()),rol.getNombre(),rol.getDescripcion());
            listaRolDTO.add(nuevoDTO);
        }
        return listaRolDTO;
    }

    @Override
    public Rol obtenerRol(String nombre) {
        return rolRepository.findByNombre(nombre);
    }

    @Override
    public void eliminarRol(long idRol) throws Exception {
        Rol rolLocal=rolRepository.findById(idRol);
        if(rolLocal!=null){
            rolRepository.deleteById(idRol);
        }
        System.out.println("El rol no  existe");
        throw new Exception("El rol no esta presente");

    }

    @Override
    public Rol actualizarRol(long rolId,Rol rol) throws Exception {
         Rol rolLocal=rolRepository.findById(rolId);
        if(rolLocal!=null){
            Rol actualizar=new Rol(rolLocal.getId(),rol.getNombre(),rol.getDescripcion());
            actualizar.setFecha_creacion(rolLocal.getFecha_creacion());
            return rolRepository.save(actualizar);
        }
       throw new Exception("Id no existe");

    }
}
