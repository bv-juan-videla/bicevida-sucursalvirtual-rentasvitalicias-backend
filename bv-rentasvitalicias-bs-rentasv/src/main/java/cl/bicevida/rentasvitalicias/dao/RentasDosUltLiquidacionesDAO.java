package cl.bicevida.rentasvitalicias.dao;

import java.util.List;

import cl.bicevida.rentasvitalicias.dto.RentasDosUltLiquidacionesDTO;

public interface RentasDosUltLiquidacionesDAO {
	
	List<RentasDosUltLiquidacionesDTO> obtenerDatosRentasDosUltLiquidaciones(String rut);
	
}