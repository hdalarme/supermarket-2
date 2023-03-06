package xyz.helbertt.supermarket.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.helbertt.supermarket.enums.UnidadeMedida;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private UnidadeMedida unidade;
	
	@Column
	private String peso;
	
	@Column
	private String codigoBarra;
	
	@Column
	private Long productParent;
	
	@Column
	private Timestamp created_at;
	
	@Column
	private Timestamp updated_at;

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param unidade
	 */
	public Product(String name, String description, UnidadeMedida unidade) {
		this.name = name;
		this.description = description;
		this.unidade = unidade;
	}
	
	/**
	 * @param name
	 * @param description
	 * @param unidade
	 * @param productParent
	 */
	public Product(String name, String description, UnidadeMedida unidade, Long productParent) {
		this.name = name;
		this.description = description;
		this.unidade = unidade;
		this.productParent = productParent;
	}
	
	
	

}
