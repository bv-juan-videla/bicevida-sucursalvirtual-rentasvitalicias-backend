package cl.bicevida.rentasvitalicias.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import cl.bicevida.rentasvitalicias.dto.RentasDosUltLiquidacionesDTO;

public class RentasDosUltLiquidacionesMapper implements RowMapper<RentasDosUltLiquidacionesDTO> {

	@Override
	public RentasDosUltLiquidacionesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("<<<< RentasUltLiquidacionesDTO mapRow >>>>>");
		RentasDosUltLiquidacionesDTO response = new RentasDosUltLiquidacionesDTO();
		response.setRut(rs.getString("rut"));
		response.setNumero_liquidacion(rs.getInt("numero_liquidacion"));
		response.setMes_proceso(rs.getString("mes_proceso"));
		response.setPension_liquida(rs.getInt("pension_liquida"));
		
		return response;
	}

}
