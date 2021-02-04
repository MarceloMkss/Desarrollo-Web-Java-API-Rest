package com.mkss.formacion.aplicacion.repository;

import org.springframework.data.repository.CrudRepository;

import com.mkss.formacion.aplicacion.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
