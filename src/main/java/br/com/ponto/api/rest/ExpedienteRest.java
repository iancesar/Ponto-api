package br.com.ponto.api.rest;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import br.com.ponto.api.config.Secured;
import br.com.ponto.api.dao.ExpedienteDAO;
import br.com.ponto.api.model.Expediente;

@Path("/api/expediente")
@Produces({"application/json"})
public class ExpedienteRest
{

	@Inject
	private ExpedienteDAO expedienteDAO;

	@Path("/list")
	@GET
	@Secured
	public List<Expediente> list(@Context final SecurityContext securityContext)
	{
		final Principal principal = securityContext.getUserPrincipal();
		final String username = principal.getName();

		System.out.println(username);

		return expedienteDAO.list();
	}

}
