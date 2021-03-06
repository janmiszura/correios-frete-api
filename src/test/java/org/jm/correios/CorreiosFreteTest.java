package org.jm.correios;

import java.math.BigDecimal;
import java.util.List;

import org.jm.correios.embalagem.Embalagem;
import org.jm.correios.embalagem.Item;
import org.jm.correios.frete.TipoServico;
import org.jm.util.CepDestinoNuloOuVazioException;
import org.jm.util.CepOrigemNuloOuVazioException;
import org.jm.util.EmbalagemIndefinidaException;
import org.jm.util.ItemIndefinidoException;
import org.jm.util.TipoServicoNuloOuVazioException;
import org.jm.util.ValorDeclaradoInvalidoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CorreiosFreteTest {
    
	CorreiosFrete correiosFrete;
	
	@Before
	public void setUp() {
		
		correiosFrete = 
				CorreiosFrete
				.novo()
				.comTipoServico(TipoServico.PAC.getCodigo())
				.comCepOrigemDestino("74371520", "74672540")
				.addEmbalagem(Embalagem.CORREIOS_TIPO_4)
				.addItem(new Item(20, 12, 5, 1), 1)
				;
		
	}
	
	@Test(expected=CepOrigemNuloOuVazioException.class)
    public void testValidarCepOrigemNuloOuVazio() {
		
		correiosFrete.comCepOrigemDestino(null, "74000000");
		
		correiosFrete.calcPrecoPrazo();
		
    }
	
	@Test(expected=CepDestinoNuloOuVazioException.class)
	public void testValidarCepDestinoNuloOuVazio() {
		
		correiosFrete.comCepOrigemDestino("74000000", null);
		
		correiosFrete.calcPrecoPrazo();
		
	}
	
	@Test(expected=TipoServicoNuloOuVazioException.class)
	public void testValidarTipoServicoNuloOuVazio() {
		
		correiosFrete.comTipoServico(null);
		
		correiosFrete.calcPrecoPrazo();
		
	}
	
	@Test(expected=ValorDeclaradoInvalidoException.class)
	public void testValidarValorDeclaradoInvalido() {
		
		correiosFrete.comValorDeclarado(new BigDecimal(18.49));
		
		correiosFrete.calcPrecoPrazo();
		
	}
	
	@Test
	public void testValidarValorDeclaradoValidoIgual() {
		
		correiosFrete.comValorDeclarado(new BigDecimal(18.5));
		
		correiosFrete.calcPrecoPrazo();
		
	}
	
	@Test
	public void testValidarValorDeclaradoValidoMaior() {
		
		correiosFrete.comValorDeclarado(new BigDecimal(18.51));
		
		correiosFrete.calcPrecoPrazo();
		
	}
	
	@Test(expected=EmbalagemIndefinidaException.class)
	public void testValidarEmbalagensAdicionadas() {
		
		correiosFrete.retirarEmbalagens();
		
		correiosFrete.calcPrecoPrazo();
		
	}
	
	@Test(expected=ItemIndefinidoException.class)
	public void testValidarItensAdicionados() {
		
		correiosFrete.retirarItens();
		
		correiosFrete.calcPrecoPrazo();
		
	}
	
	@Test
	public void testSomaDosPesos() {
		
		List<Embalagem> embalagens = correiosFrete.calcularEmbalagensNecessarias();
		
		Assert.assertEquals(1d, embalagens.get(0).calcularPeso(), 0.01);
		
	}
	
	@Test
	public void testSomaDosPesosVariosItens() {
		
		correiosFrete.addItem(new Item(10, 4, 4, 0.5f), 3);
		
		List<Embalagem> embalagens = correiosFrete.calcularEmbalagensNecessarias();
		
		Assert.assertEquals(2.5d, embalagens.get(0).calcularPeso(), 0.01);
		
	}
	
	@Test
	public void testPesoMinimo() {
		
		CorreiosFrete correiosFrete = 
				CorreiosFrete
				.novo()
				.comTipoServico(TipoServico.PAC.getCodigo())
				.comCepOrigemDestino("74371520", "74672540")
				.addEmbalagem(Embalagem.CORREIOS_TIPO_4)
				.addItem(new Item(20, 12, 5, 0), 1)
				;
		
		List<Embalagem> embalagens = correiosFrete.calcularEmbalagensNecessarias();
		
		Assert.assertEquals(0.3d, embalagens.get(0).calcularPeso(), 0.001);
		
	}
	
	@Test
	public void testValidarEmbalagemItemMesmasDimensoes() {
		
		List<ResultadoFrete> resultados = correiosFrete
		.retirarEmbalagens()
		.addEmbalagem(new Embalagem(20, 12, 10))
		.retirarItens()
		.addItem(new Item(20, 12, 10, 0.5f), 1)
		.calcPrecoPrazo();
		
		Assert.assertEquals(1, resultados.size());
	}
}
