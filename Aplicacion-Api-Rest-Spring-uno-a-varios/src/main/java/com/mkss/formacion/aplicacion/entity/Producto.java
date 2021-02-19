package com.mkss.formacion.aplicacion.entity;

import java.math.BigDecimal;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;
	private BigDecimal precio;
	
	@ManyToOne //(fetch = FetchType.EAGER) // cuando es EAGER me trae todo los datos de producto y categoria
	private Categoria categoria;
}
