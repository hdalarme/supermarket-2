package xyz.helbertt.supermarket.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import xyz.helbertt.supermarket.dto.request.PurchaseListDTO;
import io.swagger.annotations.ApiResponse;

@Api("Manages Lists")
public interface PurchaseListControllerDocs {

	@ApiOperation(value = "Returns a list of all lists registered inte system")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "List of all lists registered in the system")
	})
	public List<PurchaseListDTO> listAll();
	
}
