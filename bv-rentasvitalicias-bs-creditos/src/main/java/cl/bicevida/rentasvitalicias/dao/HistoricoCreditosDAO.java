package cl.bicevida.rentasvitalicias.dao;

import java.util.List;

import cl.bicevida.rentasvitalicias.dto.HistoricoCreditosDTO;

public interface HistoricoCreditosDAO{

	List<HistoricoCreditosDTO> obtenerDatosHistoricoCreditos(String rut);

}
