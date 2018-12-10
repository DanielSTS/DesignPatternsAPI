package com.eventos.apirest.data;

import com.eventos.apirest.models.Evento;
import java.sql.SQLException;

public class TestaBanco {

    public static void main(String[] args) throws SQLException {

        Evento e = new Evento();

        e.setCodigo(779);
        e.setNome("Festa");
        e.setData("13/08/2019");
        e.setHorario("22:00");
        e.setLocal("quinta da colina");

        EventoDao ed = new EventoDao();

        ed.adicionar(e);

        }

}
