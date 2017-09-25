package cl.bicevida.rentasvitalicias.dao.impl;

//import java.math.BigDecimal;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import cl.bicevida.rentasvitalicias.dao.RentasVDAO;
import cl.bicevida.rentasvitalicias.dao.mapper.RentasVMapper;
import cl.bicevida.rentasvitalicias.dto.RentasVDTO;
//import cl.bicevida.util.LogExecutionTime;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.OracleTypes;

@Log4j
@Repository
public class RentasVDAOImpl implements RentasVDAO{
	
	@Autowired
	@Qualifier("dsRentasV")
	private DataSource dataSource;
	
	//private LogExecutionTime executionTime;
	//private Logger log;
	
	public RentasVDAOImpl(){
		super();
	}
	
	@PostConstruct
	private void init(){
		//executionTime = new LogExecutionTime(log);
		System.out.println("<<<< Inicio >>>>");
	}

	@SuppressWarnings("unchecked")
	@Override
	public RentasVDTO obtenerDatosRentasV(String rut, int NUMERO_PERSONA_IN, String TIPO_PERSONA_IN) {
		
		//log.info("obtenerDatosCliente");
		System.out.println("RentasVDTO obtenerDatosRentasV");
		
		List<RentasVDTO> resultList = null;
		RentasVDTO response = null;
		String sql = "PKG_SUCURSAL_VIRTUAL.PROC_MI_CUENTA";
		
		try{
			SimpleJdbcCall procedureParametersCall = new SimpleJdbcCall(dataSource);
			procedureParametersCall
			.withProcedureName(sql)
			.withoutProcedureColumnMetaDataAccess()
			.declareParameters(
				new SqlParameter("vrut", Types.VARCHAR),
				new SqlParameter("NUMERO_PERSONA_IN", Types.INTEGER),
				new SqlParameter("TIPO_PERSONA_IN", Types.VARCHAR),
				new SqlOutParameter("result", OracleTypes.CURSOR, new RentasVMapper()));
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
			mapSqlParameterSource.addValue("vrut", rut);
			mapSqlParameterSource.addValue("NUMERO_PERSONA_IN", NUMERO_PERSONA_IN);
			mapSqlParameterSource.addValue("TIPO_PERSONA_IN", TIPO_PERSONA_IN);

			System.out.println("Carga de PKG");
			//executionTime.startLogin("RentasVDAO.obtenerDatosRentasV");
			Map<String, Object> result = procedureParametersCall.execute(mapSqlParameterSource);
			System.out.println("procedureParametersCall de PKG");

			
			//executionTime.stopLogin("RentasVDAO.obtenerDatosRentasV");
			System.out.println("Paso de PKG");
			
			resultList = (List<RentasVDTO>) result.get("result");
			if (!resultList.isEmpty()) {
				response = resultList.get(0);
			}
			
		}catch(EmptyResultDataAccessException e){
			//log.info("obtenerDatosCliente: The result query is empty");
			System.out.println("obtenerDatosRentasV: The result query is empty");
		}
		return response;
	}

}
