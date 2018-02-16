package org.jm.correios;

import java.math.BigDecimal;

import org.jm.correios.calculo_frete_api.TipoServico;
import org.jm.util.CepDestinoNuloOuVazioException;
import org.jm.util.CepOrigemNuloOuVazioException;
import org.jm.util.TipoServicoNuloOuVazioException;
import org.jm.util.ValorDeclaradoInvalidoException;
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
				.comCepOrigemDestino("74371520", "74672540");
		
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
}
