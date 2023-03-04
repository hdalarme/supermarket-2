package xyz.helbertt.supermarket.controller;

import java.util.List;

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
import xyz.helbertt.supermarket.dto.request.UserDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.dto.response.UserResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketAlreadyRegisteredException;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;
import xyz.helbertt.supermarket.service.UserService;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
	
	private UserService service;
	
	@GetMapping
	public List<UserResponseDTO> getAll() {
		return service.getAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody UserDTO userDTO) throws SupermarketAlreadyRegisteredException {
		return  service.create(userDTO); 
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO update(@PathVariable Long id, @RequestBody UserDTO userDTO) throws SupermarketNotFoundException, SupermarketAlreadyRegisteredException {
		return service.update(id, userDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public MessageResponseDTO delete(@PathVariable Long id) throws SupermarketNotFoundException {
		return service.delete(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDTO> getById(@PathVariable Long id) throws SupermarketNotFoundException {
		
		UserResponseDTO user = service.getById(id);
		
		// convert entity to DTO
		//UserResponseDTO userResponse = modelmapper.map(user, UserResponseDTO.class);
		
		return ResponseEntity.ok().body(user);
	}
	
}
