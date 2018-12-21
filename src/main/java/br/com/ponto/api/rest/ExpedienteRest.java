package br.com.ponto.api.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
	public List<Expediente> list()
	{
		return expedienteDAO.list();
	}

}
