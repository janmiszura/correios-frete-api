package org.jm.util;

public class EmbalagemIndefinidaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EmbalagemIndefinidaException() {
		super("Nenhuma embalagem foi definida.");
	}
	
	
	
}
