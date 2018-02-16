package org.jm.correios.calculo_frete_api;

import java.util.List;

import org.junit.Test;

public class CorreiosFreteWSTest {
    
	@Test
    public void testApp() {
        
		CorreiosFreteDTO correiosFreteDTO = new CorreiosFreteDTO();
		
		correiosFreteDTO.setnCdServico(TipoServico.PAC.getCodigo());
		correiosFreteDTO.setsCepOrigem("74371520");
		correiosFreteDTO.setsCepDestino("74672540");
		correiosFreteDTO.setnVlPeso("1");
		
		ICorreiosFrete correiosFrete = new CorreiosFreteWSImpl();
		
		List<ServicoXml> valores = correiosFrete.calcPrecoPrazo(correiosFreteDTO);
		
    }
}
