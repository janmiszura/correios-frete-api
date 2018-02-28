package org.jm.correios.embalagem;

import java.util.ArrayList;
import java.util.List;

import org.jm.util.DimensoesInvalidasException;
import org.jm.util.EmbalagemIndefinidaException;
import org.jm.util.ItemIndefinidoException;

public class Embalador {
	
	private List<Embalagem> embalagensDisponiveis = new ArrayList<Embalagem>();
	
	private List<Item> itens = new ArrayList<Item>();
	
	private List<Embalagem> embalagensNecessarias = new ArrayList<Embalagem>();
	
	public static Embalador novo() {
		return new Embalador();
	}
	
	public Embalador addEmbalagemDisponivel(Embalagem embalagem) {
		
		this.embalagensDisponiveis.add(embalagem);
		
		return this;
	}
	
	public Embalador retirarEmbalagensDisponiveis() {
		
		this.embalagensDisponiveis.clear();
		
		return this;
	}
	
	public Embalador addItem(Item item, Integer qtd) {
		
		for (int i = 0; i < qtd; i++) {
			itens.add( item.clone() );
		}
		
		return this;
	}
	
	public Embalador retirarItens() {
		
		this.itens.clear();
		
		return this;
	}
	
	private void verificarEmbalagensComDimensoesPermitidas() {
		
		for (Embalagem embalagem : embalagensDisponiveis) {
			
			embalagem.getDimensoes().ehValidaComoEmbalagem();
			
		}
		
	}
	
	private void verificarItensComDimensoesPermitidas() {
		
		for (Item item : itens) {
			
			item.getDimensoes().ehValidaComoItem();
			
		}
		
	}
	
	public void validar() {
		
		if( this.embalagensDisponiveis.isEmpty() ) {
			throw new EmbalagemIndefinidaException();
		}
		
		if( this.itens.isEmpty() ) {
			throw new ItemIndefinidoException();
		}
		
		verificarEmbalagensComDimensoesPermitidas();
		
		verificarItensComDimensoesPermitidas();
		
	}
	
	public List<Embalagem> calcular() {
		
		validar();
		
		int flag = 0;
		while( haItemParaEmbalar() ) {
			
			if( flag == itens.size()*5 ) {
				break;
			}
			
			embalarItens();
			
			flag++;
		}
		
		return embalagensNecessarias;
	}

	private Boolean haItemParaEmbalar() {
		
		Boolean retorno = false;
		
		for (Item item : itens) {
			
			if( ! item.getJaEmbalado() ) {
				retorno = true;
			}
		}
		
		return retorno;
	}
	
	private void embalarItens() {
		
		for (Embalagem embalagem : embalagensDisponiveis) {
			
			for (Item item : itens) {
				
				if( item.getJaEmbalado() ) {
					continue;
				}
				
				if( embalagem.cabeItem(item) ) {
					
					embalagem.getItens().add(item);
					item.setJaEmbalado(true);
					
				}
				
			}
			
			embalagensNecessarias.add( embalagem.clone() );
			embalagem.getItens().clear();
			
		}
		
	}
}