package com.npi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_dependentes")
public class Dependentes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private Integer idade;

	@ManyToOne
	@JoinColumn(name="socio_id")
	private Socios socio_id;
	
	public Dependentes() {
		
	}

	public Dependentes(Integer id, String nome, Integer idade, Socios socio_id) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.socio_id = socio_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Socios getSocio_id() {
		return socio_id;
	}

	public void setSocio_id(Socios socio_id) {
		this.socio_id = socio_id;
	}

}
