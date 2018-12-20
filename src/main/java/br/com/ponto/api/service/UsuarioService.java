package br.com.ponto.api.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.ponto.api.dao.UsuarioDAO;
import br.com.ponto.api.model.Usuario;

@Path("/api/user")
@Produces({"application/json"})
public class UsuarioService
{

	@Inject
	private UsuarioDAO usuarioDao;

	@Path("/create")
	@POST
	public Usuario create(final Usuario u)
	{
		return usuarioDao.create(u);
	}

	@Path("/list")
	@GET
	public List<Usuario> list()
	{
		return usuarioDao.list();
	}

	@Path("/delete/{id}")
	@DELETE
	public void remove(@PathParam("id") final Integer id)
	{
		usuarioDao.remove(id);
	}

}
