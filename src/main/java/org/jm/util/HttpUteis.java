package org.jm.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.log4j.Logger;

public class HttpUteis {

	private static final Logger logger = Logger.getLogger(HttpUteis.class);
	
	public static String sendGet(String urls, String charset) {
		StringBuffer html = new StringBuffer();

		try {
			URL url = new URL(urls);
			BufferedReader bin = new BufferedReader(new InputStreamReader(url.openStream(), charset));
			String line;
			while ((line = bin.readLine()) != null) {
				html.append(line);
			}
			bin.close();
		} catch (Exception e) {
			String m = "erro em sendGet(), URL: "+urls+", charset: "+charset;
			logger.error(m, e);
			html = new StringBuffer();
		}

		return html.toString();
	}

}
