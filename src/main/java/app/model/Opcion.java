package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Opcion {

	@Id
	@GeneratedValue
	private long id;

	private String texto;
	private boolean correcta;

	public Opcion() {
	}

	public Opcion(String texto, boolean esCorrecta) {
		super();
		this.texto = texto;
		this.correcta = esCorrecta;
	}
	
	public long getId() {
		return id;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public boolean isCorrecta() {
		return correcta;
	}

}
