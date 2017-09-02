package controllers;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import model.Pregunta;
import model.RepositorioPreguntas;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class PreguntasController implements WithGlobalEntityManager, TransactionalOps {


  public ModelAndView listar(Request request, Response response) {
    Pregunta pregunta =  RepositorioPreguntas.instancia.alguna();
    return new ModelAndView(pregunta, "preguntas.hbs");
  }


}
