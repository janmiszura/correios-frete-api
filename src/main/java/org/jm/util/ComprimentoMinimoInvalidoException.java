package org.jm.util;

public class ComprimentoMinimoInvalidoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ComprimentoMinimoInvalidoException() {
		super("Comprimento mínimo deve ser 16 cm.");
	}
	
	
	
}
