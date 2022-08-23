package com.sistema.vacunas.controladores;

import com.sistema.vacunas.DTO.TipoVacunaDTO;
import com.sistema.vacunas.entidades.TipoVacunas;
import com.sistema.vacunas.servicios.TipoVacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacuna")
public class TipoVacunasController {

    @Autowired
    private TipoVacunaService tipoVacunaService;

    @PostMapping("/")
    public TipoVacunas guardarTipoVacunas(@RequestBody TipoVacunas tipoVacunas)throws Exception{
        return tipoVacunaService.guardarTipoVacuna(tipoVacunas);
    }
    @GetMapping("/")
    public List<TipoVacunaDTO> listarTipoVacunas(){
        return tipoVacunaService.listarTipoVacunas();
    }
}
