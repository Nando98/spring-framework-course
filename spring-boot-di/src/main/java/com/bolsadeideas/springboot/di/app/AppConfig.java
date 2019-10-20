package com.bolsadeideas.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bolsadeideas.springboot.di.app.models.domain.ItemFactura;
import com.bolsadeideas.springboot.di.app.models.domain.Producto;
import com.bolsadeideas.springboot.di.app.models.services.IServicio;
import com.bolsadeideas.springboot.di.app.models.services.MiServicioNoInyectado;

@Configuration
public class AppConfig {

	// Retorna la interfaz y Servicio
	// De igual manera se puede utilizar anotaciones de Spring como @Primary
	
	@Bean("miServicioNoInyectado")
	public IServicio registrarMiServicioNoIyectado() {
		return new MiServicioNoInyectado();
	}
	
	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems() {
		Producto producto1 = new Producto("Camara Sony", 1234.00);
		Producto producto2 = new Producto("Celular", 2222.00);
		
		ItemFactura linea1 = new ItemFactura(producto1, 4);
		ItemFactura linea2 = new ItemFactura(producto2, 2);
		
		return Arrays.asList(linea1, linea2);
	}
	
	@Bean("itemsFacturaOficina")
	public List<ItemFactura> registrarItemsOficina() {
		Producto producto1 = new Producto("Monitor Sony", 2314.00);
		Producto producto2 = new Producto("Notebook", 3250.00);
		Producto producto3 = new Producto("Impresora", 500.00);
		Producto producto4 = new Producto("Otros", 222.00);
		
		ItemFactura linea1 = new ItemFactura(producto1, 5);
		ItemFactura linea2 = new ItemFactura(producto2, 8);
		ItemFactura linea3 = new ItemFactura(producto3, 10);
		ItemFactura linea4 = new ItemFactura(producto4, 22);
		
		return Arrays.asList(linea1, linea2, linea3, linea4);
	}
}
