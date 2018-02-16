package org.jm.correios.calculo_frete_api;

import java.util.List;

import org.jm.util.CorreiosFreteException;

public interface ICorreiosFrete {
	
	public List<ServicoXml> calcPrecoPrazo(CorreiosFreteDTO correiosFreteDTO) throws CorreiosFreteException;
	
}