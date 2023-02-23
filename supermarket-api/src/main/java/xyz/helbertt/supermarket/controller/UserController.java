package xyz.helbertt.supermarket.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import xyz.helbertt.supermarket.dto.UserDTO;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;
import xyz.helbertt.supermarket.model.User;
import xyz.helbertt.supermarket.service.UserService;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {

	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public List<UserDTO> getAll() {
		return service.getAll().stream().map(user -> modelmapper.map(user, UserDTO.class))
				.collect(Collectors.toList());
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
		
		// convert DTO to Entity
		//User userRequest = modelmapper.map(userDTO, User.class);
		User userRequest = modelmapper.map(userDTO, User.class);
		
		User user = service.create(userRequest);
		
		// convert entity to DTO
		UserDTO userResponse = modelmapper.map(user, UserDTO.class);
		
		return new ResponseEntity<UserDTO>(userResponse, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO userDTO) throws SupermarketNotFoundException {
		
		// convert DTO to Entity
		User userRequest = modelmapper.map(userDTO, User.class);
		
		User user = service.update(id, userRequest);
		
		// convert entity to DTO
		UserDTO userResponse = modelmapper.map(user, UserDTO.class);
		
		return ResponseEntity.ok().body(userResponse);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws SupermarketNotFoundException {
		service.delete(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getById(@PathVariable Long id) throws SupermarketNotFoundException {
		
		User user = service.getById(id);
		
		// convert entity to DTO
		UserDTO userResponse = modelmapper.map(user, UserDTO.class);
		
		return ResponseEntity.ok().body(userResponse);
	}
	
}
