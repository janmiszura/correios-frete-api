package org.jm.correios.embalagem;

import java.util.UUID;

public class Item {
	
	private String id = UUID.randomUUID().toString().substring(0, 4);
	
	private Dimensoes dimensoes;
	
	private Boolean jaEmbalado = false;
	
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

	public Boolean getJaEmbalado() {
		return jaEmbalado;
	}

	public void setJaEmbalado(Boolean jaEmbalado) {
		this.jaEmbalado = jaEmbalado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", dimensoes=" + dimensoes + ", jaEmbalado=" + jaEmbalado + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	protected Item clone() {
		
		return Item.comDimensoes(
				this.getDimensoes().getComprimento(), 
				this.getDimensoes().getLargura(), 
				this.getDimensoes().getAltura());
	}
	
	
	
	
}