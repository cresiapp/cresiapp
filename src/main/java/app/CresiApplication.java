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
            Categoria derecho = categorias.save(new Categoria(0, "Derecho"));
            Categoria salud = categorias.save(new Categoria(1, "Salud"));
            Categoria diversidad = categorias.save(categorias.save(new Categoria(2, "Diversidad")));
            Categoria proyecto = categorias.save(categorias.save(new Categoria(3, "Proyecto")));
            Categoria prevencion = categorias.save(categorias.save(new Categoria(4, "Prevencion")));

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
                    derecho));


            preguntas.save(new Pregunta(
                    "¿A qué se llama \"Trata de persona\"?",
                    Arrays.asList(
                            new Opcion("Exclavitud del sigo XXI", false),
                            new Opcion("Un delito que atenta contra los derechos humanos", false),
                            new Opcion("Alquiler o compra y venta de personas", false),
                            new Opcion("Todas las anteriores", true)
                    ),
                    "La trata de personas, conocida hoy en día como la“esclavitud del siglo XXI”, es un delito que atenta contra los derechos humanos pues vulnera la esencia misma de la persona: vida, libertad, integridad y dignidad. La trata de personas es el alquiler o la compra y venta de seres humanos. Es un crimen que anualmente afecta a millones de personas en el mundo y es visto como un proceso que comienza con el reclutamiento de la persona y termina con la explotación de la misma por bandas de crimen organizado.",
                    derecho));

            preguntas.save(new Pregunta(
                    "¿Qué es la sexualidad?",
                    Arrays.asList(
                            new Opcion("Involucra solo lo genital.", false),
                            new Opcion("Involucra solo lo psicológico", false),
                            new Opcion("Involucra lo biólogico, psicológico, cultural, y espiritual.", true),
                            new Opcion("Involucra solo lo espiritual. ", false)
                    ),
                    "El término sexualidad se refiere a una dimensión fundamental del hecho de ser humano. Se expresa en forma de pensamientos, fantasías, deseos, creencias, actitudes, actividades, prácticas, roles y relaciones. La sexualidad es el resultado de la interacción de factores biológicos, psicológicos, socioeconómicos, culturales, éticos y religiosos o espirituales. En resumen, la sexualidad se practica y se expresa en todo lo que somos, sentimos, pensamos y hacemos.",
                    salud));

            preguntas.save(new Pregunta(
                    "¿A qué se denomina homosexualidad?",
                    Arrays.asList(
                            new Opcion("Atracción sexual que una persona siente hacia otra del mismo sexo", false),
                            new Opcion("Práctica sexual que se da entre personas del mismo sexo", false),
                            new Opcion("Las 2 anteriores", true),
                            new Opcion("Ninguna de las anteriores", false)
                    ),
                    "La homosexualidad (del griego antiguo ὁμός, ‘igual’, y el latín sexus, ‘sexo’) es una atracción romántica, atracción sexual o comportamiento sexual entre miembros del mismo sexo o género. Como orientación sexual, la homosexualidad es \"un patrón duradero de atracción emocional, romántica y/o sexuales\" a personas del mismo sexo. \"También se refiere al sentido de identidad basado en esas atracciones, los comportamientos relacionados, y la pertenencia a una comunidad que comparten esas atracciones\"",
                    diversidad));

            preguntas.save(new Pregunta(
                    "¿Cómo se puede transmitir el HIV?",
                    Arrays.asList(
                            new Opcion("A través del semen, la sangre, las secreciones vaginales y la leche materna", true),
                            new Opcion("A traves de los deportes", false),
                            new Opcion("A traves del sexo oral ", false),
                            new Opcion("A traves de usar el mismo shompo", false)
                    ),
                    "El VIH se contagia a través del semen, la sangre, las secreciones vaginales y la leche materna. Estos son los fluidos corporales que presentan una concentración del virus suficiente como para infectar a una persona.",
                    prevencion));

            preguntas.save(new Pregunta(
                    "¿Qué es la abstinencia sexual?",
                    Arrays.asList(
                            new Opcion("Esperar para tener relaciones sexuales.", true),
                            new Opcion("Tener más frecuentemente relaciones sexuales", false),
                            new Opcion("Significa no tener vida social.", false),
                            new Opcion("Significa que no te sientas atraído por nadie. ", false)
                    ),
                    "Existen personas que por convicciones personales o por prácticas religiosas deciden abstenerse a tener relaciones sexuales hasta el matrimonio, o hasta encontar la persona indicada. La abstinencia continua es la única manera de estar absolutamente seguro de que no habrá un embarazo no planificado y de prevenir el contagio de una I.T.S. La abstinencia no tiene efectos secundarios médicos ni hormonales. Requiere un autocontrol personal, lo que no significa que no se tenga vida sexual.",
                    proyecto));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(CresiApplication.class, args);
    }


}
