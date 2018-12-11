package com.eventos.apirest.strategy;

import com.eventos.apirest.models.Evento;

import java.util.ArrayList;

public interface Strategy {

    ArrayList<Evento> ordenaEvento(String type,String coluna);

}
