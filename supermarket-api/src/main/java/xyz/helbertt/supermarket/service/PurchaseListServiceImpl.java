package xyz.helbertt.supermarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import xyz.helbertt.supermarket.dto.request.PurchaseListDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.dto.response.PurchaseListResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketAlreadyRegisteredException;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;
import xyz.helbertt.supermarket.model.PurchaseList;
import xyz.helbertt.supermarket.repository.PurchaseListRepository;

@Service
@AllArgsConstructor (onConstructor = @__(@Autowired))
public class PurchaseListServiceImpl implements PurchaseListService {

	private ModelMapper mapper;
	
	private final PurchaseListRepository repository;

	@Override
	public List<PurchaseListResponseDTO> getAll() {
		return repository
				.findAll()
				.stream()
				.map(purchaseList -> mapper
						.map(purchaseList, PurchaseListResponseDTO.class))
				.collect(Collectors
						.toList());
	}

	@Override
	public MessageResponseDTO create(PurchaseListDTO purchaseListDTO) throws SupermarketAlreadyRegisteredException {
		Optional<PurchaseList> purchaseListFind = repository.findByName(purchaseListDTO.getName());
		
		if (purchaseListFind.isPresent()) {
			throw new SupermarketAlreadyRegisteredException("Purchase List", "Name", purchaseListDTO.getName());
		}
		
		PurchaseList purchaseListToSave = purchaseListDTO.transformToPurchaseList();
		
		PurchaseList savedPurchaseList = repository.save(purchaseListToSave);
		
		return createMessageResponse(savedPurchaseList.getId(), "Created purchase list with ID ");
	}

	@Override
	public MessageResponseDTO update(Long id, PurchaseListDTO purchaseListDTO)
			throws SupermarketNotFoundException, SupermarketAlreadyRegisteredException {
		PurchaseList purchaseList = verifyIfExists(id);
		
		PurchaseList purchaseListToUpdate = purchaseListDTO.transformToPurchaseList();
		
		purchaseListToUpdate.setId(id);
		
		if (purchaseList.getName().equals(purchaseListToUpdate.getName()) && purchaseList.getId() != id) {
			throw new SupermarketAlreadyRegisteredException("Product", purchaseListToUpdate.getName());
		}
		
		PurchaseList updatedPurchaseList = repository.save(purchaseListToUpdate);
		
		return createMessageResponse(updatedPurchaseList.getId(), "Updated purchase list with ID ");
	}

	@Override
	public MessageResponseDTO delete(Long id) throws SupermarketNotFoundException {
		PurchaseList purchaseList = verifyIfExists(id);
		
		repository.delete(purchaseList);
		
		return createMessageResponse(id, "Deleted purchase list with ID ");
	}

	@Override
	public PurchaseListResponseDTO getById(Long id) throws SupermarketNotFoundException {
		PurchaseList purchaseList = verifyIfExists(id);
		
		PurchaseListResponseDTO purchaseListResponse = PurchaseListResponseDTO.transformToDTO(purchaseList);
		
		return purchaseListResponse;
	}
	
	private PurchaseList verifyIfExists(Long id) throws SupermarketNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new SupermarketNotFoundException("Purchase List", id));
	}	
	
	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message + id)
				.build();
	}
}
