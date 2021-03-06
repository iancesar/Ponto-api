package br.com.ponto.api.rest;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.ponto.api.dao.UsuarioDAO;
import br.com.ponto.api.model.Usuario;

@Path("/auth")
@Produces({"application/json"})
public class AuthenticationRest
{

	@Inject
	private UsuarioDAO usuarioDAO;

	@POST
	public Response authenticateUser(final Usuario usuario)
	{

		try
		{
			// Authenticate the user using the credentials provided
			authenticate(usuario);

			// Issue a token for the user
			final String token = issueToken(usuario);

			// Return the token on the response
			final JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
			jsonBuilder.add("token", token);
			return Response.ok(jsonBuilder.build().toString()).build();

		}
		catch(final Exception e)
		{
			return Response.status(Response.Status.FORBIDDEN).build();
		}
	}

	private void authenticate(Usuario usuario) throws Exception
	{
		usuario = usuarioDAO.login(usuario);
		if(usuario == null)
		{
			throw new Exception("Usuário ou senha inválidos");
		}
	}

	private String issueToken(final Usuario usuario)
	{
		// Issue a token (can be a random String persisted to a database or a JWT token)
		// The issued token must be associated to a user
		// Return the issued token
		final Random random = new SecureRandom();
		final String token = new BigInteger(130, random).toString(32);
		return token;
	}

}
