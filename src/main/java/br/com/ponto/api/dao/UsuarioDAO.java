package br.com.ponto.api.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.ponto.api.model.Usuario;

@Stateless
public class UsuarioDAO
{

	@PersistenceContext(unitName = "ponto")
	private EntityManager em;

	public Usuario create(final Usuario u)
	{
		em.persist(u);
		return u;
	}

	public List<Usuario> list()
	{
		return em.createQuery("select u from Usuario u", Usuario.class).getResultList();
	}

	public void remove(final Integer id)
	{
		em.createQuery("delete from Usuario u where u.id = :id", Usuario.class).setParameter("id", id).executeUpdate();
	}

	public Usuario login(final Usuario usuario)
	{

		try
		{
			return em.createQuery("select u from Usuario u where u.email = :email and u.senha = :senha", Usuario.class)//
				.setParameter("email", usuario.getEmail().trim())//
				.setParameter("senha", usuario.getSenha().trim())//
				.getSingleResult();
		}
		catch(final NoResultException e)
		{
			return null;
		}
	}

}
