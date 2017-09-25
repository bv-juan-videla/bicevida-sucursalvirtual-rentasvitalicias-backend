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

import cl.bicevida.rentasvitalicias.dao.CredividaDAO;
import cl.bicevida.rentasvitalicias.dto.CredividaDTO;
import cl.bicevida.rentasvitalicias.dto.Fault;
import cl.bicevida.rentasvitalicias.dto.Message;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/rentasvitalicias")
@RestController
public class CredividaController {
	
	@Autowired 
	private CredividaDAO CredividaDAO;

	@RequestMapping(value = "/credivida/{rut}", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerDatosCredivida(@PathVariable(value = "rut") Integer rut) {
		//log.info("obtenerDatosCredivida");
		System.out.println("obtenerDatosCredivida");
		CredividaDTO Credivida = new CredividaDTO();
		
		try {
			//Credivida = CredividaDAO.obtenerDatosCredivida(rut);
			System.out.println("ResponseEntity obtenerDatosCredivida");
			Credivida = CredividaDAO.obtenerDatosCredivida(rut);
			
			System.out.print("Glosa:");
			System.out.println(Credivida.getGlosa() );
			System.out.print("Cuenta:");
			System.out.println(Credivida.getCuenta() );
			
			if(Credivida!=null){
				System.out.println("Query no es nulo");
			}
		} catch (Exception e) {
			//log.error("error en obtenerDatosCredivida", e);
			System.out.println("error en obtenerDatosCredivida");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Fault(e));
		}
		if(Credivida==null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message("No se encontraron datos de Credivida"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(Credivida);
	}

}
