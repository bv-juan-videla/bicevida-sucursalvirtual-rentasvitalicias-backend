package cl.bicevida.rentasvitalicias.dto;

import java.io.Serializable;
//import java.util.List;

//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonFormat.Shape;
//import com.fasterxml.jackson.annotation.JsonProperty;

//import java.util.ArrayList;

//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
public class ProductosRVDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String poliza;
	private String rut;
	private int tiene_credivida;
	private String tiene_fde;
	private String tiene_creditosvig;
	
	public String getPoliza() {
		return poliza;
	}
	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public int getTiene_credivida() {
		return tiene_credivida;
	}
	public void setTiene_credivida(int tiene_credivida) {
		this.tiene_credivida = tiene_credivida;
	}
	public String getTiene_fde() {
		return tiene_fde;
	}
	public void setTiene_fde(String tiene_fde) {
		this.tiene_fde = tiene_fde;
	}
	public String getTiene_creditosvig() {
		return tiene_creditosvig;
	}
	public void setTiene_creditosvig(String tiene_creditosvig) {
		this.tiene_creditosvig = tiene_creditosvig;
	}
			
}
