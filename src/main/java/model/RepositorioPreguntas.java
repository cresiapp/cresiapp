package model;

import java.util.List;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class RepositorioPreguntas implements WithGlobalEntityManager {

	public static RepositorioPreguntas instancia = new RepositorioPreguntas();

	public List<Pregunta> listar() {
		return entityManager()//
				.createQuery("from Pregunta", Pregunta.class) //
				.getResultList();
	}

	public Pregunta buscar(long id) {
		return entityManager().find(Pregunta.class, id);
	}

	public void agregar(Pregunta consultora) {
		entityManager().persist(consultora);
	}

	public Pregunta siguiente(long id) {
		return entityManager().createQuery("from Pregunta where id=" + (id + 1), Pregunta.class)
				.getSingleResult();
	}

	public Pregunta alguna() {
		return entityManager().createQuery("from Pregunta", Pregunta.class).getResultList().get(0);
	}

}
