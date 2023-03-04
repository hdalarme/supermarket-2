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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import xyz.helbertt.supermarket.dto.request.ProductDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.dto.response.ProductResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketAlreadyRegisteredException;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;
import xyz.helbertt.supermarket.service.ProductService;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {
	
	private ProductService service;
	
	@GetMapping
	public List<ProductResponseDTO> getAll(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String id
		) {
		if (name != null) {
			return service.getByName(name);
		} else if (id != null) {
			Long idInfo = Long.parseLong(id);
			return service.getByProductParent(idInfo);
		} else {			
			return service.getAll();
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody ProductDTO productDTO) throws SupermarketAlreadyRegisteredException {
		return service.create(productDTO);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO update(@PathVariable Long id, @RequestBody ProductDTO productDTO) throws SupermarketNotFoundException, SupermarketAlreadyRegisteredException {
		return service.update(id, productDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public MessageResponseDTO delete(@PathVariable Long id) throws SupermarketNotFoundException {
		return service.delete(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponseDTO> getById(@PathVariable Long id) throws SupermarketNotFoundException {
		ProductResponseDTO product = service.getById(id);
		
		return ResponseEntity.ok().body(product);
	}

}
