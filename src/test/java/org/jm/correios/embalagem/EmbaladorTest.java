package org.jm.correios.embalagem;

import java.util.List;

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
	
	@Test
    public void testEmbalagemUmItem() {
		
		List<Embalagem> embalagensNecessarias = 
				Embalador
				.novo()
				.addEmbalagemDisponivel(Embalagem.CORREIOS_TIPO_4)
				.addItem(new Item(10, 10, 10), 1)
				.calcular();
		
		Assert.assertEquals(1, embalagensNecessarias.size());
		Assert.assertEquals(Embalagem.CORREIOS_TIPO_4, embalagensNecessarias.get(0));
		
	}
}
