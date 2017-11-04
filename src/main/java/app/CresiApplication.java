package app;


import app.model.CSVLoader;
import app.repository.CategoriasRepository;
import app.repository.PreguntasRepository;
import app.model.Categoria;
import app.model.Opcion;
import app.model.Pregunta;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class CresiApplication {

    @Autowired
    private PreguntasRepository preguntas;

    @Autowired
    private CategoriasRepository categorias;


    @Bean
    InitializingBean popularPreguntas(){
        return () -> {

            CSVLoader datos = new CSVLoader();
            categorias.save(datos.getCategorias());
            preguntas.save(datos.getPreguntas());
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(CresiApplication.class, args);
    }


}
