package br.com.ponto.api.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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

}
