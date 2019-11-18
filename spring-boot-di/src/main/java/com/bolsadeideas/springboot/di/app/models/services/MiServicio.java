package com.bolsadeideas.springboot.di.app.models.services;

import org.springframework.stereotype.Service;

// @Primary // Determina que Componente se instancia por Defecto al se inyectado
@Service("miServicioSimple")
public class MiServicio implements IServicio{
	
	@Override
	public String operacion() {
		// TODO Auto-generated method stub
		return "Executing some simple process...";
	}
	
	

}
