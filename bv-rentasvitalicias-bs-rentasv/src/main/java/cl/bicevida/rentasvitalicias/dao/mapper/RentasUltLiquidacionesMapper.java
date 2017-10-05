package cl.bicevida.rentasvitalicias.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import cl.bicevida.rentasvitalicias.dto.RentasUltLiquidacionesDTO;

public class RentasUltLiquidacionesMapper implements RowMapper<RentasUltLiquidacionesDTO> {

	@Override
	public RentasUltLiquidacionesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("<<<< RentasUltLiquidacionesDTO mapRow >>>>>");
		RentasUltLiquidacionesDTO response = new RentasUltLiquidacionesDTO();
		response.setRut(rs.getString("rut"));
		response.setNumero_liquidacion(rs.getInt("numero_liquidacion"));
		response.setMes_proceso(rs.getString("mes_proceso"));
		response.setPension_liquida(rs.getInt("pension_liquida"));
		response.setNumero_pensiones_pagadas(rs.getInt("numero_pensiones_pagadas"));
		
		return response;
	}

}
