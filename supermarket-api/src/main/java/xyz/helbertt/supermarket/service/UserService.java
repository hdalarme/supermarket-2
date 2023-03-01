package xyz.helbertt.supermarket.service;

import java.util.List;

import xyz.helbertt.supermarket.dto.request.UserDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;
import xyz.helbertt.supermarket.model.User;

public interface UserService {

	List<UserDTO> getAll();
	
	MessageResponseDTO create(UserDTO user);
	
	MessageResponseDTO update(Long id, UserDTO user) throws SupermarketNotFoundException;
	
	void delete(Long id) throws SupermarketNotFoundException;
	
	User getById(Long id) throws SupermarketNotFoundException;
	
}