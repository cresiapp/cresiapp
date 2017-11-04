package app.controllers.tos;

public class RespuestaDTO {

    long preguntaId;
    long opcionId;



    public long getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(long preguntaId) {
        this.preguntaId = preguntaId;
    }

    public long getOpcionId() {
        return opcionId;
    }

    public void setOpcionId(long opcionId) {
        this.opcionId = opcionId;
    }
}
