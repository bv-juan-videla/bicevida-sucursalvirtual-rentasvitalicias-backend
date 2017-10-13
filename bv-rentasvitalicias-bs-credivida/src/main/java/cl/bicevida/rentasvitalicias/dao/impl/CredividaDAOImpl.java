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

import cl.bicevida.rentasvitalicias.dao.CredividaDAO;
import cl.bicevida.rentasvitalicias.dao.mapper.CredividaMapper;
import cl.bicevida.rentasvitalicias.dto.CredividaDTO;
//import cl.bicevida.util.LogExecutionTime;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.OracleTypes;

@Log4j
@Repository
public class CredividaDAOImpl implements CredividaDAO{
	
	@Autowired
	@Qualifier("dsCredivida")
	private DataSource dataSource;
	
	//private LogExecutionTime executionTime;
	//private Logger log;
	
	public CredividaDAOImpl(){
		super();
	}
	
	@PostConstruct
	private void init(){
		//executionTime = new LogExecutionTime(log);
		System.out.println("<<<< Inicio >>>>");
	}

	@SuppressWarnings("unchecked")
	@Override
	public CredividaDTO obtenerDatosCredivida(Integer rut) {
		
		//log.info("obtenerDatosCliente");
		System.out.println("CredividaDTO obtenerDatosCredivida");
		
		List<CredividaDTO> resultList = null;
		CredividaDTO response = null;
		String sql = "PKG_SUCURSAL_VIRTUAL_CRV.OBTIENE_NRO_CREDIVIDA";
        //int vestado = 0;
        //int vnumcuenta = 0;
        //String vglosa= " ";
		
		try{
			SimpleJdbcCall procedureParametersCall = new SimpleJdbcCall(dataSource);
			procedureParametersCall
			.withProcedureName(sql)
			.withoutProcedureColumnMetaDataAccess()
			.declareParameters(
				new SqlParameter("vrut", Types.NUMERIC),
				new SqlOutParameter("result", OracleTypes.CURSOR, new CredividaMapper()));
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
			mapSqlParameterSource.addValue("vrut", rut);

			System.out.println("Carga de PKG");
			//executionTime.startLogin("CredividaDAO.obtenerDatosCredivida");
			Map<String, Object> result = procedureParametersCall.execute(mapSqlParameterSource);
			System.out.println("procedureParametersCall de PKG");

			
			//executionTime.stopLogin("CredividaDAO.obtenerDatosCredivida");
			System.out.println("Paso de PKG");
			
			resultList = (List<CredividaDTO>) result.get("result");
			if (!resultList.isEmpty()) {
				response = resultList.get(0);
			}
			
		}catch(EmptyResultDataAccessException e){
			//log.info("obtenerDatosCliente: The result query is empty");
			System.out.println("obtenerDatosCredivida: The result query is empty");
		}
		return response;
	}

