package data;

import models.Evento;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventoDao {


    public	void adiciona(Evento e) throws SQLException {

        String sql = "INSERT  INTO evento (nome,local,data,horario) VALUES(?,?,?,?) ";

        PreparedStatement pst = new SingletonConexao().getPreparedStatement(sql);

        pst.setString(1,e.getNome());
        pst.setString(2,e.getLocal());
        pst.setString(3,e.getData());
        pst.setString(4,e.getHorario());

        pst.execute();
        pst.close();

    }

    public	void remove(Evento e) throws SQLException {

        String sql = "delete	from	evento	where	codigo=?";

        PreparedStatement pst = new SingletonConexao().getPreparedStatement(sql);;

        pst.setLong(1,e.getCodigo());

        pst.execute();
    }

}

