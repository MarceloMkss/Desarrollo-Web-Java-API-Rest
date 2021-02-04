package com.mkss.formacion.aplicacion.repository;

import com.mkss.formacion.aplicacion.entity.Categoria;

public interface CategoriaDao extends Dao<Categoria> {

	Categoria obtenerPorIdConProductos(Long id);
	
}
