package org.jm.correios.frete;

import java.util.List;

import org.jm.correios.CorreiosFrete;
import org.jm.correios.ResultadoFrete;
import org.jm.correios.embalagem.Embalagem;
import org.jm.correios.embalagem.Item;
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
				.comTipoServico(TipoServico.PAC.getCodigo())
				.comCepOrigemDestino("74371520", "74672540")
				.addEmbalagem(Embalagem.CORREIOS_TIPO_4)
				.addItem(new Item(20, 12, 5), 1)
				;
		
	}
	
	@Test
    public void testPAC() {
		
		correiosFrete.comTipoServico(TipoServico.PAC.getCodigo());
		
		List<ResultadoFrete> resultados = correiosFrete.calcPrecoPrazo();
		
		Assert.assertEquals("0", resultados.get(0).getServicosXml().get(0).getErro());
		Assert.assertEquals(TipoServico.PAC.getCodigo(), resultados.get(0).getServicosXml().get(0).getCodigo());
    }
	
	@Test
	public void testSedex() {
		
		correiosFrete.comTipoServico(TipoServico.SEDEX.getCodigo());
		
		List<ResultadoFrete> resultados = correiosFrete.calcPrecoPrazo();
		
		Assert.assertEquals("0", resultados.get(0).getServicosXml().get(0).getErro());
		Assert.assertEquals(TipoServico.SEDEX.getCodigo(), resultados.get(0).getServicosXml().get(0).getCodigo());
	}
}
