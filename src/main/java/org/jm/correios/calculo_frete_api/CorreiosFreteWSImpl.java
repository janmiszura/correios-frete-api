package org.jm.correios.calculo_frete_api;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.apache.log4j.Logger;
import org.jm.util.CorreiosFreteException;
import org.jm.util.HttpUteis;

public class CorreiosFreteWSImpl implements ICorreiosFrete {
	
	static Logger logger = Logger.getLogger(CorreiosFreteWSImpl.class);
	
	private BigDecimal VALOR_DECLARADO_MINIMO = new BigDecimal(18.5);
	
	public List<ServicoXml> calcPrecoPrazo(CorreiosFreteDTO correiosFreteDTO) throws CorreiosFreteException {
		
		String url = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx";
	    url += "?nCdEmpresa="+correiosFreteDTO.getnCdEmpresa();
	    url += "&sDsSenha="+correiosFreteDTO.getsDsSenha();
	    url += "&StrRetorno="+correiosFreteDTO.getStrRetorno();
	    url += "&nIndicaCalculo="+correiosFreteDTO.getnIndicaCalculo();
	    url += "&nCdServico="+correiosFreteDTO.getnCdServico();
	    
	    url += "&sCepOrigem="+correiosFreteDTO.getsCepOrigem();
	    url += "&sCepDestino="+correiosFreteDTO.getsCepDestino();
	    
	    url += "&nCdFormato="+correiosFreteDTO.getnCdFormato();
	    
	    url += "&nVlPeso="+formatNumber(correiosFreteDTO.getnVlPeso());
	    url += "&nVlComprimento="+formatNumber(correiosFreteDTO.getnVlComprimento());
	    url += "&nVlAltura="+formatNumber(correiosFreteDTO.getnVlAltura());
		url += "&nVlLargura="+formatNumber(correiosFreteDTO.getnVlLargura());
	    
		if( correiosFreteDTO.getnVlDiametro() != null ) {
			url += "&nVlDiametro="+formatNumber(correiosFreteDTO.getnVlDiametro());
		}
		
	    url += "&sCdMaoPropria="+correiosFreteDTO.getsCdMaoPropria();
	    
	    BigDecimal valorDeclarado = correiosFreteDTO.getnVlValorDeclarado();
	    
	    if( valorDeclarado != null ) {
	    	if( valorDeclarado.doubleValue() < VALOR_DECLARADO_MINIMO.doubleValue() ) {
	    		valorDeclarado = VALOR_DECLARADO_MINIMO;
	    	}
	    }
	    
	    url += "&nVlValorDeclarado="+(valorDeclarado!=null?valorDeclarado.toString():VALOR_DECLARADO_MINIMO.toString());
	    
	    url += "&sCdAvisoRecebimento="+correiosFreteDTO.getsCdAvisoRecebimento();
	    
	    if( logger.isDebugEnabled() ) {
	    	logger.debug(url);
	    }
	    
		String respostaXml = HttpUteis.sendGet(url, "UTF-8");
		
		if( logger.isDebugEnabled() ) {
			logger.debug(respostaXml);
		}
		
		if( ! respostaXml.contains("<Erro>0</Erro>") ) {
			throw new CorreiosFreteException("erro ao consultar cep: "+correiosFreteDTO.getsCepDestino());
		}
		
		List<ServicoXml> fretes = ServicosXml.fromXml(respostaXml);
		
		return fretes;
	}
	
	private String formatNumber(BigDecimal v) {
		
		if( v == null ) {
			return "";
		}
		
		return v.setScale(2, RoundingMode.HALF_DOWN).toPlainString();
	}
}