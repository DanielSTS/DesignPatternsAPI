package com.eventos.apirest.controller;

import com.eventos.apirest.facade.Facade;
import com.eventos.apirest.models.Evento;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")

public class EventoController {


    @RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
    public void adicionarEvento(Evento e){
        new Facade().adicionarEvento(e);
    }

    @RequestMapping("/eventos")
    public ArrayList<Evento> listaEventos()  {
        return new Facade().listarTodosEventos();
    }

    @RequestMapping(value="/{codigo}", method=RequestMethod.GET)
    public Evento detalhesEvento(@PathVariable("codigo") int codigo){
      return new Facade().detalhes(codigo);
    }

    @RequestMapping(value="/deletarEvento/{codEvento}/{idUser}", method=RequestMethod.DELETE)
    public void deletarEvento(@PathVariable("cod_evento") int codEvento,@PathVariable("id_user") int idUser) {
        System.out.println(codEvento+" "+idUser);
        new Facade().removerEvento(codEvento,idUser);
    }

    @RequestMapping("/deletarUsuario")
    public void deletarUsuario(@RequestBody int u) {
        new Facade().removerUsuario(u);
    }

    @RequestMapping(value="/{type}/{coluna}", method=RequestMethod.GET)
    public ArrayList listaOrdenado(@PathVariable("type") String type,@PathVariable("coluna") String coluna){
        return new Facade().listarOrdenado(type,coluna);
    }
}