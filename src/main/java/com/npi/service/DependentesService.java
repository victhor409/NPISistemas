package com.npi.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npi.dao.DependentesDao;
import com.npi.dao.SociosDao;
import com.npi.dto.DependentesDto;
import com.npi.entities.Dependentes;
import com.npi.entities.Socios;

@Service
public class DependentesService {

	@Autowired
	private DependentesDao dao;
	
	@Autowired
	private SociosDao sociosDao;
	
	@Transactional
	public List<Dependentes> findAll(){
		
		List<Dependentes> list = new ArrayList<>();
		list=dao.findAll();
		return list;
	}
	
	
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}
	
	
	
	
	@Transactional
	public DependentesDto inserir(DependentesDto dto) {
		
		Dependentes entity = new Dependentes();
		
		entity.setId(dto.getId());
		entity.setIdade(dto.getIdade());
		entity.setNome(dto.getNome());
		
		
		Socios socio = sociosDao.getOne(dto.getSocio_id());
		entity.setSocio_id(socio);
		
		dao.save(entity);
		
		
		
		return dto;
	}
	
	@Transactional
	public Dependentes updateData(Integer id,Dependentes dto) {
		Dependentes entity = dao.getOne(id);
		Update(entity, dto);
		return dao.save(entity);
	}
	
	
	
	@Transactional
	public void Update(Dependentes entity, Dependentes dto) {
		entity.setId(dto.getId());
		entity.setIdade(dto.getIdade());
		entity.setNome(dto.getNome());
		
		Socios socio = sociosDao.getOne(dto.getId());
		entity.setSocio_id(socio);
	}
	
	
	
	
	
	
	
	
	
}
