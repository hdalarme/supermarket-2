package xyz.helbertt.supermarket.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import xyz.helbertt.supermarket.dto.request.UserDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;
import xyz.helbertt.supermarket.model.User;
import xyz.helbertt.supermarket.repository.UserRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

	private ModelMapper modelmapper;
	
	private final UserRepository repository;
	
	/*public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}*/
	
	@Override
	public List<UserDTO> getAll() {
		//return repository.findAll();
		return repository.findAll().stream().map(user -> modelmapper.map(user, UserDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public MessageResponseDTO create(UserDTO user) {
		User userToSave = user.transformToUser(); 
		
		User savedUser = repository.save(userToSave);
		
		return createMessageResponse(savedUser.getId(), "Created user with ID ");
		
	}

	@Override
	public MessageResponseDTO update(Long id, UserDTO userRequest) throws SupermarketNotFoundException {
		User user = verifyIfExists(id);
		
		User userToUpdate = userRequest.transformToUser();
		
		userToUpdate.setId(id);
		
		if (user.getEmail().equals(userToUpdate.getEmail()) && user.getId() != userToUpdate.getId()) {			
			return createMessageResponse(user.getId(), "A user with the informad email already exists in the system.");
		}
		
		User updatedUser = repository.save(userToUpdate);
		
		return createMessageResponse(updatedUser.getId(), "Updated user with ID ");
	}

	@Override
	public void delete(Long id) throws SupermarketNotFoundException {
		User user = verifyIfExists(id);
		
		repository.delete(user);
		
	}

	@Override
	public User getById(Long id) throws SupermarketNotFoundException {
		User user = verifyIfExists(id);
		
		return user;
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
