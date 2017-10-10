package cl.bicevida.rentasvitalicias.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.bicevida.rentasvitalicias.dao.RentasInicioLiquidacionDAO;
import cl.bicevida.rentasvitalicias.dto.Fault;
import cl.bicevida.rentasvitalicias.dto.Message;
import cl.bicevida.rentasvitalicias.dto.RentasInicioLiquidacionDTO;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/rentasvitalicias")
@RestController
public class RentasInicioLiquidacionController {

	@Autowired 
	private RentasInicioLiquidacionDAO RentasInicioLiquidacionDAO;

	@RequestMapping(value = "/rentasv/inicioliquidacion/{rut}", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerDatosRentasInicioLiquidacion(@PathVariable(value = "rut") String rut) {
		//log.info("obtenerDatosCreditos");
		System.out.println("obtenerDatosRentasInicioLiquidacion");
		
		List<RentasInicioLiquidacionDTO> listRentasInicioLiquidacion = null;
		HashMap<String,List<RentasInicioLiquidacionDTO>> response = new HashMap<String,List<RentasInicioLiquidacionDTO>>();		
		
		try {
			System.out.println("ResponseEntity obtenerDatosCreditos");
			
			System.out.println("<<<< parametros >>>>");
			
			listRentasInicioLiquidacion = RentasInicioLiquidacionDAO.obtenerDatosRentasInicioLiquidacion(rut);
			response.put("InicioLiquidacion", listRentasInicioLiquidacion);			
		} catch (Exception e) {
			//log.error("error en obtenerDatosCreditos", e);
			System.out.println("error en obtenerDatosInicioLiquidacion");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Fault(e));
		}
		if(listRentasInicioLiquidacion==null){			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message("No se encontraron datos de Inicio Liquidación"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
