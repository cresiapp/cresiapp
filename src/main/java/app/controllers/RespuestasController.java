package app.controllers;


import app.controllers.tos.RespuestaDTO;
import app.controllers.tos.ResultadoRespuestaDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(Endpoints.RESPUESTAS)
public class RespuestasController {

    @RequestMapping(method = RequestMethod.POST)
    public ResultadoRespuestaDTO responder(@RequestBody RespuestaDTO respuesta){
        return new ResultadoRespuestaDTO("En octubre de 2006, el Congreso sancionó la Ley Nacional que crea el Programa Nacional de Educación Sexual Integral (Ley 26.150). Esta ley establece: “Todos los educandos tienen derecho a recibir educación sexual integral en los establecimientos educativos públicos, de gestión estatal y privada de las jurisdicciones nacional, provincial, de la Ciudad Autónoma de Buenos Aires y municipal”. ", true);

    }




}
