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

import cl.bicevida.rentasvitalicias.dao.RentasAsignacionFamiliarDAO;
import cl.bicevida.rentasvitalicias.dao.mapper.RentasAsignacionFamiliarMapper;
import cl.bicevida.rentasvitalicias.dto.RentasAsignacionFamiliarDTO;
//import cl.bicevida.util.LogExecutionTime;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.OracleTypes;

@Log4j
@Repository
public class RentasAsignacionFamiliarDAOImpl implements RentasAsignacionFamiliarDAO{
	
	@Autowired
	@Qualifier("dsRentasV")
	private DataSource dataSource;
	
	//private LogExecutionTime executionTime;
	//private Logger log;
	
	public RentasAsignacionFamiliarDAOImpl(){
		super();
	}
	
	@PostConstruct
	private void init(){
		//executionTime = new LogExecutionTime(log);
		//System.out.println("<<<< Inicio >>>>");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RentasAsignacionFamiliarDTO> obtenerDatosRentasAsignacionFamiliar(String poliza) {
		
		//log.info("obtenerAsignacionFamiliar");
		System.out.println("RentasAsignacionFamiliarDTO obtenerDatosRentasAsignacionFamiliar");
		
		List<RentasAsignacionFamiliarDTO> response = null;
		
		System.out.println("<<<< PKG parametros modificados PKG >>>>");
		
		String sql = "PKG_SUCURSAL_VIRTUAL.PROC_ASIGNACION_FAMILIAR";
		
		try{
			SimpleJdbcCall procedureParametersCall = new SimpleJdbcCall(dataSource);
			procedureParametersCall
			.withProcedureName(sql)
			.withoutProcedureColumnMetaDataAccess()
			.declareParameters(
				new SqlParameter("poliza", Types.VARCHAR),
				new SqlOutParameter("result", OracleTypes.CURSOR, new RentasAsignacionFamiliarMapper()));
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
			mapSqlParameterSource.addValue("poliza", poliza);

			System.out.println("Carga de PKG");
			//executionTime.startLogin("CreditosDAO.obtenerDatosAsignacionFamiliar");
			Map<String, Object> result = procedureParametersCall.execute(mapSqlParameterSource);
			System.out.println("procedureParametersCall de PKG");

			
			//executionTime.stopLogin("CreditosDAO.obtenerDatosAsignacionFamiliar");
			System.out.println("Paso de PKG");
			
			response = (List<RentasAsignacionFamiliarDTO>) result.get("result");
			
			/* resultList = (List<RentasUltLiquidacionesDTO>) result.get("result");
			if (!resultList.isEmpty()) {
				for (int x=0;x<resultList.size();x++ ){
					response = resultList.get(x);
				}
			}*/
			
		}catch(EmptyResultDataAccessException e){
			//log.info("obtenerDatosAsignacionFamiliar: The result query is empty");
			System.out.println("obtenerDatosRentasAsignacionFamiliar: The result query is empty");
		}
		return response;
	}

}
