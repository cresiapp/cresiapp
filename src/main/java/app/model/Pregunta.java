package app.model;

import java.util.Collection;

import javax.persistence.*;

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

	@OneToOne(cascade =  {CascadeType.REFRESH, CascadeType.DETACH})
	private Categoria categoria;

	public Pregunta() {
	}

	public Pregunta(String enunciado, Collection<Opcion> opciones, String explicacion, Categoria categoria) {
		super();
		this.enunciado = enunciado;
		this.opciones = opciones;
		this.explicacion = explicacion;
		this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Opcion opcionCorrecta() {
	    return this.opciones.stream().filter(p -> p.isCorrecta()).findFirst().get();

    }
}
