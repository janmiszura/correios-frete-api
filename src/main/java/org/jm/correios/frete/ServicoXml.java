package org.jm.correios.frete;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("cServico")
public class ServicoXml {
	
	@XStreamAlias("Servico")
	private String servico;

	@XStreamAlias("Codigo")
	private String codigo;
	
	@XStreamAlias("ValorAvisoRecebimento")
	private String valorAvisoRecebimento;
	
	private String UfDestino;
	private String UfOrigem;
	
	@XStreamAlias("Erro")
	private String erro;
	
	@XStreamAlias("MsgErro")
	private String msgErro;
	
	@XStreamAlias("EntregaDomiciliar")
	private String entregaDomiciliar;
	
	@XStreamAlias("Valor")
	private String valor;
	
	@XStreamAlias("ValorSemAdicionais")
	private String valorSemAdicionais;
	
	@XStreamAlias("ValorValorDeclarado")
	private String valorValorDeclarado;
	
	private String Peso;
	
	private String CepOrigem;
	
	private String CepDestino;
	
	@XStreamAlias("PrazoEntrega")
	private String prazoEntrega;
	
	private String LocalDestino;
	
	@XStreamAlias("ValorMaoPropria")
	private String valorMaoPropria;
	
	@XStreamAlias("EntregaSabado")
	private String entregaSabado;
	
	private String LocalOrigem;
	
	@XStreamAlias("CodRestricao")
	private String codRestricao;
	
	@XStreamAlias("DefRestricao")
	private String defRestricao;
	
	@XStreamAlias("MsgRestricao")
	private String msgRestricao;
	
	@XStreamAlias("TipoLog")
	private String tipoLog;
	
	private String obsFim;
	


	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getValorAvisoRecebimento() {
		return valorAvisoRecebimento;
	}

	public String getUfDestino() {
		return UfDestino;
	}

	public String getUfOrigem() {
		return UfOrigem;
	}

	public String getErro() {
		return erro;
	}

	public String getMsgErro() {
		return msgErro;
	}

	public String getEntregaDomiciliar() {
		return entregaDomiciliar;
	}

	public String getValor() {
		return valor;
	}

	public String getValorValorDeclarado() {
		return valorValorDeclarado;
	}

	public String getPeso() {
		return Peso;
	}

	public String getCepOrigem() {
		return CepOrigem;
	}

	public String getCepDestino() {
		return CepDestino;
	}

	public String getPrazoEntrega() {
		return prazoEntrega;
	}

	public String getLocalDestino() {
		return LocalDestino;
	}

	public String getValorMaoPropria() {
		return valorMaoPropria;
	}

	public String getEntregaSabado() {
		return entregaSabado;
	}

	public String getLocalOrigem() {
		return LocalOrigem;
	}

	public String getValorSemAdicionais() {
		return valorSemAdicionais;
	}

	public String getCodRestricao() {
		return codRestricao;
	}

	public String getDefRestricao() {
		return defRestricao;
	}

	public String getMsgRestricao() {
		return msgRestricao;
	}

	public String getTipoLog() {
		return tipoLog;
	}

	public String getObsFim() {
		return obsFim;
	}

	public void setObsFim(String obsFim) {
		this.obsFim = obsFim;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setValorAvisoRecebimento(String valorAvisoRecebimento) {
		this.valorAvisoRecebimento = valorAvisoRecebimento;
	}

	public void setUfDestino(String ufDestino) {
		UfDestino = ufDestino;
	}

	public void setUfOrigem(String ufOrigem) {
		UfOrigem = ufOrigem;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public void setMsgErro(String msgErro) {
		this.msgErro = msgErro;
	}

	public void setEntregaDomiciliar(String entregaDomiciliar) {
		this.entregaDomiciliar = entregaDomiciliar;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void setValorSemAdicionais(String valorSemAdicionais) {
		this.valorSemAdicionais = valorSemAdicionais;
	}

	public void setValorValorDeclarado(String valorValorDeclarado) {
		this.valorValorDeclarado = valorValorDeclarado;
	}

	public void setPeso(String peso) {
		Peso = peso;
	}

	public void setCepOrigem(String cepOrigem) {
		CepOrigem = cepOrigem;
	}

	public void setCepDestino(String cepDestino) {
		CepDestino = cepDestino;
	}

	public void setPrazoEntrega(String prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public void setLocalDestino(String localDestino) {
		LocalDestino = localDestino;
	}

	public void setValorMaoPropria(String valorMaoPropria) {
		this.valorMaoPropria = valorMaoPropria;
	}

	public void setEntregaSabado(String entregaSabado) {
		this.entregaSabado = entregaSabado;
	}

	public void setLocalOrigem(String localOrigem) {
		LocalOrigem = localOrigem;
	}

	public void setCodRestricao(String codRestricao) {
		this.codRestricao = codRestricao;
	}

	public void setDefRestricao(String defRestricao) {
		this.defRestricao = defRestricao;
	}

	public void setMsgRestricao(String msgRestricao) {
		this.msgRestricao = msgRestricao;
	}

	public void setTipoLog(String tipoLog) {
		this.tipoLog = tipoLog;
	}

	@Override
	public String toString() {
		return "ServicoFreteCorreiosXml [servico=" + servico + ", codigo=" + codigo + ", valorAvisoRecebimento="
				+ valorAvisoRecebimento + ", UfDestino=" + UfDestino + ", UfOrigem=" + UfOrigem + ", erro=" + erro
				+ ", msgErro=" + msgErro + ", entregaDomiciliar=" + entregaDomiciliar + ", valor=" + valor
				+ ", valorSemAdicionais=" + valorSemAdicionais + ", valorValorDeclarado=" + valorValorDeclarado
				+ ", Peso=" + Peso + ", CepOrigem=" + CepOrigem + ", CepDestino=" + CepDestino + ", prazoEntrega="
				+ prazoEntrega + ", LocalDestino=" + LocalDestino + ", valorMaoPropria=" + valorMaoPropria
				+ ", entregaSabado=" + entregaSabado + ", LocalOrigem=" + LocalOrigem + ", codRestricao=" + codRestricao
				+ ", defRestricao=" + defRestricao + ", msgRestricao=" + msgRestricao + ", tipoLog=" + tipoLog
				+ ", obsFim=" + obsFim + "]";
	}
	
	
}
