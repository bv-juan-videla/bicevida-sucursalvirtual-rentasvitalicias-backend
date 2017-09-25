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

import cl.bicevida.rentasvitalicias.dao.RentasUltLiquidacionesDAO;
import cl.bicevida.rentasvitalicias.dto.RentasUltLiquidacionesDTO;
import cl.bicevida.rentasvitalicias.dto.Fault;
import cl.bicevida.rentasvitalicias.dto.Message;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/rentasvitalicias")
@RestController
public class RentasUltLiquidacionesController {
	
	@Autowired 
	private RentasUltLiquidacionesDAO RentasUltLiquidacionesDAO;

	@RequestMapping(value = "/rentasv/ultimasliquidaciones/{desde}/{hasta}/{rut}", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerDatosRentasUltLiquidaciones(@PathVariable(value = "rut") String rut,
			@PathVariable(value = "desde") String desde,
			@PathVariable(value = "hasta") String hasta) {
		//log.info("obtenerDatosCreditos");
		System.out.println("obtenerDatosRentasUltLiquidaciones");
		
		List<RentasUltLiquidacionesDTO> listRentasUltLiquidaciones = null;
		HashMap<String,List<RentasUltLiquidacionesDTO>> response = new HashMap<String,List<RentasUltLiquidacionesDTO>>();		
		
		try {
			System.out.println("ResponseEntity obtenerDatosCreditos");
			
			System.out.println("<<<< parametros >>>>");
			System.out.print("desde");
			System.out.println(desde);
			System.out.println("hasta");
			System.out.println(hasta);
			desde = desde.replaceAll("-", "/");
			hasta = hasta.replaceAll("-", "/");
			System.out.println("<<<< parametros modificados >>>>");
			System.out.print("desde");
			System.out.println(desde);
			System.out.println("hasta");
			System.out.println(hasta);
			
			listRentasUltLiquidaciones = RentasUltLiquidacionesDAO.obtenerDatosRentasUltLiquidaciones(rut,desde,hasta);
			response.put("UltimasLiquidaciones", listRentasUltLiquidaciones);			
		} catch (Exception e) {
			//log.error("error en obtenerDatosCreditos", e);
			System.out.println("error en obtenerDatosCreditos");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Fault(e));
		}
		if(listRentasUltLiquidaciones==null){			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message("No se encontraron datos de Creditos"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
