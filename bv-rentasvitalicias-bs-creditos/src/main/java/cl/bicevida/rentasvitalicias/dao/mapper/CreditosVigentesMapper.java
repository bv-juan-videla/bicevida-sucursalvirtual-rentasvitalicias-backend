package cl.bicevida.rentasvitalicias.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import cl.bicevida.rentasvitalicias.dto.CreditosVigentesDTO;

public class CreditosVigentesMapper implements RowMapper<CreditosVigentesDTO> {

	@Override
	public CreditosVigentesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("<<<< CreditosVigentesDTO mapRow >>>>>");
		CreditosVigentesDTO response = new CreditosVigentesDTO();
		response.setIdcredito(rs.getInt("idcredito"));
		response.setRut(rs.getString("rut"));
		response.setUsuario(rs.getString("usuario"));
		response.setSucursal(rs.getNString("sucursal"));
		response.setPagare(rs.getInt("pagare"));
		response.setFecha_pagare(rs.getDate("fecha_pagare"));
		response.setFecha_otorgamiento(rs.getDate("fecha_otorgamiento"));
		response.setMonto_solicitado(rs.getInt("monto_solicitado"));
		response.setPlazo(rs.getInt("plazo"));
		response.setTasa(rs.getFloat("tasa"));
		response.setMonto_cuota(rs.getInt("monto_cuota"));
		response.setProyeccion(rs.getInt("proyeccion"));
		response.setGastos_notariales(rs.getInt("gastos_notariales"));
		response.setImpuestos(rs.getInt("impuestos"));
		response.setTotal_credito(rs.getInt("total_credito"));
		response.setEstado_i(rs.getString("estado_i"));
		response.setMonto_repactado(rs.getInt("monto_repactado"));
		response.setVia_pago(rs.getString("via_pago"));
		response.setProducto(rs.getString("producto"));
		response.setTermino_credito(rs.getDate("termino_credito"));
		response.setCuotas_pagadas(rs.getString("cuotas_pagadas"));		
		return response;
	}

}
