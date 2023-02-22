package xyz.helbertt.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.helbertt.supermarket.model.PurchaseList;

public interface PurchaseListRepository extends JpaRepository<PurchaseList, Long> {

}
