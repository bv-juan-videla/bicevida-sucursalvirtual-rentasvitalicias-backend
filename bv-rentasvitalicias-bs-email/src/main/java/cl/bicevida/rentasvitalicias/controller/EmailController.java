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

import cl.bicevida.rentasvitalicias.dao.EmailDAO;
import cl.bicevida.rentasvitalicias.dto.EmailDTO;
import cl.bicevida.rentasvitalicias.dto.Fault;
import cl.bicevida.rentasvitalicias.dto.Message;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/rentasvitalicias")
@RestController
public class EmailController {
	
	@Autowired 
	private EmailDAO EmailDAO;

	@RequestMapping(value = "/email/{rut}", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerDatosEmail(@PathVariable(value = "rut") String rut) {
		//log.info("obtenerDatosEmail");
		System.out.println("obtenerDatosEmail");
		EmailDTO Email = new EmailDTO();
		
		try {
			//Email = EmailDAO.obtenerDatosEmail(rut);
			System.out.println("ResponseEntity obtenerDatosEmail");
			Email = EmailDAO.obtenerDatosEmail(rut);
			
			System.out.print("Glosa:");
			System.out.println(Email.getEnvio_mail() );
			System.out.print("Cuenta:");
			System.out.println(Email.getMail_principal() );
			
			if(Email!=null){
				System.out.println("Query no es nulo");
			}
		} catch (Exception e) {
			//log.error("error en obtenerDatosEmail", e);
			System.out.println("error en obtenerDatosEmail");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Fault(e));
		}
		if(Email==null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message("No se encontraron datos de Email"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(Email);
	}
	

}
