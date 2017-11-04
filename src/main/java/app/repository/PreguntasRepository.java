package app.repository;


import app.model.Categoria;
import app.model.Pregunta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PreguntasRepository extends CrudRepository<Pregunta, Long> {

    List<Pregunta> findByCategoria(Categoria categoria);


}
