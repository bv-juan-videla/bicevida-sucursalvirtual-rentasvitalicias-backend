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

import cl.bicevida.rentasvitalicias.dao.CreditosVigentesDAO;
import cl.bicevida.rentasvitalicias.dto.CreditosVigentesDTO;
import cl.bicevida.rentasvitalicias.dto.Fault;
import cl.bicevida.rentasvitalicias.dto.Message;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/rentasvitalicias")
@RestController
public class CreditosVigentesController {
	
	@Autowired 
	private CreditosVigentesDAO CreditosVigentesDAO;

	@RequestMapping(value = "/creditos/vigentes/{rut}", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerDatosCreditosVigentes(@PathVariable(value = "rut") String rut) {
		//log.info("obtenerDatosCreditos");
		System.out.println("obtenerDatosCreditosVigentes");
		
		List<CreditosVigentesDTO> listCreditosVigentes = null;
		HashMap<String,List<CreditosVigentesDTO>> response = new HashMap<String,List<CreditosVigentesDTO>>();		
		
		try {
			System.out.println("ResponseEntity obtenerDatosCreditos");
			listCreditosVigentes = CreditosVigentesDAO.obtenerDatosCreditosVigentes(rut);
			response.put("creditosVigentes", listCreditosVigentes);			
		} catch (Exception e) {
			//log.error("error en obtenerDatosCreditos", e);
			System.out.println("error en obtenerDatosCreditos");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Fault(e));
		}
		if(listCreditosVigentes==null){			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message("No se encontraron datos de Creditos"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	

}
