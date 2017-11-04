package app.controllers.tos;

import app.model.Opcion;

public class OpcionDTO {
    Long id;
    String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public OpcionDTO(Opcion opcion){
        this.id = opcion.getId();
        this.texto = opcion.getTexto();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
