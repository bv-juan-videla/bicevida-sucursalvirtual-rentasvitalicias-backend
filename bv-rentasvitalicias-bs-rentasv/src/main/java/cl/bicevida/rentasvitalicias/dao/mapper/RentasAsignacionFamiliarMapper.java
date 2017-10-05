package cl.bicevida.rentasvitalicias.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import cl.bicevida.rentasvitalicias.dto.RentasAsignacionFamiliarDTO;

public class RentasAsignacionFamiliarMapper implements RowMapper<RentasAsignacionFamiliarDTO> {

	@Override
	public RentasAsignacionFamiliarDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("<<<< RentasAsignacionFamiliarDTO mapRow >>>>>");
		RentasAsignacionFamiliarDTO response = new RentasAsignacionFamiliarDTO();
		response.setPoliza(rs.getString("poliza"));
		response.setMes_proceso(rs.getString("mes_proceso"));
		response.setUltimo_pago(rs.getDate("ultimo_pago"));
		response.setInicio_pago_asignacion(rs.getDate("inicio_pago_asignacion"));
		response.setRut(rs.getString("rut"));
		response.setNombre(rs.getString("nombre"));
		response.setParentesco(rs.getString("parentesco"));
		response.setNumero_carga(rs.getString("numero_carga"));
		response.setMonto_pagado(rs.getString("monto_pagado"));
		response.setMonto_total_pagado(rs.getString("monto_total_pagado"));
		
		return response;
	}

}
