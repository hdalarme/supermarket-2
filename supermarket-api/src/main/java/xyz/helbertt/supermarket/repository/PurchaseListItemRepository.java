package xyz.helbertt.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.helbertt.supermarket.model.PurchaseListItem;

public interface PurchaseListItemRepository extends JpaRepository<PurchaseListItem, Long> {

}
