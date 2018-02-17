package org.jm.correios.embalagem;

import java.util.List;

import org.jm.util.DimensoesInvalidasException;
import org.jm.util.EmbalagemIndefinidaException;
import org.jm.util.ItemIndefinidoException;
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
	
	@Test(expected=DimensoesInvalidasException.class)
	public void testEmbalagemNaoPermitidaViaCorreios() {
		
		Embalador
		.novo()
		.addEmbalagemDisponivel(new Embalagem(106, 15, 10))
		.addItem(new Item(105, 15, 10), 1)
		.calcular();
		
	}
	
	@Test(expected=DimensoesInvalidasException.class)
	public void testItemNaoPermitidoViaCorreios() {
		
		Embalador
		.novo()
		.addEmbalagemDisponivel(Embalagem.CORREIOS_TIPO_4)
		.addItem(new Item(106, 15, 10), 1)
		.calcular();
		
	}
	
	@Test
    public void testEmbalagemUmItem() {
		
		List<Embalagem> embalagensNecessarias = 
				Embalador
				.novo()
				.addEmbalagemDisponivel(Embalagem.CORREIOS_TIPO_4)
				.addItem(new Item(20, 15, 10), 1)
				.calcular();
		
		Assert.assertEquals(1, embalagensNecessarias.size());
		Assert.assertEquals(Embalagem.CORREIOS_TIPO_4.getDimensoes(), embalagensNecessarias.get(0).getDimensoes());
		
	}
	
	@Test
	public void testEmbalagemDoisItensPequenosUmaEmbalagem() {
		
		List<Embalagem> embalagensNecessarias = 
				Embalador
				.novo()
				.addEmbalagemDisponivel(Embalagem.CORREIOS_TIPO_4)
				.addItem(new Item(20, 12, 15), 2)
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
				.addItem(new Item(30, 20, 15), 2)
				.calcular();
		
		Assert.assertEquals(2, embalagensNecessarias.size());
		Assert.assertEquals(Embalagem.CORREIOS_TIPO_4.getDimensoes(), embalagensNecessarias.get(0).getDimensoes());
		Assert.assertEquals(Embalagem.CORREIOS_TIPO_4.getDimensoes(), embalagensNecessarias.get(1).getDimensoes());
	}
}
