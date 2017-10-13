package cl.bicevida.rentasvitalicias.dto;

import java.io.Serializable;

public class ObtieneNroFdeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int numfde;
	private Integer estado;
	private String glosa;
	
	public int getNumfde() {
		return numfde;
	}
	public void setNumfde(int numfde) {
		this.numfde = numfde;
	}
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
	
	
}
