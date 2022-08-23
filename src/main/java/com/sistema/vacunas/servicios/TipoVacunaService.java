package com.sistema.vacunas.servicios;
import com.sistema.vacunas.DTO.TipoVacunaDTO;
import com.sistema.vacunas.entidades.TipoVacunas;
import java.util.List;

public interface TipoVacunaService {
    public TipoVacunas guardarTipoVacuna(TipoVacunas tipoVacunas) throws Exception;
    public List<TipoVacunaDTO> listarTipoVacunas();
}
