package main;

import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

import controllers.HomeController;
import controllers.PreguntasController;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Routes {

  public static void main(String[] args) {
	Bootstrap.main(args);  
	  
    System.out.println("Iniciando servidor");

    HomeController home = new HomeController();
    PreguntasController preguntas = new PreguntasController();
    HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

    port(getHerokuAssignedPort());

    staticFileLocation("/public");

    get("/", home::mostrar, engine);
    get("/index.html", (request, response) -> {
      response.redirect("/");
      return null;
    });
    get("/preguntas", preguntas::listar, engine);

  }
  
  static int getHerokuAssignedPort() {
      ProcessBuilder processBuilder = new ProcessBuilder();
      if (processBuilder.environment().get("PORT") != null) {
          return Integer.parseInt(processBuilder.environment().get("PORT"));
      }
      return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
  }

}
