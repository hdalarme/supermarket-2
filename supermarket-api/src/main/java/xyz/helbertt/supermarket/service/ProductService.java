package xyz.helbertt.supermarket.service;

import java.util.List;

import xyz.helbertt.supermarket.dto.request.ProductDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.dto.response.ProductResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketAlreadyRegisteredException;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;

public interface ProductService {

	List<ProductResponseDTO> getAll();
	
	List<ProductResponseDTO> getByName(String name);
	
	List<ProductResponseDTO> getByProductParent(Long id);
	
	MessageResponseDTO create(ProductDTO product) throws SupermarketAlreadyRegisteredException;
	
	MessageResponseDTO update(Long id, ProductDTO product) throws SupermarketNotFoundException, SupermarketAlreadyRegisteredException;
	
	MessageResponseDTO delete(Long id) throws SupermarketNotFoundException;
	
	ProductResponseDTO getById(Long id) throws SupermarketNotFoundException;
	
	ProductResponseDTO getByCodBarras(String codigoBarra) throws SupermarketNotFoundException;
	
}

