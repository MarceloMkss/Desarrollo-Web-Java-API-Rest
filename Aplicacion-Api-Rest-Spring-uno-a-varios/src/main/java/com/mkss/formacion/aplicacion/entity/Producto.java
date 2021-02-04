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
	private BigDecimal precio;
	
	@ManyToOne //(fetch = FetchType.EAGER)
	private Categoria categoria;
}
