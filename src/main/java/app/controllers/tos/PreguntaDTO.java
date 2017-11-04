package app.controllers.tos;

import app.model.Opcion;
import app.model.Pregunta;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PreguntaDTO {

    private final long id;
    private final List<OpcionDTO> opciones;
    private final String enunciado;

    public PreguntaDTO(Pregunta pregunta){
        this.id = pregunta.getId();
        this.enunciado = pregunta.getEnunciado();
        this.opciones = pregunta.getOpciones().stream().map(opcion -> new OpcionDTO(opcion)).collect(Collectors.toList());
    };

    public long getId() {
        return id;
    }

    public List<OpcionDTO> getOpciones() {
        return opciones;
    }

    public String getEnunciado() {
        return enunciado;
    }
}
