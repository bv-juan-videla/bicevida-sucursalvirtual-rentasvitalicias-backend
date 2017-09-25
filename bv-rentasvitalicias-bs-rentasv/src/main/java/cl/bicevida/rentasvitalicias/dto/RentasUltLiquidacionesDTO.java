package cl.bicevida.rentasvitalicias.dto;

import java.io.Serializable;
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
public class RentasUltLiquidacionesDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String rut;
	private int numero_liquidacion;
	private String mes_proceso;
	private int pension_liquida;
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public int getNumero_liquidacion() {
		return numero_liquidacion;
	}
	public void setNumero_liquidacion(int numero_liquidacion) {
		this.numero_liquidacion = numero_liquidacion;
	}
	public String getMes_proceso() {
		return mes_proceso;
	}
	public void setMes_proceso(String mes_proceso) {
		this.mes_proceso = mes_proceso;
	}
	public int getPension_liquida() {
		return pension_liquida;
	}
	public void setPension_liquida(int pension_liquida) {
		this.pension_liquida = pension_liquida;
	}
	
		
}
