package xyz.helbertt.supermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.helbertt.supermarket.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByNameContaining(String name);
	List<Product> findByProductParent(Long productParent);
	
	Product findByCodigoBarra(String codigoBarra);
	Product findByName(String name);
	
}
