package app;

import app.model.Categoria;
import app.model.Pregunta;
import org.springframework.data.repository.CrudRepository;

public interface CategoriasRepository extends CrudRepository<Categoria, Long> {

}
