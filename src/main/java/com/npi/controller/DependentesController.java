package com.npi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.npi.dao.DependentesDao;
import com.npi.dao.DependentesDao;
import com.npi.entities.Dependentes;
import com.npi.entities.Socios;


@Controller
public class DependentesController {

	
	
	@Autowired
	private DependentesDao dao;
	
	@Autowired
	private DependentesDao socioDao;
	
	
	/*
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
	
	*/
	
	 // Acessa o formulario
    @GetMapping("/Dependentes/formDependentes")
    public String DependentesForm(Dependentes Dependentes) {
    	
        return "Dependentes/addDependentes";
    }

    // Adiciona novo Dependentes
    @PostMapping("/Dependentes/novoDependente")
    public String novo( Dependentes Dependentes, BindingResult result) {

        if (result.hasFieldErrors()) {
            return "redirect:Dependentes/formDependentes";
        }

        dao.save(Dependentes);

        return "redirect:/home";
    }

    // Acessa o formulario de edição
    @GetMapping("formDependentes/{id}")
    public String updateForm(Model model, @PathVariable(name = "id") Integer id) {

        Dependentes Dependentes = dao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
       
        model.addAttribute("Dependentes", Dependentes);
        return "AtualizaForm";
    }

    // Atualiza Dependentes
    @PostMapping("updateDependentes/{id}")
    public String alterarProduto( Dependentes Dependentes, BindingResult result, @PathVariable Integer id) {

        if (result.hasErrors()) {
            return "redirect:/form";
        }
        
        dao.save(Dependentes);
        return "redirect:/home";
    }

    @GetMapping("deleteDependentes/{id}")
    @CacheEvict(value = "Dependentes", allEntries = true)
    public String delete(@PathVariable(name = "id") int id, Model model) {

        Dependentes Dependentes = dao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        
        dao.delete(Dependentes);
        return "redirect:/home";
    }
    
    @GetMapping("Dependentes/dependentes")
    public String findAll(Model model) {
    	List<Dependentes> dependentes = dao.findAll();
        model.addAttribute("dependentes", dependentes);
        return "Dependentes/TabelaDependentes";
    }
	
}
