package com.eventos.apirest.resources;

import com.eventos.apirest.data.EventoDao;
import com.eventos.apirest.data.UsuarioDao;
import com.eventos.apirest.models.Convidado;
import com.eventos.apirest.models.Evento;
import com.eventos.apirest.models.Usuario;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")

public class EventosResource {

    //retorna um usuario

    @GetMapping("getusuario/{login}")
    public Usuario getUsuario(@PathVariable(value = "login") String login)
    {
        Usuario u = new Usuario();
        u.setLogin(login);

        UsuarioDao dao = new UsuarioDao();
        u = dao.buscar(u);

        return u;
    }


    //retorna uma lista de usuarios

    @GetMapping("getlistusuario/list")
    public ArrayList<Usuario> listUsuarios() throws SQLException {
        ArrayList<Usuario> lista;

        UsuarioDao dao = new UsuarioDao();
        lista = dao.listar();

        return lista;

    }


    //retorna todos os eventos

    @GetMapping("geteventosfull")
    public List<Evento> getEventosFull() throws SQLException {
        List<Evento> lista;

        EventoDao dao = new EventoDao();
        lista = dao.listarTudo();

        return lista;

    }


    //retorna apenas os eventos que está participando

    @GetMapping("geteventos/{login}")
    public List<Evento> getEventos(@PathVariable("login") String login){
        List<Evento> lista;

        Convidado c = new Convidado();
        c.setRg(login);

        EventoDao dao = new EventoDao();
        lista = dao.listar(c);

        return lista;
    }

}
