package xyz.helbertt.supermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.helbertt.supermarket.model.Establishment;

public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {
	
	List<Establishment> findByNameIsContainingIgnoreCase(String name);
	List<Establishment> findByCityIsContainingIgnoreCase(String city);

}
