package cl.bicevida.rentasvitalicias.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.bicevida.rentasvitalicias.dto.ObtieneNroFdeDTO;

public class ObtieneNroFdeMapper implements RowMapper<ObtieneNroFdeDTO> {

	@Override
	public ObtieneNroFdeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("<<<< ObtieneNroFdeDTO mapRow >>>>>");
		ObtieneNroFdeDTO response = new ObtieneNroFdeDTO();
		response.setNumfde(rs.getInt("NUMFDE"));
		response.setEstado(rs.getInt("ESTADO"));
		response.setGlosa(rs.getString("GLOSA"));
		return response;
	}
}
