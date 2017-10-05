package cl.bicevida.rentasvitalicias.dto;

import java.io.Serializable;
//import java.util.List;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonFormat.Shape;
//import com.fasterxml.jackson.annotation.JsonProperty;

//import java.util.ArrayList;
//import java.util.Date;

//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
public class RentasVDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String rut;
	private int poliza;
	private String nombre_liquidacion;
	private String rentista_vigente;
	private String estado_poliza;
	private String etapa_pago;
	private String tipo_pension;
	private String tipo_renta;
	private String modalidad_renta;
	private int liquido;
	private String mes_proceso;
	@JsonFormat(timezone = "Chile/Continental", shape=Shape.NUMBER)
	private Date ultimo_pago_realizado;
	@JsonFormat(timezone = "Chile/Continental", shape=Shape.NUMBER)
	private Date proximo_pago;
	private double pension_mensual;
	private int codigo_via_pago;
	private String via_pago;
	private int numero_cuenta;
	
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public int getPoliza() {
		return poliza;
	}
	public void setPoliza(int poliza) {
		this.poliza = poliza;
	}
	public String getNombre_liquidacion() {
		return nombre_liquidacion;
	}
	public void setNombre_liquidacion(String nombre_liquidacion) {
		this.nombre_liquidacion = nombre_liquidacion;
	}
	public String getRentista_vigente() {
		return rentista_vigente;
	}
	public void setRentista_vigente(String rentista_vigente) {
		this.rentista_vigente = rentista_vigente;
	}
	public String getEstado_poliza() {
		return estado_poliza;
	}
	public void setEstado_poliza(String estado_poliza) {
		this.estado_poliza = estado_poliza;
	}
	public String getEtapa_pago() {
		return etapa_pago;
	}
	public void setEtapa_pago(String etapa_pago) {
		this.etapa_pago = etapa_pago;
	}
	public String getTipo_pension() {
		return tipo_pension;
	}
	public void setTipo_pension(String tipo_pension) {
		this.tipo_pension = tipo_pension;
	}
	public String getTipo_renta() {
		return tipo_renta;
	}
	public void setTipo_renta(String tipo_renta) {
		this.tipo_renta = tipo_renta;
	}
	public String getModalidad_renta() {
		return modalidad_renta;
	}
	public void setModalidad_renta(String modalidad_renta) {
		this.modalidad_renta = modalidad_renta;
	}
	public int getLiquido() {
		return liquido;
	}
	public void setLiquido(int liquido) {
		this.liquido = liquido;
	}
	public String getMes_proceso() {
		return mes_proceso;
	}
	public void setMes_proceso(String mes_proceso) {
		this.mes_proceso = mes_proceso;
	}	
	public Date getUltimo_pago_realizado() {
		return ultimo_pago_realizado;
	}
	public void setUltimo_pago_realizado(Date ultimo_pago_realizado) {
		this.ultimo_pago_realizado = ultimo_pago_realizado;
	}
	public Date getProximo_pago() {
		return proximo_pago;
	}
	public void setProximo_pago(Date proximo_pago) {
		this.proximo_pago = proximo_pago;
	}
	public double getPension_mensual() {
		return pension_mensual;
	}
	public void setPension_mensual(double pension_mensual) {
		this.pension_mensual = pension_mensual;
	}
	public int getCodigo_via_pago() {
		return codigo_via_pago;
	}
	public void setCodigo_via_pago(int codigo_via_pago) {
		this.codigo_via_pago = codigo_via_pago;
	}
	public String getVia_pago() {
		return via_pago;
	}
	public void setVia_pago(String via_pago) {
		this.via_pago = via_pago;
	}
	public int getNumero_cuenta() {
		return numero_cuenta;
	}
	public void setNumero_cuenta(int numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}
	
	
}
