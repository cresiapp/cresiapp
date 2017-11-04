package app.model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.util.*;

public class CSVLoader {

    private Map<String, Categoria> descripcionPorCategoria = new HashMap<>();

    private List<Pregunta> preguntas;

    public CSVLoader() {
        this.descripcionPorCategoria = new HashMap<String, Categoria>();
        this.preguntas = new ArrayList<>();
        this.load();
    }

    public void load() {
        Reader in = null;
        try {
            in = new FileReader("preguntas.csv");
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            for (CSVRecord record : records) {
                preguntas.add(
                        new Pregunta(
                                record.get("Pregunta"),
                                this.crearOpciones(record),
                                record.get("MasInfo"),
                                this.determinarCategoria(record.get("Categoria"))
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private Categoria determinarCategoria(String nombreCategoria) {
        Categoria defaultValue = new Categoria(descripcionPorCategoria.size(), nombreCategoria);
        descripcionPorCategoria.putIfAbsent(nombreCategoria, defaultValue);
        return descripcionPorCategoria.get(nombreCategoria);
    }

    private Collection<Opcion> crearOpciones(CSVRecord opcionesCSV) {
        Collection<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion(opcionesCSV.get("Respuestas 1")));
        opciones.add(new Opcion(opcionesCSV.get("Respuestas 2")));
        opciones.add(new Opcion(opcionesCSV.get("Respuestas 3")));
        opciones.add(new Opcion(opcionesCSV.get("Respuestas 4")));
        opciones.add(new Opcion(opcionesCSV.get("Respuestas 5")));
        opciones.add(new Opcion(opcionesCSV.get("Correcta"), true));
        return opciones;
    }

    public Collection<Categoria> getCategorias() {
        return descripcionPorCategoria.values();
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }
}