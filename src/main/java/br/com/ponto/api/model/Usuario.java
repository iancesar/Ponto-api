/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ponto.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author ian
 */
@Entity
@Table(name = "Usuario")
@NamedQueries({
	@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
	@NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
	@NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
	@NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
	@NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
	@NamedQuery(name = "Usuario.findBySaldoInicial", query = "SELECT u FROM Usuario u WHERE u.saldoInicial = :saldoInicial")})
public class Usuario implements Serializable
{

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer				id;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "nome")
	private String					nome;

	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "email")
	private String					email;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "senha")
	private String					senha;

	@Column(name = "saldoInicial")
	@Temporal(TemporalType.TIME)
	private Date					saldoInicial;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	//@JsonIgnore
	private List<Expediente>	expedienteList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	@JsonIgnore
	private List<Marcacao>		marcacaoList;

	public Usuario()
	{
	}

	public Usuario(final Integer id)
	{
		this.id = id;
	}

	public Usuario(final Integer id, final String nome, final String email, final String senha)
	{
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(final Integer id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(final String nome)
	{
		this.nome = nome;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getSenha()
	{
		return senha;
	}

	public void setSenha(final String senha)
	{
		this.senha = senha;
	}

	public Date getSaldoInicial()
	{
		return saldoInicial;
	}

	public void setSaldoInicial(final Date saldoInicial)
	{
		this.saldoInicial = saldoInicial;
	}

	public List<Expediente> getExpedienteList()
	{
		return expedienteList;
	}

	public void setExpedienteList(final List<Expediente> expedienteList)
	{
		this.expedienteList = expedienteList;
	}

	public List<Marcacao> getMarcacaoList()
	{
		return marcacaoList;
	}

	public void setMarcacaoList(final List<Marcacao> marcacaoList)
	{
		this.marcacaoList = marcacaoList;
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
		if(!(object instanceof Usuario))
		{
			return false;
		}
		final Usuario other = (Usuario) object;
		if(((this.id == null) && (other.id != null)) || ((this.id != null) && !this.id.equals(other.id)))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "br.com.ponto.api.model.Usuario[ id=" + id + " ]";
	}

}
