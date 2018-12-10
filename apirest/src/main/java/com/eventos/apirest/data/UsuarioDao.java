package com.eventos.apirest.data;

import com.eventos.apirest.models.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDao {

    //Adiciona um usuário

    public	void adicionar(Usuario u) throws SQLException {

        String sql = "INSERT  INTO usuario (nome,rg,login,senha) VALUES(?,?,?,?) ";

        PreparedStatement pst = SingletonConexao.getPreparedStatement(sql);

        pst.setString(1,u.getNome());
        pst.setString(2,u.getRg());
        pst.setString(3,u.getLogin());
        pst.setString(4,u.getSenha());

        pst.execute();
        pst.close();


    }


    //Remove um usuário

    public	void remover(Usuario u) throws SQLException {

        String sql = "delete	from	usuario	where	rg=?";

        PreparedStatement pst = SingletonConexao.getPreparedStatement(sql);

        pst.setString(1,u.getRg());

        pst.execute();
        pst.close();

    }

    //Retorna um usuário específico

    public Usuario buscar(String rg)

    {
        String sql = "SELECT * FROM usuario where rg=?";

        Usuario retorno = null;

        PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);
        try {

            pst.setString(1, rg);
            ResultSet res = pst.executeQuery();

            if(res.next())
            {
                retorno = new Usuario();
                retorno.setNome(res.getString("nome"));
                retorno.setRg(res.getString("rg"));
                retorno.setLogin(res.getString("login"));
                retorno.setSenha(res.getString("senha"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;

    }

    //Retorna todos os usuários

    public ArrayList<Usuario> listar()  {
        String sql = "SELECT * FROM usuario";
        ArrayList<Usuario> retorno = new ArrayList<Usuario>();

        PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);

        ResultSet res = null;

        try {
            res = pst.executeQuery();

        while(res.next())
            {
                Usuario item = new Usuario();
                item.setNome(res.getString("nome"));
                item.setRg(res.getString("rg"));
                item.setLogin(res.getString("login"));
                item.setSenha(res.getString("senha"));

                retorno.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

            return retorno;

    }

}

