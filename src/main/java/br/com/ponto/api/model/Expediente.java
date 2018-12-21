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
@Table(name = "Expediente")
@NamedQueries({
	@NamedQuery(name = "Expediente.findAll", query = "SELECT e FROM Expediente e"),
	@NamedQuery(name = "Expediente.findById", query = "SELECT e FROM Expediente e WHERE e.id = :id"),
	@NamedQuery(name = "Expediente.findByDia", query = "SELECT e FROM Expediente e WHERE e.dia = :dia"),
	@NamedQuery(name = "Expediente.findByEntrada", query = "SELECT e FROM Expediente e WHERE e.entrada = :entrada"),
	@NamedQuery(name = "Expediente.findBySaidaAlmoco", query = "SELECT e FROM Expediente e WHERE e.saidaAlmoco = :saidaAlmoco"),
	@NamedQuery(name = "Expediente.findByRetornoAlmoco", query = "SELECT e FROM Expediente e WHERE e.retornoAlmoco = :retornoAlmoco"),
	@NamedQuery(name = "Expediente.findBySaida", query = "SELECT e FROM Expediente e WHERE e.saida = :saida"),
	@NamedQuery(name = "Expediente.findByHabilitado", query = "SELECT e FROM Expediente e WHERE e.habilitado = :habilitado")})
public class Expediente implements Serializable
{

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer				id;

	@Basic(optional = false)
	@NotNull
	@Column(name = "dia")
	private int						dia;

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
	@Column(name = "habilitado")
	private boolean				habilitado;

	@JoinColumn(name = "usuario", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Usuario				usuario;

	public Expediente()
	{
	}

	public Expediente(final Integer id)
	{
		this.id = id;
	}

	public Expediente(final Integer id, final int dia, final Date entrada, final Date saidaAlmoco, final Date retornoAlmoco, final Date saida,
		final boolean habilitado)
	{
		this.id = id;
		this.dia = dia;
		this.entrada = entrada;
		this.saidaAlmoco = saidaAlmoco;
		this.retornoAlmoco = retornoAlmoco;
		this.saida = saida;
		this.habilitado = habilitado;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(final Integer id)
	{
		this.id = id;
	}

	public int getDia()
	{
		return dia;
	}

	public void setDia(final int dia)
	{
		this.dia = dia;
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

	public boolean getHabilitado()
	{
		return habilitado;
	}

	public void setHabilitado(final boolean habilitado)
	{
		this.habilitado = habilitado;
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
		if(!(object instanceof Expediente))
		{
			return false;
		}
		final Expediente other = (Expediente) object;
		if(((this.id == null) && (other.id != null)) || ((this.id != null) && !this.id.equals(other.id)))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "br.com.ponto.api.model.Expediente[ id=" + id + " ]";
	}

}
