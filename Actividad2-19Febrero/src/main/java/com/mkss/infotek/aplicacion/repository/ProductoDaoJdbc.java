package com.mkss.infotek.aplicacion.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mkss.infotek.aplicacion.entity.Categoria;
import com.mkss.infotek.aplicacion.entity.Producto;

@Repository
public class ProductoDaoJdbc implements Dao<Producto> {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Iterable<Producto> obtenerTodos() {
		
		return jdbcTemplate.query("select p.id, p.nombre, p.precio, c.id, c.nombre, c.descripcion from productos p\r\n"
				+ "left join categorias c\r\n"
				+ "on p.categorias_id = c.id\r\n"
				+ "where p.categorias_id = c.id;", (rs, rowNum) ->  new Producto(rs.getLong("p.id"), rs.getString("p.nombre"), rs.getBigDecimal("p.precio"),
						new Categoria(rs.getLong("c.id"), rs.getString("c.nombre"), rs.getString("c.descripcion"))));
	}

	

	
	

}
