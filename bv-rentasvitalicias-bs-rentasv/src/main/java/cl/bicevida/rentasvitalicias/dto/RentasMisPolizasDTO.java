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
public class RentasMisPolizasDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String poliza;
	private String rut;
	private String nombre;
	private String tipo_persona;
	private int numero_persona;
	private String mandatoria;
	private String desc_tipo_persona;
	
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo_persona() {
		return tipo_persona;
	}
	public void setTipo_persona(String tipo_persona) {
		this.tipo_persona = tipo_persona;
	}
	public int getNumero_persona() {
		return numero_persona;
	}
	public void setNumero_persona(int numero_persona) {
		this.numero_persona = numero_persona;
	}
	public String getMandatoria() {
		return mandatoria;
	}
	public void setMandatoria(String mandatoria) {
		this.mandatoria = mandatoria;
	}
	public String getDesc_tipo_persona() {
		return desc_tipo_persona;
	}
	public void setDesc_tipo_persona(String desc_tipo_persona) {
		this.desc_tipo_persona = desc_tipo_persona;
	}
			
}
