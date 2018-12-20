package br.com.ponto.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the Usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;

	private String nome;

	private Time saldoInicial;

	private String senha;

	//bi-directional many-to-one association to Expediente
	@OneToMany(mappedBy="usuarioBean")
	private List<Expediente> expedientes;

	//bi-directional many-to-one association to Marcacao
	@OneToMany(mappedBy="usuarioBean")
	private List<Marcacao> marcacaos;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Time getSaldoInicial() {
		return this.saldoInicial;
	}

	public void setSaldoInicial(Time saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Expediente> getExpedientes() {
		return this.expedientes;
	}

	public void setExpedientes(List<Expediente> expedientes) {
		this.expedientes = expedientes;
	}

	public Expediente addExpediente(Expediente expediente) {
		getExpedientes().add(expediente);
		expediente.setUsuarioBean(this);

		return expediente;
	}

	public Expediente removeExpediente(Expediente expediente) {
		getExpedientes().remove(expediente);
		expediente.setUsuarioBean(null);

		return expediente;
	}

	public List<Marcacao> getMarcacaos() {
		return this.marcacaos;
	}

	public void setMarcacaos(List<Marcacao> marcacaos) {
		this.marcacaos = marcacaos;
	}

	public Marcacao addMarcacao(Marcacao marcacao) {
		getMarcacaos().add(marcacao);
		marcacao.setUsuarioBean(this);

		return marcacao;
	}

	public Marcacao removeMarcacao(Marcacao marcacao) {
		getMarcacaos().remove(marcacao);
		marcacao.setUsuarioBean(null);

		return marcacao;
	}

}