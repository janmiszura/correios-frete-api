package org.jm.correios.embalagem;

import org.jm.util.AlturaMinimaInvalidaException;
import org.jm.util.ComprimentoMaximoInvalidoException;
import org.jm.util.ComprimentoMinimoInvalidoException;
import org.jm.util.DimensoesInvalidasException;
import org.jm.util.LarguraMaximaInvalidaException;
import org.jm.util.LarguraMinimaInvalidaException;
import org.junit.Before;
import org.junit.Test;

public class EmbalagemTest {
	
	Embalagem embalagem;
	
	@Before
	public void setUp() {
		embalagem = new Embalagem(16, 11, 2);
	}
	
	@Test
    public void testValidarDimensoesMinimas() {
		
		embalagem.getDimensoes().ehValidaComoEmbalagem();
		
	}
	
	@Test(expected=ComprimentoMinimoInvalidoException.class)
	public void testValidarDimensoesMinimasComprimento() {
		
		embalagem.getDimensoes().setComprimento(15);
		
		embalagem.getDimensoes().ehValidaComoEmbalagem();
	}
	
	@Test(expected=LarguraMinimaInvalidaException.class)
	public void testValidarDimensoesMinimasLargura() {
		
		embalagem.getDimensoes().setLargura(10);
		
		embalagem.getDimensoes().ehValidaComoEmbalagem();
	}
	
	@Test(expected=AlturaMinimaInvalidaException.class)
	public void testValidarDimensoesMinimasAltura() {
		
		embalagem.getDimensoes().setAltura(1);
		
		embalagem.getDimensoes().ehValidaComoEmbalagem();
		
	}
	
	@Test(expected=ComprimentoMaximoInvalidoException.class)
	public void testValidarDimensoesMaximasComprimento() {
		
		embalagem.getDimensoes().setComprimento(106);
		
		embalagem.getDimensoes().ehValidaComoEmbalagem();
		
	}
	
	@Test(expected=LarguraMaximaInvalidaException.class)
	public void testValidarDimensoesMaximasLargura() {
		
		embalagem.getDimensoes().setLargura(106);
		
		embalagem.getDimensoes().ehValidaComoEmbalagem();
		
	}
	
	@Test(expected=DimensoesInvalidasException.class)
	public void testValidarDimensoesMaximasAltura() {
		
		embalagem.getDimensoes().setAltura(106);
		
		embalagem.getDimensoes().ehValidaComoEmbalagem();
		
	}
	
	@Test(expected=DimensoesInvalidasException.class)
	public void testValidarDimensoesRegraDaSomaSuperar200() {
		
		embalagem = new Embalagem(105, 50, 50);
		
		embalagem.getDimensoes().ehValidaComoEmbalagem();
		
	}
}
