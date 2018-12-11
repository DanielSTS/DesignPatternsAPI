package com.eventos.apirest.strategy;

import com.eventos.apirest.data.EventoDao;
import com.eventos.apirest.data.UsuarioDao;
import java.util.ArrayList;


public class OrdenacaoTipos implements Ordena {

    @Override
    public ArrayList ordenaEvento(String type, String coluna ) {

        if(type == "evento"){
            return new EventoDao().listarTudo(coluna);
        }

        return new UsuarioDao().listar(coluna);
    }
}
