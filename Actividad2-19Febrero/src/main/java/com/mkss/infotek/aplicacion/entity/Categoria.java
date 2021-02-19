package com.mkss.infotek.aplicacion.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "categorias")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;
	
	@ToString.Exclude // esa coleccion la quiero excluir del metodo toString.. porque me lanza un lazy, pero no lo quiero que me hagan un lazy si no lo quiero.
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "categoria")
	private final Set<Producto> productos = new HashSet<>();
	
}
