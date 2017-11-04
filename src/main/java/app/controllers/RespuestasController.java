package app.controllers;


import app.controllers.repository.PreguntasRepository;
import app.controllers.repository.OpcionesRepository;
import app.controllers.tos.RespuestaDTO;
import app.controllers.tos.ResultadoRespuestaDTO;
import app.model.Categoria;
import app.model.Opcion;
import app.model.Pregunta;
import app.model.NoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(Endpoints.RESPUESTAS)
public class RespuestasController {

    @Autowired
    private PreguntasRepository preguntas;

    @Autowired
    private OpcionesRepository opciones;

    @RequestMapping(method = RequestMethod.GET)
    public ResultadoRespuestaDTO responder(@RequestParam Map<String,String> requestParams){

        Pregunta pregunta = new Pregunta(
                "¿Qué ley otorga la responsabilidad de educar en la sexualidad a las escuelas y docentes?",
                Arrays.asList(
                        new Opcion("26150", true),
                        new Opcion("25500", false),
                        new Opcion("15200", false),
                        new Opcion("25150", false)
                ),
                "En octubre de 2006, el Congreso sancionó la Ley Nacional que crea el Programa Nacional de Educación Sexual Integral (Ley 26.150). Esta ley establece: “Todos los educandos tienen derecho a recibir educación sexual integral en los establecimientos educativos públicos, de gestión estatal y privada de las jurisdicciones nacional, provincial, de la Ciudad Autónoma de Buenos Aires y municipal”. ",
                new Categoria(0,"Derecho"));

        return new ResultadoRespuestaDTO(pregunta.getExplicacion(),true, new Opcion("26150", true));

/*        long preguntaId = Long.valueOf(requestParams.get("preguntaId"));
        long respuestaId = Long.valueOf(requestParams.get("respuestaId"));

        Opcion opcion = opciones.findOne(preguntaId);

        if(opcion == null){
            //throw new NoEncontradoException("No hay respuesta en la base para la opcion elegida");
            return new ResultadoRespuestaDTO("algo",true);
        }

        Pregunta preguntaRealizada = preguntas.findOne(respuestaId);

        if(preguntaRealizada == null){
            //throw new NoEncontradoException("No hay pregunta en la base");
            return new ResultadoRespuestaDTO("otro algo",false);
        }

        return new ResultadoRespuestaDTO(preguntaRealizada.getExplicacion(),opcion.isCorrecta()); */
    }




}
