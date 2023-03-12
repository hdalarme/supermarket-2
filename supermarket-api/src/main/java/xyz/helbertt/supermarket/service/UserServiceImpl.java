package xyz.helbertt.supermarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import xyz.helbertt.supermarket.dto.request.UserDTO;
import xyz.helbertt.supermarket.dto.response.UserResponseDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketAlreadyRegisteredException;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;
import xyz.helbertt.supermarket.model.User;
import xyz.helbertt.supermarket.repository.UserRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

	private PasswordEncoder encoder;
	
	private ModelMapper modelmapper;
	
	private final UserRepository repository;
	
	/*public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}*/
	
	@Override
	public List<UserResponseDTO> getAll() {
		return repository.findAll().stream().map(user -> modelmapper.map(user, UserResponseDTO.class))
				.collect(Collectors.toList());
		
	}

	@Override
	public MessageResponseDTO create(UserDTO user) throws SupermarketAlreadyRegisteredException {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		Optional<User> userFind = repository.findByEmail(user.getEmail());
				
		if (userFind.isPresent()) {
			throw new SupermarketAlreadyRegisteredException("User", user.getEmail());
		}
		
		User userToSave = user.transformToUser(); 
		
		User savedUser = repository.save(userToSave);
		
		return createMessageResponse(savedUser.getId(), "Created user with ID ");
		
	}

	@Override
	public MessageResponseDTO update(Long id, UserDTO userRequest) throws SupermarketNotFoundException, SupermarketAlreadyRegisteredException {
		User user = verifyIfExists(id);
		
		userRequest.setPassword(encoder.encode(userRequest.getPassword()));
		
		User userToUpdate = userRequest.transformToUser();
		
		userToUpdate.setId(id);
		
		if (user.getEmail().equals(userToUpdate.getEmail()) && user.getId() != id) {			
			throw new SupermarketAlreadyRegisteredException("User", userToUpdate.getEmail());
		}
		
		User updatedUser = repository.save(userToUpdate);
		
		return createMessageResponse(updatedUser.getId(), "Updated user with ID ");
	}

	@Override
	public MessageResponseDTO delete(Long id) throws SupermarketNotFoundException {
		User user = verifyIfExists(id);
		
		repository.delete(user);
		
		return createMessageResponse(id, "Deleted user with ID ");
		
	}

	@Override
	public UserResponseDTO getById(Long id) throws SupermarketNotFoundException {
		User user = verifyIfExists(id);
		
		UserResponseDTO userResponse  = UserResponseDTO.transformToDTO(user);
		
		return userResponse; 
	}
	
	private User verifyIfExists(Long id) throws SupermarketNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new SupermarketNotFoundException ("User", id));
	}
	
	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message + id)
				.build();
	}

}
