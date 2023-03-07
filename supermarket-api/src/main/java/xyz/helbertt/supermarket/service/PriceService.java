package xyz.helbertt.supermarket.service;

import java.util.List;

import xyz.helbertt.supermarket.dto.request.PriceDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.dto.response.PriceResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketAlreadyRegisteredException;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;

public interface PriceService {

	List<PriceResponseDTO> getAll();
	
	MessageResponseDTO create(PriceDTO priceDTO) throws SupermarketAlreadyRegisteredException;
	
	MessageResponseDTO update(Long id, PriceDTO priceDTO) throws SupermarketNotFoundException, SupermarketAlreadyRegisteredException;
	
	MessageResponseDTO delete(Long id) throws SupermarketNotFoundException;
	
	PriceResponseDTO getById(Long id) throws SupermarketNotFoundException;
	
}
