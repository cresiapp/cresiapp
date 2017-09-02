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
    		  "En promedio se liberan 250 millones de espermatozoides por eyaculación." +
			  "Los espermatozoides recorren entre 17 y 25 centímetros hasta el óvulo, y miden, en promedio, 0,09 milímetros. Su velocdad promedio de desplazzamiento es de 3 milímetros por minuto."));

      persist(new Pregunta(
    		  "¿Qué es la misoginia?", 
    		  Arrays.asList(
    				  new Opcion("Un rol sexual", false), 
    				  new Opcion("Es el odio hacia un género", true),
    				  new Opcion("Una orientación sexua", false),
    				  new Opcion("Una identidad de género", false)),
    		  "La misoginia se define como el odio o aversión hacia el género femenino. Esta puede manifestarse de diversas maneras, que incluyen denigración, discriminación, violencia contra la mujer en general y cosificación sexual de la mujer."));

      persist(new Pregunta(
    		  "¿A qué edad hay que vacunarse contra la hepatits B?", 
    		  Arrays.asList(
    				  new Opcion("A los cuatro (4) y seis (6) meses", false), 
    				  new Opcion("A los dos (2) meses", false),
    				  new Opcion("A las doce (12) horas de vida", false),
    				  new Opcion("Todas las anteriores", true)),
    		  "La hepatitis B es una inflamación del hígado causada por el virus de la hepatitis B. La vacuna es e método más efectivo para la prevención de esta enfermedad. Es muy importante la vacunación precozy completar el esquema adecuado según el calendario nacional. Se aplica una dosis al recién nacido dentro de las doce (12) horas de vida y luego como parte de la vacuna quíntuple celular o la pentavalente a los dos (2), cuatro (4) y seis (6) meses de vida. También se incorporó el calendario para todos los adultos. Las vacunas son gratuitas en todos los centros de vacunación y hospitales públicos del país."));
    });
  }

}
