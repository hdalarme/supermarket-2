package xyz.helbertt.supermarket.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import xyz.helbertt.supermarket.dto.PurchaseListDTO;
import xyz.helbertt.supermarket.service.PurchaseListService;

@RestController
@RequestMapping("/api/v1/list")
@AllArgsConstructor //(onConstructor = @__(@Autowired))
public class PurchaseListController {

	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private PurchaseListService listService;
	
	@GetMapping
	public List<PurchaseListDTO> listAll() {
		return listService.getAll().stream().map(purchaseList -> modelmapper.map(purchaseList, PurchaseListDTO.class))
				.collect(Collectors.toList());
	}
	
}
