package br.com.ponto.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the Marcacao database table.
 * 
 */
@Entity
@NamedQuery(name="Marcacao.findAll", query="SELECT m FROM Marcacao m")
public class Marcacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date data;

	private Time entrada;

	private Time retornoAlmoco;

	private Time saida;

	private Time saidaAlmoco;

	private Time saldoDia;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuarioBean;

	public Marcacao() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getEntrada() {
		return this.entrada;
	}

	public void setEntrada(Time entrada) {
		this.entrada = entrada;
	}

	public Time getRetornoAlmoco() {
		return this.retornoAlmoco;
	}

	public void setRetornoAlmoco(Time retornoAlmoco) {
		this.retornoAlmoco = retornoAlmoco;
	}

	public Time getSaida() {
		return this.saida;
	}

	public void setSaida(Time saida) {
		this.saida = saida;
	}

	public Time getSaidaAlmoco() {
		return this.saidaAlmoco;
	}

	public void setSaidaAlmoco(Time saidaAlmoco) {
		this.saidaAlmoco = saidaAlmoco;
	}

	public Time getSaldoDia() {
		return this.saldoDia;
	}

	public void setSaldoDia(Time saldoDia) {
		this.saldoDia = saldoDia;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}