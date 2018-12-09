package service;

import com.google.gson.Gson;
import data.UsuarioDao;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import models.Usuario;
import org.jboss.logging.Param;

@Path("fazenda")
public class EventosApp {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FazendaWS
     */

    public EventosApp() {
    }

    /**
     * Retrieves representation of an instance of ws.FazendaWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/text")
    public String getJson() {
        return "meu primeiro WS RESTFULL";
    }

    @GET
    @Produces("application/json")
    @Path("Usuario/get/{login}")
    public String getUsuario(@PathParam("login") String login)
    {
        Usuario u = new Usuario();
        u.setLogin(login);

        UsuarioDao dao = new UsuarioDao();
        u = dao.buscar(u);

        //Converter para Gson
        Gson g = new Gson();
        return g.toJson(u);
    }
    @GET
    @Produces("application/json")
    @Path("Usuario/list")
    public String listUsuarios()
    {
        List<Usuario> lista;

        UsuarioDao dao = new UsuarioDao();
        lista = dao.listar();

        //Converter para Gson
        Gson g = new Gson();
        return g.toJson(lista);
    }


    /**
     * PUT method for updating or creating an instance of FazendaWS
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}