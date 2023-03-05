package xyz.helbertt.supermarket.service;

import java.util.List;

import xyz.helbertt.supermarket.dto.request.EstablishmentDTO;
import xyz.helbertt.supermarket.dto.response.EstablishmentResponseDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketAlreadyRegisteredException;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;

public interface EstablishmentService {

	List<EstablishmentResponseDTO> getAll();
	
	List<EstablishmentResponseDTO> getByName(String name);
	
	List<EstablishmentResponseDTO> getByCity(String city);
	
	MessageResponseDTO create(EstablishmentDTO establishmentDTO) throws SupermarketAlreadyRegisteredException;
	
	MessageResponseDTO update(Long id, EstablishmentDTO establishmentDTO) throws SupermarketNotFoundException, SupermarketAlreadyRegisteredException;
	
	MessageResponseDTO delete(Long id) throws SupermarketNotFoundException;
	
	EstablishmentResponseDTO getById(Long id) throws SupermarketNotFoundException;
	
}
