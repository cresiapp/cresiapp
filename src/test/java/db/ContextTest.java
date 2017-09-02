package db;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import model.Pregunta;

public class ContextTest extends AbstractPersistenceTest implements
    WithGlobalEntityManager {

  @Test
  public void contextUp() {
 
    persist(new Pregunta());
  }

}
