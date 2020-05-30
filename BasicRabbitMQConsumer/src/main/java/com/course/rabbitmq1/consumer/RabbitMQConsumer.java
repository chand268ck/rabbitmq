package com.course.rabbitmq1.consumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

	 @RabbitListener(queues = "cources.hello")
	public void consumeMessage(String messahe) {
		System.out.println("consumed message is "+messahe);
	}
}
