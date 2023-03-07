package xyz.helbertt.supermarket.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import xyz.helbertt.supermarket.dto.request.PriceDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.dto.response.PriceResponseDTO;
import xyz.helbertt.supermarket.dto.response.PurchaseListResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketAlreadyRegisteredException;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;
import xyz.helbertt.supermarket.model.Price;
import xyz.helbertt.supermarket.model.PurchaseList;
import xyz.helbertt.supermarket.repository.PriceRepository;
import xyz.helbertt.supermarket.repository.PurchaseListRepository;


@Service
@AllArgsConstructor (onConstructor = @__(@Autowired))
public class PriceServiceImpl implements PriceService {

	private ModelMapper mapper;
	
	private final PriceRepository repository;
	
	@Override
	public List<PriceResponseDTO> getAll() {
		return repository
				.findAll()
				.stream()
				.map(price -> mapper
						.map(price, PriceResponseDTO.class))
				.collect(Collectors
						.toList());
	}

	@Override
	public MessageResponseDTO create(PriceDTO priceDTO) throws SupermarketAlreadyRegisteredException {
		Price priceToSave = priceDTO.transformToPrice();
		
		Price savedPrice = repository.save(priceToSave);
		
		return createMessageResponse(savedPrice.getId(), "Created price with ID ");
	}

	@Override
	public MessageResponseDTO update(Long id, PriceDTO priceDTO)
			throws SupermarketNotFoundException, SupermarketAlreadyRegisteredException {
		Price price = verifyIfExists(id);
		
		Price priceToUpdate = priceDTO.transformToPrice();
		
		priceToUpdate.setId(id);
		
		Price updatedPrice = repository.save(priceToUpdate);
		
		return createMessageResponse(updatedPrice.getId(), "Updated price with ID ");
	}

	@Override
	public MessageResponseDTO delete(Long id) throws SupermarketNotFoundException {
		Price price = verifyIfExists(id);
		
		repository.delete(price);
		
		return createMessageResponse(id, "Deleted price with ID ");
	}

	@Override
	public PriceResponseDTO getById(Long id) throws SupermarketNotFoundException {
		Price price = verifyIfExists(id);
		
		PriceResponseDTO priceResponse = PriceResponseDTO.transformToDTO(price);
		
		return priceResponse;
	}
	
	private Price verifyIfExists(Long id) throws SupermarketNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new SupermarketNotFoundException("Price", id));
	}	
	
	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message + id)
				.build();
	}
	
}
