package xyz.helbertt.supermarket.dto.request;

import java.math.BigDecimal;

import lombok.Data;
import xyz.helbertt.supermarket.model.Establishment;
import xyz.helbertt.supermarket.model.Price;
import xyz.helbertt.supermarket.model.Product;
import xyz.helbertt.supermarket.model.PurchaseListItem;
import xyz.helbertt.supermarket.model.User;

@Data
public class PriceDTO {
	private Long id;
	private BigDecimal price;
	private BigDecimal pricePromotional;
	private User user;
	private Product product;
	private Establishment establishment;
	private PurchaseListItem item;
	
	public Price transformToPrice() {
		return new Price(price, pricePromotional, user, product, establishment, item);
	}
}
