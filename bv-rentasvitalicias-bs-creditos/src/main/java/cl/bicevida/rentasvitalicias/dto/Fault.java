package cl.bicevida.rentasvitalicias.dto;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
public class Fault {

	private String clase;
	private String mensaje;
	
	public Fault(Exception e){
		this.clase=e.getClass().getSimpleName();
		this.mensaje=e.getMessage();
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
