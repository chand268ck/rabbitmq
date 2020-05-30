package com.course.rabbitmq1.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class HelloRabbitProducer {
	@Autowired
private RabbitTemplate rabbitTemplete;
public void sendHello(String name) {
	rabbitTemplete.convertAndSend("cources.hello", "Hello "+ name);
}
}
