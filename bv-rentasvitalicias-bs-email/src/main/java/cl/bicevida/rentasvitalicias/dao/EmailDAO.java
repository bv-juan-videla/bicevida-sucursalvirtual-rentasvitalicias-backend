package cl.bicevida.rentasvitalicias.dao;

//import java.util.List;

import cl.bicevida.rentasvitalicias.dto.EmailDTO;

public interface EmailDAO {
	
	EmailDTO obtenerDatosEmail(String rut);
	
	/*
	List<DireccionDTO> obtenerDireccionCliente(Integer rut);
	
	void actualizarDatosCliente(Integer rut, String dv, String email, String celular, 
			String numeroCasilla, String oficinaCasilla, Integer tipoEnvioCorrespondencia, String usuario);
	
	void actualizarDireccionCliente(Integer rut, Integer tipoInfoContacto, String telefono, 
			String calle, String numero, String conara, Integer codigoComuna, String usuario);
	
	Boolean debeActualizarDatos(Integer rut);
	*/
}