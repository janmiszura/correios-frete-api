package org.jm.correios.calculo_frete_api;

import java.util.List;

import org.jm.correios.CorreiosFrete;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CorreiosFreteWSImplTest {
    
	CorreiosFrete correiosFrete;
	
	@Before
	public void setUp() {
		
		correiosFrete = 
				CorreiosFrete
				.novo()
				.comCepOrigemDestino("74371520", "74672540");
		
	}
	
	@Test
    public void testPAC() {
		
		correiosFrete.comTipoServico(TipoServico.PAC.getCodigo());
		
		List<ServicoXml> servicos = correiosFrete.calcPrecoPrazo();
		
		Assert.assertEquals("0", servicos.get(0).getErro());
		Assert.assertEquals(TipoServico.PAC.getCodigo(), servicos.get(0).getCodigo());
    }
	
	@Test
	public void testSedex() {
		
		correiosFrete.comTipoServico(TipoServico.SEDEX.getCodigo());
		
		List<ServicoXml> servicos = correiosFrete.calcPrecoPrazo();
		
		Assert.assertEquals("0", servicos.get(0).getErro());
		Assert.assertEquals(TipoServico.SEDEX.getCodigo(), servicos.get(0).getCodigo());
	}
}
