package com.course.rabbitmq1.producer;

import org.apache.logging.log4j.message.ObjectMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.rabbitmq1.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeJsonRabbitMQProducer {

	@Autowired
	private RabbitTemplate templete;
	private ObjectMapper objectmapper =new ObjectMapper();
	
	
	public void sendMessage(Employee employee) {
		try {
			String jsondata=objectmapper.writeValueAsString(employee);
			templete.convertAndSend("course.employee", jsondata);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
