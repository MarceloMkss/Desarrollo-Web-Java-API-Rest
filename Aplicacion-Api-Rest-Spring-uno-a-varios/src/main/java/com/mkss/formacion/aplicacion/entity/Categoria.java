package com.mkss.formacion.aplicacion.entity;

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
@Data // me crea los metodos: get, set, hashcod y tostring
@AllArgsConstructor // me crea un constructor
@NoArgsConstructor // me crea un constructor vacio
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;

	@ToString.Exclude // esa coleccion la quiero excluir del metodo toString.. porque me lanza un lazy, pero no lo quiero que me hagan un lazy si no lo quiero.
	@EqualsAndHashCode.Exclude // excluyo tambien los hashcode de lombok
	@OneToMany(mappedBy = "categoria") // , fetch = FetchType.LAZY) // cuando es LAZY me trae todo solo los datos categoria, caso quiera pedir el producto tengo que poner un GetProductos
	private final Set<Producto> productos = new HashSet<>();

}
