package xyz.helbertt.supermarket.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.helbertt.supermarket.model.PurchaseList;
import xyz.helbertt.supermarket.model.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseListResponseDTO {

	private Long id;
	private String name;
	private User userId;
	
	public static PurchaseListResponseDTO transformToDTO(PurchaseList purchaseList) {
		return new PurchaseListResponseDTO(
			purchaseList.getId(),
			purchaseList.getName(),
			purchaseList.getUserId()
		);
	}
}
