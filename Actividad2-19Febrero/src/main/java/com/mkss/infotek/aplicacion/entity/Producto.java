package com.mkss.infotek.aplicacion.entity;

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
	
	@ManyToOne
	@JoinColumn(name = "categorias_id")
	private Categoria categoria;
}
