package app.controllers;


import app.CategoriasRepository;
import app.model.Categoria;
import app.model.Pregunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(Endpoints.CATEGORIAS)
public class CategoriasController {

    @Autowired
    CategoriasRepository categorias;

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> list(){
        List<Categoria> todas = new ArrayList<>();
        Iterable<Categoria> all = categorias.findAll();
        all.forEach( cate -> todas.add(cate));
        return todas;

    }



}
