package com.eventos.apirest.facade;

import com.eventos.apirest.data.EventoDao;
import com.eventos.apirest.data.UsuarioDao;
import com.eventos.apirest.models.Evento;
import com.eventos.apirest.models.Usuario;
import com.eventos.apirest.strategy.OrdenacaoTipos;

import java.util.ArrayList;

public class Facade {

    protected UsuarioDao usuarioDao = new UsuarioDao();
    protected EventoDao eventoDao = new EventoDao();


    public void adicionarUsuario(Usuario u){
        usuarioDao.adicionar(u);
    }

    public Usuario getUsuario(int rg){
        return usuarioDao.buscar(rg);
    }

    public void removerUsuario (int u){
        usuarioDao.remover(u);
    }
    public ArrayList<Usuario> listarUsuarios(){

        return usuarioDao.listar();
    }

    public void adicionarEvento(Evento e){
        eventoDao.adicionar(e);
    }

    public void removerEvento (int e){
        eventoDao.remover(e);
    }
    public ArrayList<Evento> listarEventos(String rg){

        return eventoDao.listar(rg);
    }

    public ArrayList<Evento> listarTodosEventos(){

        return eventoDao.listarTudo();
    }

    public Evento detalhes (int codigo){
        return eventoDao.detalhes(codigo);
    }

    public ArrayList listarOrdenado(String type,String coluna){

        return new OrdenacaoTipos().ordenaEvento(type,coluna);
    }

}