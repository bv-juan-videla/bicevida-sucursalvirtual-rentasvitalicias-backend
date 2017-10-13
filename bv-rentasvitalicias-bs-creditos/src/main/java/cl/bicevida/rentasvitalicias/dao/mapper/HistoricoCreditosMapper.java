package cl.bicevida.rentasvitalicias.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.bicevida.rentasvitalicias.dto.HistoricoCreditosDTO;

public class HistoricoCreditosMapper implements RowMapper<HistoricoCreditosDTO> {
	
	@Override
	public HistoricoCreditosDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("<<<< CreditosVigentesDTO mapRow >>>>>");
		HistoricoCreditosDTO response = new HistoricoCreditosDTO();
		response.setIdcredito(rs.getInt("idcredito"));
		response.setRut(rs.getString("rut"));
		response.setPagare(rs.getInt("pagare"));
		response.setFecha_pagare(rs.getDate("fecha_pagare"));
		response.setFecha_otorgamiento(rs.getDate("fecha_otorgamiento"));
		response.setMonto_solicitado(rs.getInt("monto_solicitado"));
		response.setCuotas_pactadas(rs.getInt("cuotas_pactadas"));
		response.setMonto_cuota(rs.getInt("monto_cuota"));
		response.setTotal_credito(rs.getInt("total_credito"));
		response.setEstado(rs.getString("estado"));
		response.setEstado1(rs.getString("estado1"));
		response.setFecha_ultcuota_pagada(rs.getDate("fecha_ultcuota_pagada"));
		return response;
	}	
}
