package xyz.helbertt.supermarket.service;

import java.util.List;

import xyz.helbertt.supermarket.dto.request.PurchaseListDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.dto.response.PurchaseListResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketAlreadyRegisteredException;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;


public interface PurchaseListService {

	List<PurchaseListResponseDTO> getAll();
	
	MessageResponseDTO create(PurchaseListDTO purchaseListDTO) throws SupermarketAlreadyRegisteredException;
	
	MessageResponseDTO update(Long id, PurchaseListDTO purchaseListDTO) throws SupermarketNotFoundException, SupermarketAlreadyRegisteredException;
	
	MessageResponseDTO delete(Long id) throws SupermarketNotFoundException;
	
	PurchaseListResponseDTO getById(Long id) throws SupermarketNotFoundException;
	
	
}
