package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.app.models.dao.IClientDao;
import com.bolsadeideas.springboot.app.models.entity.Client;

@Controller
@SessionAttributes(value = "client")
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

	@GetMapping("/form")
	public String createForm(Map<String, Object> model) {
		Client client = new Client();
		model.put("client", client);
		model.put("title", "Client form");

		return "form";
	}

	@PostMapping("/form")
	public String saveClient(@Valid Client client, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("title", "Client form");
			return "form";
		}
		clientDao.save(client);
		status.setComplete(); // Elimina el objeto "cliente" de la sesión
		return "redirect:list";
	}

	@GetMapping("/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Client client = null;
		if (id > 0) {
			client = clientDao.findOne(id);
		} else {
			return "redirect:list";
		}
		model.put("client", client);
		model.put("title", "Editar cliente");

		return "form";
	}

}
