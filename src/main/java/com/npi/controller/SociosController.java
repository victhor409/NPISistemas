package com.npi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.npi.dao.SociosDao;

import com.npi.entities.Socios;


@Controller
public class SociosController {

	
	@Autowired
	private SociosDao dao;
	
	
	
	
	
	
	/*@PostMapping
	public ResponseEntity inserir(@RequestBody SociosDto dto) {
		SociosDto newDto = service.inserir(dto);
		return ResponseEntity.ok().body(newDto); 
	}
	
	 @PostMapping("/add")
	public String insert(@Validated SociosDto dto, BindingResult result) {
		
		  if (result.hasFieldErrors()) {
	            return "redirect:/form";
	        }

		  SociosDto newDto = service.inserir(dto);

	        return "redirect:/home";
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity <Void> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity <List<Socios>> findAll(){
		List<Socios> list=service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity update (@PathVariable Integer id, @RequestBody Socios obj) {
		obj = service.updateData(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	*/
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	 // Acessa o formulario
    @GetMapping("/form")
    public String SociosForm(Socios Socios) {
    	
        return "addSocio";
    }

    // Adiciona novo Socios
    @PostMapping("/add")
    public String novo(  Socios Socios, BindingResult result) {

        if (result.hasFieldErrors()) {
            return "redirect:/form";
        }

        dao.save(Socios);

        return "redirect:/home";
    }

    // Acessa o formulario de edição
    @GetMapping("form/{id}")
    public String updateForm(Model model, @PathVariable(name = "id") Integer id) {

       // Socios Socios = dao.findById(id)
         //       .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
       
    	Optional<Socios> socio = dao.findById(id);
    	
        model.addAttribute("socio", socio.get());
        return "AtualizaForm";
    }

    // Atualiza Socios
    @PostMapping("update/{id}")
    public String alterar( Socios Socios, BindingResult result, @PathVariable Integer id) {

        if (result.hasErrors()) {
            return "redirect:/form";
        }
        
        dao.save(Socios);
        return "redirect:/home";
    }

    @GetMapping("delete/{id}")
    @CacheEvict(value = "Socios", allEntries = true)
    public String delete(@PathVariable(name = "id") int id, Model model) {

        Socios Socios = dao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        
        dao.delete(Socios);
        return "redirect:/home";
    }
	
    @GetMapping("/socio")
    public String home(Model model) {
    	List<Socios> socios = dao.findAll();
        model.addAttribute("socios", socios);
        return "TabelaSocio";
    }
	
	
}
