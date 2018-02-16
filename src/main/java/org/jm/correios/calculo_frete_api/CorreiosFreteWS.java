package org.jm.correios.calculo_frete_api;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.jm.util.CorreiosFreteException;
import org.jm.util.HttpUteis;

public class CorreiosFreteWS {
	
	static Logger logger = Logger.getLogger(CorreiosFreteWS.class);
	
	private String nCdEmpresa;
	
	private String sDsSenha;
	
	private String StrRetorno = "xml";
	
	private String nIndicaCalculo = "3";
	
	private String nCdServico;
	
	private String sCepOrigem;
	
	private String sCepDestino;
	
	private String nVlPeso;//kg
	
	private String nCdFormato = "1";//caixa/pacote=1, rolo/prisma=2, Envelope=3
	
	private String nVlComprimento;//cm
	
	private String nVlAltura;//cm
	
	private String nVlLargura;//cm
	
	private String nVlDiametro;//cm
	
	private String sCdMaoPropria = "n";
	
	private BigDecimal nVlValorDeclarado;
	
	private BigDecimal VALOR_DECLARADO_MINIMO = new BigDecimal(18.5);
	
	private String sCdAvisoRecebimento = "n";
	
	public CorreiosFreteWS() {
		super();
		this.nCdEmpresa = "";
		this.sDsSenha = "";
		this.nCdServico = "";
		this.sCepOrigem= "74510010";
		this.nVlPeso = "";//kg
		this.nVlComprimento = "16";
		this.nVlLargura = "11";
		this.nVlAltura = "2";
	}
	
	public List<ServicoXml> calcular() {
	    
		String url = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx";
	    url += "?nCdEmpresa="+nCdEmpresa;
	    url += "&sDsSenha="+sDsSenha;
	    url += "&StrRetorno="+StrRetorno;
	    url += "&nIndicaCalculo="+nIndicaCalculo;
	    url += "&nCdServico="+nCdServico;
	    url += "&sCepOrigem="+sCepOrigem;
	    url += "&sCepDestino="+sCepDestino;
	    url += "&nVlPeso="+nVlPeso;
	    url += "&nCdFormato="+nCdFormato;
	    url += "&nVlComprimento="+nVlComprimento;
	    url += "&nVlAltura="+nVlAltura;
		url += "&nVlLargura="+nVlLargura;
	    if( nVlDiametro != null ) {
	    	url += "&nVlDiametro="+nVlDiametro;
	    }
	    url += "&sCdMaoPropria="+sCdMaoPropria;
	    
	    if( nVlValorDeclarado != null ) {
	    	if( nVlValorDeclarado.doubleValue() < VALOR_DECLARADO_MINIMO.doubleValue() ) {
	    		nVlValorDeclarado = VALOR_DECLARADO_MINIMO;
	    	}
	    }
	    
	    url += "&nVlValorDeclarado="+(nVlValorDeclarado!=null?nVlValorDeclarado.intValue():VALOR_DECLARADO_MINIMO.toString());
	    url += "&sCdAvisoRecebimento="+sCdAvisoRecebimento;
	    
	    if( logger.isDebugEnabled() ) {
	    	logger.debug(url);
	    }
	    
		String respostaXml = HttpUteis.sendGet(url, "UTF-8");
		
		if( logger.isDebugEnabled() ) {
			logger.debug(respostaXml);
		}
		
		if( ! respostaXml.contains("<Erro>0</Erro>") ) {
			throw new CorreiosFreteException("erro ao consultar cep: "+this.sCepDestino);
		}
		
		List<ServicoXml> fretes = ServicosXml.fromXml(respostaXml);
		
		return fretes;
	}

	public String getStrRetorno() {
		return StrRetorno;
	}

	public void setStrRetorno(String strRetorno) {
		StrRetorno = strRetorno;
	}

	public String getnIndicaCalculo() {
		return nIndicaCalculo;
	}

	public void setnIndicaCalculo(String nIndicaCalculo) {
		this.nIndicaCalculo = nIndicaCalculo;
	}

	public String getnCdEmpresa() {
		return nCdEmpresa;
	}

	public void setnCdEmpresa(String nCdEmpresa) {
		this.nCdEmpresa = nCdEmpresa;
	}

	public String getsDsSenha() {
		return sDsSenha;
	}

	public void setsDsSenha(String sDsSenha) {
		this.sDsSenha = sDsSenha;
	}

	public String getnCdServico() {
		return nCdServico;
	}

	public void setnCdServico(String nCdServico) {
		this.nCdServico = nCdServico;
	}

	public String getsCepOrigem() {
		return sCepOrigem;
	}

	public void setsCepOrigem(String sCepOrigem) {
		this.sCepOrigem = sCepOrigem;
	}

	public String getsCepDestino() {
		return sCepDestino;
	}

	public void setsCepDestino(String sCepDestino) {
		this.sCepDestino = sCepDestino;
	}

	public String getnVlPeso() {
		return nVlPeso;
	}

	public void setnVlPeso(String nVlPeso) {
		this.nVlPeso = nVlPeso;
	}

	public String getnCdFormato() {
		return nCdFormato;
	}

	public void setnCdFormato(String nCdFormato) {
		this.nCdFormato = nCdFormato;
	}

	public String getnVlComprimento() {
		return nVlComprimento;
	}

	public void setnVlComprimento(String nVlComprimento) {
		this.nVlComprimento = nVlComprimento;
	}

	public String getnVlAltura() {
		return nVlAltura;
	}

	public void setnVlAltura(String nVlAltura) {
		this.nVlAltura = nVlAltura;
	}

	public String getnVlLargura() {
		return nVlLargura;
	}

	public void setnVlLargura(String nVlLargura) {
		this.nVlLargura = nVlLargura;
	}

	public String getnVlDiametro() {
		return nVlDiametro;
	}

	public void setnVlDiametro(String nVlDiametro) {
		this.nVlDiametro = nVlDiametro;
	}

	public String getsCdMaoPropria() {
		return sCdMaoPropria;
	}

	public void setsCdMaoPropria(String sCdMaoPropria) {
		this.sCdMaoPropria = sCdMaoPropria;
	}

	public BigDecimal getnVlValorDeclarado() {
		return nVlValorDeclarado;
	}

	public void setnVlValorDeclarado(BigDecimal nVlValorDeclarado) {
		this.nVlValorDeclarado = nVlValorDeclarado;
	}

	public String getsCdAvisoRecebimento() {
		return sCdAvisoRecebimento;
	}

	public void setsCdAvisoRecebimento(String sCdAvisoRecebimento) {
		this.sCdAvisoRecebimento = sCdAvisoRecebimento;
	}

	
	
	
}