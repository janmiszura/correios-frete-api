package org.jm.correios.calculo_frete_api;

import java.math.BigDecimal;
import java.math.MathContext;

public class CorreiosFreteDTO {
	
	private String nCdEmpresa;
	
	private String sDsSenha;
	
	private String StrRetorno = "xml";
	
	private String nIndicaCalculo = "3";
	
	private String nCdServico;
	
	private String sCepOrigem;
	
	private String sCepDestino;
	
	private BigDecimal nVlPeso;//kg
	
	private String nCdFormato = "1";//caixa/pacote=1, rolo/prisma=2, Envelope=3
	
	private String nVlComprimento;//cm
	
	private String nVlAltura;//cm
	
	private String nVlLargura;//cm
	
	private String nVlDiametro;//cm
	
	private String sCdMaoPropria = "n";
	
	private BigDecimal nVlValorDeclarado;
	
	private String sCdAvisoRecebimento = "n";
	
	public CorreiosFreteDTO() {
		super();
		this.nCdEmpresa = "";
		this.sDsSenha = "";
		this.nCdServico = "";
		this.sCepOrigem= "";
		this.nVlPeso = new BigDecimal(0.3);//kg
		this.nVlComprimento = "16";
		this.nVlLargura = "11";
		this.nVlAltura = "2";
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

	public BigDecimal getnVlPeso() {
		return nVlPeso;
	}

	public void setnVlPeso(BigDecimal nVlPeso) {
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

	@Override
	public String toString() {
		return "CorreiosFreteDTO [nCdEmpresa=" + nCdEmpresa + ", sDsSenha=" + sDsSenha + ", StrRetorno=" + StrRetorno
				+ ", nIndicaCalculo=" + nIndicaCalculo + ", nCdServico=" + nCdServico + ", sCepOrigem=" + sCepOrigem
				+ ", sCepDestino=" + sCepDestino + ", nVlPeso=" + nVlPeso + ", nCdFormato=" + nCdFormato
				+ ", nVlComprimento=" + nVlComprimento + ", nVlAltura=" + nVlAltura + ", nVlLargura=" + nVlLargura
				+ ", nVlDiametro=" + nVlDiametro + ", sCdMaoPropria=" + sCdMaoPropria + ", nVlValorDeclarado="
				+ nVlValorDeclarado + ", sCdAvisoRecebimento=" + sCdAvisoRecebimento + "]";
	}

	
	
	
}