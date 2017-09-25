package cl.bicevida.rentasvitalicias.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.bicevida.rentasvitalicias.dto.EmailDTO;

public class EmailMapper implements RowMapper<EmailDTO> {

	@Override
	public EmailDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("<<<< EmailDTO mapRow >>>>>");
		EmailDTO response = new EmailDTO();
		response.setEnvio_mail(rs.getInt("ENVIO_MAIL"));
		response.setMail_principal(rs.getString("MAIL_PRINCIPAL"));
		return response;
	}

}
