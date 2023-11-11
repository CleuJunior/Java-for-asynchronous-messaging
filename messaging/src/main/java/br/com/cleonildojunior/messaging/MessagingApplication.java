package br.com.cleonildojunior.messaging;

import br.com.cleonildojunior.messaging.entity.Picture;
import br.com.cleonildojunior.messaging.producer.HumanResourceProducer;
import br.com.cleonildojunior.messaging.producer.PictureProducer;
import br.com.cleonildojunior.messaging.producer.PictureProducer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

//@EnableScheduling
@SpringBootApplication
public class MessagingApplication implements CommandLineRunner {
//	@Autowired
//	private HelloRabbitProducer producer;
//
//	@Autowired
//	FixedRateProducer fixedRateProducer;

//	@Autowired
//	HumanResourceProducer producer;

//	@Autowired
//	EmployeeJsonProducer producer;
//
//	@Autowired
//	PictureProducer producer;
	@Autowired
	PictureProducer2 producer;

	private final List<String> SOURCE = List.of("mobile", "web");
	private final List<String> TYPE = List.of("jpg", "png", "svg");

	public static void main(String[] args) {
		SpringApplication.run(MessagingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		producer.sendHello("Cleonildo Junior " + Math.random());

//		fixedRateProducer.sendMessage();

//		this.producer.sendMessage(new Employee("1", "Cleonildo Junior", LocalDate.of(1990, 11, 9)));
//		this.producer.sendMessage(new Employee("2", "Thamyris Amaral", LocalDate.of(1996, 2, 24)));
//		this.producer.sendMessage(new Employee("3", "Agatha Guimaraes", LocalDate.now()));


		for (int i = 1; i < 11; i++) {
			producer.sendMessage(
					new Picture(
							"Selfie ID " + i,
							TYPE.get(new Random().nextInt(0, 3)),
							SOURCE.get(new Random().nextInt(0, 2)),
							new Random().nextInt(1_000, 5_001)
					)
			);
		}


	}
}
