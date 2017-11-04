package app.controllers;


import app.repository.PreguntasRepository;
import app.controllers.tos.PreguntaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(Endpoints.PREGUNTAS)
public class PreguntasController {

    @Autowired
    private PreguntasRepository preguntas;

    @RequestMapping(method = RequestMethod.GET)
    public PreguntaDTO getPregunta(@RequestParam (value="categoria", required = false) Long categoria){
        return new PreguntaDTO(preguntas.findOne(0l));
    }



}
