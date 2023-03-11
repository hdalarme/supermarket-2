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
import xyz.helbertt.supermarket.dto.request.PurchaseListDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.dto.response.PurchaseListResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketAlreadyRegisteredException;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;
import xyz.helbertt.supermarket.service.PurchaseListService;

@RestController
@RequestMapping("/api/v1/lists")
@AllArgsConstructor (onConstructor = @__(@Autowired))
public class PurchaseListController {
	
	private PurchaseListService service;
	
	@GetMapping
	public List<PurchaseListResponseDTO> getAll() {
		return service.getAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody PurchaseListDTO purchaseListDTO) throws SupermarketAlreadyRegisteredException {
		return service.create(purchaseListDTO);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO update(@PathVariable Long id, @RequestBody PurchaseListDTO purchaseListDTO) throws SupermarketNotFoundException, SupermarketAlreadyRegisteredException {
		return service.update(id, purchaseListDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public MessageResponseDTO delete(@PathVariable Long id) throws SupermarketNotFoundException {
		return service.delete(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PurchaseListResponseDTO> getById(@PathVariable Long id) throws SupermarketNotFoundException {
		PurchaseListResponseDTO purchaseList = service.getById(id);
		
		return ResponseEntity.ok().body(purchaseList);
	}
	
}
