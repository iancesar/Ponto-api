/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ponto.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ian
 */
@Entity
@Table(name = "Marcacao")
@NamedQueries({
	@NamedQuery(name = "Marcacao.findAll", query = "SELECT m FROM Marcacao m"),
	@NamedQuery(name = "Marcacao.findById", query = "SELECT m FROM Marcacao m WHERE m.id = :id"),
	@NamedQuery(name = "Marcacao.findByData", query = "SELECT m FROM Marcacao m WHERE m.data = :data"),
	@NamedQuery(name = "Marcacao.findByEntrada", query = "SELECT m FROM Marcacao m WHERE m.entrada = :entrada"),
	@NamedQuery(name = "Marcacao.findBySaidaAlmoco", query = "SELECT m FROM Marcacao m WHERE m.saidaAlmoco = :saidaAlmoco"),
	@NamedQuery(name = "Marcacao.findByRetornoAlmoco", query = "SELECT m FROM Marcacao m WHERE m.retornoAlmoco = :retornoAlmoco"),
	@NamedQuery(name = "Marcacao.findBySaida", query = "SELECT m FROM Marcacao m WHERE m.saida = :saida"),
	@NamedQuery(name = "Marcacao.findBySaldoDia", query = "SELECT m FROM Marcacao m WHERE m.saldoDia = :saldoDia")})
public class Marcacao implements Serializable
{

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer				id;

	@Basic(optional = false)
	@NotNull
	@Column(name = "data")
	@Temporal(TemporalType.DATE)
	private Date					data;

	@Basic(optional = false)
	@NotNull
	@Column(name = "entrada")
	@Temporal(TemporalType.TIME)
	private Date					entrada;

	@Basic(optional = false)
	@NotNull
	@Column(name = "saidaAlmoco")
	@Temporal(TemporalType.TIME)
	private Date					saidaAlmoco;

	@Basic(optional = false)
	@NotNull
	@Column(name = "retornoAlmoco")
	@Temporal(TemporalType.TIME)
	private Date					retornoAlmoco;

	@Basic(optional = false)
	@NotNull
	@Column(name = "saida")
	@Temporal(TemporalType.TIME)
	private Date					saida;

	@Basic(optional = false)
	@NotNull
	@Column(name = "saldoDia")
	@Temporal(TemporalType.TIME)
	private Date					saldoDia;

	@JoinColumn(name = "usuario", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Usuario				usuario;

	public Marcacao()
	{
	}

	public Marcacao(final Integer id)
	{
		this.id = id;
	}

	public Marcacao(final Integer id, final Date data, final Date entrada, final Date saidaAlmoco, final Date retornoAlmoco, final Date saida,
		final Date saldoDia)
	{
		this.id = id;
		this.data = data;
		this.entrada = entrada;
		this.saidaAlmoco = saidaAlmoco;
		this.retornoAlmoco = retornoAlmoco;
		this.saida = saida;
		this.saldoDia = saldoDia;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(final Integer id)
	{
		this.id = id;
	}

	public Date getData()
	{
		return data;
	}

	public void setData(final Date data)
	{
		this.data = data;
	}

	public Date getEntrada()
	{
		return entrada;
	}

	public void setEntrada(final Date entrada)
	{
		this.entrada = entrada;
	}

	public Date getSaidaAlmoco()
	{
		return saidaAlmoco;
	}

	public void setSaidaAlmoco(final Date saidaAlmoco)
	{
		this.saidaAlmoco = saidaAlmoco;
	}

	public Date getRetornoAlmoco()
	{
		return retornoAlmoco;
	}

	public void setRetornoAlmoco(final Date retornoAlmoco)
	{
		this.retornoAlmoco = retornoAlmoco;
	}

	public Date getSaida()
	{
		return saida;
	}

	public void setSaida(final Date saida)
	{
		this.saida = saida;
	}

	public Date getSaldoDia()
	{
		return saldoDia;
	}

	public void setSaldoDia(final Date saldoDia)
	{
		this.saldoDia = saldoDia;
	}

	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(final Usuario usuario)
	{
		this.usuario = usuario;
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(final Object object)
	{
		// TODO: Warning - this method won't work in the case the id fields are not set
		if(!(object instanceof Marcacao))
		{
			return false;
		}
		final Marcacao other = (Marcacao) object;
		if(((this.id == null) && (other.id != null)) || ((this.id != null) && !this.id.equals(other.id)))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "br.com.ponto.api.model.Marcacao[ id=" + id + " ]";
	}

}
