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

import cl.bicevida.rentasvitalicias.dao.EmailDAO;
import cl.bicevida.rentasvitalicias.dao.mapper.EmailMapper;
import cl.bicevida.rentasvitalicias.dto.EmailDTO;
//import cl.bicevida.util.LogExecutionTime;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.OracleTypes;

@Log4j
@Repository
public class EmailDAOImpl implements EmailDAO{
	
	@Autowired
	@Qualifier("dsCreditos")
	private DataSource dataSource;
	
	//private LogExecutionTime executionTime;
	//private Logger log;
	
	public EmailDAOImpl(){
		super();
	}
	
	@PostConstruct
	private void init(){
		//executionTime = new LogExecutionTime(log);
		System.out.println("<<<< Inicio >>>>");
	}

	@SuppressWarnings("unchecked")
	@Override
	public EmailDTO obtenerDatosEmail(String rut) {
		
		//log.info("obtenerDatosCliente");
		System.out.println("EmailDTO obtenerDatosEmail");
		
		List<EmailDTO> resultList = null;
		EmailDTO response = null;
		String sql = "PKG_SUCURSAL_VIRTUAL_CRE.CORREO_ELECTRONICO";
        //int vestado = 0;
        //int vnumcuenta = 0;
        //String vglosa= " ";
		
		try{
			SimpleJdbcCall procedureParametersCall = new SimpleJdbcCall(dataSource);
			procedureParametersCall
			.withProcedureName(sql)
			.withoutProcedureColumnMetaDataAccess()
			.declareParameters(
				new SqlParameter("vrut", Types.VARCHAR),
				new SqlOutParameter("result", OracleTypes.CURSOR, new EmailMapper()));
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
			mapSqlParameterSource.addValue("vrut", rut);

			System.out.println("Carga de PKG");
			//executionTime.startLogin("EmailDAO.obtenerDatosEmail");
			Map<String, Object> result = procedureParametersCall.execute(mapSqlParameterSource);
			System.out.println("procedureParametersCall de PKG");

			
			//executionTime.stopLogin("EmailDAO.obtenerDatosEmail");
			System.out.println("Paso de PKG");
			
			resultList = (List<EmailDTO>) result.get("result");
			if (!resultList.isEmpty()) {
				response = resultList.get(0);
			}
			
		}catch(EmptyResultDataAccessException e){
			//log.info("obtenerDatosCliente: The result query is empty");
			System.out.println("obtenerDatosEmail: The result query is empty");
		}
		return response;
	}

}
