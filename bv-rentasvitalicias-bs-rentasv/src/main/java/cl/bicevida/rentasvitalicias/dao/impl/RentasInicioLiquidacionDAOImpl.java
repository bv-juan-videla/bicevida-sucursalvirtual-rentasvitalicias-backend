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

import cl.bicevida.rentasvitalicias.dao.RentasInicioLiquidacionDAO;
import cl.bicevida.rentasvitalicias.dao.mapper.RentasInicioLiquidacionMapper;
import cl.bicevida.rentasvitalicias.dao.mapper.RentasUltLiquidacionesMapper;
import cl.bicevida.rentasvitalicias.dto.RentasInicioLiquidacionDTO;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.OracleTypes;

@Log4j
@Repository
public class RentasInicioLiquidacionDAOImpl implements RentasInicioLiquidacionDAO {

	@Autowired
	@Qualifier("dsRentasV")
	private DataSource dataSource;
	
	//private LogExecutionTime executionTime;
	//private Logger log;
	
	public RentasInicioLiquidacionDAOImpl(){
		super();
	}
	
	@PostConstruct
	private void init(){
		//executionTime = new LogExecutionTime(log);
		System.out.println("<<<< Inicio >>>>");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RentasInicioLiquidacionDTO> obtenerDatosRentasInicioLiquidacion(String rut) {
		
		//log.info("obtenerDatosCliente");
		System.out.println("RentasInicioLiquidacionDTO obtenerDatosRentasInicioLiquidacion");
		
		String xrut = rut.toUpperCase();
		
		//List<RentasUltLiquidacionesDTO> resultList = null;
		//RentasUltLiquidacionesDTO response = null;
		List<RentasInicioLiquidacionDTO> response = null;
		
		System.out.println("<<<< PKG parametros modificados PKG >>>>");
		
		String sql = "PKG_SUCURSAL_VIRTUAL.PROC_ULTIMA_LIQUIDACION";
		
		try{
			SimpleJdbcCall procedureParametersCall = new SimpleJdbcCall(dataSource);
			procedureParametersCall
			.withProcedureName(sql)
			.withoutProcedureColumnMetaDataAccess()
			.declareParameters(
				new SqlParameter("vrut", Types.VARCHAR),
				new SqlOutParameter("result", OracleTypes.CURSOR, new RentasInicioLiquidacionMapper()));
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
			mapSqlParameterSource.addValue("vrut", xrut);

			System.out.println("Carga de PKG");
			//executionTime.startLogin("CreditosDAO.obtenerDatosCreditos");
			Map<String, Object> result = procedureParametersCall.execute(mapSqlParameterSource);
			System.out.println("procedureParametersCall de PKG");

			
			//executionTime.stopLogin("CreditosDAO.obtenerDatosCreditos");
			System.out.println("Paso de PKG");
			
			response = (List<RentasInicioLiquidacionDTO>) result.get("result");
			
			/* resultList = (List<RentasUltLiquidacionesDTO>) result.get("result");
			if (!resultList.isEmpty()) {
				for (int x=0;x<resultList.size();x++ ){
					response = resultList.get(x);
				}
			}*/
			
		}catch(EmptyResultDataAccessException e){
			//log.info("obtenerDatosCliente: The result query is empty");
			System.out.println("obtenerDatosRentasUltimaLiquidación: The result query is empty");
		}
		return response;
	}
	
}
