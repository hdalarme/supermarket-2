package xyz.helbertt.supermarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import xyz.helbertt.supermarket.model.PurchaseList;
import xyz.helbertt.supermarket.repository.PurchaseListRepository;

@Service
@AllArgsConstructor
public class PurchaseListServiceImpl implements PurchaseListService {

	@Autowired
	private final PurchaseListRepository listRepository;
	
	@Autowired
	public PurchaseListServiceImpl(PurchaseListRepository listRepository) {
		super();
		this.listRepository = listRepository;
	}
	
	@Override
	public List<PurchaseList> getAll() {
		return listRepository.findAll();
		
	}
	
	
	
}
