package com.bolsadeideas.springboot.web.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.model.Usuario;

@Controller
@RequestMapping("/app") // Ruta de primer nivel - Mapeando método controller
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoLista;

	// Para pasar datos a la vista se puede utilizar - Mapeando método Handler
	/*
	 * Model, ModelMap, ModelAndView
	 * 
	 * El más utilizado es el Model (is Interface)
	 */

	@GetMapping({ "/index", "/", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}

	@GetMapping("/profile")	
	public String profile(Model model) {
		Usuario user = new Usuario();
		user.setName("Fernando");
		user.setLastName("Muñoz");
		user.setEmail("fer.munoz.alvarez@gmail.com");

		model.addAttribute("user", user);
		model.addAttribute("titulo", textoPerfil.concat(user.getName()));

		return "profile";
	}

	@GetMapping("/list")
	public String list(Model model) {
		// Manera convencional para agregar elementos a un array
		List<Usuario> userList = new ArrayList<Usuario>();

		userList.add(new Usuario("Fernando", "Muñoz", "fer.munoz.alvarez@gmail.com"));
		userList.add(new Usuario("Mathias", "Muñoz", "mathiaskit@gmail.com"));
		userList.add(new Usuario("Papu", "Gomez", "elpapugomez@gmail.com"));

		model.addAttribute("titulo", textoLista);
		model.addAttribute("users_2", userList);

		return "list";
	}
	
	// Con "ModelAttribute" podemos pasar datos a la vista, separado de un Handler
	// Su uso es para todo el Controller
	@ModelAttribute("users")
	public List<Usuario> cargarUsuarios() {
		// Otra manera de agregar elementos a un array
		List<Usuario> userOtherList = Arrays.asList(new Usuario("Fernando", "Muñoz", "fer.munoz.alvarez@gmail.com"),
				new Usuario("Mathias", "Muñoz", "mathiaskit@gmail.com"),
				new Usuario("Papu", "Gomez", "elpapugomez@gmail.com"));
		return userOtherList;
	}

}
