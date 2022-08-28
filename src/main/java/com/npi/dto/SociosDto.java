package com.npi.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.npi.entities.Socios;


public class SociosDto {

	
	private Integer id;
	
	
	private String nome;
	
	
	private BigDecimal renda;
	
	
	private boolean ativo;
	
	private List<DependentesDto> dependentes = new ArrayList<>();
	

	public SociosDto() {
		
	}

	public SociosDto(Integer id, String nome, BigDecimal renda, boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.renda = renda;
		this.ativo = ativo;
	}
	
	public SociosDto(Socios entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.renda = entity.getRenda();
		this.ativo = entity.getAtivo();
		this.dependentes = entity.getDependentes().stream().map(x-> new DependentesDto(x)).toList();
	}
	
	
	
	

	public List<DependentesDto> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<DependentesDto> dependentes) {
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
