package xyz.helbertt.supermarket.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import xyz.helbertt.supermarket.model.User;

@AllArgsConstructor//(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class UserResponseDTO {

	private Long id;
	private String name; 
	private String email;
	
	public static UserResponseDTO transformToDTO(User user) {
		return new UserResponseDTO(
			user.getId(),
			user.getName(),
			user.getEmail()
		);
	}
	
	public User transformToUser() {
		return new User(id, name, email);
	}
	
}
