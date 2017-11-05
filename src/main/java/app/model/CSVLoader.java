package app.model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.*;
import java.util.function.Function;

public class CSVLoader {

    private Map<String, Categoria> descripcionPorCategoria = new HashMap<>();

    private List<Pregunta> preguntas;

    public CSVLoader() {
        this.descripcionPorCategoria = new HashMap<String, Categoria>();
        descripcionPorCategoria.put("Derecho", new Categoria(0, "Derecho"));
        descripcionPorCategoria.put("Salud", new Categoria(1, "Salud"));
        descripcionPorCategoria.put("Diversidad", new Categoria(2, "Diversidad"));
        descripcionPorCategoria.put("Proyecto", new Categoria(3, "Proyecto"));
        descripcionPorCategoria.put("Prevención", new Categoria(4, "Prevención"));
        this.preguntas = new ArrayList<>();
        this.load();
    }

    public void load() {
        Reader in = null;
        try {
            final InputStream inputStream = new ClassPathResource("preguntas.csv").getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));

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
        Categoria categoria = descripcionPorCategoria.computeIfAbsent(nombreCategoria, nombre -> new Categoria(descripcionPorCategoria.size(), nombre));
        return categoria;
    }


    private Collection<Opcion> crearOpciones(CSVRecord opcionesCSV) {
        List<Opcion> opciones = new ArrayList<>();
        List<String> textosOpciones = new ArrayList<>();
        agregarOpcion(opcionesCSV,"Respuestas 1", opciones, textosOpciones);
        agregarOpcion(opcionesCSV,"Respuesta 2", opciones, textosOpciones);
        agregarOpcion(opcionesCSV,"Respuesta 3", opciones, textosOpciones);
        agregarOpcion(opcionesCSV,"Respuesta 4", opciones, textosOpciones);
        marcarCorrecta(opcionesCSV.get("Correcta"), textosOpciones, opciones);
        return opciones;
    }

    private void marcarCorrecta(String textoCorrecta, List<String> textosOpciones, List<Opcion> opciones) {
        int index = textosOpciones.indexOf(textoCorrecta);
        if(index == -1){
            throw new RuntimeException(String.format("CSV mal formado, respuesta buscada: [%s] posibles: [%s]",textoCorrecta, textosOpciones));
        }
        opciones.get(index).setCorrecta(true);
    }

    private void agregarOpcion(CSVRecord opcionesCSV, String columna, Collection<Opcion> opciones, List<String> textosOpciones) {
        String rta1 = opcionesCSV.get(columna);
        opciones.add(new Opcion(rta1));
        textosOpciones.add(rta1);
    }

    public Collection<Categoria> getCategorias() {
        return descripcionPorCategoria.values();
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }
}