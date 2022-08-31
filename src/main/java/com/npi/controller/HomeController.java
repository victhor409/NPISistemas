package com.npi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.npi.dao.SociosDao;
import com.npi.entities.Socios;

@Controller
public class HomeController {
	
	@Autowired
	private SociosDao dao;

	@GetMapping("/home")
    public String home(Model model) {
    	List<Socios> socios = dao.findAll();
        model.addAttribute("socios", socios);
        return "home";
    }
	
}
