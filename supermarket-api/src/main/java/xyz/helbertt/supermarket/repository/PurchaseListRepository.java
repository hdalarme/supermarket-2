package xyz.helbertt.supermarket.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.helbertt.supermarket.model.PurchaseList;

public interface PurchaseListRepository extends JpaRepository<PurchaseList, Long> {

	List<PurchaseList> findByUserId(Long userId);
	List<PurchaseList> findByNameIsContainingIgnoreCase(String name);
	
	Optional<PurchaseList> findByName(String name);
	
}
