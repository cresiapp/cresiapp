package app.controllers;


import app.model.Categoria;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(Endpoints.CATEGORIAS)
public class CategoriasController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> list(){


        return Arrays.asList(
                new Categoria(0,"Derecho"),
                new Categoria(1,"Salud"),
                new Categoria(2,"Diversidad"),
                new Categoria(3,"Proyecto"),
                new Categoria(4,"Prevension")
        );

    }



}
