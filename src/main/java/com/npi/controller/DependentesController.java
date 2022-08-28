package com.npi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.npi.dto.DependentesDto;
import com.npi.entities.Dependentes;
import com.npi.service.DependentesService;

@Controller
@RequestMapping(value="/dependente")
public class DependentesController {

	@Autowired
	private DependentesService service;
	
	@PostMapping
	public ResponseEntity inserir(@RequestBody DependentesDto dto) {
		DependentesDto newDto = service.inserir(dto);
		return ResponseEntity.ok().body(newDto); 
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity <Void> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity <List<Dependentes>> findAll(){
		List<Dependentes> list=service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity update (@PathVariable Integer id, @RequestBody Dependentes obj) {
		obj = service.updateData(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
}
