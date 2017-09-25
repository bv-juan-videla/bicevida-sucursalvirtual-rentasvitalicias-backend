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

import cl.bicevida.rentasvitalicias.dao.CreditoDisponibleDAO;
import cl.bicevida.rentasvitalicias.dto.CreditoDisponibleDTO;
import cl.bicevida.rentasvitalicias.dto.Fault;
import cl.bicevida.rentasvitalicias.dto.Message;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/rentasvitalicias")
@RestController
public class CreditoDisponibleController {
	
	@Autowired 
	private CreditoDisponibleDAO CreditoDisponibleDAO;

	@RequestMapping(value = "/creditos/disponible/{rut}", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerDatosCreditoDisponible(@PathVariable(value = "rut") String rut) {
		//log.info("obtenerDatosCreditoDisponible");
		System.out.println("obtenerDatosCreditoDisponible");
		CreditoDisponibleDTO CreditoDisponible = new CreditoDisponibleDTO();
		
		try {
			//CreditoDisponible = CreditoDisponibleDAO.obtenerDatosCreditoDisponible(rut);
			System.out.println("ResponseEntity obtenerDatosCreditoDisponible");
			CreditoDisponible = CreditoDisponibleDAO.obtenerDatosCreditoDisponible(rut);
			
			if(CreditoDisponible!=null){
				System.out.println("Query no es nulo");
			}
		} catch (Exception e) {
			//log.error("error en obtenerDatosCreditoDisponible", e);
			System.out.println("error en obtenerDatosCreditoDisponible");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Fault(e));
		}
		if(CreditoDisponible==null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message("No se encontraron datos de CreditoDisponible"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(CreditoDisponible);
	}
	
}
