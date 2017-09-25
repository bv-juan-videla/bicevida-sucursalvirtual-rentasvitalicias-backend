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
public class EmailDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer envio_mail;
	private String mail_principal;
	public Integer getEnvio_mail() {
		return envio_mail;
	}
	public void setEnvio_mail(Integer envio_mail) {
		this.envio_mail = envio_mail;
	}
	public String getMail_principal() {
		return mail_principal;
	}
	public void setMail_principal(String mail_principal) {
		this.mail_principal = mail_principal;
	}

}
