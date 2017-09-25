package cl.bicevida.rentasvitalicias.controller;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.jdbc.UncategorizedSQLException;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.jsf.FacesContextUtils;

import cl.bicevida.rentasvitalicias.dao.RentasDosUltLiquidacionesDAO;
import cl.bicevida.rentasvitalicias.dto.RentasDosUltLiquidacionesDTO;
import cl.bicevida.rentasvitalicias.dto.Fault;
import cl.bicevida.rentasvitalicias.dto.Message;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/rentasvitalicias")
@RestController
public class RentasDosUltLiquidacionesController {
	
	@Autowired 
	private RentasDosUltLiquidacionesDAO RentasDosUltLiquidacionesDAO;

	@RequestMapping(value = "/rentasv/dosultimasliquidaciones/{rut}", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerDatosRentasDosUltLiquidaciones(@PathVariable(value = "rut") String rut) {
		//log.info("obtenerDatosCreditos");
		System.out.println("obtenerDatosRentasDosUltLiquidaciones");
		
		List<RentasDosUltLiquidacionesDTO> listRentasDosUltLiquidaciones = null;
		HashMap<String,List<RentasDosUltLiquidacionesDTO>> response = new HashMap<String,List<RentasDosUltLiquidacionesDTO>>();		
		
		try {
			System.out.println("ResponseEntity obtenerDatos Dos Ultimas liquidaciones");
			
			System.out.println("<<<< parametros >>>>");
			
			listRentasDosUltLiquidaciones = RentasDosUltLiquidacionesDAO.obtenerDatosRentasDosUltLiquidaciones(rut);
			response.put("DosUltimasLiquidaciones", listRentasDosUltLiquidaciones);			
		} catch (Exception e) {
			//log.error("error en obtenerDatosCreditos", e);
			System.out.println("error en obtenerDatos Dos Ultimas Liquidaciones");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Fault(e));
		}
		if(listRentasDosUltLiquidaciones==null){			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message("No se encontraron datos de Dos Ultimas Liquidaciones"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
