package main;

import model.Opcion;
import model.Pregunta;

import java.util.Arrays;

import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

/**
 * Ejecutar antes de levantar el servidor por primera vez
 * 
 * @author flbulgarelli
 */
public class Bootstrap implements WithGlobalEntityManager, EntityManagerOps, TransactionalOps {

  public static void main(String[] args) {
    new Bootstrap().run();
  }

  public void run() {
    withTransaction(() -> {
      persist(new Pregunta(
    		  "¿Cuántos espermatozoides libera el hombre en una eyaculación?", 
    		  Arrays.asList(
    				  new Opcion("Miles", false), 
    				  new Opcion("Algunos Pocos", false),
    				  new Opcion("86", false),
    				  new Opcion("Millones", true)),
    		  "En promedio se liberan 250 millones (...)"));
    });
  }

}
