package xyz.helbertt.supermarket.dto.request;

import lombok.Data;
import xyz.helbertt.supermarket.model.PurchaseList;
import xyz.helbertt.supermarket.model.User;

@Data
public class PurchaseListDTO {

	private Long id;
	private String name;
	private User user;
	
	public PurchaseList transformToPurchaseList() {
		return new PurchaseList(name, user);
	}
	
}
