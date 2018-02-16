package org.jm.correios.calculo_frete_api;

import java.util.List;

import org.junit.Test;

public class CorreiosFreteWSTest {
    
	@Test
    public void testApp() {
        
		CorreiosFreteWS correiosFreteWS = new CorreiosFreteWS();
		correiosFreteWS.setnCdServico(TipoServico.PAC.getCodigo());
		correiosFreteWS.setsCepOrigem("74371520");
		correiosFreteWS.setsCepDestino("74672540");
		correiosFreteWS.setnVlPeso("1");
		List<ServicoXml> valores = correiosFreteWS.calcular();
		
    }
}
