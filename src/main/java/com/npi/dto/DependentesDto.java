package com.npi.dto;



import com.npi.entities.Dependentes;
import com.npi.entities.Socios;

public class DependentesDto {

	
	
	private Integer id;
	private String nome;
	private Integer idade;
	
	
	private Socios socio_id;
	
	
	public DependentesDto() {
		
	}
	
	
	public DependentesDto(Integer id, String nome, Integer idade, Socios socio_id) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.socio_id = socio_id;
	}
	
	
	public DependentesDto(Dependentes entity) {
		
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.idade = entity.getIdade();
		this.socio_id = entity.getSocio_id();
		
		
		
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
