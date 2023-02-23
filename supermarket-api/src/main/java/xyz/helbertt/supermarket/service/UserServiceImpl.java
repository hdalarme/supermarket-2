package xyz.helbertt.supermarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import xyz.helbertt.supermarket.dto.UserDTO;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;
import xyz.helbertt.supermarket.model.User;
import xyz.helbertt.supermarket.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private final UserRepository repository;
	
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<User> getAll() {
		return repository.findAll();
	}

	@Override
	public User create(User user) {
		return repository.save(user);
	}

	@Override
	public User update(Long id, User userRequest) throws SupermarketNotFoundException {
		User user = repository.findById(id)
				.orElseThrow(() -> new SupermarketNotFoundException ("User", id));
		return repository.save(user);
	}

	@Override
	public void delete(Long id) throws SupermarketNotFoundException {
		User user = repository.findById(id)
				.orElseThrow(() -> new SupermarketNotFoundException ("User", id));
		
		repository.delete(user);
		
	}

	@Override
	public User getById(Long id) throws SupermarketNotFoundException {
		Optional<User> result = repository.findById(id);
		if(result.isPresent()) {
			return result.get();
		} else {
			throw new SupermarketNotFoundException ("User", id);
		}
	}

}
