package com.example.demo;

import com.example.demo.service.MotorService;
import com.example.demo.service.contracts.IMotorService;
import com.example.demo.service.contracts.dto.DtoInputDataTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	@Autowired
	private IMotorService motorService;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

	}

	@Scheduled (fixedDelay = 1 * 60 * 1000)
	public void receberDados() {
		DtoInputDataTransfer dtoInputDataTransfer = new DtoInputDataTransfer(
				"oka-syga-21254",
				"ooata-aqaq-147",
				"14478-aolaiha-elk",
				"ajoiqja-qhiuah-176",
				"2021-08-12",
				1000.00
		);

		String response = motorService.processDataConciliation(dtoInputDataTransfer);// incluir dto contas a receber / o retorno String response será substituido pela classe de conciliação
		System.out.println(response);
	}


}
