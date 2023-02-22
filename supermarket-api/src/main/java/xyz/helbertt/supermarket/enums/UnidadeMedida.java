package xyz.helbertt.supermarket.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UnidadeMedida {

	KG("Peso"),
	UN("Unidade"),
	CX("Caixa");
	
	private final String description;

	/**
	 * @param description
	 */
	private UnidadeMedida(String description) {
		this.description = description;
	}
	
	
}
