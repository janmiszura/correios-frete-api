package org.jm.correios;

import java.util.List;

import org.jm.correios.calculo_frete_api.CorreiosFreteDTO;
import org.jm.correios.calculo_frete_api.CorreiosFreteWSImpl;
import org.jm.correios.calculo_frete_api.ICorreiosFrete;
import org.jm.correios.calculo_frete_api.ServicoXml;
import org.jm.util.CepDestinoNuloOuVazioException;
import org.jm.util.CepOrigemNuloOuVazioException;
import org.jm.util.TipoServicoNuloOuVazioException;
import org.jm.util.Utils;

public class CorreiosFrete {
	
	private static ICorreiosFrete correiosFreteInstance;
	
	static {
		correiosFreteInstance = new CorreiosFreteWSImpl();
	}
	
	private CorreiosFreteDTO correiosFreteDTO = new CorreiosFreteDTO();
	
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
		
		return correiosFreteInstance.calcPrecoPrazo(correiosFreteDTO);
		
	}
}