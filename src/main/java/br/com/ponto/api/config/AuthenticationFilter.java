package br.com.ponto.api.config;

import java.io.IOException;
import java.security.Principal;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter
{

	private static final String	REALM							= "example";

	private static final String	AUTHENTICATION_SCHEME	= "Bearer";

	@Override
	public void filter(final ContainerRequestContext requestContext) throws IOException
	{

		final SecurityContext currentSecurityContext = requestContext.getSecurityContext();

		// Get the Authorization header from the request
		final String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		// Validate the Authorization header
		if(!isTokenBasedAuthentication(authorizationHeader))
		{
			abortWithUnauthorized(requestContext);
			return;
		}

		// Extract the token from the Authorization header
		final String token = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();

		try
		{

			// Validate the token
			validateToken(token);

			requestContext.setSecurityContext(new SecurityContext()
			{

				@Override
				public Principal getUserPrincipal()
				{
					return () -> token;
				}

				@Override
				public boolean isUserInRole(final String role)
				{
					return true;
				}

				@Override
				public boolean isSecure()
				{
					return currentSecurityContext.isSecure();
				}

				@Override
				public String getAuthenticationScheme()
				{
					return AUTHENTICATION_SCHEME;
				}

			});

		}
		catch(final Exception e)
		{
			abortWithUnauthorized(requestContext);
		}
	}

	private boolean isTokenBasedAuthentication(final String authorizationHeader)
	{

		// Check if the Authorization header is valid
		// It must not be null and must be prefixed with "Bearer" plus a whitespace
		// The authentication scheme comparison must be case-insensitive
		return (authorizationHeader != null) && authorizationHeader.toLowerCase().startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
	}

	private void abortWithUnauthorized(final ContainerRequestContext requestContext)
	{

		// Abort the filter chain with a 401 status code response
		// The WWW-Authenticate header is sent along with the response
		requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
			.header(HttpHeaders.WWW_AUTHENTICATE, AUTHENTICATION_SCHEME + " realm=\"" + REALM + "\"").build());
	}

	private void validateToken(final String token) throws Exception
	{
		// Check if the token was issued by the server and if it's not expired
		// Throw an Exception if the token is invalid
	}

}
