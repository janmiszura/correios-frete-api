package org.jm.correios.embalagem;

public class Embalagem {
	
	public static final Embalagem CORREIOS_TIPO_1 = new Embalagem(18, 13.5f, 9);
	public static final Embalagem CORREIOS_TIPO_2 = new Embalagem(27, 18, 9);
	public static final Embalagem CORREIOS_TIPO_3 = new Embalagem(27, 22.5f, 13.5f);
	public static final Embalagem CORREIOS_TIPO_4 = new Embalagem(36, 27, 18);
	public static final Embalagem CORREIOS_TIPO_5 = new Embalagem(54, 36, 27);
	public static final Embalagem CORREIOS_TIPO_6 = new Embalagem(36, 27, 27);
	public static final Embalagem CORREIOS_TIPO_7 = new Embalagem(36, 28, 4);
	
	private Dimensoes dimensoes;
	
	public Embalagem(float comprimento, float largura, float altura) {
		super();
		this.dimensoes = new Dimensoes(comprimento, largura, altura);
	}

	public static Embalagem comDimensoes(float comprimento, float largura, float altura) {
		
		return new Embalagem(comprimento, largura, altura);
	}

	public Dimensoes getDimensoes() {
		return dimensoes;
	}

	public void setDimensoes(Dimensoes dimensoes) {
		this.dimensoes = dimensoes;
	}

	@Override
	public String toString() {
		return "Embalagem [dimensoes=" + dimensoes + "]";
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
		Embalagem other = (Embalagem) obj;
		if (dimensoes == null) {
			if (other.dimensoes != null)
				return false;
		} else if (!dimensoes.equals(other.dimensoes))
			return false;
		return true;
	}
	
	
	
	
	
}