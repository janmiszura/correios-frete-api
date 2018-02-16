package org.jm.correios.embalagem;

public class Item {
	
	private float comprimento;//cm
	private float largura;//cm
	private float altura;//cm
	
	public Item(float comprimento, float largura, float altura) {
		super();
		this.comprimento = comprimento;
		this.largura = largura;
		this.altura = altura;
	}

	public static Item comDimensoes(float comprimento, float largura, float altura) {
		
		return new Item(comprimento, largura, altura);
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
		Item other = (Item) obj;
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
		return "Item [comprimento=" + comprimento + ", largura=" + largura + ", altura=" + altura + "]";
	}
	
	
}