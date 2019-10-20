package com.bolsadeideas.springboot.di.app.models.services;

import org.springframework.stereotype.Service;

@Service("miServicioComplejo")
public class MiServicioComplejo implements IServicio{
	
	@Override
	public String operacion() {
		// TODO Auto-generated method stub
		return "Executing some important process...";
	}
	
	

}
