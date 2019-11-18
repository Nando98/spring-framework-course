package com.bolsadeideas.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.app.models.dao.IClientDao;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private IClientDao clientDao;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("title", "Listado de clientes");
		model.addAttribute("clients", clientDao.findAll());
		return "list";
	}
}
