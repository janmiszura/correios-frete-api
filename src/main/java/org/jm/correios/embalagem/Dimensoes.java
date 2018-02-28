package org.jm.correios.embalagem;

import org.jm.util.AlturaMinimaInvalidaException;
import org.jm.util.ComprimentoMaximoInvalidoException;
import org.jm.util.ComprimentoMinimoInvalidoException;
import org.jm.util.DimensoesInvalidasException;
import org.jm.util.LarguraMaximaInvalidaException;
import org.jm.util.LarguraMinimaInvalidaException;

public class Dimensoes implements Comparable<Dimensoes> {
	
	private float comprimento;//cm
	private float largura;//cm
	private float altura;//cm
	
	public Dimensoes(float comprimento, float largura, float altura) {
		super();
		this.comprimento = comprimento;
		this.largura = largura;
		this.altura = altura;
	}

	public static Dimensoes comDimensoes(float comprimento, float largura, float altura) {
		
		return new Dimensoes(comprimento, largura, altura);
	}
	
	public float getComprimento() {
		return comprimento;
	}

	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}

	public float getLargura() {
		return largura;
	}

	public void setLargura(float largura) {
		this.largura = largura;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	public float calcularVolume() {
		return comprimento*largura*altura;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(altura);
		result = prime * result + Float.floatToIntBits(comprimento);
		result = prime * result + Float.floatToIntBits(largura);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dimensoes other = (Dimensoes) obj;
		if (Float.floatToIntBits(altura) != Float.floatToIntBits(other.altura))
			return false;
		if (Float.floatToIntBits(comprimento) != Float.floatToIntBits(other.comprimento))
			return false;
		if (Float.floatToIntBits(largura) != Float.floatToIntBits(other.largura))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Dimensoes [comprimento=" + comprimento + ", largura=" + largura + ", altura=" + altura + "]";
	}
	
	/*
	 * PACOTE E CAIXA
	 * Especificações	Mínimo	Máximo
	 * Comprimento (C)	16 cm	105 cm
	 * Largura (L)	11 cm	105 cm
	 * Altura (A)	2 cm	105 cm
	 * Soma (C+L+A)	29 cm	200 cm
	 * 
	 * Obs. 1: A soma resultante do comprimento + largura + altura não deve superar 200 cm.
	 * Obs. 2: A soma resultante do comprimento + o dobro do diâmetro não pode ser menor que 28 cm.
	 */
	public void ehValidaComoEmbalagem() {
		
		if( comprimento < 16 ) {
			throw new ComprimentoMinimoInvalidoException();
		}
		
		if( largura < 11 ) {
			throw new LarguraMinimaInvalidaException();
		}
		
		if( altura < 2 ) {
			throw new AlturaMinimaInvalidaException();
		}
		
		if( comprimento > 105 ) {
			throw new ComprimentoMaximoInvalidoException();
		}
		
		if( largura > 105 ) {
			throw new LarguraMaximaInvalidaException();
		}
		
		if( altura > 105 ) {
			throw new DimensoesInvalidasException();
		}
		
		float soma = comprimento + largura + altura;
		
		if( soma > 200 ) {
			throw new DimensoesInvalidasException();
		}
		
	}
	
	public void ehValidaComoItem() {
		
		if( comprimento > 105 ) {
			throw new DimensoesInvalidasException();
		}
		
		if( largura > 105 ) {
			throw new DimensoesInvalidasException();
		}
		
		if( altura > 105 ) {
			throw new DimensoesInvalidasException();
		}
		
		float soma = comprimento + largura + altura;
		
		if( soma > 200 ) {
			throw new DimensoesInvalidasException();
		}
		
	}

	public int compareTo(Dimensoes o) {
		
		if( o == null ) {
			return 0;
		}
		
		float v1 = this.calcularVolume();
		float v2 = o.calcularVolume();
		
		if( v1 == v2 ) {
			return 0;
		}
		
		return v1 > v2 ? 1 : -1;
	}
	
	
}