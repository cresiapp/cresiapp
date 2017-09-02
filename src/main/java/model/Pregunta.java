package model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Pregunta {

	@Id
	@GeneratedValue
	private long id;

	private String enunciado;
	
	@Column(length = 1000)
	private String explicacion;

	@OneToMany(cascade = {CascadeType.ALL})
	private Collection<Opcion> opciones;

	public Pregunta() {
	}

	public Pregunta(String enunciado, Collection<Opcion> opciones, String explicacion) {
		super();
		this.enunciado = enunciado;
		this.opciones = opciones;
		this.explicacion = explicacion;
	}

	public long getId() {
		return id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public String getExplicacion() {
		return explicacion;
	}

	public Collection<Opcion> getOpciones() {
		return opciones;
	}

}
