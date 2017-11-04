package app.controllers.tos;

import app.model.Opcion;

public class ResultadoRespuestaDTO {
    private final String texto;
    private final boolean respondeOk;
    private final OpcionDTO opcion;

    public ResultadoRespuestaDTO(String texto, boolean respondeOk, Opcion opcion) {
        this.texto = texto;
        this.respondeOk = respondeOk;
        this.opcion = new OpcionDTO(opcion);
    }

    public String getTexto() {
        return texto;
    }

    public boolean isRespondeOk() {
        return respondeOk;
    }

    public OpcionDTO getOpcion() {
        return opcion;
    }
}
