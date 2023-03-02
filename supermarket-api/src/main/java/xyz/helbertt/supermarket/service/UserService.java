package xyz.helbertt.supermarket.service;

import java.util.List;

import xyz.helbertt.supermarket.dto.request.UserDTO;
import xyz.helbertt.supermarket.dto.response.UserResponseDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketMailAlreadyRegisteredException;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;

public interface UserService {

	List<UserResponseDTO> getAll();
	
	MessageResponseDTO create(UserDTO user) throws SupermarketMailAlreadyRegisteredException;
	
	MessageResponseDTO update(Long id, UserDTO user) throws SupermarketNotFoundException, SupermarketMailAlreadyRegisteredException;
	
	MessageResponseDTO delete(Long id) throws SupermarketNotFoundException;
	
	UserResponseDTO getById(Long id) throws SupermarketNotFoundException;
	
}