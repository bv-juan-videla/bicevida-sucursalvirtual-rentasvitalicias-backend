package cl.bicevida.rentasvitalicias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.bicevida.rentasvitalicias.dao.ObtieneNroFdeDAO;
import cl.bicevida.rentasvitalicias.dto.CredividaDTO;
import cl.bicevida.rentasvitalicias.dto.Fault;
import cl.bicevida.rentasvitalicias.dto.Message;
import cl.bicevida.rentasvitalicias.dto.ObtieneNroFdeDTO;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/rentasvitalicias")
@RestController
public class ObtieneNroFdeController {

	@Autowired 
	private ObtieneNroFdeDAO ObtieneNroFdeDAO;
	
	@RequestMapping(value = "/credivida/obtienenrofde/{rut}", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerNroFDE(@PathVariable(value = "rut") Integer rut) {
		//log.info("obtenerNroFDE");
		System.out.println("obtenerNroFDE");
		ObtieneNroFdeDTO NroFDE = new ObtieneNroFdeDTO();
		
		try {
			//Credivida = CredividaDAO.obtenerDatosCredivida(rut);
			System.out.println("ResponseEntity obtenerDatosCredivida");
			NroFDE = ObtieneNroFdeDAO.obtenerNroFDE(rut);
			
			if(NroFDE!=null){
				System.out.println("Query no es nulo");
			}
		} catch (Exception e) {
			//log.error("error en obtenerDatosCredivida", e);
			System.out.println("error en obtenerDatosCredivida");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Fault(e));
		}
		if(NroFDE==null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message("No se encontraron datos de NroFDE"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(NroFDE);
	}
}