	/*
	@SuppressWarnings("unchecked")
	@Override
	public List<DireccionDTO> obtenerDireccionCliente(Integer rut) {
		log.info("obtenerDireccionCliente");
		
		List<DireccionDTO> response = null;
		String sql = "PKG_NSV_CLIENTES.OBTENER_DIRECIONES_CLIENTE";

		try{
			SimpleJdbcCall procedureParametersCall = new SimpleJdbcCall(dataSource);
			procedureParametersCall
			.withProcedureName(sql)
			.withoutProcedureColumnMetaDataAccess()
			.declareParameters(
				new SqlParameter("rut", Types.NUMERIC),
				new SqlOutParameter("result", OracleTypes.CURSOR, new DireccionMapper()));
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
			mapSqlParameterSource.addValue("rut", rut);
			
			executionTime.startLogin("ClienteDAO.obtenerDireccionCliente");
			Map<String, Object> result = procedureParametersCall.execute(mapSqlParameterSource);
			executionTime.stopLogin("ClienteDAO.obtenerDireccionCliente");
			
			response = (List<DireccionDTO>) result.get("result");		
		}catch(EmptyResultDataAccessException e){
			log.info("obtenerDireccionCliente: The result query is empty");
		}
		return response;
	}
	@Override
	public void actualizarDatosCliente(Integer rut, String dv, String email, String celular, 
				String numeroCasilla, String oficinaCasilla, Integer tipoEnvioCorrespondencia,
				String usuario){
		log.info("actualizaDatosCliente");

		String sql = "PKG_NSV_CLIENTES.ACTUALIZAR_DATOS_CLIENTE";
		
		SimpleJdbcCall procedureParametersCall = new SimpleJdbcCall(dataSource);
		procedureParametersCall
		.withProcedureName(sql)
		.withoutProcedureColumnMetaDataAccess()
		.declareParameters(
			new SqlParameter("p_rut", Types.NUMERIC),
			new SqlParameter("p_dv", Types.VARCHAR),
			new SqlParameter("p_email", Types.VARCHAR),
			new SqlParameter("p_celular", Types.VARCHAR),
			new SqlParameter("p_numero_casilla", Types.VARCHAR),
			new SqlParameter("p_oficina_casilla", Types.VARCHAR),
			new SqlParameter("p_tipo_envio_correspondencia", Types.NUMERIC),
			new SqlParameter("p_sys_usuario", Types.VARCHAR))
		.setNamedBinding(true);
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("p_rut", rut);
		mapSqlParameterSource.addValue("p_dv", dv);
		mapSqlParameterSource.addValue("p_email", email);
		mapSqlParameterSource.addValue("p_celular", celular);
		mapSqlParameterSource.addValue("p_numero_casilla", numeroCasilla);
		mapSqlParameterSource.addValue("p_oficina_casilla", oficinaCasilla);
		mapSqlParameterSource.addValue("p_tipo_envio_correspondencia", tipoEnvioCorrespondencia);
		mapSqlParameterSource.addValue("p_sys_usuario", usuario);
		
		executionTime.startLogin("ClienteDAO.actualizarDatosCliente");
		procedureParametersCall.execute(mapSqlParameterSource);	
		executionTime.stopLogin("ClienteDAO.actualizarDatosCliente");
		
	}
	@Override
	public void actualizarDireccionCliente(Integer rut, Integer tipoInfoContacto, String telefono, 
			String calle, String numero, String conara, Integer codigoComuna, String usuario){
		log.info("actualizarDireccionCliente");
	
		String sql = "PKG_NSV_CLIENTES.ACTUALIZAR_DIRECCION_CLIENTE";
		try{
			SimpleJdbcCall procedureParametersCall = new SimpleJdbcCall(dataSource);
			procedureParametersCall
			.withProcedureName(sql)
			.withoutProcedureColumnMetaDataAccess()
			.declareParameters(
				new SqlParameter("p_rut", Types.NUMERIC),
				new SqlParameter("P_Tipo_Info_Contacto", Types.VARCHAR),
				new SqlParameter("P_Numero_Fono_Fijo", Types.VARCHAR),
				new SqlParameter("P_Calle", Types.VARCHAR),
				new SqlParameter("P_Numeracion", Types.VARCHAR),
				new SqlParameter("P_Conara", Types.VARCHAR),
				new SqlParameter("P_Codigo_Comuna", Types.NUMERIC),
				new SqlParameter("p_sys_usuario", Types.VARCHAR))
			.setNamedBinding(true);
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
			mapSqlParameterSource.addValue("p_rut", rut);
			mapSqlParameterSource.addValue("P_Tipo_Info_Contacto", tipoInfoContacto);
			mapSqlParameterSource.addValue("P_Numero_Fono_Fijo", telefono);
			mapSqlParameterSource.addValue("P_Calle", calle);
			mapSqlParameterSource.addValue("P_Numeracion", numero);
			mapSqlParameterSource.addValue("P_Conara", conara);
			mapSqlParameterSource.addValue("P_Codigo_Comuna", codigoComuna);
			mapSqlParameterSource.addValue("p_sys_usuario", usuario);
			
			executionTime.startLogin("ClienteDAO.actualizarDireccionCliente");
			procedureParametersCall.execute(mapSqlParameterSource);	
			executionTime.stopLogin("ClienteDAO.actualizarDireccionCliente");
			
		}catch(EmptyResultDataAccessException e){
			log.info("actualizarDireccionCliente: The result query is empty");
		}		
	}
	
	@Override
	public Boolean debeActualizarDatos(Integer rut){
		log.info("debeActualizarDatos");
	
		String sql = "PKG_NSV_CLIENTES.Cliente_ultima_actualizacion";
		BigDecimal result;
		Boolean debeActualizar = true; 
		try{
			SimpleJdbcCall procedureParametersCall = new SimpleJdbcCall(dataSource);
			procedureParametersCall
			.withFunctionName(sql)
			.withoutProcedureColumnMetaDataAccess()
			.declareParameters(
					new SqlOutParameter("result", Types.NUMERIC),
					new SqlParameter("p_rut", Types.NUMERIC));
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
			mapSqlParameterSource.addValue("p_rut", rut);
			
			executionTime.startLogin("ClienteDAO.debeActualizarDatos");
			Map<String,Object> salida = procedureParametersCall.execute(mapSqlParameterSource);
			executionTime.stopLogin("ClienteDAO.debeActualizarDatos");
			
			result = (BigDecimal)salida.get("result");	
			if(result!=null){
				debeActualizar = result.intValue()==0?false:true;
			}
		}catch(EmptyResultDataAccessException e){
			log.info("actualizarDireccionCliente: The result query is empty");
		}	
		return debeActualizar;
	}
	*/
}
