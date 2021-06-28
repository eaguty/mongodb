package com.tvazteca.Borrado.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String appConfigPath = rootPath + "app.properties";
		
		Properties appProps = new Properties();
		
		appProps.load(new FileInputStream(appConfigPath));
		
		String token= appProps.getProperty("app.mediastream.azteca.token");
		System.out.println(token);

	}

}
