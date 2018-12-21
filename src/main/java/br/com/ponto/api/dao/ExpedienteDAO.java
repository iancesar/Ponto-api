package br.com.ponto.api.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.ponto.api.model.Expediente;

@Stateless
public class ExpedienteDAO
{
	@PersistenceContext(unitName = "ponto")
	private EntityManager em;

	public List<Expediente> list()
	{
		return em.createNamedQuery("Expediente.findAll", Expediente.class).getResultList();
	}

}
