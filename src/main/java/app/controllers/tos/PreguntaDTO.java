package app.controllers.tos;

import app.model.Opcion;
import app.model.Pregunta;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PreguntaDTO {

    private final long id;
    private final List<OpcionDTO> opciones;
    private final String enunciado;
    private final long categoria;

    public PreguntaDTO(Pregunta pregunta){
        this.id = pregunta.getId();
        this.enunciado = pregunta.getEnunciado();
        this.opciones = desordenar(pregunta.getOpciones().stream().map(opcion -> new OpcionDTO(opcion)).collect(Collectors.toList()));
        this.categoria = pregunta.getCategoria().getId();
    }

    private List<OpcionDTO> desordenar(List<OpcionDTO> opciones) {
        Collections.shuffle(opciones);
        return opciones;
    }


    public long getId() {
        return id;
    }

    public List<OpcionDTO> getOpciones() {
        return opciones;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public long getCategoria() {
        return categoria;
    }
}
