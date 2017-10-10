package cl.bicevida.rentasvitalicias.dao;

import java.util.List;

import cl.bicevida.rentasvitalicias.dto.RentasInicioLiquidacionDTO;

public interface RentasInicioLiquidacionDAO {

	List<RentasInicioLiquidacionDTO> obtenerDatosRentasInicioLiquidacion(String rut);

}
