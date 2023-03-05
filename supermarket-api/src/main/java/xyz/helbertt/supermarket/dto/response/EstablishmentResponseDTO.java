package xyz.helbertt.supermarket.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.helbertt.supermarket.model.Establishment;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstablishmentResponseDTO {

	private Long id;
	private String name;
	private String address;
	private String district;
	private String city;
	private String state;
	private String phone;

	public static EstablishmentResponseDTO transformToDTO(Establishment establishment) {
		return new EstablishmentResponseDTO(
		establishment.getId(),
		establishment.getName(),
		establishment.getAddress(),
		establishment.getDistrict(),
		establishment.getCity(),
		establishment.getState(),
		establishment.getPhone()
		);
	}
}
