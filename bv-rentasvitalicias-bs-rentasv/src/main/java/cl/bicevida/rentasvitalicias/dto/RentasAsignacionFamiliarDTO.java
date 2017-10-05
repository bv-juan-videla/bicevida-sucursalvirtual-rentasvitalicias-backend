package cl.bicevida.rentasvitalicias.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
//import java.util.List;

//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonFormat.Shape;
//import com.fasterxml.jackson.annotation.JsonProperty;

//import java.util.ArrayList;
//import java.util.Date;

//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
public class RentasAsignacionFamiliarDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String poliza;
	private String mes_proceso;
	@JsonFormat(timezone = "Chile/Continental", shape=Shape.NUMBER)
	private Date ultimo_pago;
	//private String ultimo_pago;
	@JsonFormat(timezone = "Chile/Continental", shape=Shape.NUMBER)
	private Date inicio_pago_asignacion;
	private String rut; 
	private String nombre;
	private String parentesco;
	private String numero_carga;
	private String monto_pagado;
	private String monto_total_pagado;
	
	// getter and setter
	public String getPoliza() {
		return poliza;
	}
	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}
	public String getMes_proceso() {
		return mes_proceso;
	}
	public void setMes_proceso(String mes_proceso) {
		this.mes_proceso = mes_proceso;
	}
	
	public Date getUltimo_pago() {
		return ultimo_pago;
	}
	public void setUltimo_pago(Date ultimo_pago) {
		this.ultimo_pago = ultimo_pago;
	}
	public Date getInicio_pago_asignacion() {
		return inicio_pago_asignacion;
	}
	public void setInicio_pago_asignacion(Date inicio_pago_asignacion) {
		this.inicio_pago_asignacion = inicio_pago_asignacion;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	public String getNumero_carga() {
		return numero_carga;
	}
	public void setNumero_carga(String numero_carga) {
		this.numero_carga = numero_carga;
	}
	public String getMonto_pagado() {
		return monto_pagado;
	}
	public void setMonto_pagado(String monto_pagado) {
		this.monto_pagado = monto_pagado;
	}
	public String getMonto_total_pagado() {
		return monto_total_pagado;
	}
	public void setMonto_total_pagado(String monto_total_pagado) {
		this.monto_total_pagado = monto_total_pagado;
	}
			
}
