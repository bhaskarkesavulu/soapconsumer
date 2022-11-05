package com.web.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.consumer.SoapClient;
import com.web.consumer.stub.DetailsType;
import com.web.consumer.stub.GetBankResponseType;
import com.web.consumer.stub.GetBankType;
import com.web.consumer.stub.ObjectFactory;

@RestController
@RequestMapping("/")
public class BlzController {

	@Autowired
	private SoapClient soapClient;

	@GetMapping
	public DetailsType sum(@RequestParam String code) {

		ObjectFactory objectFactory = new ObjectFactory();
		GetBankType type = new GetBankType();
		System.out.println("After Passing Code setting code here for Blz");
		type.setBlz(code);

		GetBankResponseType response = soapClient.getBank("http://www.thomas-bayer.com/axis2/services/BLZService.wsdl",
				objectFactory.createGetBank(type));
		return response.getDetails();
	}

}
