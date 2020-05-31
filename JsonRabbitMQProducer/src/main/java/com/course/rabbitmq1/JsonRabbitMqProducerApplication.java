package com.course.rabbitmq1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.datetime.joda.LocalDateTimeParser;

import com.course.rabbitmq1.model.Employee;
import com.course.rabbitmq1.producer.EmployeeJsonRabbitMQProducer;

@SpringBootApplication
public class JsonRabbitMqProducerApplication implements CommandLineRunner{

	@Autowired
	EmployeeJsonRabbitMQProducer producer;
	
	public static void main(String[] args) {
		SpringApplication.run(JsonRabbitMqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee emp=new Employee("empId1", "Chandan", LocalDate.now());
		producer.sendMessage(emp);
	}

}
