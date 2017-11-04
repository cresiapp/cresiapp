package app;


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

            categorias.deleteAll();
            Categoria categoria = new Categoria(0, "Derecho");
            categorias.save(categoria);
            Categoria salud = categorias.save(new Categoria(1, "Salud"));
            categorias.save(new Categoria(2, "Diversidad"));
            categorias.save(new Categoria(3, "Proyecto"));
            categorias.save(new Categoria(4, "Prevencion"));

            preguntas.deleteAll();
            preguntas.save(new Pregunta(
                    "¿Qué ley otorga la responsabilidad de educar en la sexualidad a las escuelas y docentes?",
                    Arrays.asList(
                            new Opcion("26150", true),
                            new Opcion("25500", false),
                            new Opcion("15200", false),
                            new Opcion("25150", false)
                    ),
                    "En octubre de 2006, el Congreso sancionó la Ley Nacional que crea el Programa Nacional de Educación Sexual Integral (Ley 26.150). Esta ley establece: “Todos los educandos tienen derecho a recibir educación sexual integral en los establecimientos educativos públicos, de gestión estatal y privada de las jurisdicciones nacional, provincial, de la Ciudad Autónoma de Buenos Aires y municipal”. ",
                    categoria));


            preguntas.save(new Pregunta(
                    "¿A qué se llama \"Trata de persona\"?",
                    Arrays.asList(
                            new Opcion("Exclavitud del sigo XXI", false),
                            new Opcion("Un delito que atenta contra los derechos humanos", false),
                            new Opcion("Alquiler o compra y venta de personas", false),
                            new Opcion("Todas las anteriores", true)
                    ),
                    "La trata de personas, conocida hoy en día como la“esclavitud del siglo XXI”, es un delito que atenta contra los derechos humanos pues vulnera la esencia misma de la persona: vida, libertad, integridad y dignidad. La trata de personas es el alquiler o la compra y venta de seres humanos. Es un crimen que anualmente afecta a millones de personas en el mundo y es visto como un proceso que comienza con el reclutamiento de la persona y termina con la explotación de la misma por bandas de crimen organizado.",
                    salud));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(CresiApplication.class, args);
    }


}
