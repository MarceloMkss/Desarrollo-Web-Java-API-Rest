package com.mkss.infotek.aplicacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkss.infotek.aplicacion.entity.Producto;
import com.mkss.infotek.aplicacion.repository.Dao;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private Dao<Producto> productoDao;
	
	@GetMapping("productos")
	public Iterable<Producto> get() {
		return productoDao.obtenerTodos();
		
	}	

	
	

}


