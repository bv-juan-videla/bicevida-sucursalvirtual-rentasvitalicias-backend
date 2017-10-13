package cl.bicevida.rentasvitalicias.dao.impl;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import oracle.jdbc.OracleTypes;
import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import cl.bicevida.rentasvitalicias.dao.HistoricoCreditosDAO;
import cl.bicevida.rentasvitalicias.dao.mapper.HistoricoCreditosMapper;
import cl.bicevida.rentasvitalicias.dto.HistoricoCreditosDTO;

@Log4j
@Repository
public class HistoricoCreditosDAOImpl implements HistoricoCreditosDAO{

	@Autowired
	@Qualifier("dsCreditos")
	private DataSource dataSource;
	
	//private LogExecutionTime executionTime;
	//private Logger log;
	
	public HistoricoCreditosDAOImpl(){
		super();
	}
	
	@PostConstruct
	private void init(){
		//executionTime = new LogExecutionTime(log);
		System.out.println("<<<< Inicio >>>>");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistoricoCreditosDTO> obtenerDatosHistoricoCreditos(String rut) {
									  
		//log.info("obtenerDatosCliente");
		System.out.println("HistoricoCreditosDTO obtenerDatosHistoricoCreditos");
		
		List<HistoricoCreditosDTO> response = null;
		
		String sql = "PKG_SUCURSAL_VIRTUAL_CRE.HISTORIAL_CREDITOS";	
		try{
			SimpleJdbcCall procedureParametersCall = new SimpleJdbcCall(dataSource);
			procedureParametersCall
			.withProcedureName(sql)
			.withoutProcedureColumnMetaDataAccess()
			.declareParameters(
				new SqlParameter("vrut", Types.VARCHAR),
				new SqlOutParameter("result", OracleTypes.CURSOR, new HistoricoCreditosMapper()));
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
			mapSqlParameterSource.addValue("vrut", rut);

			System.out.println("Carga de PKG");
			//executionTime.startLogin("CreditosDAO.obtenerDatosCreditos");
			Map<String, Object> result = procedureParametersCall.execute(mapSqlParameterSource);
			System.out.println("procedureParametersCall de PKG");

			
			//executionTime.stopLogin("CreditosDAO.obtenerDatosCreditos");
			System.out.println("Paso de PKG");
			
			response = (List<HistoricoCreditosDTO>) result.get("result");
			
			/* resultList = (List<CreditosVigentesDTO>) result.get("result");
			if (!resultList.isEmpty()) {
				for (int x=0;x<resultList.size();x++ ){
					response = resultList.get(x);
				}
			}*/
			
		}catch(EmptyResultDataAccessException e){
			//log.info("obtenerDatosCliente: The result query is empty");
			System.out.println("obtenerDatosHistoricoCreditos: The result query is empty");
		}
		return response;		
	}
}
