package com.eventos.apirest.facade;

import com.eventos.apirest.data.EventoDao;
import com.eventos.apirest.data.UsuarioDao;
import com.eventos.apirest.models.Evento;
import com.eventos.apirest.models.Usuario;
import com.eventos.apirest.proxy.ProxyEvento;
import com.eventos.apirest.strategy.StrategyOrdena;

import java.util.ArrayList;

public class Facade {

    protected UsuarioDao usuarioDao = new UsuarioDao();
    protected EventoDao eventoDao = new EventoDao();
    protected ProxyEvento proxyEvento = new ProxyEvento();

//Strategy Para Ordenar Eventos ou Usuário
    public ArrayList listarOrdenado(String type,String coluna){

        return new StrategyOrdena().ordenaEvento(type,coluna);
    }

    //PROXY Acessa proxy pra poder remover Evento
    public void removerEvento (int e, int u){
        proxyEvento.removerEvento(e,u);
    }


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


    public ArrayList<Evento> listarEventos(String rg){

        return eventoDao.listar(rg);
    }

    public ArrayList<Evento> listarTodosEventos(){

        return eventoDao.listarTudo();
    }

    public Evento detalhes (int codigo){
        return eventoDao.detalhes(codigo);
    }



}