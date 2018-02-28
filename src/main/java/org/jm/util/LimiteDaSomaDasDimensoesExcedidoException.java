package org.jm.util;

public class LimiteDaSomaDasDimensoesExcedidoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public LimiteDaSomaDasDimensoesExcedidoException() {
		super("O resultado da soma comprimento + largura + altura não pode exceder 200 cm.");
	}
	
}
