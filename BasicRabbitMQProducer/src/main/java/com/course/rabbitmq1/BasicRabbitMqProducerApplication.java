package com.course.rabbitmq1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.course.rabbitmq1.producer.HelloRabbitProducer;

@SpringBootApplication
public class BasicRabbitMqProducerApplication implements CommandLineRunner {

	@Autowired
	HelloRabbitProducer producer;
	
	public static void main(String[] args) {
		SpringApplication.run(BasicRabbitMqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		producer.sendHello("World");
	}

}
