package cl.bicevida.rentasvitalicias.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.bicevida.rentasvitalicias.dto.ProductosRVDTO;

public class ProductosRVMapper implements RowMapper<ProductosRVDTO> {

	@Override
	public ProductosRVDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("<<<< ProductosRVDTO mapRow >>>>>");
		ProductosRVDTO response = new ProductosRVDTO();
		response.setPoliza(rs.getString("poliza"));
		response.setRut(rs.getString("rut"));
		response.setTiene_credivida(rs.getInt("tiene_credivida"));
		response.setTiene_fde(rs.getString("tiene_fde"));
		response.setTiene_creditosvig(rs.getString("tiene_creditosvig"));
		return response;
	}

}
