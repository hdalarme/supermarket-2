package xyz.helbertt.supermarket.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "establishments")
public class Establishment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private String address;
	
	@Column
	private String district;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
	@Column
	private String phone;
	
	@Column
	private Timestamp created_at;
	
	@Column
	private Timestamp updated_at;

	
	/**
	 * @param name
	 * @param address
	 * @param district
	 * @param city
	 * @param state
	 * @param phone
	 */
	public Establishment(String name, String address, String district, String city, String state, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.district = district;
		this.city = city;
		this.state = state;
		this.phone = phone;
	}
	
}
