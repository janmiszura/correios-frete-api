package org.jm.correios.embalagem;

import java.util.UUID;

public class Item {
	
	private String id = UUID.randomUUID().toString().substring(0, 6);
	
	private Dimensoes dimensoes;
	
	private float peso;
	
	private Boolean jaEmbalado = false;
	
	public Item(float comprimento, float largura, float altura, float peso) {
		super();
		this.dimensoes = new Dimensoes(comprimento, largura, altura);
		this.peso = peso;
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

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
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
		return "Item [id=" + id + ", dimensoes=" + dimensoes + ", peso=" + peso + ", jaEmbalado=" + jaEmbalado + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	protected Item clone() {
		
		return new Item(
				this.getDimensoes().getComprimento(), 
				this.getDimensoes().getLargura(), 
				this.getDimensoes().getAltura(),
				this.peso);
	}
	
	
	
	
}