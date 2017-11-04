package app.controllers;


import app.repository.PreguntasRepository;
import app.repository.OpcionesRepository;
import app.controllers.tos.ResultadoRespuestaDTO;
import app.model.Opcion;
import app.model.Pregunta;
import app.model.NoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

        Long preguntaId = Long.valueOf(requestParams.get("pregunta_id"));
        Long respuestaId = Long.valueOf(requestParams.get("respuesta_id"));

        Opcion opcion = opciones.findOne(respuestaId);

        if(opcion == null){
            throw new NoEncontradoException("No hay respuesta para lo elegido");
        }

        Pregunta preguntaRealizada = preguntas.findOne(preguntaId);

        if(preguntaRealizada == null){
            throw new NoEncontradoException("No hay pregunta en la base");
        }

        return new ResultadoRespuestaDTO(preguntaRealizada.getExplicacion(),opcion.isCorrecta(), preguntaRealizada.opcionCorrecta());
    }




}
