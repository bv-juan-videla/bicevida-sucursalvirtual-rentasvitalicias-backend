package cl.bicevida.rentasvitalicias.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class RentasInicioLiquidacionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String rut;
	private int numero_liquidacion;
	private String mes_proceso;
	private double pension_mensual_uf;
	private int pension_liquida;
	@JsonFormat(timezone = "Chile/Continental", shape=Shape.NUMBER)
	private Date fecha_ultimo_pago;
	@JsonFormat(timezone = "Chile/Continental", shape=Shape.NUMBER)
	private Date proximo_pago;
	private String primer_pago;
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
	public double getPension_mensual_uf() {
		return pension_mensual_uf;
	}
	public void setPension_mensual_uf(double pension_mensual_uf) {
		this.pension_mensual_uf = pension_mensual_uf;
	}
	public int getPension_liquida() {
		return pension_liquida;
	}
	public void setPension_liquida(int pension_liquida) {
		this.pension_liquida = pension_liquida;
	}
	public Date getFecha_ultimo_pago() {
		return fecha_ultimo_pago;
	}
	public void setFecha_ultimo_pago(Date fecha_ultimo_pago) {
		this.fecha_ultimo_pago = fecha_ultimo_pago;
	}
	public Date getProximo_pago() {
		return proximo_pago;
	}
	public void setProximo_pago(Date proximo_pago) {
		this.proximo_pago = proximo_pago;
	}
	public String getPrimer_pago() {
		return primer_pago;
	}
	public void setPrimer_pago(String primer_pago) {
		this.primer_pago = primer_pago;
	}
	
}
