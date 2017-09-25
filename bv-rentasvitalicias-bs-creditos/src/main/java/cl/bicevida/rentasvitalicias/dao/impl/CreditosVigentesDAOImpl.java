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

import cl.bicevida.rentasvitalicias.dao.CreditosVigentesDAO;
import cl.bicevida.rentasvitalicias.dao.mapper.CreditosVigentesMapper;
import cl.bicevida.rentasvitalicias.dto.CreditosVigentesDTO;
//import cl.bicevida.util.LogExecutionTime;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.OracleTypes;

@Log4j
@Repository
public class CreditosVigentesDAOImpl implements CreditosVigentesDAO{
	
	@Autowired
	@Qualifier("dsCreditos")
	private DataSource dataSource;
	
	//private LogExecutionTime executionTime;
	//private Logger log;
	
	public CreditosVigentesDAOImpl(){
		super();
	}
	
	@PostConstruct
	private void init(){
		//executionTime = new LogExecutionTime(log);
		System.out.println("<<<< Inicio >>>>");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CreditosVigentesDTO> obtenerDatosCreditosVigentes(String rut) {
		
		//log.info("obtenerDatosCliente");
		System.out.println("CreditosVigentesDTO obtenerDatosCreditosVigentes");
		
		//List<CreditosVigentesDTO> resultList = null;
		//CreditosVigentesDTO response = null;
		List<CreditosVigentesDTO> response = null;
		
		String sql = "PKG_SUCURSAL_VIRTUAL_CRE.MIS_CREDITOS_VIGENTES";
		
		try{
			SimpleJdbcCall procedureParametersCall = new SimpleJdbcCall(dataSource);
			procedureParametersCall
			.withProcedureName(sql)
			.withoutProcedureColumnMetaDataAccess()
			.declareParameters(
				new SqlParameter("vrut", Types.VARCHAR),
				new SqlOutParameter("result", OracleTypes.CURSOR, new CreditosVigentesMapper()));
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
			mapSqlParameterSource.addValue("vrut", rut);

			System.out.println("Carga de PKG");
			//executionTime.startLogin("CreditosDAO.obtenerDatosCreditos");
			Map<String, Object> result = procedureParametersCall.execute(mapSqlParameterSource);
			System.out.println("procedureParametersCall de PKG");

			
			//executionTime.stopLogin("CreditosDAO.obtenerDatosCreditos");
			System.out.println("Paso de PKG");
			
			response = (List<CreditosVigentesDTO>) result.get("result");
			
			/* resultList = (List<CreditosVigentesDTO>) result.get("result");
			if (!resultList.isEmpty()) {
				for (int x=0;x<resultList.size();x++ ){
					response = resultList.get(x);
				}
			}*/
			
		}catch(EmptyResultDataAccessException e){
			//log.info("obtenerDatosCliente: The result query is empty");
			System.out.println("obtenerDatosCreditosVigentes: The result query is empty");
		}
		return response;
	}

}
