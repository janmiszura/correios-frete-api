package org.jm.correios.embalagem;

public class Item {
	
	private Dimensoes dimensoes;
	
	public Item(float comprimento, float largura, float altura) {
		super();
		this.dimensoes = new Dimensoes(comprimento, largura, altura);
	}

	public static Item comDimensoes(float comprimento, float largura, float altura) {
		
		return new Item(comprimento, largura, altura);
	}

	public Dimensoes getDimensoes() {
		return dimensoes;
	}

	public void setDimensoes(Dimensoes dimensoes) {
		this.dimensoes = dimensoes;
	}

	@Override
	public String toString() {
		return "Item [dimensoes=" + dimensoes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dimensoes == null) ? 0 : dimensoes.hashCode());
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
		if (dimensoes == null) {
			if (other.dimensoes != null)
				return false;
		} else if (!dimensoes.equals(other.dimensoes))
			return false;
		return true;
	}
	
	
	
	
}