package org.jm.correios.embalagem;

import org.jm.util.EmbalagemInvalidaException;
import org.junit.Assert;
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
		
		Assert.assertTrue( embalagem.ehValida() );
		
	}
	
	@Test(expected=EmbalagemInvalidaException.class)
	public void testValidarDimensoesMinimasComprimento() {
		
		embalagem.setComprimento(15);
		
		embalagem.ehValida();
	}
	
	@Test(expected=EmbalagemInvalidaException.class)
	public void testValidarDimensoesMinimasLargura() {
		
		embalagem.setLargura(10);
		
		embalagem.ehValida();
	}
	
	@Test(expected=EmbalagemInvalidaException.class)
	public void testValidarDimensoesMinimasAltura() {
		
		embalagem.setAltura(1);
		
		embalagem.ehValida();
		
	}
	
	@Test(expected=EmbalagemInvalidaException.class)
	public void testValidarDimensoesMaximasComprimento() {
		
		embalagem.setComprimento(106);
		
		embalagem.ehValida();
		
	}
	
	@Test(expected=EmbalagemInvalidaException.class)
	public void testValidarDimensoesMaximasLargura() {
		
		embalagem.setLargura(106);
		
		embalagem.ehValida();
		
	}
	
	@Test(expected=EmbalagemInvalidaException.class)
	public void testValidarDimensoesMaximasAltura() {
		
		embalagem.setAltura(106);
		
		embalagem.ehValida();
		
	}
	
	@Test(expected=EmbalagemInvalidaException.class)
	public void testValidarDimensoesRegraDaSomaSuperar200() {
		
		embalagem = new Embalagem(105, 50, 50);
		
		embalagem.ehValida();
		
	}
}
