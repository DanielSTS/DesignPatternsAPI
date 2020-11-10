package com.eventos.apirest.data;

import com.eventos.apirest.models.Evento;
import java.sql.SQLException;

public class TestaBanco {

    public static void main(String[] args) throws SQLException {

        Evento e = new Evento();

        e.setCodigo(000);
        e.setNome("tesewewewewewee");
        e.setData("4325");
        e.setHorario("hi");
        e.setLocal("dsfdf");

        EventoDao ed = new EventoDao();

        ed.adicionar(e);

        }

}
