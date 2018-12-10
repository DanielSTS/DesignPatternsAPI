package com.eventos.apirest.facade;

import com.eventos.apirest.data.EventoDao;
import com.eventos.apirest.data.UsuarioDao;
import com.eventos.apirest.models.Evento;
import com.eventos.apirest.models.Usuario;

import java.util.ArrayList;

public class Facade {

    protected UsuarioDao usuarioDao;
    protected EventoDao eventoDao;

    public Usuario getUsuario(String rg){

        return usuarioDao.buscar(rg);
    }

    public ArrayList<Usuario> listarUsuarios(){

        return usuarioDao.listar();
    }

    public ArrayList<Evento> listarEventos(String rg){

        return eventoDao.listar(rg);
    }

    public ArrayList<Evento> listarTodosEventos(){

        return eventoDao.listarTudo();
    }


}
