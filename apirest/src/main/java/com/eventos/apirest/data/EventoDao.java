package com.eventos.apirest.data;

import com.eventos.apirest.models.Convidado;
import com.eventos.apirest.models.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventoDao {

    private Connection	connection;

    //Criar um Evento

    public	void adiciona(Evento e) throws SQLException {

        String sql = "INSERT  INTO evento (nome,local,data,horario) VALUES(?,?,?,?) ";

       PreparedStatement pst = SingletonConexao.getPreparedStatement(sql);

        pst.setString(1,e.getNome());
        pst.setString(2,e.getLocal());
        pst.setString(3,e.getData());
        pst.setString(4,e.getHorario());

        pst.execute();
        pst.close();



    }


    //Remover um evento

    public	void remove(Evento e) throws SQLException {

        String sql = "delete	from	evento	where	codigo=?";

        PreparedStatement pst = SingletonConexao.getPreparedStatement(sql);;

        pst.setLong(1,e.getCodigo());

        pst.execute();
    }



    //Exibir todos os eventos

    public ArrayList<Evento> listarTudo()  {
        String sql =  "SELECT * FROM evento ";

        ArrayList<Evento> retorno = new ArrayList<Evento>();

        PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);


        ResultSet res = null;
        try {
            res = pst.executeQuery();

            while(res.next())
            {
                Evento item = new Evento();
                item.setNome(res.getString("nome"));
                item.setLocal(res.getString("local"));
                item.setData(res.getString("data"));
                item.setHorario(res.getString("horario"));

                retorno.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;

    }


    //Exibir apenas os eventos que está participando

    public List<Evento> listar(Convidado c)  {
        String sql =  "SELECT * FROM evento WHERE evento.codigo = evento_convidado.codigo_evento AND evento_convidado.codigo_convidado = '"+c.getRg()+"'";

        List<Evento> retorno = new ArrayList<Evento>();

        PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);


        ResultSet res = null;
        try {
            res = pst.executeQuery();

            while(res.next())
            {
                Evento item = new Evento();
                item.setNome(res.getString("nome"));
                item.setLocal(res.getString("local"));
                item.setData(res.getString("data"));
                item.setHorario(res.getString("horario"));

                retorno.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;

    }

}

