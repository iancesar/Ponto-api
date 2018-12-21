package br.com.ponto.api.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.ponto.api.dao.UsuarioDAO;
import br.com.ponto.api.model.Expediente;
import br.com.ponto.api.model.Usuario;

@Stateless
public class UsuarioService
{

	@Inject
	private UsuarioDAO usuarioDao;

	public Usuario create(final Usuario u)
	{

		u.setExpedienteList(new ArrayList<>());
		final DayOfWeek[] dias = DayOfWeek.values();

		for(final DayOfWeek dia : dias)
		{
			final Expediente e = new Expediente();
			e.setDia(dia.getValue());
			e.setEntrada(createDate(8, 0, 0));
			e.setSaidaAlmoco(createDate(12, 0, 0));
			e.setRetornoAlmoco(createDate(13, 30, 0));
			e.setSaida(createDate(18, 0, 0));
			e.setHabilitado(false);
			e.setUsuario(u);
			u.getExpedienteList().add(e);
		}

		return usuarioDao.create(u);
	}

	private Date createDate(final int hours, final int minus, final int seconds)
	{
		return Date.from(LocalDateTime.now().withHour(hours).withMinute(minus).withSecond(seconds).atZone(ZoneId.systemDefault()).toInstant());
	}

}
