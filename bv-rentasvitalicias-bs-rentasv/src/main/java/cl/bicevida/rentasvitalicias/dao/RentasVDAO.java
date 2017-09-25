package cl.bicevida.rentasvitalicias.dao;

import cl.bicevida.rentasvitalicias.dto.RentasVDTO;

public interface RentasVDAO {
	
	RentasVDTO obtenerDatosRentasV(String rut, int NUMERO_PERSONA_IN, String TIPO_PERSONA_IN);
	
	/*
	List<DireccionDTO> obtenerDireccionCliente(Integer rut);
	
	void actualizarDatosCliente(Integer rut, String dv, String email, String celular, 
			String numeroCasilla, String oficinaCasilla, Integer tipoEnvioCorrespondencia, String usuario);
	
	void actualizarDireccionCliente(Integer rut, Integer tipoInfoContacto, String telefono, 
			String calle, String numero, String conara, Integer codigoComuna, String usuario);
	
	Boolean debeActualizarDatos(Integer rut);
	*/
}