package org.jm.correios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jm.correios.embalagem.Embalador;
import org.jm.correios.embalagem.Embalagem;
import org.jm.correios.embalagem.Item;
import org.jm.correios.frete.CorreiosFreteDTO;
import org.jm.correios.frete.CorreiosFreteWSImpl;
import org.jm.correios.frete.ICorreiosFrete;
import org.jm.correios.frete.ServicoXml;
import org.jm.util.CepDestinoNuloOuVazioException;
import org.jm.util.CepOrigemNuloOuVazioException;
import org.jm.util.TipoServicoNuloOuVazioException;
import org.jm.util.Utils;
import org.jm.util.ValorDeclaradoInvalidoException;

public class CorreiosFrete {
	
	static Logger logger = Logger.getLogger(CorreiosFrete.class);
	
	private static ICorreiosFrete correiosFreteInstance;
	
	static {
		correiosFreteInstance = new CorreiosFreteWSImpl();
	}
	
	private CorreiosFreteDTO correiosFreteDTO = new CorreiosFreteDTO();
	
	private Embalador embalador = Embalador.novo();
	
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
		
		this.embalador.addEmbalagemDisponivel(embalagem);
		
		return this;
	}
	
	public CorreiosFrete retirarEmbalagens() {
		
		this.embalador.retirarEmbalagensDisponiveis();
		
		return this;
	}
	
	public CorreiosFrete addItem(Item item, Integer qtd) {
		
		this.embalador.addItem(item, qtd);
		
		return this;
	}
	
	public CorreiosFrete retirarItens() {
		
		this.embalador.retirarItens();
		
		return this;
	}
	
	public List<Embalagem> calcularEmbalagensNecessarias() {
		List<Embalagem> embalagens = embalador.calcular();
		return embalagens;
	}
	
	public List<ResultadoFrete> calcPrecoPrazo() {
		
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
		
		List<Embalagem> embalagens = calcularEmbalagensNecessarias();
		
		List<ResultadoFrete> resultados = new ArrayList<ResultadoFrete>();
		
		for (Embalagem embalagem : embalagens) {
			
			correiosFreteDTO.comEmbalagem(embalagem);
			
			if( logger.isDebugEnabled() ) {
				logger.debug("("+embalagem.getId()+"): "+embalagem);
			}
			
			List<ServicoXml> servicosXml = correiosFreteInstance.calcPrecoPrazo(correiosFreteDTO);
			
			resultados.add( new ResultadoFrete(embalagem, servicosXml) );
		}
		
		return resultados;
		
	}
}