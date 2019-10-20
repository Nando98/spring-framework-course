package com.bolsadeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	// forward -> solo es utilizado para las rutas de los controladores

	@GetMapping({"", "/"})
	public String home() {
		return "redirect:/app/index";
	}
}
