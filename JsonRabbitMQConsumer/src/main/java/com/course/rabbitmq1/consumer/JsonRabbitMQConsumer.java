package com.course.rabbitmq1.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.course.rabbitmq1.model.Employee;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JsonRabbitMQConsumer {

private	ObjectMapper objectMapper=new ObjectMapper() ;
Logger log=LoggerFactory.getLogger(JsonRabbitMQConsumer.class);

@RabbitListener(queues = "course.employee")
public void listen(String name) {
	Employee emp;
	try {
		emp= objectMapper.readValue(name, Employee.class);
		log.info("consumed message {}",emp);
	} catch (JsonParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
