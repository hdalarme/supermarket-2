package xyz.helbertt.supermarket.service;

import java.util.List;

import xyz.helbertt.supermarket.dto.request.PurchaseListItemDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.dto.response.PurchaseListItemResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketAlreadyRegisteredException;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;

public interface PurchaseListItemService {

	List<PurchaseListItemResponseDTO> getAll();
	
	MessageResponseDTO create(PurchaseListItemDTO purchaseListItemDTO) throws SupermarketAlreadyRegisteredException;
	
	MessageResponseDTO update(Long id, PurchaseListItemDTO purchaseListItemDTO) throws SupermarketNotFoundException, SupermarketAlreadyRegisteredException;
	
	MessageResponseDTO delete(Long id) throws SupermarketNotFoundException;
	
	PurchaseListItemResponseDTO getById(Long id) throws SupermarketNotFoundException;
	
}
