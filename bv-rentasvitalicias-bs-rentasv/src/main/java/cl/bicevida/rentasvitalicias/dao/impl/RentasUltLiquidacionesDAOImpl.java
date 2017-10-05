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

import cl.bicevida.rentasvitalicias.dao.RentasUltLiquidacionesDAO;
import cl.bicevida.rentasvitalicias.dao.mapper.RentasUltLiquidacionesMapper;
import cl.bicevida.rentasvitalicias.dto.RentasUltLiquidacionesDTO;
//import cl.bicevida.util.LogExecutionTime;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.OracleTypes;

@Log4j
@Repository
public class RentasUltLiquidacionesDAOImpl implements RentasUltLiquidacionesDAO{
	
	@Autowired
	@Qualifier("dsRentasV")
	private DataSource dataSource;
	
	//private LogExecutionTime executionTime;
	//private Logger log;
	
	public RentasUltLiquidacionesDAOImpl(){
		super();
	}
	
	@PostConstruct
	private void init(){
		//executionTime = new LogExecutionTime(log);
		System.out.println("<<<< Inicio >>>>");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RentasUltLiquidacionesDTO> obtenerDatosRentasUltLiquidaciones(String rut, String desde, String hasta) {
		
		//log.info("obtenerDatosCliente");
		System.out.println("RentasUltLiquidacionesDTO obtenerDatosRentasUltLiquidaciones");
		
		String xrut = rut.toUpperCase();
		
		//List<RentasUltLiquidacionesDTO> resultList = null;
		//RentasUltLiquidacionesDTO response = null;
		List<RentasUltLiquidacionesDTO> response = null;
		
		System.out.println("<<<< PKG parametros modificados PKG >>>>");
		System.out.print("desde");
		System.out.println(desde);
		System.out.println("hasta");
		System.out.println(hasta);
		
		String sql = "PKG_SUCURSAL_VIRTUAL.PROC_ULTIMAS_LIQUIDACIONES";
		
		try{
			SimpleJdbcCall procedureParametersCall = new SimpleJdbcCall(dataSource);
			procedureParametersCall
			.withProcedureName(sql)
			.withoutProcedureColumnMetaDataAccess()
			.declareParameters(
				new SqlParameter("vrut", Types.VARCHAR),
				new SqlParameter("vdesde", Types.VARCHAR),
				new SqlParameter("vhasta", Types.VARCHAR),
				new SqlOutParameter("result", OracleTypes.CURSOR, new RentasUltLiquidacionesMapper()));
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
			mapSqlParameterSource.addValue("vrut", xrut);
			mapSqlParameterSource.addValue("vdesde", desde);
			mapSqlParameterSource.addValue("vhasta", hasta);

			System.out.println("Carga de PKG");
			//executionTime.startLogin("CreditosDAO.obtenerDatosCreditos");
			Map<String, Object> result = procedureParametersCall.execute(mapSqlParameterSource);
			System.out.println("procedureParametersCall de PKG");

			
			//executionTime.stopLogin("CreditosDAO.obtenerDatosCreditos");
			System.out.println("Paso de PKG");
			
			response = (List<RentasUltLiquidacionesDTO>) result.get("result");
			
			/* resultList = (List<RentasUltLiquidacionesDTO>) result.get("result");
			if (!resultList.isEmpty()) {
				for (int x=0;x<resultList.size();x++ ){
					response = resultList.get(x);
				}
			}*/
			
		}catch(EmptyResultDataAccessException e){
			//log.info("obtenerDatosCliente: The result query is empty");
			System.out.println("obtenerDatosRentasUltLiquidaciones: The result query is empty");
		}
		return response;
	}

}
