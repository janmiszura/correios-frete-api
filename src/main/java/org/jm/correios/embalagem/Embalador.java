package org.jm.correios.embalagem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jm.util.DimensoesInvalidasException;
import org.jm.util.EmbalagemIndefinidaException;
import org.jm.util.ItemIndefinidoException;

public class Embalador {
	
	private List<Embalagem> embalagensDisponiveis = new ArrayList<Embalagem>();
	
	private Map<Item, Integer> itens = new HashMap<Item, Integer>();
	
	private List<Embalagem> embalagensNecessarias = new ArrayList<Embalagem>();
	
	public static Embalador novo() {
		return new Embalador();
	}
	
	public Embalador addEmbalagemDisponivel(Embalagem embalagem) {
		
		this.embalagensDisponiveis.add(embalagem);
		
		return this;
	}
	
	public Embalador addItem(Item item, Integer qtd) {
		
		Integer qtdTotal = itens.get(item);
		
		if( qtdTotal == null ) {
			qtdTotal = 0;
		}
		
		qtdTotal += qtd;
		
		this.itens.put(item, qtdTotal);
		
		return this;
	}
	
	private Boolean embalagensComDimensoesPermitidas() {
		
		Boolean retorno = true;
		
		for (Embalagem embalagem : embalagensDisponiveis) {
			
			if( ! embalagem.getDimensoes().ehValida() ) {
				retorno = false;
			}
			
		}
		
		return retorno;
	}
	
	private Boolean itensComDimensoesPermitidas() {
		
		Boolean retorno = true;
		
		for (Item item : itens.keySet()) {
			
			if( ! item.getDimensoes().ehValida() ) {
				retorno = false;
			}
			
		}
		
		return retorno;
	}
	
	public List<Embalagem> calcular() {
		
		if( this.embalagensDisponiveis.isEmpty() ) {
			throw new EmbalagemIndefinidaException();
		}
		
		if( this.itens.isEmpty() ) {
			throw new ItemIndefinidoException();
		}
		
		if( ! embalagensComDimensoesPermitidas() ) {
			throw new DimensoesInvalidasException();
		}
		
		if( ! itensComDimensoesPermitidas() ) {
			throw new DimensoesInvalidasException();
		}
		
		Embalagem e = embalagensDisponiveis.get(0);
		
		embalagensNecessarias.add(e);
		
		return embalagensNecessarias;
	}
}