package app;


import app.controllers.repository.PreguntasRepository;
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

            categorias.deleteAll();
            Categoria categoria = new Categoria(0, "Derecho");
            categorias.save(categoria);
            categorias.save(new Categoria(1, "Salud"));
            categorias.save(new Categoria(2, "Diversidad"));
            categorias.save(new Categoria(3, "Proyecto"));
            categorias.save(new Categoria(4, "Prevencion"));

            preguntas.deleteAll();
            preguntas.save(new Pregunta(0,
                    "¿Qué ley otorga la responsabilidad de educar en la sexualidad a las escuelas y docentes?",
                    Arrays.asList(
                            new Opcion("26150", true),
                            new Opcion("25500", false),
                            new Opcion("15200", false),
                            new Opcion("25150", false)
                    ),
                    "En octubre de 2006, el Congreso sancionó la Ley Nacional que crea el Programa Nacional de Educación Sexual Integral (Ley 26.150). Esta ley establece: “Todos los educandos tienen derecho a recibir educación sexual integral en los establecimientos educativos públicos, de gestión estatal y privada de las jurisdicciones nacional, provincial, de la Ciudad Autónoma de Buenos Aires y municipal”. ",
                    categoria));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(CresiApplication.class, args);
    }


}
