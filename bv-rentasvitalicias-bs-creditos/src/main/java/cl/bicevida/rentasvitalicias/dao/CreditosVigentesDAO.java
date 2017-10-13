package cl.bicevida.rentasvitalicias.dao;

import java.util.List;

import cl.bicevida.rentasvitalicias.dto.CreditosVigentesDTO;

public interface CreditosVigentesDAO {
	
	List<CreditosVigentesDTO> obtenerDatosCreditosVigentes(String rut);
	
}