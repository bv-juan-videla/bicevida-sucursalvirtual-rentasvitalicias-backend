package cl.bicevida.rentasvitalicias.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.jsf.FacesContextUtils;

import cl.bicevida.rentasvitalicias.dao.HistoricoCreditosDAO;
import cl.bicevida.rentasvitalicias.dto.HistoricoCreditosDTO;
import cl.bicevida.rentasvitalicias.dto.Fault;
import cl.bicevida.rentasvitalicias.dto.Message;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/rentasvitalicias")
@RestController
public class HistoricoCreditosController {

	@Autowired 
	private HistoricoCreditosDAO HistoricoCreditosDAO;
	
	@RequestMapping(value = "/creditos/historicos/{rut}", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerDatosHistoricoCreditos(@PathVariable(value = "rut") String rut) {
		//log.info("obtenerDatosCreditos");
		System.out.println("obtenerDatosHistoricoCreditos");
		
		List<HistoricoCreditosDTO> listHistoricoCreditos = null;
		HashMap<String,List<HistoricoCreditosDTO>> response = new HashMap<String,List<HistoricoCreditosDTO>>();		
		
		try {
			System.out.println("ResponseEntity obtenerDatosCreditos");
			listHistoricoCreditos = HistoricoCreditosDAO.obtenerDatosHistoricoCreditos(rut);
			response.put("historicoCreditos", listHistoricoCreditos);			
		} catch (Exception e) {
			//log.error("error en obtenerDatosCreditos", e);
			System.out.println("error en obtenerDatosCreditos");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Fault(e));
		}
		if(listHistoricoCreditos==null){			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message("No se encontraron datos de Historico Creditos"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
