package org.jm.correios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.jm.correios.embalagem.Embalagem;
import org.jm.correios.embalagem.Item;
import org.jm.correios.frete.CorreiosFreteDTO;
import org.jm.correios.frete.CorreiosFreteWSImpl;
import org.jm.correios.frete.ICorreiosFrete;
import org.jm.correios.frete.ServicoXml;
import org.jm.util.CepDestinoNuloOuVazioException;
import org.jm.util.CepOrigemNuloOuVazioException;
import org.jm.util.EmbalagemIndefinidaException;
import org.jm.util.ItemIndefinidoException;
import org.jm.util.TipoServicoNuloOuVazioException;
import org.jm.util.Utils;
import org.jm.util.ValorDeclaradoInvalidoException;

public class CorreiosFrete {
	
	private static ICorreiosFrete correiosFreteInstance;
	
	static {
		correiosFreteInstance = new CorreiosFreteWSImpl();
	}
	
	private CorreiosFreteDTO correiosFreteDTO = new CorreiosFreteDTO();
	
	private List<Embalagem> embalagens = new ArrayList<Embalagem>();
	
	private List<Item> itens = new ArrayList<Item>();
	
	public static CorreiosFrete novo() {
		
		CorreiosFrete correiosFrete = new CorreiosFrete();
		
		return correiosFrete;
	}
	
	public CorreiosFrete comEmpresaSenha(String cdEmpresa, String dsSenha) {
		
		this.correiosFreteDTO.setnCdEmpresa(cdEmpresa);
		this.correiosFreteDTO.setsDsSenha(dsSenha);
		
		return this;
	}
	
	public CorreiosFrete comTipoServico(String cdServico) {
		
		this.correiosFreteDTO.setnCdServico(cdServico);
		
		return this;
	}
	
	public CorreiosFrete comCepOrigemDestino(String cepOrigem, String cepDestino) {
		
		this.correiosFreteDTO.setsCepOrigem(cepOrigem);
		this.correiosFreteDTO.setsCepDestino(cepDestino);
		
		return this;
	}
	
	public CorreiosFrete comValorDeclarado(BigDecimal valorDeclarado) {
		
		this.correiosFreteDTO.setnVlValorDeclarado(valorDeclarado);
		
		return this;
	}
	
	public CorreiosFrete addEmbalagem(Embalagem embalagem) {
		
		this.embalagens.add(embalagem);
		
		return this;
	}
	
	public CorreiosFrete retirarEmbalagens() {
		
		this.embalagens.clear();
		
		return this;
	}
	
	public CorreiosFrete addItem(Item item) {
		
		this.itens.add(item);
		
		return this;
	}
	
	public CorreiosFrete retirarItens() {
		
		this.itens.clear();
		
		return this;
	}
	
	public List<ServicoXml> calcPrecoPrazo() {
		
		if( Utils.isNullOrBlank(this.correiosFreteDTO.getsCepOrigem()) ) {
			throw new CepOrigemNuloOuVazioException();
		}
		
		if( Utils.isNullOrBlank(this.correiosFreteDTO.getsCepDestino()) ) {
			throw new CepDestinoNuloOuVazioException();
		}
		
		if( Utils.isNullOrBlank(this.correiosFreteDTO.getnCdServico()) ) {
			throw new TipoServicoNuloOuVazioException();
		}
		
		if( ! this.correiosFreteDTO.ehValorDeclaradoValido() ) {
			throw new ValorDeclaradoInvalidoException();
		}

		if( this.embalagens.isEmpty() ) {
			throw new EmbalagemIndefinidaException();
		}
		
		if( this.itens.isEmpty() ) {
			throw new ItemIndefinidoException();
		}
		
		return correiosFreteInstance.calcPrecoPrazo(correiosFreteDTO);
		
	}
}