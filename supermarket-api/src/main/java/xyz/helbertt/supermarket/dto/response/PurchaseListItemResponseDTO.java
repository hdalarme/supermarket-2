package xyz.helbertt.supermarket.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.helbertt.supermarket.model.Product;
import xyz.helbertt.supermarket.model.PurchaseList;
import xyz.helbertt.supermarket.model.PurchaseListItem;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseListItemResponseDTO {

	private Long id;
	private PurchaseList purchaseList;
	private Product product;
	private Long amount;
	private boolean done;
	
	public static PurchaseListItemResponseDTO transformToDTO(PurchaseListItem purchaseListItem) {
		return new PurchaseListItemResponseDTO(
				purchaseListItem.getId(),
				purchaseListItem.getPurchaseList(),
				purchaseListItem.getProduct(),
				purchaseListItem.getAmount(),
				purchaseListItem.isDone()
			);
	}
	
}
