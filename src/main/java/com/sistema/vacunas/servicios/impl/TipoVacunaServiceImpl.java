package com.sistema.vacunas.servicios.impl;
import com.sistema.vacunas.DTO.TipoVacunaDTO;
import com.sistema.vacunas.entidades.TipoVacunas;
import com.sistema.vacunas.repositorios.TipoVacunaRepository;
import com.sistema.vacunas.servicios.TipoVacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TipoVacunaServiceImpl implements TipoVacunaService {
    @Autowired
    private TipoVacunaRepository tipoVacunaRepository;

    @Override
    public TipoVacunas guardarTipoVacuna(TipoVacunas tipoVacunas) throws Exception {
        TipoVacunas tipoVacunasLocal=tipoVacunaRepository.findByNombre(tipoVacunas.getNombre());
        if(tipoVacunasLocal!=null){
            System.out.println("La vacuna ya existe");
            throw new Exception("La vacuna ya esta presente");
        }else{
            tipoVacunasLocal=tipoVacunaRepository.save(tipoVacunas);
        }
        return tipoVacunasLocal;
    }

    @Override
    public List<TipoVacunaDTO> listarTipoVacunas() {
        List<TipoVacunaDTO> listaVacuna=new ArrayList<>();
        for (TipoVacunas vacuna:tipoVacunaRepository.findAll()) {
            TipoVacunaDTO nuevoDTO=new TipoVacunaDTO(((int) vacuna.getId()),vacuna.getNombre());
            listaVacuna.add(nuevoDTO);
        }
        return listaVacuna;
    }

}
