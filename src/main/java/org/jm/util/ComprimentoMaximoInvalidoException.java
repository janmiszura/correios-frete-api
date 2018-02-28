package org.jm.util;

public class ComprimentoMaximoInvalidoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ComprimentoMaximoInvalidoException() {
		super("Comprimento máximo deve ser 105 cm.");
	}
	
	
	
}
