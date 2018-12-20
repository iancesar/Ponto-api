package br.com.ponto.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the Expediente database table.
 * 
 */
@Entity
@NamedQuery(name="Expediente.findAll", query="SELECT e FROM Expediente e")
public class Expediente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int dia;

	private Time entrada;

	private byte habilitado;

	private Time retornoAlmoco;

	private Time saida;

	private Time saidaAlmoco;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuarioBean;

	public Expediente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDia() {
		return this.dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public Time getEntrada() {
		return this.entrada;
	}

	public void setEntrada(Time entrada) {
		this.entrada = entrada;
	}

	public byte getHabilitado() {
		return this.habilitado;
	}

	public void setHabilitado(byte habilitado) {
		this.habilitado = habilitado;
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

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}