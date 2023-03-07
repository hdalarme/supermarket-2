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
import xyz.helbertt.supermarket.dto.request.PriceDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.dto.response.PriceResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketAlreadyRegisteredException;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;
import xyz.helbertt.supermarket.service.PriceService;

@RestController
@RequestMapping("/api/v1/prices")
@AllArgsConstructor (onConstructor = @__(@Autowired))
public class PriceController {

	private PriceService service;
	
	@GetMapping
	public List<PriceResponseDTO> listAll() {
		return service.getAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody PriceDTO priceDTO) throws SupermarketAlreadyRegisteredException {
		return service.create(priceDTO);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO update(@PathVariable Long id, @RequestBody PriceDTO priceDTO) throws SupermarketNotFoundException, SupermarketAlreadyRegisteredException {
		return service.update(id, priceDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public MessageResponseDTO delete(@PathVariable Long id) throws SupermarketNotFoundException {
		return service.delete(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PriceResponseDTO> getById(@PathVariable Long id) throws SupermarketNotFoundException {
		PriceResponseDTO price = service.getById(id);
		
		return ResponseEntity.ok().body(price);
	}
	
}
