package org.jm.correios.embalagem;

import java.util.List;

import org.jm.util.AlturaMaximaInvalidaException;
import org.jm.util.ComprimentoMaximoInvalidoException;
import org.jm.util.EmbalagemIndefinidaException;
import org.jm.util.ItemIndefinidoException;
import org.jm.util.LarguraMaximaInvalidaException;
import org.jm.util.LimiteDaSomaDasDimensoesExcedidoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmbaladorTest {
	
	@Before
	public void setUp() {
	}
	
	@Test(expected=EmbalagemIndefinidaException.class)
    public void testEmbalagemIndefinida() {
		
		Embalador.novo().calcular();
		
	}
	
	@Test(expected=ItemIndefinidoException.class)
	public void testItemIndefinido() {
		
		Embalador
		.novo()
		.addEmbalagemDisponivel(Embalagem.CORREIOS_TIPO_4)
		.calcular();
		
	}
	
	@Test(expected=ComprimentoMaximoInvalidoException.class)
	public void testEmbalagemNaoPermitidaViaCorreios() {
		
		Embalador
		.novo()
		.addEmbalagemDisponivel(new Embalagem(106, 15, 10))
		.addItem(new Item(105, 15, 10, 1), 1)
		.calcular();
		
	}
	
	@Test(expected=ComprimentoMaximoInvalidoException.class)
	public void testItemNaoPermitidoViaCorreiosComprimentoMaximo() {
		
		Embalador
		.novo()
		.addEmbalagemDisponivel(Embalagem.CORREIOS_TIPO_4)
		.addItem(new Item(106, 15, 10, 1), 1)
		.calcular();
		
	}
	
	@Test(expected=LarguraMaximaInvalidaException.class)
	public void testItemNaoPermitidoViaCorreiosLarguraMaxima() {
		
		Embalador
		.novo()
		.addEmbalagemDisponivel(Embalagem.CORREIOS_TIPO_4)
		.addItem(new Item(20, 106, 10, 1), 1)
		.calcular();
		
	}
	
	@Test(expected=AlturaMaximaInvalidaException.class)
	public void testItemNaoPermitidoViaCorreiosAlturaMaxima() {
		
		Embalador
		.novo()
		.addEmbalagemDisponivel(Embalagem.CORREIOS_TIPO_4)
		.addItem(new Item(20, 10, 106, 1), 1)
		.calcular();
		
	}
	
	@Test(expected=LimiteDaSomaDasDimensoesExcedidoException.class)
	public void testItemNaoPermitidoViaCorreiosSomaDasDimensoes() {
		
		Embalador
		.novo()
		.addEmbalagemDisponivel(Embalagem.CORREIOS_TIPO_4)
		.addItem(new Item(80, 80, 70, 1), 1)
		.calcular();
		
	}
	
	@Test
    public void testEmbalagemUmItem() {
		
		List<Embalagem> embalagensNecessarias = 
				Embalador
				.novo()
				.addEmbalagemDisponivel(Embalagem.CORREIOS_TIPO_4)
				.addItem(new Item(20, 15, 10, 1), 1)
				.calcular();
		
		Assert.assertEquals(1, embalagensNecessarias.size());
		Assert.assertEquals(Embalagem.CORREIOS_TIPO_4.getDimensoes(), embalagensNecessarias.get(0).getDimensoes());
		
	}
	
	@Test
	public void testEmbalagemEItemMesmasDimensoes() {
		
		float comp = 20;
		float larg = 15;
		float alt = 10;
		
		List<Embalagem> embalagensNecessarias = 
				Embalador
				.novo()
				.addEmbalagemDisponivel(new Embalagem(comp, larg, alt))
				.addItem(new Item(comp, larg, alt, 1), 1)
				.calcular();
		
		Assert.assertEquals(1, embalagensNecessarias.size());
		
	}
	
	@Test
	public void testEmbalagemDoisItensPequenosUmaEmbalagem() {
		
		List<Embalagem> embalagensNecessarias = 
				Embalador
				.novo()
				.addEmbalagemDisponivel(Embalagem.CORREIOS_TIPO_4)
				.addItem(new Item(20, 12, 15, 1), 2)
				.calcular();
		
		Assert.assertEquals(1, embalagensNecessarias.size());
		Assert.assertEquals(Embalagem.CORREIOS_TIPO_4.getDimensoes(), embalagensNecessarias.get(0).getDimensoes());
	}
	
	@Test
	public void testEmbalagemDoisItensGrandesDuasEmbalagens() {
		
		List<Embalagem> embalagensNecessarias = 
				Embalador
				.novo()
				.addEmbalagemDisponivel(Embalagem.CORREIOS_TIPO_4)
				.addItem(new Item(30, 20, 15, 1), 2)
				.calcular();
		
		Assert.assertEquals(2, embalagensNecessarias.size());
		Assert.assertEquals(Embalagem.CORREIOS_TIPO_4.getDimensoes(), embalagensNecessarias.get(0).getDimensoes());
		Assert.assertEquals(Embalagem.CORREIOS_TIPO_4.getDimensoes(), embalagensNecessarias.get(1).getDimensoes());
	}
}
