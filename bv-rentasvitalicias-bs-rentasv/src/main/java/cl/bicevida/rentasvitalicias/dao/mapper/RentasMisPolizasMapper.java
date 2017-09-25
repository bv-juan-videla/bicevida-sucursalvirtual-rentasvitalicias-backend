package cl.bicevida.rentasvitalicias.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import cl.bicevida.rentasvitalicias.dto.RentasMisPolizasDTO;

public class RentasMisPolizasMapper implements RowMapper<RentasMisPolizasDTO> {

	@Override
	public RentasMisPolizasDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("<<<< RentasMisPolizasDTO mapRow >>>>>");
		RentasMisPolizasDTO response = new RentasMisPolizasDTO();
		response.setPoliza(rs.getString("poliza"));
		response.setRut(rs.getString("rut"));
		response.setNombre(rs.getString("nombre"));
		response.setTipo_persona(rs.getString("tipo_persona"));
		response.setNumero_persona(rs.getInt("numero_persona"));
		response.setMandatoria(rs.getString("mandatoria"));
		response.setDesc_tipo_persona(rs.getString("desc_tipo_persona"));
		return response;
	}

}
