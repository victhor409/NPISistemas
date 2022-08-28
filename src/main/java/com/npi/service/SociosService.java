package com.npi.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npi.dao.DependentesDao;
import com.npi.dao.SociosDao;
import com.npi.dto.DependentesDto;
import com.npi.dto.SociosDto;
import com.npi.entities.Dependentes;
import com.npi.entities.Socios;

@Service
public class SociosService {

	@Autowired
	private SociosDao dao;
	
	@Autowired
	private DependentesDao dependenteDao;
	
	@Transactional
	public List<Socios> findAll(){
		
		List<Socios> list = new ArrayList<>();
		list=dao.findAll();
		return list;
	}
	
	
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}
	
	
	
	
	@Transactional
	public SociosDto inserir(SociosDto dto) {
		
		Socios entity = new Socios();
		
		for(DependentesDto d : dto.getDependentes()) {
			Dependentes dependente = dependenteDao.getOne(d.getId());
			entity.getDependentes().add(dependente);
		}
		
		entity=dao.save(entity);
		
		
		
		return new SociosDto(entity);
	}
	
	@Transactional
	public Socios updateData(Integer id,Socios dto) {
		Socios entity = dao.getOne(id);
		Update(entity, dto);
		return dao.save(entity);
	}
	
	
	
	@Transactional
	public void Update(Socios entity, Socios dto) {
		entity.setId(dto.getId());
		entity.setAtivo(dto.getAtivo());
		entity.setNome(dto.getNome());
		entity.setRenda(dto.getRenda());
	}
	
	
	
	
	
	
	
	
	
}
