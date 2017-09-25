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

import cl.bicevida.rentasvitalicias.dao.RentasMisPolizasDAO;
import cl.bicevida.rentasvitalicias.dto.RentasMisPolizasDTO;
import cl.bicevida.rentasvitalicias.dto.Fault;
import cl.bicevida.rentasvitalicias.dto.Message;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/rentasvitalicias")
@RestController
public class RentasMisPolizasController {
	
	@Autowired 
	private RentasMisPolizasDAO RentasMisPolizasDAO;

	@RequestMapping(value = "/rentasv/mispolizas/{rut}", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerDatosRentasMisPolizas(@PathVariable(value = "rut") String rut) {
		//log.info("obtenerDatosCreditos");
		System.out.println("obtenerDatosRentasMisPolizas");
		
		List<RentasMisPolizasDTO> listRentasMisPolizas = null;
		HashMap<String,List<RentasMisPolizasDTO>> response = new HashMap<String,List<RentasMisPolizasDTO>>();		
		
		try {
			System.out.println("ResponseEntity obtenerDatosCreditos");
					
			listRentasMisPolizas = RentasMisPolizasDAO.obtenerDatosRentasMisPolizas(rut);
			response.put("MisPolizas", listRentasMisPolizas);			
		} catch (Exception e) {
			//log.error("error en obtenerMisPolizas", e);
			System.out.println("error en obtenerMisPolizas");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Fault(e));
		}
		if(listRentasMisPolizas==null){			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message("No se encontraron datos de Mis Polizas"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
