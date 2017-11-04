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

        long preguntaId = Long.valueOf(requestParams.get("preguntaId"));
        long respuestaId = Long.valueOf(requestParams.get("respuestaId"));

        Opcion opcion = opciones.findOne(preguntaId);

        if(opcion == null){
            throw new NoEncontradoException("No hay respuesta para lo elegido");
        }

        Pregunta preguntaRealizada = preguntas.findOne(respuestaId);

        if(preguntaRealizada == null){
            throw new NoEncontradoException("No hay pregunta en la base");
        }

        return new ResultadoRespuestaDTO(preguntaRealizada.getExplicacion(),opcion.isCorrecta(), preguntaRealizada.opcionCorrecta());
    }




}
