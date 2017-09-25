package cl.bicevida.rentasvitalicias.controller;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;

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

import cl.bicevida.rentasvitalicias.dao.RentasVDAO;
import cl.bicevida.rentasvitalicias.dto.RentasVDTO;
import cl.bicevida.rentasvitalicias.dto.Fault;
import cl.bicevida.rentasvitalicias.dto.Message;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/rentasvitalicias")
@RestController
public class RentasVController {
	
	@Autowired 
	private RentasVDAO RentasVDAO;

	@RequestMapping(value = "/rentasv/{rut}/{NUMERO_PERSONA_IN}/{TIPO_PERSONA_IN}", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerDatosRentasV(@PathVariable(value = "rut") String rut,
			@PathVariable(value = "NUMERO_PERSONA_IN") int NUMERO_PERSONA_IN,
			@PathVariable(value = "TIPO_PERSONA_IN") String TIPO_PERSONA_IN) {
		//log.info("obtenerDatosRentasV");
		System.out.println("obtenerDatosRentasV");
		RentasVDTO RentasV = new RentasVDTO();
		
		try {
			System.out.println("ResponseEntity obtenerDatosRentasV");
			RentasV = RentasVDAO.obtenerDatosRentasV(rut, NUMERO_PERSONA_IN, TIPO_PERSONA_IN);
						
			if(RentasV!=null){
				System.out.println("Query no es nulo");
			}
		} catch (Exception e) {
			//log.error("error en obtenerDatosRentasV", e);
			System.out.println("error en obtenerDatosRentasV");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Fault(e));
		}
		if(RentasV==null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message("No se encontraron datos de RentasV"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(RentasV);
	}
	

}
