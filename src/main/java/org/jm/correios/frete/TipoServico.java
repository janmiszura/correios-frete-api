package org.jm.correios.frete;

public enum TipoServico {
	
	PAC("04510", "PAC"),
	PAC_VAREJO("41106", "PAC Varejo"),
	
	SEDEX("04014", "Sedex"),
	SEDEX_VAREJO("40010", "SEDEX Varejo"),
	SEDEX_A_COBRAR_VAREJO("40045", "SEDEX a Cobrar Varejo"),
	SEDEX_10_VAREJO("40215", "SEDEX 10 Varejo"),
	SEDEX_HOJE_VAREJO("40290", "SEDEX Hoje Varejo"),
	;
	
	private String codigo;
	private String nome;
	
	private TipoServico(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public String getCodigo() {
		return codigo;
	}
	
}