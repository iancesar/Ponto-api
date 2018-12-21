package br.com.ponto.api.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.ponto.api.dao.UsuarioDAO;
import br.com.ponto.api.model.Usuario;
import br.com.ponto.api.service.UsuarioService;

@Path("/api/user")
@Produces({"application/json"})
public class UsuarioRest
{

	@Inject
	private UsuarioService	usuarioService;

	@Inject
	private UsuarioDAO		usuarioDao;

	@Path("/create")
	@POST
	public Usuario create(final Usuario u)
	{
		return usuarioService.create(u);
	}

	@Path("/list")
	@GET
	public List<Usuario> list()
	{
		return usuarioDao.list();
	}

	@Path("/login")
	@POST
	public Response login(Usuario usuario)
	{
		System.out.println(usuario.getSenha());
		usuario = usuarioDao.login(usuario);
		if(usuario != null)
		{
			return Response.ok(usuario).build();
		}
		else
		{
			return Response.status(Status.UNAUTHORIZED).build();
		}
	}

	/*

	@Path("/delete/{id}")
	@DELETE
	public void remove(@PathParam("id") final Integer id)
	{
		usuarioDao.remove(id);
	}

	*/

}
