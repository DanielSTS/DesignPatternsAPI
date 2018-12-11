package com.eventos.apirest.strategy;

import com.eventos.apirest.models.Evento;

import java.util.ArrayList;

public interface Ordena {

    ArrayList<Evento> ordenaEvento(String type,String coluna);

}
