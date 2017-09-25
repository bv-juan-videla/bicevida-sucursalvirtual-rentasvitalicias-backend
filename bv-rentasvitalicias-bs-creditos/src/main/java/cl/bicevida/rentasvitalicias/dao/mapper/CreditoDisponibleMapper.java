package cl.bicevida.rentasvitalicias.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.bicevida.rentasvitalicias.dto.CreditoDisponibleDTO;

public class CreditoDisponibleMapper implements RowMapper<CreditoDisponibleDTO> {

	@Override
	public CreditoDisponibleDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("<<<< CreditoDisponibleDTO mapRow >>>>>");
		CreditoDisponibleDTO response = new CreditoDisponibleDTO();
		response.setMonto_maximo(rs.getInt("monto_maximo"));
		response.setMonto_solicitado(rs.getInt("monto_solicitado"));
		response.setMonto_preaprobado(rs.getInt("monto_preaprobado"));
		return response;
	}

}
