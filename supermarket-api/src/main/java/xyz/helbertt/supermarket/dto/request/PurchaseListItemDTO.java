package xyz.helbertt.supermarket.dto.request;

import lombok.Data;
import xyz.helbertt.supermarket.model.Product;
import xyz.helbertt.supermarket.model.PurchaseList;
import xyz.helbertt.supermarket.model.PurchaseListItem;

@Data
public class PurchaseListItemDTO {

	private Long id;
	private PurchaseList purchaseList;
	private Product product;
	private Long amount;
	private boolean done;
	
	public PurchaseListItem transformToPurchaseListItem() {
		return new PurchaseListItem(purchaseList, product, amount, done);
	}
	
}
