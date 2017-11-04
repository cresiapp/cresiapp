package app.controllers.tos;

public class ResultadoRespuestaDTO {
    private final String texto;
    private final boolean respondeOk;

    public ResultadoRespuestaDTO(String texto, boolean respondeOk) {
        this.texto = texto;
        this.respondeOk = respondeOk;
    }

    public String getTexto() {
        return texto;
    }

    public boolean isRespondeOk() {
        return respondeOk;
    }
}
