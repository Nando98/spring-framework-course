package com.bolsadeideas.springboot.di.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.services.IServicio;

@Controller
public class IndexController {
	
	@Autowired
	@Qualifier("miServicioNoInyectado") // @Qualifier ayuda a inyectar un Componente en especifico, que no sea primario
	private IServicio servicio;
	
	
	@GetMapping({"", "/", "index"})
	public String index(Model model) {
		model.addAttribute("objeto", servicio.operacion());
		return "index";
	}
	
	//@Autowired
	//public IndexController(IServicio servicio) {
	//	super();
	//	this.servicio = servicio;
	//}

	//@Autowired
	//public void setServicio(IServicio servicio) {
	//	this.servicio = servicio;
	//}

}
