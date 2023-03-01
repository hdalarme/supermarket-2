package xyz.helbertt.supermarket.dto.request;

import lombok.Data;
import xyz.helbertt.supermarket.model.User;

@Data
public class UserDTO {

	private Long id;
	private String name; 
	private String email;
	private String password;
	
	public User transformToUser() {
		return new User(name, email, password);
	}
	
}
