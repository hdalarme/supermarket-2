package xyz.helbertt.supermarket.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prices")
public class Price {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private BigDecimal price;
	
	@Column
	private BigDecimal pricePromotional;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", nullable = false)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id", nullable = false)
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="establishment_id", nullable = false)
	private Establishment establishment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="purchase_list_id", nullable = false)
	private PurchaseListItem item;
	
	@Column
	private Timestamp created_at;
	
	@Column
	private Timestamp updated_at;

	/**
	 * @param price
	 * @param pricePromotional
	 * @param user
	 * @param product
	 * @param establishment
	 * @param item
	 */
	public Price(BigDecimal price, BigDecimal pricePromotional, User user, Product product, Establishment establishment,
			PurchaseListItem item) {
		super();
		this.price = price;
		this.pricePromotional = pricePromotional;
		this.user = user;
		this.product = product;
		this.establishment = establishment;
		this.item = item;
	}
	
	
}
