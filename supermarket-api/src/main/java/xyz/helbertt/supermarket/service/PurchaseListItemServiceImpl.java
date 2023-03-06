package xyz.helbertt.supermarket.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import xyz.helbertt.supermarket.dto.request.PurchaseListItemDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.dto.response.PurchaseListItemResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketAlreadyRegisteredException;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;
import xyz.helbertt.supermarket.model.PurchaseListItem;
import xyz.helbertt.supermarket.repository.PurchaseListItemRepository;

@Service
@AllArgsConstructor (onConstructor = @__(@Autowired))
public class PurchaseListItemServiceImpl implements PurchaseListItemService {
	
	private ModelMapper mapper;

	private final PurchaseListItemRepository repository;

	@Override
	public List<PurchaseListItemResponseDTO> getAll() {
		return repository
				.findAll()
				.stream()
				.map(purchaseListItem -> mapper
						.map(purchaseListItem, PurchaseListItemResponseDTO.class))
				.collect(Collectors
						.toList());
	}

	@Override
	public MessageResponseDTO create(PurchaseListItemDTO purchaseListItemDTO)
			throws SupermarketAlreadyRegisteredException {
		PurchaseListItem purchaseListItemToSave = purchaseListItemDTO.transformToPurchaseListItem();
		
		PurchaseListItem savedPurchaseListItem = repository.save(purchaseListItemToSave);
		
		return createMessageResponse(savedPurchaseListItem.getId(), "Created purchase list item with ID ");
	}

	@Override
	public MessageResponseDTO update(Long id, PurchaseListItemDTO purchaseListItemDTO)
			throws SupermarketNotFoundException, SupermarketAlreadyRegisteredException {
		PurchaseListItem purchaseListItemToUpdate = purchaseListItemDTO.transformToPurchaseListItem();
		
		purchaseListItemToUpdate.setId(id);
		
		PurchaseListItem updatedPurchaseListItem = repository.save(purchaseListItemToUpdate);
		
		return createMessageResponse(updatedPurchaseListItem.getId(), "Updated purchase list item with ID ");
	}

	@Override
	public MessageResponseDTO delete(Long id) throws SupermarketNotFoundException {
		PurchaseListItem purchaseListItem = verifyIfExists(id);
		
		repository.delete(purchaseListItem);
		
		return createMessageResponse(id, "Deleted purchase list item with ID ");
	}

	@Override
	public PurchaseListItemResponseDTO getById(Long id) throws SupermarketNotFoundException {
		PurchaseListItem purchaseListItem = verifyIfExists(id);
		
		PurchaseListItemResponseDTO purchaseListItemResponse = PurchaseListItemResponseDTO.transformToDTO(purchaseListItem);
		
		return purchaseListItemResponse;
	}
	
	private PurchaseListItem verifyIfExists(Long id) throws SupermarketNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new SupermarketNotFoundException("Purchase List Item", id));
	}	
	
	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message + id)
				.build();
	}

}
