package com.mkss.formacion.aplicacion.repository;

public interface Dao<T> {	
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
}
