package app.controllers.repository;

import app.model.Opcion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface OpcionesRepository extends CrudRepository<Opcion, Long> {


}
