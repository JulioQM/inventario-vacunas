package com.sistema.vacunas.servicios;
import com.sistema.vacunas.modelo.dto.TipoVacunaDTO;
import com.sistema.vacunas.modelo.entidades.TipoVacunas;
import java.util.List;

public interface TipoVacunaService {
    public List<TipoVacunaDTO> listarTipoVacunas();
    public TipoVacunas guardarTipoVacunas(TipoVacunas tipoVacunas) throws Exception;

}
