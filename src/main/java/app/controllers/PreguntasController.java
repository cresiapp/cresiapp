package app.controllers;


import app.model.Categoria;
import app.model.Pregunta;
import app.repository.CategoriasRepository;
import app.repository.PreguntasRepository;
import app.controllers.tos.PreguntaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping(Endpoints.PREGUNTAS)
public class PreguntasController {
    private final Random randomGenerator;

    @Autowired
    private PreguntasRepository preguntas;

    @Autowired
    private CategoriasRepository categorias;


    public PreguntasController(){
        randomGenerator = new Random();
    }

    @RequestMapping(method = RequestMethod.GET)
    public PreguntaDTO getPregunta(@RequestParam (value="categoria", required = false) Long categoriaId){

        List<Pregunta> posiblesPreguntas = this.preguntasCandidatas(categoriaId);
        Pregunta seleccionada = seleccionarPreguntaRandom(posiblesPreguntas);
        return new PreguntaDTO(seleccionada);

    }

    private Pregunta seleccionarPreguntaRandom(List<Pregunta> posiblesPreguntas) {
        int index = randomGenerator.nextInt(posiblesPreguntas.size());
        return posiblesPreguntas.get(index);
    }

    private List<Pregunta> preguntasCandidatas(Long categoriaId) {
        if(categoriaId != null) {
            Categoria categoria = categorias.findOne(categoriaId);
            return preguntas.findByCategoria(categoria);
        }

        List<Pregunta> posiblesPreguntas = new ArrayList<>();
        Iterable<Pregunta> all = preguntas.findAll();
        all.forEach( cate -> posiblesPreguntas.add(cate));
        return  posiblesPreguntas;
    }
}
