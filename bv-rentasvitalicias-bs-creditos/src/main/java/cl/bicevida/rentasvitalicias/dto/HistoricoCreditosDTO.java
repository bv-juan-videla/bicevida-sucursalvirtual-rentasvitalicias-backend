package cl.bicevida.rentasvitalicias.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class HistoricoCreditosDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idcredito;
	private String rut;
	private int pagare;
	@JsonFormat(timezone = "Chile/Continental", shape=Shape.STRING)
	private Date fecha_pagare;
	@JsonFormat(timezone = "Chile/Continental", shape=Shape.STRING)
	private Date fecha_otorgamiento;
	private int monto_solicitado;
	private int cuotas_pactadas;
	private int monto_cuota;
	private int total_credito;
	private String estado;
	private String estado1;
	@JsonFormat(timezone = "Chile/Continental", shape=Shape.STRING)	
	private Date fecha_ultcuota_pagada;
	
	public int getIdcredito() {
		return idcredito;
	}
	public void setIdcredito(int idcredito) {
		this.idcredito = idcredito;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public int getPagare() {
		return pagare;
	}
	public void setPagare(int pagare) {
		this.pagare = pagare;
	}
	public Date getFecha_pagare() {
		return fecha_pagare;
	}
	public void setFecha_pagare(Date fecha_pagare) {
		this.fecha_pagare = fecha_pagare;
	}
	public Date getFecha_otorgamiento() {
		return fecha_otorgamiento;
	}
	public void setFecha_otorgamiento(Date fecha_otorgamiento) {
		this.fecha_otorgamiento = fecha_otorgamiento;
	}
	public int getMonto_solicitado() {
		return monto_solicitado;
	}
	public void setMonto_solicitado(int monto_solicitado) {
		this.monto_solicitado = monto_solicitado;
	}
	public int getCuotas_pactadas() {
		return cuotas_pactadas;
	}
	public void setCuotas_pactadas(int cuotas_pactadas) {
		this.cuotas_pactadas = cuotas_pactadas;
	}
	public int getMonto_cuota() {
		return monto_cuota;
	}
	public void setMonto_cuota(int monto_cuota) {
		this.monto_cuota = monto_cuota;
	}
	public int getTotal_credito() {
		return total_credito;
	}
	public void setTotal_credito(int total_credito) {
		this.total_credito = total_credito;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstado1() {
		return estado1;
	}
	public void setEstado1(String estado1) {
		this.estado1 = estado1;
	}
	public Date getFecha_ultcuota_pagada() {
		return fecha_ultcuota_pagada;
	}
	public void setFecha_ultcuota_pagada(Date fecha_ultcuota_pagada) {
		this.fecha_ultcuota_pagada = fecha_ultcuota_pagada;
	}
	
			
}
