package xyz.helbertt.supermarket.dto.request;

import lombok.Data;
import xyz.helbertt.supermarket.enums.UnidadeMedida;
import xyz.helbertt.supermarket.model.Product;

@Data
public class ProductDTO {
	private Long id;
	private String name;
	private String description;
	private UnidadeMedida unidade;
	private String peso;
	private String codigoBarra;
	private Long productParent;
	
	public Product transformToProduct() {
		return new Product(name, description, unidade);
	}
}
