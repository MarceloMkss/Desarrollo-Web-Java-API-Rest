package com.mkss.formacion.aplicacion;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mkss.formacion.aplicacion.entity.Categoria;
import com.mkss.formacion.aplicacion.entity.Producto;
import com.mkss.formacion.aplicacion.repository.CategoriaDao;
import com.mkss.formacion.aplicacion.repository.CategoriaRepository;
import com.mkss.formacion.aplicacion.repository.Dao;
import com.mkss.formacion.aplicacion.repository.ProductoRepository;

@SpringBootApplication
public class AplicacionApiRestSpringUnoAVariosApplication implements CommandLineRunner {
	
	@Autowired
	private Dao<Producto> daoProductos;

	@Autowired
	private CategoriaDao daoCategorias;

	@Autowired
	private ProductoRepository productos;

	@Autowired
	private CategoriaRepository categorias;
	

	public static void main(String[] args) {
		SpringApplication.run(AplicacionApiRestSpringUnoAVariosApplication.class, args);
	}
	
	
    // implementado con commandLineRunner
	@Override
	public void run(String... args) throws Exception {		
		
		
		System.out.println(daoProductos.obtenerPorId(2L));

		Categoria categoria = daoCategorias.obtenerPorIdConProductos(1L);

		System.out.println(categoria);

		for (Producto producto : categoria.getProductos()) {
			System.out.println(producto);
		}
		// inicializarDatos(); // lo usare para trabajar con JPA

	    // mostrarDatos(); // lo usare para trabajar con JPA
		
	}
	
	@Transactional
	private void mostrarDatos() {
		System.out.println(productos.findById(2L).orElse(null));

		Categoria categoria = categorias.findById(1L).orElse(null); // orElse es para quitar lo de optional, asi le digo que sea null o no me trae lo que he pedido

		System.out.println(categoria);

		for (Producto producto : categoria.getProductos()) {
			System.out.println(producto);
		}
	}

	@Transactional
	private void inicializarDatos() {
		Categoria informatica = new Categoria(null, "Informática", "Electronica");

		Producto monitor = new Producto(null, "Monitor", new BigDecimal("123.45"), informatica);
		Producto raton = new Producto(null, "Ratón", new BigDecimal("12.34"), informatica);

		categorias.save(informatica);

		productos.save(monitor);
		productos.save(raton);
	}

}
