package br.com.cleonildojunior.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MessagingApplication implements CommandLineRunner {
//	@Autowired
//	private HelloRabbitProducer producer;
//
//	@Autowired
//	FixedRateProducer fixedRateProducer;
	
	public static void main(String[] args) {
		SpringApplication.run(MessagingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		producer.sendHello("Cleonildo Junior " + Math.random());

//		fixedRateProducer.sendMessage();
	}
}
