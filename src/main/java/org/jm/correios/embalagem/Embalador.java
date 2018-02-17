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
	
	public Embalador addItem(Item item, Integer qtd) {
		
		for (int i = 0; i < qtd; i++) {
			itens.add( item.clone() );
		}
		
		return this;
	}
	
	private Boolean embalagensComDimensoesPermitidas() {
		
		Boolean retorno = true;
		
		for (Embalagem embalagem : embalagensDisponiveis) {
			
			if( ! embalagem.getDimensoes().ehValidaComoEmbalagem() ) {
				retorno = false;
			}
			
		}
		
		return retorno;
	}
	
	private Boolean itensComDimensoesPermitidas() {
		
		Boolean retorno = true;
		
		for (Item item : itens) {
			
			if( ! item.getDimensoes().ehValidaComoItem() ) {
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