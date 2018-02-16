package org.jm.correios.calculo_frete_api;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CorreiosFreteWSTest {
    
	ICorreiosFrete correiosFrete;
	
	CorreiosFreteDTO correiosFreteDTO;
	
	@Before
	public void setUp() {
		correiosFrete = new CorreiosFreteWSImpl();
		
		correiosFreteDTO = new CorreiosFreteDTO();
		
		correiosFreteDTO.setsCepOrigem("74371520");
		correiosFreteDTO.setsCepDestino("74672540");
		correiosFreteDTO.setnVlPeso("1");
	}
	
	@Test
    public void testWSPAC() {
		
		correiosFreteDTO.setnCdServico(TipoServico.PAC.getCodigo());
		
		List<ServicoXml> servicos = correiosFrete.calcPrecoPrazo(correiosFreteDTO);
		
		Assert.assertEquals("0", servicos.get(0).getErro());
		Assert.assertEquals(TipoServico.PAC.getCodigo(), servicos.get(0).getCodigo());
    }
	
	@Test
	public void testWSSedex() {
		
		correiosFreteDTO.setnCdServico(TipoServico.SEDEX.getCodigo());
		
		List<ServicoXml> servicos = correiosFrete.calcPrecoPrazo(correiosFreteDTO);
		
		Assert.assertEquals("0", servicos.get(0).getErro());
		Assert.assertEquals(TipoServico.SEDEX.getCodigo(), servicos.get(0).getCodigo());
	}
}
