package app.model;

public class NoEncontradoException extends RuntimeException{
    public NoEncontradoException(String descripcion) {
        super(descripcion);
    }
}
