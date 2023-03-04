package xyz.helbertt.supermarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import xyz.helbertt.supermarket.dto.request.ProductDTO;
import xyz.helbertt.supermarket.dto.response.MessageResponseDTO;
import xyz.helbertt.supermarket.dto.response.ProductResponseDTO;
import xyz.helbertt.supermarket.exception.SupermarketAlreadyRegisteredException;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;
import xyz.helbertt.supermarket.model.Product;
import xyz.helbertt.supermarket.repository.ProductRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductImpl implements ProductService {

	private ModelMapper productMapper;
	
	private final ProductRepository repository;
	
	@Override
	public List<ProductResponseDTO> getAll() {
		return repository
				.findAll()
				.stream()
				.map(product -> productMapper
						.map(product, ProductResponseDTO.class))
				.collect(Collectors
						.toList());
	}
	
	@Override
	public List<ProductResponseDTO> getByName(String name) {
		return repository
				.findByNameIsContainingIgnoreCase(name)
				.stream()
				.map(product -> productMapper
						.map(product, ProductResponseDTO.class))
				.collect(Collectors
						.toList());
	}

	@Override
	public List<ProductResponseDTO> getByProductParent(Long id) {
		return repository
				.findByProductParent(id)
				.stream()
				.map(product -> productMapper
						.map(product, ProductResponseDTO.class))
				.collect(Collectors
						.toList());
	}

	@Override
	public MessageResponseDTO create(ProductDTO product) throws SupermarketAlreadyRegisteredException {
		Optional<Product> productFind = repository.findByName(product.getName());
		
		if (productFind.isPresent()) {
			throw new SupermarketAlreadyRegisteredException("Product", "Name", product.getName());
		}
		
		Product productToSave = product.transformToProduct();
		
		Product savedProduct = repository.save(productToSave);
		
		return createMessageResponse(savedProduct.getId(), "Created product with ID ");
	}

	@Override
	public MessageResponseDTO update(Long id, ProductDTO productRequest) throws SupermarketNotFoundException, SupermarketAlreadyRegisteredException {
		Product product = verifyIfExists(id);
		
		Product productToUpdate = productRequest.transformToProduct();
		
		productToUpdate.setId(id);
		
		if (product.getName().equals(productToUpdate.getName()) && product.getId() != id) {
			throw new SupermarketAlreadyRegisteredException("Product", productToUpdate.getName());
		}
		
		Product updatedProduct = repository.save(productToUpdate);
		
		return createMessageResponse(updatedProduct.getId(), "Updated user with ID ");
	}

	@Override
	public MessageResponseDTO delete(Long id) throws SupermarketNotFoundException {
		Product product = verifyIfExists(id);
		
		repository.delete(product);
		
		return createMessageResponse(id, "Deleted product with ID ");
	}

	@Override
	public ProductResponseDTO getById(Long id) throws SupermarketNotFoundException {
		Product product = verifyIfExists(id);
		
		ProductResponseDTO productResponse = ProductResponseDTO.transformToDTO(product);
		
		return productResponse;
	}
	
	@Override
	public ProductResponseDTO getByCodBarras(String codigoBarra) throws SupermarketNotFoundException {
		Product product = repository.findByCodigoBarra(codigoBarra)
				.orElseThrow(() -> new SupermarketNotFoundException("Product", "Bar Code", codigoBarra));
		
		ProductResponseDTO productResponse = ProductResponseDTO.transformToDTO(product);
		
		return productResponse;
	}
	
	private Product verifyIfExists(Long id) throws SupermarketNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new SupermarketNotFoundException("Product", id));
	}
	
	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message + id)
				.build();
	}

}
