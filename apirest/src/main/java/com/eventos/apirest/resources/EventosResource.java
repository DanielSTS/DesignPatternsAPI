package com.eventos.apirest.resources;

import com.eventos.apirest.facade.Facade;
import com.eventos.apirest.models.Evento;
import com.eventos.apirest.models.Usuario;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.ArrayList;



@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")

public class EventosResource {

    Facade facade = new Facade();

    //retorna um usuario

    @GetMapping("getusuario/{rg}")
    public Usuario getUsuario(@PathVariable(value = "login") String rg)
    {
        return facade.getUsuario(rg);
    }


    //retorna todos os usuarios

    @GetMapping("getlistusuario/list")
    public ArrayList<Usuario> listUsuarios() throws SQLException {

        return facade.listarUsuarios();
    }


    //retorna todos os eventos

    @GetMapping("geteventosfull")
    public ArrayList<Evento> listEventosFull() throws SQLException {

        return facade.listarTodosEventos();
    }


    //retorna apenas os eventos que está participando

    @GetMapping("geteventos/{rg}")
    public ArrayList<Evento> listEventos(@PathVariable("rg") String rg){

        return facade.listarEventos(rg);
    }

}
