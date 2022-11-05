package com.web.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class BeanConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {

		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.web.consumer.stub");
		System.out.println("Passing STUB classes path here to context path");
		return marshaller;
	}

	@Bean
	public SoapClient soapConnector(Jaxb2Marshaller marshaller) {
		SoapClient client = new SoapClient();
		client.setDefaultUri("http://www.thomas-bayer.com/axis2/services/BLZService.wsdl");
		client.setMarshaller(marshaller);
		System.out.println("Marshaller Object is : " + marshaller);
		client.setUnmarshaller(marshaller);
		System.out.println("After Un Marshaller Object is : " + marshaller);
		return client;

	}

}
