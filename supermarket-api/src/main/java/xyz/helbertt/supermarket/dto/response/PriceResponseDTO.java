package xyz.helbertt.supermarket.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.helbertt.supermarket.model.Establishment;
import xyz.helbertt.supermarket.model.Price;
import xyz.helbertt.supermarket.model.Product;
import xyz.helbertt.supermarket.model.PurchaseListItem;
import xyz.helbertt.supermarket.model.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceResponseDTO {
	public Long id;
	public BigDecimal price;
	public BigDecimal pricePromotional;
	public User user;
	public Product product;
	public Establishment establishment;
	public PurchaseListItem item;
	
	public static PriceResponseDTO transformToDTO(Price price) {
		return new PriceResponseDTO(
			price.getId(),
			price.getPrice(),
			price.getPricePromotional(),
			price.getUser(),
			price.getProduct(),
			price.getEstablishment(),
			price.getItem()
		);
	}
}
