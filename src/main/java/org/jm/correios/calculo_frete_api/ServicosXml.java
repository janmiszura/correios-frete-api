package org.jm.correios.calculo_frete_api;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.io.xml.DomDriver;

@XStreamAlias("Servicos")
public class ServicosXml {
	
	static Logger logger = Logger.getLogger(ServicosXml.class);
	
	@XStreamImplicit(itemFieldName="cServico")
	private List<ServicoXml> servicos = new ArrayList<ServicoXml>();
	
	public List<ServicoXml> getServicos() {
		return servicos;
	}
	
	public void setServicos(List<ServicoXml> servicos) {
		this.servicos = servicos;
	}
	
	public static List<ServicoXml> fromXml(String xml){
		
		ServicosXml servicos = new ServicosXml();
		
		try {
			
			XStream xStream = new XStream(new DomDriver());
			xStream.processAnnotations(ServicosXml.class);
			//logger.info("Resposta correios "+ xml);
			servicos = (ServicosXml) xStream.fromXML(xml);
			
		} catch (Exception e) {
			logger.error("erro ao ler xml: "+xml, e);
		}
		
		return servicos.getServicos();
	}
	
}