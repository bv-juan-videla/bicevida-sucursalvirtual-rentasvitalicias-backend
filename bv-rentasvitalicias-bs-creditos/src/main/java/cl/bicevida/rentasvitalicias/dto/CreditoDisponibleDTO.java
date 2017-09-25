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
public class CreditoDisponibleDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int monto_maximo;
	private int monto_solicitado;
	private int monto_preaprobado;
	
	public int getMonto_maximo() {
		return monto_maximo;
	}
	public void setMonto_maximo(int monto_maximo) {
		this.monto_maximo = monto_maximo;
	}
	public int getMonto_solicitado() {
		return monto_solicitado;
	}
	public void setMonto_solicitado(int monto_solicitado) {
		this.monto_solicitado = monto_solicitado;
	}
	public int getMonto_preaprobado() {
		return monto_preaprobado;
	}
	public void setMonto_preaprobado(int monto_preaprobado) {
		this.monto_preaprobado = monto_preaprobado;
	}

}
