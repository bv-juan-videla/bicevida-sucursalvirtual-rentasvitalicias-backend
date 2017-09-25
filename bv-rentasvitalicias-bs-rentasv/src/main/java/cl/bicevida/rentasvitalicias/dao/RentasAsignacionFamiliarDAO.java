package cl.bicevida.rentasvitalicias.dao;

import java.util.List;

import cl.bicevida.rentasvitalicias.dto.RentasAsignacionFamiliarDTO;

public interface RentasAsignacionFamiliarDAO {
	
	List<RentasAsignacionFamiliarDTO> obtenerDatosRentasAsignacionFamiliar(String poliza);

}