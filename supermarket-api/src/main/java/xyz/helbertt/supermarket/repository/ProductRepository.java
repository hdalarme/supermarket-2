package xyz.helbertt.supermarket.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.helbertt.supermarket.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByNameIsContainingIgnoreCase(String name);
	List<Product> findByProductParent(Long productParent);
	
	Optional<Product> findByCodigoBarra(String codigoBarra);
	Optional<Product> findByName(String name);
	
}
