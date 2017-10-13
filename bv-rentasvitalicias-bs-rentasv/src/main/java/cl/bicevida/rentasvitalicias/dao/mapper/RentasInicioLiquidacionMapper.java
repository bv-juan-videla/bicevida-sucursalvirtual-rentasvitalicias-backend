package cl.bicevida.rentasvitalicias.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.bicevida.rentasvitalicias.dto.RentasInicioLiquidacionDTO;

public class RentasInicioLiquidacionMapper implements RowMapper<RentasInicioLiquidacionDTO> {

	@Override
	public RentasInicioLiquidacionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("<<<< RentasInicioLiquidacionDTO mapRow >>>>>");
		RentasInicioLiquidacionDTO response = new RentasInicioLiquidacionDTO();
		//RentasInicioLiquidacionJsonDTO response = new RentasInicioLiquidacionJsonDTO();
		response.setRut(rs.getString("rut"));
		response.setNumero_liquidacion(rs.getInt("numero_liquidacion"));
		response.setMes_proceso(rs.getString("mes_proceso"));
		response.setPension_mensual_uf(rs.getString("pension_mensual_uf"));
		response.setPension_liquida(rs.getInt("pension_liquida"));
		response.setFecha_ultimo_pago(rs.getString("fecha_ultimo_pago"));
		response.setProximo_pago(rs.getString("proximo_pago"));
		response.setPrimer_pago(rs.getString("primer_pago"));		
		return response;
	}
}
