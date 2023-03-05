package xyz.helbertt.supermarket.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import xyz.helbertt.supermarket.dto.request.EstablishmentDTO;
import xyz.helbertt.supermarket.dto.response.EstablishmentResponseDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketAlreadyRegisteredException;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;
import xyz.helbertt.supermarket.model.Establishment;
import xyz.helbertt.supermarket.repository.EstablishmentRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EstablishmentServiceImpl implements EstablishmentService {
	
	private ModelMapper mapper;

	private final EstablishmentRepository repository;
	
	@Override
	public List<EstablishmentResponseDTO> getAll() {
		return repository
				.findAll()
				.stream()
				.map(establishment -> mapper
						.map(establishment, EstablishmentResponseDTO.class))
				.collect(Collectors
						.toList());
	}
	
	@Override
	public List<EstablishmentResponseDTO> getByName(String name) {
		return repository
				.findByNameIsContainingIgnoreCase(name)
				.stream()
				.map(establishment -> mapper
						.map(establishment, EstablishmentResponseDTO.class))
				.collect(Collectors
						.toList());
	}
	
	@Override
	public List<EstablishmentResponseDTO> getByCity(String city) {
		return repository
				.findByCityIsContainingIgnoreCase(city)
				.stream()
				.map(establishment -> mapper
						.map(establishment, EstablishmentResponseDTO.class))
				.collect(Collectors
						.toList());
	}

	@Override
	public MessageResponseDTO create(EstablishmentDTO establishmentDTO) throws SupermarketAlreadyRegisteredException {
		Establishment establishmentToSave = establishmentDTO.transformtoEstablishment();
		
		Establishment savedEstablishment = repository.save(establishmentToSave);
		
		return createMessageResponse(savedEstablishment.getId(), "Created establishment with ID ");
	}

	@Override
	public MessageResponseDTO update(Long id, EstablishmentDTO establishmentDTO)
			throws SupermarketNotFoundException, SupermarketAlreadyRegisteredException {
		//@SuppressWarnings("unused")
		Establishment establishment = verifyIfExists(id);
		
		Establishment establishmentToTpdate = establishmentDTO.transformtoEstablishment();
		
		establishmentToTpdate.setId(id);
		
		Establishment updatedEstablishment = repository.save(establishmentToTpdate);
		
		return createMessageResponse(updatedEstablishment.getId(), "Updated establishment with ID ");
	}

	@Override
	public MessageResponseDTO delete(Long id) throws SupermarketNotFoundException {
		Establishment establishment = verifyIfExists(id);
		
		repository.delete(establishment);
		
		return createMessageResponse(id, "Deleted establishment with ID ");
	}

	@Override
	public EstablishmentResponseDTO getById(Long id) throws SupermarketNotFoundException {
		Establishment establishment = verifyIfExists(id);
		
		EstablishmentResponseDTO establishmentResponse = EstablishmentResponseDTO.transformToDTO(establishment);
		
		return establishmentResponse;
	}
	
	private Establishment verifyIfExists(Long id) throws SupermarketNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new SupermarketNotFoundException("Establishment", id));
	}
	
	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message + id)
				.build();
	}
	
}
