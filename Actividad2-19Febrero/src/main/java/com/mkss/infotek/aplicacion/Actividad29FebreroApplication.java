package com.mkss.infotek.aplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mkss.infotek.aplicacion.entity.Producto;
import com.mkss.infotek.aplicacion.repository.Dao;

import lombok.extern.java.Log;


@Log
@SpringBootApplication
public class Actividad29FebreroApplication implements CommandLineRunner {

	@Autowired
	private Dao<Producto> productoDao;
	
	

	public static void main(String[] args) {
		SpringApplication.run(Actividad29FebreroApplication.class, args);
	}
	
   
	@Override
	public void run(String... args) throws Exception {	
		

		for (Producto productos : productoDao.obtenerTodos()) {
			
			log.info(productos.toString());
			
		}
		
	}

}
