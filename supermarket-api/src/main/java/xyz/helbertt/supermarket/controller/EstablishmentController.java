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
import xyz.helbertt.supermarket.dto.request.EstablishmentDTO;
import xyz.helbertt.supermarket.dto.response.EstablishmentResponseDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketAlreadyRegisteredException;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;
import xyz.helbertt.supermarket.service.EstablishmentService;


@RestController
@RequestMapping("api/v1/establishment")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EstablishmentController {

	private EstablishmentService service;
	
	@GetMapping
	public List<EstablishmentResponseDTO> getAll(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String city
		) {
		if (name != null) {
			return service.getByName(name);
		} else if (city != null) {
			return service.getByCity(city);
		} else {			
			return service.getAll();
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody EstablishmentDTO establishmentDTO) throws SupermarketAlreadyRegisteredException {
		return service.create(establishmentDTO);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO update(@PathVariable Long id, @RequestBody EstablishmentDTO establishmentDTO) throws SupermarketNotFoundException, SupermarketAlreadyRegisteredException {
		return service.update(id, establishmentDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public MessageResponseDTO delete(@PathVariable Long id) throws SupermarketNotFoundException {
		return service.delete(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EstablishmentResponseDTO> getById(@PathVariable Long id) throws SupermarketNotFoundException {
		EstablishmentResponseDTO establishment = service.getById(id);
		
		return ResponseEntity.ok().body(establishment);
	}
	
}
