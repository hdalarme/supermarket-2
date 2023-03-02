package xyz.helbertt.supermarket.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true) 
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "userId")
	private List<PurchaseList> purchaseLists;

	/**
	 * @param name
	 * @param email
	 * @param password
	 */
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	/**
	 * @param id
	 * @param name
	 * @param email
	 */
	public User(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
}
