package cl.bicevida.rentasvitalicias.dto;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
public class Message {

	private String mensaje;

	public Message(String mensaje) {
		// TODO Auto-generated constructor stub
		setMensaje(mensaje);
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	
}
