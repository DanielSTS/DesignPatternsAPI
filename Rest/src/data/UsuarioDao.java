package data;

import models.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDao {

    public	void adiciona(Usuario u) throws SQLException {

        String sql = "INSERT  INTO usuario (login,nomeCompleto,senha) VALUES(?,?,?) ";

        PreparedStatement pst = new SingletonConexao().getPreparedStatement(sql);

        pst.setString(1,u.getLogin());
        pst.setString(2,u.getNomeCompleto());
        pst.setString(3,u.getSenha());

        pst.execute();
        pst.close();

    }

    public	void remove(Usuario u) throws SQLException {

        String sql = "delete	from	usuario	where	login=?";

        PreparedStatement pst = new SingletonConexao().getPreparedStatement(sql);

        pst.setString(1,u.getLogin());

        pst.execute();
        pst.close();

    }

    public Usuario buscar(Usuario usuario)

    {
        String sql = "SELECT * FROM usuario where login=?";

        Usuario retorno = null;

        PreparedStatement pst =  new SingletonConexao().getPreparedStatement(sql);
        try {

            pst.setString(1, usuario.getLogin());
            ResultSet res = pst.executeQuery();

            if(res.next())
            {
                retorno = new Usuario();
                retorno.setLogin(res.getString("login"));
                retorno.setSenha(res.getString("senha"));
                retorno.setNomeCompleto(res.getString("nome_completo"));


            }



        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;


    }


    public List<Usuario> listar()
    {
        String sql = "SELECT * FROM usuario";
        List<Usuario> retorno = new ArrayList<Usuario>();

        PreparedStatement pst =  new SingletonConexao().getPreparedStatement(sql);
        try {


            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Usuario item = new Usuario();
                item.setLogin(res.getString("login"));
                item.setSenha(res.getString("senha"));
                item.setNomeCompleto(res.getString("nome_completo"));

                retorno.add(item);
            }



        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;


    }

}

