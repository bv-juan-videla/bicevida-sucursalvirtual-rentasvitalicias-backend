package cl.bicevida.rentasvitalicias.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.bicevida.rentasvitalicias.dto.CredividaDTO;

public class CredividaMapper implements RowMapper<CredividaDTO> {

	@Override
	public CredividaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("<<<< CredividaDTO mapRow >>>>>");
		CredividaDTO response = new CredividaDTO();
		response.setEstado(rs.getInt("ESTADO"));
		response.setGlosa(rs.getString("GLOSA"));
		response.setCuenta(rs.getInt("CUENTA"));
		return response;
	}

}
