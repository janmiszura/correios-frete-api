package org.jm.correios.frete;

import java.util.List;

import org.jm.util.CorreiosFreteException;

public interface ICorreiosFrete {
	
	public List<ServicoXml> calcPrecoPrazo(CorreiosFreteDTO correiosFreteDTO) throws CorreiosFreteException;
	
}