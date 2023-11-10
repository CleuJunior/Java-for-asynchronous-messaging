package br.com.cleonildojunior.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

//@EnableScheduling
@SpringBootApplication
public class MessagingApplication implements CommandLineRunner {
//	@Autowired
//	private HelloRabbitProducer producer;
//
//	@Autowired
//	FixedRateProducer fixedRateProducer;

	@Autowired
	EmployeeJsonProducer producer;
	
	public static void main(String[] args) {
		SpringApplication.run(MessagingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		producer.sendHello("Cleonildo Junior " + Math.random());

//		fixedRateProducer.sendMessage();

		this.producer.sendMessage(new Employee("1", "Cleonildo Junior", LocalDate.of(1990, 11, 9)));
		this.producer.sendMessage(new Employee("2", "Thamyris Amaral", LocalDate.of(1996, 2, 24)));
	}
}
