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
public class CredividaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//@JsonProperty("estado")
	private Integer estado;
	//@JsonProperty("estado")
	private String glosa;
	//@JsonProperty("estado")
	private Integer cuenta;
	//@JsonFormat(timezone = "Chile/Continental", shape=Shape.NUMBER)
	//private Date fechaNacimiento;
	
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public String getGlosa() {
		return glosa;
	}
	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}
	public Integer getCuenta() {
		return cuenta;
	}
	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}
	

}
