package org.jm.util;

public class EmbalagemInvalidaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EmbalagemInvalidaException() {
		super("Embalagem inválida, por favor revise as regras.");
	}
	
	
	
}
