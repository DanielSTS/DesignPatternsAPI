package com.eventos.apirest.data;

import com.eventos.apirest.iterator.IteratorInterface;
import com.eventos.apirest.iterator.IteratorResultset;
import com.eventos.apirest.models.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EventoDao {

    private Connection	connection;

    //Criar um Evento
    public	void adicionar(Evento e)  {

        String sql = "INSERT  INTO evento (nome,local,data,horario) VALUES(?,?,?,?) ";

       PreparedStatement pst = SingletonConexao.getPreparedStatement(sql);

        try {

            pst.setString(1,e.getNome());
            pst.setString(2,e.getLocal());
            pst.setString(3,e.getData());
            pst.setString(4,e.getHorario());

            pst.execute();
            pst.close();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }


    //Remover um evento
    public	void remover(Long e) {

        String sql = "delete	from	evento	where	codigo=?";

        PreparedStatement pst = SingletonConexao.getPreparedStatement(sql);
        ;

        try {
            pst.setLong(1, e);
            pst.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    //Exibir apenas os eventos que está participando
    public ArrayList<Evento> listar(String e)  {
        String sql =  "SELECT * FROM evento WHERE evento.codigo = evento_usuario.codigo_evento AND evento_usuario.codigo_usuario = '"+e+"'";

        ArrayList<Evento> retorno = new ArrayList<Evento>();

        PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);


        ResultSet res = null;
        try {
            res = pst.executeQuery();

            IteratorInterface iter = criarIterator(res);

            while(iter.hasNext())
            {
                Evento item = new Evento();
                item.setCodigo(res.getLong("codigo"));
                item.setNome(res.getString("nome"));
                item.setLocal(res.getString("local"));
                item.setData(res.getString("data"));
                item.setHorario(res.getString("horario"));

                retorno.add(item);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return retorno;

    }

    //Detalhes do evento
    public Evento detalhes(long e)  {

            String sql = "SELECT * FROM evento where codigo=?";

            Evento retorno = null;

            PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);
            try {

                pst.setLong(1, e);
                ResultSet res = pst.executeQuery();

                if(res.next())
                {
                    retorno = new Evento();
                    retorno.setCodigo(res.getLong("codigo"));
                    retorno.setNome(res.getString("nome"));
                    retorno.setLocal(res.getString("local"));
                    retorno.setData(res.getString("data"));
                    retorno.setHorario(res.getString("horario"));

                }

            } catch (SQLException ex) {
                Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);

            }

            return retorno;

        }


    //Exibir todos os eventos
    public ArrayList<Evento> listarTudo()  {
        String sql =  "SELECT * FROM evento ";

        ArrayList<Evento> retorno = new ArrayList<Evento>();

        PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);


        ResultSet res = null;

        try {
            res = pst.executeQuery();

            IteratorInterface iter = criarIterator(res);

            while(iter.hasNext())
            {
                Evento item = new Evento();
                item.setCodigo(res.getLong("codigo"));
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

    public ArrayList<Evento> listarTudo(String atributo)  {
        String sql =  "SELECT * FROM evento ORDER BY '"+atributo+"'";

        ArrayList<Evento> retorno = new ArrayList<Evento>();

        PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);


        ResultSet res = null;

        try {
            res = pst.executeQuery();

            IteratorInterface iter = criarIterator(res);

            while(iter.hasNext())
            {
                Evento item = new Evento();
                item.setCodigo(res.getLong("codigo"));
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



    public IteratorResultset criarIterator(ResultSet rs) {
        return new IteratorResultset(rs);
    }



}

