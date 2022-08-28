package com.npi.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_socio")
public class Socios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="renda")
	private BigDecimal renda;
	
	@Column(name="ativo")
	private boolean ativo;
	
	@OneToMany(mappedBy="socio_id")
	private List<Dependentes> dependentes = new ArrayList<>();
	
	
	
	
	public Socios() {
		
	}

	public Socios(Integer id, String nome, BigDecimal renda, boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.renda = renda;
		this.ativo = ativo;
	}
	

	public List<Dependentes> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependentes> dependentes) {
		this.dependentes = dependentes;
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

	public BigDecimal getRenda() {
		return renda;
	}

	public void setRenda(BigDecimal renda) {
		this.renda = renda;
	}

	public boolean isAtivo() {
		return ativo;
	}
	
	public boolean getAtivo() {
		return ativo;
	}
	
	

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
	
	
	
}
