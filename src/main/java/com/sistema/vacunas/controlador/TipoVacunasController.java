package com.sistema.vacunas.controlador;
import com.sistema.vacunas.modelo.dto.TipoVacunaDTO;
import com.sistema.vacunas.modelo.entidades.TipoVacunas;
import com.sistema.vacunas.servicios.TipoVacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vacunas")
public class TipoVacunasController {

    @Autowired
    private TipoVacunaService tipoVacunasService;

    @GetMapping("/")
    public List<TipoVacunaDTO> listarTipoVacunas(){
        return tipoVacunasService.listarTipoVacunas();
    }
    @PostMapping("/")
    public TipoVacunas guardarTipoVacunas(@RequestBody TipoVacunas tipoVacunas)throws Exception{
        return tipoVacunasService.guardarTipoVacunas(tipoVacunas);
    }

}
