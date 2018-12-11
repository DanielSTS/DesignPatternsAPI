package com.eventos.apirest.data;

import com.eventos.apirest.iterator.IteratorInterface;
import com.eventos.apirest.iterator.IteratorResultset;
import com.eventos.apirest.models.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDao {

    public	void adicionar(Usuario u)  {

        String sql = "INSERT  INTO usuario (nome,rg,login,senha) VALUES(?,?,?,?) ";

        PreparedStatement pst = SingletonConexao.getPreparedStatement(sql);

        try {

            pst.setString(1,u.getNome());
            pst.setInt(2,u.getRg());
            pst.setString(3,u.getLogin());
            pst.setString(4,u.getSenha());
            pst.execute();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public	void remover(int rg)  {

        String sql = "delete	from	usuario	where	rg=?";

        PreparedStatement pst = SingletonConexao.getPreparedStatement(sql);

        try {
            pst.setInt(1,rg);
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Usuario buscar(int rg)

    {
        String sql = "SELECT * FROM usuario where rg=?";

        Usuario retorno = null;

        PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);
        try {

            pst.setInt(1, rg);
            ResultSet res = pst.executeQuery();

            if(res.next())
            {
                retorno = new Usuario();
                retorno.setNome(res.getString("nome"));
                retorno.setRg(res.getInt("rg"));
                retorno.setLogin(res.getString("login"));
                retorno.setSenha(res.getString("senha"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;


    }


    public ArrayList<Usuario> listar()  {
        String sql = "SELECT * FROM usuario";
        ArrayList<Usuario> retorno = new ArrayList<Usuario>();

        PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);


        ResultSet res = null;
        try {
            res = pst.executeQuery();

            IteratorInterface iter = criarIterator(res);

            while(iter.hasNext())
            {
                Usuario item = new Usuario();
                item.setNome(res.getString("nome"));
                item.setRg(res.getInt("rg"));
                item.setLogin(res.getString("login"));
                item.setSenha(res.getString("senha"));

                retorno.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

            return retorno;

    }


    public ArrayList<Usuario> listar(String atributo)  {
        String sql =  "SELECT * FROM evento ORDER BY '"+atributo+"'";

        ArrayList<Usuario> retorno = new ArrayList<Usuario>();

        PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);


        ResultSet res = null;
        try {
            res = pst.executeQuery();

            IteratorInterface iter = criarIterator(res);

            while(iter.hasNext())
            {
                Usuario item = new Usuario();
                item.setNome(res.getString("nome"));
                item.setRg(res.getInt("rg"));
                item.setLogin(res.getString("login"));
                item.setSenha(res.getString("senha"));

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

