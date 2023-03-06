package xyz.helbertt.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.helbertt.supermarket.model.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {

}
