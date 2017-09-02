package controllers;

import java.util.HashMap;
import java.util.Map;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import model.Opcion;
import model.Pregunta;
import model.RepositorioPreguntas;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ResultadosController implements WithGlobalEntityManager, TransactionalOps {

	public ModelAndView verificar(Request request, Response response) {
	  int preguntaId = Integer.parseInt(request.params("preguntaId"));
	  int opcionId = Integer.parseInt(request.params("opcionId"));
	  Pregunta pregunta =  RepositorioPreguntas.instancia.buscar(preguntaId);
	  Opcion opcion = pregunta.getOpciones().stream().filter(it -> it.getId() == opcionId).findFirst().get();
	  Map<String, Object> data = new HashMap<String, Object>();
	  data.put("pregunta", pregunta);
	  data.put("opcion", opcion);
	  
	  return new ModelAndView(data, "resultados.hbs");
	}

}
