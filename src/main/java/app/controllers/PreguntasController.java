package app.controllers;


import app.controllers.tos.PreguntaDTO;
import app.model.Opcion;
import app.model.Pregunta;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping(Endponts.PREGUNTAS)
public class PreguntasController {

    @RequestMapping(method = RequestMethod.GET)
    public PreguntaDTO getPregunta(@RequestParam (value="categoria", required = false) Long categoria){
        return new PreguntaDTO(new Pregunta(
                "¿Qué ley otorga la responsabilidad de educar en la sexualidad a las escuelas y docentes?",
                Arrays.asList(
                        new Opcion("26150", true),
                        new Opcion("25500", false),
                        new Opcion("15200", false),
                        new Opcion("25150", false)
                ),
                "En octubre de 2006, el Congreso sancionó la Ley Nacional que crea el Programa Nacional de Educación Sexual Integral (Ley 26.150). Esta ley establece: “Todos los educandos tienen derecho a recibir educación sexual integral en los establecimientos educativos públicos, de gestión estatal y privada de las jurisdicciones nacional, provincial, de la Ciudad Autónoma de Buenos Aires y municipal”. ")
        );

    }



}
