package xyz.helbertt.supermarket.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import xyz.helbertt.supermarket.model.User;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
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
	
}
