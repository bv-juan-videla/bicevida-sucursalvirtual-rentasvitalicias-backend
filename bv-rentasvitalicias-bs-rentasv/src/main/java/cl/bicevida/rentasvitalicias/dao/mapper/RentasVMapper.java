package cl.bicevida.rentasvitalicias.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.bicevida.rentasvitalicias.dto.RentasVDTO;

public class RentasVMapper implements RowMapper<RentasVDTO> {

	@Override
	public RentasVDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("<<<< RentasVDTO mapRow >>>>>");
		RentasVDTO response = new RentasVDTO();
		
		response.setRut(rs.getString("rut"));
		response.setPoliza(rs.getInt("poliza"));
		response.setNombre_liquidacion(rs.getString("nombre_liquidacion"));
		response.setRentista_vigente(rs.getString("rentista_vigente"));
		response.setEstado_poliza(rs.getString("estado_poliza"));
		response.setEtapa_pago(rs.getString("etapa_pago"));
		response.setTipo_pension(rs.getString("tipo_pension"));
		response.setTipo_renta(rs.getString("tipo_renta"));
		response.setModalidad_renta(rs.getString("modalidad_renta"));
		response.setLiquido(rs.getInt("liquido"));
		response.setMes_proceso(rs.getString("mes_proceso"));
		response.setUltimo_pago_realizado(rs.getDate("ultimo_pago_realizado"));
		response.setProximo_pago(rs.getDate("proximo_pago"));
		response.setPension_mensual(rs.getInt("pension_mensual"));
		response.setCodigo_via_pago(rs.getInt("codigo_via_pago"));
		response.setVia_pago(rs.getString("via_pago"));
		response.setNumero_cuenta(rs.getInt("numero_cuenta"));		
		return response;
	}

}
