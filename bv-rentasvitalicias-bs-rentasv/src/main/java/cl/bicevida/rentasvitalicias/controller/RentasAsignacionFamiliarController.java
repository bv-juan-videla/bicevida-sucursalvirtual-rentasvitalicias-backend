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

import cl.bicevida.rentasvitalicias.dao.RentasAsignacionFamiliarDAO;
import cl.bicevida.rentasvitalicias.dto.RentasAsignacionFamiliarDTO;
import cl.bicevida.rentasvitalicias.dto.Fault;
import cl.bicevida.rentasvitalicias.dto.Message;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/rentasvitalicias")
@RestController
public class RentasAsignacionFamiliarController {
	
	@Autowired 
	private RentasAsignacionFamiliarDAO RentasAsignacionFamiliarDAO;

	@RequestMapping(value = "/rentasv/asignacionfamiliar/{poliza}", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerDatosRentasAsignacionFamiliar(@PathVariable(value = "poliza") String poliza) {
		//log.info("obtenerDatosAsignacionFamiliar");
		System.out.println("obtenerDatosRentasAsignacionFamiliar");
		
		List<RentasAsignacionFamiliarDTO> listRentasAsignacionFamiliar = null;
		HashMap<String,List<RentasAsignacionFamiliarDTO>> response = new HashMap<String,List<RentasAsignacionFamiliarDTO>>();		
		
		try {
			System.out.println("ResponseEntity obtenerDatosAsignacionFamiliar");
					
			listRentasAsignacionFamiliar = RentasAsignacionFamiliarDAO.obtenerDatosRentasAsignacionFamiliar(poliza);
			response.put("AsignacionFamiliar", listRentasAsignacionFamiliar);			
		} catch (Exception e) {
			//log.error("error en obtenerAsignacionFamiliar", e);
			System.out.println("error en obtenerAsignacionFamiliar");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Fault(e));
		}
		if(listRentasAsignacionFamiliar==null){			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message("No se encontraron datos de Asignacion Familiar"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
