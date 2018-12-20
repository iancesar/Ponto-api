package br.com.ponto.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Usuario")
public class Usuario implements Serializable
{

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer				id;

	@Column
	private String					nome;

	@Column
	private String					email;

	@Column
	private String					senha;

	public Usuario()
	{
	}

	public Usuario(final String nome, final String email, final String senha)
	{
		super();
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

}
