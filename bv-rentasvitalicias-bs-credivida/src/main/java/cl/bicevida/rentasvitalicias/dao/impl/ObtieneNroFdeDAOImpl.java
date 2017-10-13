package cl.bicevida.rentasvitalicias.dao.impl;

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

import cl.bicevida.rentasvitalicias.dao.ObtieneNroFdeDAO;
import cl.bicevida.rentasvitalicias.dao.mapper.ObtieneNroFdeMapper;
import cl.bicevida.rentasvitalicias.dto.ObtieneNroFdeDTO;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.OracleTypes;

@Log4j
@Repository
public class ObtieneNroFdeDAOImpl implements ObtieneNroFdeDAO{

	@Autowired
	@Qualifier("dsCredivida")
	private DataSource dataSource;
	
	//private LogExecutionTime executionTime;
	//private Logger log;
	
	public ObtieneNroFdeDAOImpl(){
		super();
	}
	
	@PostConstruct
	private void init(){
		//executionTime = new LogExecutionTime(log);
		System.out.println("<<<< Inicio >>>>");
	}

	@SuppressWarnings("unchecked")
	@Override
	public ObtieneNroFdeDTO obtenerNroFDE(Integer rut) {
		
		//log.info("obtenerDatosCliente");
		System.out.println("ObtieneNroFdeDTO obtenerNroFDE");
		
		List<ObtieneNroFdeDTO> resultList = null;
		ObtieneNroFdeDTO response = null;
		String sql = "PKG_SUCURSAL_VIRTUAL_CRV.OBTIENE_NRO_FDE";
		
		try{
			SimpleJdbcCall procedureParametersCall = new SimpleJdbcCall(dataSource);
			procedureParametersCall
			.withProcedureName(sql)
			.withoutProcedureColumnMetaDataAccess()
			.declareParameters(
				new SqlParameter("vrut", Types.NUMERIC),
				new SqlOutParameter("result", OracleTypes.CURSOR, new ObtieneNroFdeMapper()));
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
			mapSqlParameterSource.addValue("vrut", rut);

			System.out.println("Carga de PKG");
			//executionTime.startLogin("CredividaDAO.obtenerDatosCredivida");
			Map<String, Object> result = procedureParametersCall.execute(mapSqlParameterSource);
			System.out.println("procedureParametersCall de PKG");

			System.out.println("Paso de PKG");
			
			resultList = (List<ObtieneNroFdeDTO>) result.get("result");
			if (!resultList.isEmpty()) {
				response = resultList.get(0);
			}
			
		}catch(EmptyResultDataAccessException e){
			//log.info("obtenerDatosCliente: The result query is empty");
			System.out.println("obtenerDatosCredivida: The result query is empty");
		}
		return response;
	}
}
