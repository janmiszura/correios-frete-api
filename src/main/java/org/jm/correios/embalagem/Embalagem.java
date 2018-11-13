package org.jm.correios.embalagem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Embalagem {
	
	public static final Embalagem CORREIOS_TIPO_1 = new Embalagem(18, 13.5f, 9);
	public static final Embalagem CORREIOS_TIPO_2 = new Embalagem(27, 18, 9);
	public static final Embalagem CORREIOS_TIPO_3 = new Embalagem(27, 22.5f, 13.5f);
	public static final Embalagem CORREIOS_TIPO_4 = new Embalagem(36, 27, 18);
	public static final Embalagem CORREIOS_TIPO_5 = new Embalagem(54, 36, 27);
	public static final Embalagem CORREIOS_TIPO_6 = new Embalagem(36, 27, 27);
	public static final Embalagem CORREIOS_TIPO_7 = new Embalagem(36, 28, 4);
	
	private String id = UUID.randomUUID().toString().substring(0, 6);
	
	private Dimensoes dimensoes;
	
	private List<Item> itens = new ArrayList<Item>();
	
	public Embalagem(float comprimento, float largura, float altura) {
		super();
		this.dimensoes = new Dimensoes(comprimento, largura, altura);
	}

	public static Embalagem comDimensoes(float comprimento, float largura, float altura) {
		
		return new Embalagem(comprimento, largura, altura);
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Dimensoes getDimensoes() {
		return dimensoes;
	}

	public void setDimensoes(Dimensoes dimensoes) {
		this.dimensoes = dimensoes;
	}
	
	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "Embalagem [id=" + id + ", dimensoes=" + dimensoes + ", itens=" + itens + ", pesoDosItens: " + calcularPeso() + "]";
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
		Embalagem other = (Embalagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public float calcularVolumeItens() {
		
		float volumeItens = 0;
		
		for (Item item : itens) {
			
			volumeItens += item.getDimensoes().calcularVolume();
			
		}
		
		return volumeItens;
	}
	
	public boolean cabeItem(Item item) {
		
		float volumeTotal = this.getDimensoes().calcularVolume();
		
		float volumeItens = calcularVolumeItens();
		
		float volumeRestante = volumeTotal - volumeItens;
		
		float volumeItem = item.getDimensoes().calcularVolume();
		
		return volumeRestante >= volumeItem;
	}
	
	
	public Embalagem clone() {
		
		Embalagem e = Embalagem.comDimensoes(
					this.dimensoes.getComprimento(), 
					this.dimensoes.getLargura(), 
					this.dimensoes.getAltura());
		
		e.getItens().addAll(itens);
		
		return e;
	}
	
	public float calcularPeso() {
		
		float pesoTotal = 0;
		
		for (Item item : itens) {
			
			pesoTotal += item.getPeso();
			
		}
		
		if( pesoTotal < 0.3 ) {
			pesoTotal = 0.3f;
		}
		
		return pesoTotal;
	}
	
}