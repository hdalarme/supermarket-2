package xyz.helbertt.supermarket.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.helbertt.supermarket.enums.UnidadeMedida;
import xyz.helbertt.supermarket.model.Product;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponseDTO {
	private Long id;
	private String name;
	private String description;
	private UnidadeMedida unidade;
	private String peso;
	private String codigoBarra;
	private Long productParent;
	
	public static ProductResponseDTO transformToDTO(Product product) {
		return new ProductResponseDTO(
				product.getId(),
				product.getName(),
				product.getDescription(),
				product.getUnidade(),
				product.getPeso(),
				product.getCodigoBarra(),
				product.getProductParent()
		);
	}
}
