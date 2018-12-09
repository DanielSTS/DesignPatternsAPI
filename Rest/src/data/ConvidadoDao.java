package data;

import models.Convidado;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConvidadoDao {

    public	void adiciona(Convidado c) throws SQLException {

        String sql = "INSERT  INTO convidado (rg,nome_convidado,evento_codigo) VALUES(?,?,?) ";

        PreparedStatement pst = new SingletonConexao().getPreparedStatement(sql);

        pst.setString(1,c.getRg());
        pst.setString(2,c.getNomeConvidado());
        pst.setLong(3,c.getEvento().getCodigo());

        pst.execute();
        pst.close();

    }

    public	void remove(Convidado c) throws SQLException {

        String sql = "delete	from	convidado	where	rg=?";

        PreparedStatement pst = new SingletonConexao().getPreparedStatement(sql);;

        pst.setString(1,c.getRg());

        pst.execute();
        pst.close();

    }

}

