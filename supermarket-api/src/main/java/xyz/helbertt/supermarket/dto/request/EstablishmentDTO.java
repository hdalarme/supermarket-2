package xyz.helbertt.supermarket.dto.request;

import lombok.Data;
import xyz.helbertt.supermarket.model.Establishment;

@Data
public class EstablishmentDTO {

	private Long id;
	private String name;
	private String address;
	private String district;
	private String city;
	private String state;
	private String phone;
	

	public Establishment transformtoEstablishment() {
		return new Establishment(name, address, district, city, state, phone); 
	}
	
}
