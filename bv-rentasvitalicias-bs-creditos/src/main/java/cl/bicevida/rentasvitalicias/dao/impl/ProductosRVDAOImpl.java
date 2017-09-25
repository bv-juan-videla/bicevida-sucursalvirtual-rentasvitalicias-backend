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

import cl.bicevida.rentasvitalicias.dao.ProductosRVDAO;
import cl.bicevida.rentasvitalicias.dao.mapper.ProductosRVMapper;
import cl.bicevida.rentasvitalicias.dto.ProductosRVDTO;
//import cl.bicevida.util.LogExecutionTime;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.OracleTypes;

@Log4j
@Repository
public class ProductosRVDAOImpl implements ProductosRVDAO{
	
	@Autowired
	@Qualifier("dsCreditos")
	private DataSource dataSource;
	
	//private LogExecutionTime executionTime;
	//private Logger log;
	
	public ProductosRVDAOImpl(){
		super();
	}
	
	@PostConstruct
	private void init(){
		//executionTime = new LogExecutionTime(log);
		System.out.println("<<<< Inicio >>>>");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductosRVDTO> obtenerDatosProductosRV(String poliza) {
		
		//log.info("obtenerDatosCliente");
		System.out.println("ProductosRVDTO obtenerDatosProductosRV");
		
		//List<ProductosRVDTO> resultList = null;
		//ProductosRVDTO response = null;
		List<ProductosRVDTO> response = null;
		
		String sql = "PKG_SUCURSAL_VIRTUAL_CRE.PRODUCTOS_RRVV";
		
		try{
			SimpleJdbcCall procedureParametersCall = new SimpleJdbcCall(dataSource);
			procedureParametersCall
			.withProcedureName(sql)
			.withoutProcedureColumnMetaDataAccess()
			.declareParameters(
				new SqlParameter("vpoliza", Types.VARCHAR),
				new SqlOutParameter("result", OracleTypes.CURSOR, new ProductosRVMapper()));
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
			mapSqlParameterSource.addValue("vpoliza", poliza);

			System.out.println("Carga de PKG");
			//executionTime.startLogin("CreditosDAO.obtenerDatosCreditos");
			Map<String, Object> result = procedureParametersCall.execute(mapSqlParameterSource);
			System.out.println("procedureParametersCall de PKG");

			//executionTime.stopLogin("CreditosDAO.obtenerDatosCreditos");
			System.out.println("Paso de PKG");
			
			response = (List<ProductosRVDTO>) result.get("result");
			
			/* resultList = (List<ProductosRVDTO>) result.get("result");
			if (!resultList.isEmpty()) {
				for (int x=0;x<resultList.size();x++ ){
					response = resultList.get(x);
				}
			}*/
			
		}catch(EmptyResultDataAccessException e){
			//log.info("obtenerDatosCliente: The result query is empty");
			System.out.println("obtenerDatosProductosRV: The result query is empty");
		}
		return response;
	}

}
