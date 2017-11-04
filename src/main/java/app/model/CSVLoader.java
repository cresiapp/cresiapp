package app.model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;

import java.io.FileReader;
import java.io.IOException;
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
            in = new FileReader(new ClassPathResource("preguntas.csv").getFile());
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
            in.close();
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
        opciones.add(new Opcion(opcionesCSV.get("Respuesta 2")));
        opciones.add(new Opcion(opcionesCSV.get("Respuesta 3")));
        opciones.add(new Opcion(opcionesCSV.get("Respuesta 4")));
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