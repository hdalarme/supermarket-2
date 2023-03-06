package xyz.helbertt.supermarket.model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "purchase_list_items")
public class PurchaseListItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="purchase_list_id", nullable = false)
	private PurchaseList purchaseList;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id", nullable = false)
	private Product product;
	
	@Column
	private Long amount;
	
	@OneToMany(mappedBy = "item")
	private List<Price> price;
	
	@Column
	private boolean done;
	
	@Column
	private Timestamp created_at;
	
	@Column
	private Timestamp updated_at;

	/**
	 * @param id
	 * @param purchaseList
	 * @param product
	 * @param amount
	 * @param done
	 */
	public PurchaseListItem(PurchaseList purchaseList, Product product, Long amount, boolean done) {
		this.purchaseList = purchaseList;
		this.product = product;
		this.amount = amount;
		this.done = done;
	}

	
	
}
